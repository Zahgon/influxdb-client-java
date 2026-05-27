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
package com.influxdb.spring.influx;

import java.time.Duration;
import com.influxdb.LogLevel;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for InfluxDB 2.
 *
 * @author Jakub Bednar (bednar@github) (06/05/2019 12:54)
 */
@ConfigurationProperties(prefix = "influx")
public class InfluxDB2Properties {

    private static final int DEFAULT_TIMEOUT = 10_000;

    /**
     * URL to connect to InfluxDB.
     */
    private String url;

    /**
     * Username to use in the basic auth.
     */
    private String username;

    /**
     * Password to use in the basic auth.
     */
    private String password;

    /**
     * Token to use for the authorization.
     */
    private String token;

    /**
     * Default destination organization for writes and queries.
     */
    private String org;

    /**
     * Default destination bucket for writes.
     */
    private String bucket;

    /**
     * The log level for logging the HTTP request and HTTP response.
     */
    private LogLevel logLevel = LogLevel.NONE;

    /**
     * Read timeout for {@code OkHttpClient}.
     */
    private Duration readTimeout = Duration.ofMillis(DEFAULT_TIMEOUT);

    /**
     * Write timeout for {@code OkHttpClient}.
     */
    private Duration writeTimeout = Duration.ofMillis(DEFAULT_TIMEOUT);

    /**
     * Connection timeout for {@code OkHttpClient}.
     */
    private Duration connectTimeout = Duration.ofMillis(DEFAULT_TIMEOUT);

    public String getUrl() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setUrl(final String url) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getUsername() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setUsername(final String username) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getPassword() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setPassword(final String password) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getToken() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setToken(final String token) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public LogLevel getLogLevel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLogLevel(final LogLevel logLevel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getOrg() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setOrg(final String org) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getBucket() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setBucket(final String bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Duration getReadTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setReadTimeout(final Duration readTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Duration getWriteTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setWriteTimeout(final Duration writeTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Duration getConnectTimeout() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setConnectTimeout(final Duration connectTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
