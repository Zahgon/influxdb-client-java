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
package com.influxdb.query.dsl.functions.properties;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.query.dsl.Flux;
import com.influxdb.query.dsl.VariableAssignment;
import com.influxdb.utils.Arguments;

/**
 * The function properties. Support named-property, property with values.
 *
 * @author Jakub Bednar (bednar@github) (28/06/2018 05:32)
 */
public final class FunctionsParameters {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnn'Z'").withZone(ZoneId.of("UTC"));

    private static final String DEFAULT_DELIMITER = ":";

    private static final String FUNCTION_DELIMITER = " => ";

    private static final int DOUBLE_FRACTION_DIGITS = 340;

    private final Map<String, Property<?>> properties = new LinkedHashMap<>();

    public static String escapeDoubleQuotes(final String val) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

    static {
        // https://stackoverflow.com/a/25307973
        DECIMAL_FORMAT.setMaximumFractionDigits(DOUBLE_FRACTION_DIGITS);
    }

    private FunctionsParameters() {
    }

    @Nonnull
    public static FunctionsParameters of() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Serialize value for Flux property.
     *
     * @param value to serialize
     * @return serialized value
     */
    @Nullable
    public static String serializeValue(@Nonnull final Object value, final boolean escapeStrings) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param fluxName      name in Flux query
     * @param namedProperty name in named properties
     * @see Flux#withPropertyNamed(String, String)
     */
    public void putPropertyNamed(@Nonnull final String fluxName, @Nonnull final String namedProperty) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param functionName  name in Flux query
     * @param namedProperty name in named properties
     * @see Flux#withPropertyNamed(String, String)
     */
    public void putFunctionNamed(@Nonnull final String functionName, @Nonnull final String namedProperty) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param fluxName name in Flux query
     * @param value    value of property. If null than ignored.
     * @see Flux#withPropertyValue(String, Object)
     */
    public void putPropertyValue(@Nonnull final String fluxName, @Nullable final Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param functionName name in Flux query
     * @param function     defined function
     * @see Flux#withPropertyValue(String, Object)
     */
    public void putFunctionValue(@Nonnull final String functionName, @Nullable final Object function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param fluxName name of property in Flux query
     * @param amount   the amount of the duration, measured in terms of the unit, positive or negative
     * @param unit     the unit that the duration is measured in, must have an exact duration.  If null than ignored.
     * @see Flux#withPropertyValue(String, Long, ChronoUnit)
     */
    public void putPropertyValue(@Nonnull final String fluxName, @Nullable final Long amount, @Nullable final ChronoUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param fluxName name of property in Flux query
     * @param value    value of property. If null than ignored.
     * @see Flux#withPropertyValueEscaped(String, String)
     */
    public void putPropertyValueString(@Nonnull final String fluxName, @Nullable final String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    public Collection<String> keys() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    public String get(@Nonnull final String key, @Nonnull final Map<String, Object> namedProperties) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void put(@Nonnull final String name, @Nullable final Property<?> property) {
        if (property == null) {
            return;
        }
        properties.put(name, property);
    }

    @Nonnull
    public String getDelimiter(@Nonnull final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private interface Property<T> {

        /**
         * @param namedProperties named property values
         * @return value of property
         */
        @Nullable
        T value(@Nonnull final Map<String, Object> namedProperties);

        /**
         * @return For value property it is ": ", but for function it is "=&gt;".
         */
        @Nonnull
        String delimiter();
    }

    private static final class NamedProperty<T> implements Property<T> {

        private final String parameterName;

        private final String delimiter;

        private NamedProperty(@Nonnull final String parameterName, @Nonnull final String delimiter) {
            Arguments.checkNonEmpty(parameterName, "Parameter name");
            Arguments.checkNonEmpty(delimiter, "delimiter");
            this.parameterName = parameterName;
            this.delimiter = delimiter;
        }

        @Nonnull
        @Override
        @SuppressWarnings("unchecked")
        public T value(@Nonnull final Map<String, Object> namedProperties) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Nonnull
        @Override
        public String delimiter() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class StringProperty extends AbstractProperty<String> {

        private final String value;

        private StringProperty(@Nullable final String value) {
            this.value = value;
        }

        @Nullable
        @Override
        public String value(@Nonnull final Map<String, Object> namedProperties) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private abstract static class AbstractProperty<T> implements Property<T> {

        /**
         * @return For value property it is ": ", but for function it is "=&gt;".
         */
        @Nonnull
        @Override
        public String delimiter() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
