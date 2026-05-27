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
package com.influxdb.client;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import com.influxdb.LogLevel;
import com.influxdb.client.domain.WriteConsistency;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.PointSettings;
import com.influxdb.client.write.WriteParameters;
import com.influxdb.exceptions.InfluxException;
import com.influxdb.utils.Arguments;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/**
 * InfluxDBClientOptions are used to configure theInfluxDB 2.x connections.
 *
 * @author Jakub Bednar (bednar@github) (05/09/2018 10:22)
 */
public final class InfluxDBClientOptions {

    private static final Pattern TAGS_PROPERTY = Pattern.compile("(influx2\\.tags\\.)(.+)");

    private static final Pattern DURATION_PATTERN = Pattern.compile("^(\\d+)([a-zA-Z]{0,2})$");

    private final String url;

    private final String clientType;

    private final OkHttpClient.Builder okHttpClient;

    private final LogLevel logLevel;

    private final AuthScheme authScheme;

    private final char[] token;

    private final String username;

    private final char[] password;

    private final String org;

    private final String bucket;

    private final WritePrecision precision;

    private final WriteConsistency consistency;

    private final PointSettings pointSettings;

    private InfluxDBClientOptions(@Nonnull final InfluxDBClientOptions.Builder builder) {
        Arguments.checkNotNull(builder, "InfluxDBClientOptions.Builder");
        this.url = builder.url;
        this.clientType = builder.clientType;
        this.okHttpClient = builder.okHttpClient;
        this.logLevel = builder.logLevel;
        this.authScheme = builder.authScheme;
        this.token = builder.token;
        this.username = builder.username;
        this.password = builder.password;
        this.org = builder.org;
        this.bucket = builder.bucket;
        this.precision = builder.precision != null ? builder.precision : WriteParameters.DEFAULT_WRITE_PRECISION;
        this.consistency = builder.consistency;
        this.pointSettings = builder.pointSettings;
    }

    /**
     * The scheme uses to Authentication.
     */
    public enum AuthScheme {

        /**
         * Basic auth.
         */
        SESSION,
        /**
         * Authentication token.
         */
        TOKEN
    }

