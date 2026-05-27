/*
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.influxdb.client.internal;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.Cancellable;
import com.influxdb.client.InfluxQLQueryApi;
import com.influxdb.client.domain.InfluxQLQuery;
import com.influxdb.client.service.InfluxQLQueryService;
import com.influxdb.internal.AbstractQueryApi;
import com.influxdb.query.InfluxQLQueryResult;
import com.influxdb.utils.Arguments;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import retrofit2.Call;

public class InfluxQLQueryApiImpl extends AbstractQueryApi implements InfluxQLQueryApi {

    private final InfluxQLQueryService service;

    public InfluxQLQueryApiImpl(@Nonnull final InfluxQLQueryService service) {
        Arguments.checkNotNull(service, "service");
        this.service = service;
    }

    @Nonnull
    @Override
    public InfluxQLQueryResult query(@Nonnull final InfluxQLQuery influxQLQuery) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public InfluxQLQueryResult query(@Nonnull final InfluxQLQuery influxQLQuery, @Nullable final InfluxQLQueryResult.Series.ValueExtractor valueExtractor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public InfluxQLQueryResult queryCSV(@Nonnull final InfluxQLQuery influxQLQuery) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public InfluxQLQueryResult queryCSV(@Nonnull final InfluxQLQuery influxQLQuery, @Nullable final InfluxQLQueryResult.Series.ValueExtractor valueExtractor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public InfluxQLQueryResult queryJSON(@Nonnull final InfluxQLQuery influxQLQuery) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    @Override
    public InfluxQLQueryResult queryJSON(@Nonnull final InfluxQLQuery influxQLQuery, @Nullable final InfluxQLQueryResult.Series.ValueExtractor valueExtractor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    private InfluxQLQueryResult query(@Nonnull final InfluxQLQuery influxQlQuery, @Nullable final InfluxQLQuery.AcceptHeader accept, @Nullable final InfluxQLQueryResult.Series.ValueExtractor valueExtractor) {
        Call<ResponseBody> call = service.query(influxQlQuery.getCommand(), influxQlQuery.getDatabase(), influxQlQuery.getRetentionPolicy(), influxQlQuery.getPrecision() != null ? influxQlQuery.getPrecision().getSymbol() : null, null, accept != null ? accept.getVal() : InfluxQLQuery.AcceptHeader.JSON.getVal());
        AtomicReference<InfluxQLQueryResult> atomicReference = new AtomicReference<>();
        BiConsumer<Cancellable, BufferedSource> consumer = (cancellable, bufferedSource) -> {
            try {
                InfluxQLQueryResult result = parseResponse(bufferedSource, cancellable, accept, valueExtractor);
                atomicReference.set(result);
            } catch (IOException e) {
                ERROR_CONSUMER.accept(e);
            }
        };
        query(call, consumer, ERROR_CONSUMER, EMPTY_ACTION, false);
        return atomicReference.get();
    }

    private InfluxQLQueryResult parseResponse(@Nonnull final BufferedSource bufferedSource, @Nonnull final Cancellable cancellable, @Nonnull final InfluxQLQuery.AcceptHeader accept, @Nullable final InfluxQLQueryResult.Series.ValueExtractor valueExtractor) throws IOException {
        Arguments.checkNotNull(bufferedSource, "bufferedSource");
        try (Reader reader = new InputStreamReader(bufferedSource.inputStream(), StandardCharsets.UTF_8)) {
            if (accept == InfluxQLQuery.AcceptHeader.CSV) {
                return readInfluxQLCSVResult(reader, cancellable, valueExtractor);
            }
            return readInfluxQLJsonResult(reader, cancellable, valueExtractor);
        }
    }

    static InfluxQLQueryResult readInfluxQLCSVResult(@Nonnull final Reader reader, @Nonnull final Cancellable cancellable, @Nullable final InfluxQLQueryResult.Series.ValueExtractor valueExtractor) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Map<String, String> parseTags(@Nonnull final String value) {
        final Map<String, String> tags = new HashMap<>();
        if (value.isEmpty()) {
            return tags;
        }
        StringBuilder currentKey = new StringBuilder();
        StringBuilder currentValue = new StringBuilder();
        boolean inValue = false;
        boolean escaped = false;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (escaped) {
                // current character is escaped - treat it as a literal
                if (inValue) {
                    currentValue.append(c);
                } else {
                    currentKey.append(c);
                }
                escaped = false;
                continue;
            }
            if (c == '\\') {
                // start escape sequence
                // don't preserve escape character
                escaped = true;
                continue;
            }
            if (!inValue && c == '=') {
                // unescaped '=' marks copula
                inValue = true;
                continue;
            }
            if (inValue && c == ',') {
                // unescaped comma separates key value pairs
                // finalize
                String key = currentKey.toString();
                String val = currentValue.toString();
                if (!key.isEmpty()) {
                    tags.put(key, val);
                }
                currentKey.setLength(0);
                currentValue.setLength(0);
                inValue = false;
                continue;
            }
            if (inValue) {
                currentValue.append(c);
            } else {
                currentKey.append(c);
            }
        }
        // finalize last key/value pair if any
        String key = currentKey.toString();
        String val = currentValue.toString();
        if (inValue && !key.isEmpty()) {
            tags.put(key, val);
        }
        return tags;
    }

    static InfluxQLQueryResult readInfluxQLJsonResult(@Nonnull final Reader reader, @Nonnull final Cancellable cancellable, @Nullable final InfluxQLQueryResult.Series.ValueExtractor valueExtractor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class ResultsDeserializer implements JsonDeserializer<InfluxQLQueryResult> {

        Cancellable cancellable;

        public ResultsDeserializer(final Cancellable cancellable) {
            this.cancellable = cancellable;
        }

        @Override
        public InfluxQLQueryResult deserialize(final JsonElement elem, final Type type, final JsonDeserializationContext ctx) throws JsonParseException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class ResultDeserializer implements JsonDeserializer<InfluxQLQueryResult.Result> {

        InfluxQLQueryResult.Series.ValueExtractor extractor;

        public ResultDeserializer(final InfluxQLQueryResult.Series.ValueExtractor extractor) {
            this.extractor = extractor;
        }

        @Override
        public InfluxQLQueryResult.Result deserialize(final JsonElement elem, final Type type, final JsonDeserializationContext ctx) throws JsonParseException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