    /**
     * @return the url to connect to InfluxDB
     * @see InfluxDBClientOptions.Builder#url(String)
     */
    @Nonnull
    public String getUrl() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * If the {@code clientType} is not specified the `java`, `kotlin` or `scala` is used depends on the type of client.
     *
     * @return the client type to report as a part of User-Agent to remote server
     * @see InfluxDBClientOptions.Builder#clientType(String)
     */
    @Nullable
    public String getClientType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return HTTP client to use for communication with InfluxDB
     * @see InfluxDBClientOptions.Builder#okHttpClient(OkHttpClient.Builder)
     */
    @Nonnull
    public OkHttpClient.Builder getOkHttpClient() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The log level for the request and response information.
     * @see InfluxDBClientOptions.Builder#logLevel(LogLevel)
     */
    @Nonnull
    public LogLevel getLogLevel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the authorization scheme
     * @see InfluxDBClientOptions.Builder#authenticateToken(char[])
     * @see InfluxDBClientOptions.Builder#authenticate(String, char[]) (char[])
     */
    @Nullable
    public AuthScheme getAuthScheme() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the token to use for the authorization
     * @see InfluxDBClientOptions.Builder#authenticateToken(char[])
     */
    @Nullable
    public char[] getToken() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the username to use in the basic auth
     * @see InfluxDBClientOptions.Builder#authenticate(String, char[])
     */
    @Nullable
    public String getUsername() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the password to use in the basic auth
     * @see InfluxDBClientOptions.Builder#authenticate(String, char[])
     */
    @Nullable
    public char[] getPassword() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the default destination organization for writes and queries
     * @see InfluxDBClientOptions.Builder#org(String)
     */
    @Nullable
    public String getOrg() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return default destination bucket for writes
     * @see InfluxDBClientOptions.Builder#bucket(String)
     */
    @Nullable
    public String getBucket() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return default precision for unix timestamps in the line protocol
     * @see InfluxDBClientOptions.Builder#precision(WritePrecision)
     */
    @Nonnull
    public WritePrecision getPrecision() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The write consistency for the point.
     * <p>
     * InfluxDB assumes that the write consistency is {@link  WriteConsistency#ONE} if you do not specify consistency.
     * See the <a href="https://bit.ly/enterprise-consistency">InfluxDB Enterprise documentation</a> for
     * detailed descriptions of each consistency option.
     *
     * <b>Available with InfluxDB Enterprise clusters only!</b>
     *
     * @return the write consistency for the point.
     * @see InfluxDBClientOptions.Builder#consistency(WriteConsistency)
     */
    @Nullable
    public WriteConsistency getConsistency() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Default tags that will be use for writes by Point and POJO.
     *
     * @return default tags
     * @see InfluxDBClientOptions.Builder#addDefaultTag(String, String)
     */
    @Nonnull
    public PointSettings getPointSettings() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a builder instance.
     *
     * @return a builder
     */
    @Nonnull
    public static InfluxDBClientOptions.Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A builder for {@code InfluxDBClientOptions}.
     */
    @NotThreadSafe
    public static class Builder {

        private String url;

        private String clientType;

        private OkHttpClient.Builder okHttpClient;

        private LogLevel logLevel;

        private AuthScheme authScheme;

        private char[] token;

        private String username;

        private char[] password;

        private String org;

        private String bucket;

        private WritePrecision precision;

        private WriteConsistency consistency;

        private final PointSettings pointSettings = new PointSettings();

        /**
         * Set the url to connect to InfluxDB.
         * <p>
         * The url could be a connection string with various configurations. For more info
         * see: {@link #connectionString(String)}.
         * </p>
         *
         * @param url the url to connect to InfluxDB (required). Example: http://localhost:8086?readTimeout=5000
         * @return {@code this}
         */
        @Nonnull
        public InfluxDBClientOptions.Builder url(@Nonnull final String url) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set the {@code clientType} to customize the User-Agent HTTP header.
         * <p>
         * If the {@code clientType} is set to "awesome-service" the User-Agent header will be:
         * <code>influxdb-client-awesome-service/6.2.0</code>.
         *
         * @param clientType the client type to report as a part of User-Agent to remote server
         * @return {@code this}
         */
        @Nonnull
        public InfluxDBClientOptions.Builder clientType(@Nonnull final String clientType) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set the HTTP client to use for communication with InfluxDB.
         *
         * @param okHttpClient the HTTP client to use.
         * @return {@code this}
         */
        @Nonnull
        public InfluxDBClientOptions.Builder okHttpClient(@Nonnull final OkHttpClient.Builder okHttpClient) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set the log level for the request and response information.
         *
         * @param logLevel The log level for the request and response information.
         * @return {@code this}
         */
        @Nonnull
        public InfluxDBClientOptions.Builder logLevel(@Nonnull final LogLevel logLevel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Setup authorization by {@link AuthScheme#SESSION}.
         *
         * <p>
         * The <i>username/password</i> auth is based on
         * <a href="http://bit.ly/http-basic-auth">HTTP "Basic" authentication</a>. The authorization expires when the
         * <a href="http://bit.ly/session-length">time-to-live (TTL)</a> (default 60 minutes) is reached
         * and client produces {@link com.influxdb.exceptions.UnauthorizedException}.
         * </p>
         *
         * @param username the username to use in the basic auth
         * @param password the password to use in the basic auth
         * @return {@code this}
         */
        @Nonnull
        public InfluxDBClientOptions.Builder authenticate(@Nonnull final String username, @Nonnull final char[] password) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Setup authorization by {@link AuthScheme#TOKEN}.
         *
         * @param token the token to use for the authorization
         * @return {@code this}
         */
        @Nonnull
        public InfluxDBClientOptions.Builder authenticateToken(final char[] token) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Specify the default destination organization for writes and queries.
         *
         * @param org the default destination organization for writes and queries
         * @return {@code this}
         */
        @Nonnull
        public InfluxDBClientOptions.Builder org(@Nullable final String org) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Specify the default destination bucket for writes.
         *
         * @param bucket default destination bucket for writes
         * @return {@code this}
         */
        @Nonnull
        public InfluxDBClientOptions.Builder bucket(@Nullable final String bucket) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Specify the default precision for unix timestamps in the line protocol.
         *
         * @param precision default precision for unix timestamps in the line protocol
         * @return {@code this}
         */
        @Nonnull
        public InfluxDBClientOptions.Builder precision(@Nullable final WritePrecision precision) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Specify the write consistency for the point.
         * <p>
         * InfluxDB assumes that the write consistency is {@link  WriteConsistency#ONE}
         * if you do not specify consistency.
         * See the <a href="https://bit.ly/enterprise-consistency">InfluxDB Enterprise documentation</a> for
         * detailed descriptions of each consistency option.
         *
         * <b>Available with InfluxDB Enterprise clusters only!</b>
         *
         * @param consistency The write consistency for the point.
         * @return {@code this}
         */
        @Nonnull
        public InfluxDBClientOptions.Builder consistency(@Nullable final WriteConsistency consistency) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Add default tag that will be use for writes by Point and POJO.
         * <p>
         * The expressions can be:
         * <ul>
         * <li>"California Miner" - static value</li>
         * <li>"${version}" - system property</li>
         * <li>"${env.hostname}" - environment property</li>
         * </ul>
         *
         * @param key        the tag name
         * @param expression the tag value expression
         * @return this
         */
        @Nonnull
        public InfluxDBClientOptions.Builder addDefaultTag(@Nonnull final String key, @Nullable final String expression) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Configure Builder via connection string. The allowed configuration:
         *
         * <ul>
         *     <li><code>org</code> - default destination organization for writes and queries</li>
         *     <li><code>bucket</code> - default destination bucket for writes</li>
         *     <li><code>token</code> - the token to use for the authorization</li>
         *     <li><code>logLevel</code> - rest client verbosity level</li>
         *     <li><code>readTimeout</code> - read timeout</li>
         *     <li><code>writeTimeout</code> - write timeout</li>
         *     <li><code>connectTimeout</code> - socket timeout</li>
         *     <li><code>precision</code> - default precision for unix timestamps in the line protocol</li>
         *     <li><code>consistency</code> - specify the write consistency for the point</li>
         *     <li><code>clientType</code> - to customize the User-Agent HTTP header</li>
         * </ul>
         * <p>
         * Connection string example:
         * <pre>
         * http://localhost:8086?readTimeout=30000&amp;token=my-token&amp;bucket=my-bucket&amp;org=my-org
         * </pre>
         *
         * @return {@code this}
         */
        @Nonnull
        public InfluxDBClientOptions.Builder connectionString(@Nonnull final String connectionString) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Configure Builder via {@code influx2.properties}.
         *
         * @return {@code this}
         */
        @Nonnull
        public InfluxDBClientOptions.Builder loadProperties() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Build an instance of InfluxDBClientOptions.
         *
         * @return {@link InfluxDBClientOptions}
         */
        @Nonnull
        public InfluxDBClientOptions build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Nonnull
        private InfluxDBClientOptions.Builder configure(@Nonnull final String url, @Nullable final String org, @Nullable final String bucket, @Nullable final String token, @Nullable final String logLevel, @Nullable final String readTimeout, @Nullable final String writeTimeout, @Nullable final String connectTimeout, @Nullable final String precision, @Nullable final String consistency, @Nullable final String clientType) {
            this.url = new ParsedUrl(url).urlWithoutParams;
            if (org != null) {
                org(org);
            }
            if (bucket != null) {
                bucket(bucket);
            }
            if (token != null) {
                authenticateToken(token.toCharArray());
            }
            if (logLevel != null) {
                logLevel(Enum.valueOf(LogLevel.class, logLevel));
            }
            if (precision != null) {
                precision(Enum.valueOf(WritePrecision.class, precision));
            }
            if (consistency != null) {
                consistency(Enum.valueOf(WriteConsistency.class, consistency));
            }
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient.Builder().protocols(Collections.singletonList(Protocol.HTTP_1_1));
            }
            if (readTimeout != null) {
                okHttpClient.readTimeout(toDuration(readTimeout));
            }
            if (writeTimeout != null) {
                okHttpClient.writeTimeout(toDuration(writeTimeout));
            }
            if (connectTimeout != null) {
                okHttpClient.connectTimeout(toDuration(connectTimeout));
            }
            if (clientType != null) {
                clientType(clientType);
            }
            return this;
        }

        @Nonnull
        private Duration toDuration(@Nonnull final String value) {
            Matcher matcher = DURATION_PATTERN.matcher(value);
            if (!matcher.matches()) {
                throw new InfluxException("'" + value + "' is not a valid duration");
            }
            String amount = matcher.group(1);
            String unit = matcher.group(2);
            ChronoUnit chronoUnit;
            switch(unit != null && !unit.isEmpty() ? unit.toLowerCase() : "ms") {
                case "ms":
                    chronoUnit = ChronoUnit.MILLIS;
                    break;
                case "s":
                    chronoUnit = ChronoUnit.SECONDS;
                    break;
                case "m":
                    chronoUnit = ChronoUnit.MINUTES;
                    break;
                default:
                    throw new InfluxException("unknown unit for '" + value + "'");
            }
            return Duration.of(Long.parseLong(amount), chronoUnit);
        }

        private static final class ParsedUrl {

            @Nonnull
            private final String urlWithoutParams;

            @Nonnull
            private final HttpUrl httpUrl;

            private ParsedUrl(@Nonnull final String connectionString) {
                HttpUrl parse = HttpUrl.parse(connectionString);
                if (parse == null) {
                    throw new InfluxException("Unable to parse connection string " + connectionString);
                }
                this.httpUrl = parse;
                HttpUrl url = this.httpUrl.newBuilder().build();
                //detect IPV6
                String host = url.host().contains(":") ? "[" + url.host() + "]" : url.host();
                String urlWithoutParams = url.scheme() + "://" + host + ":" + url.port() + url.encodedPath();
                this.urlWithoutParams = urlWithoutParams.endsWith("/") ? urlWithoutParams : urlWithoutParams + "/";
            }
        }
    }
}
