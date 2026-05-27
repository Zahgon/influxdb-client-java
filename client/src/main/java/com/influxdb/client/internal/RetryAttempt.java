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
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import com.influxdb.client.WriteApi.RetryOptions;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

/**
 * RetryConfiguration.
 *
 * @author Jakub Bednar (29/09/2020 14:19)
 */
public final class RetryAttempt {

    private static final Integer ABLE_TO_RETRY_ERROR = 429;

    private static final Logger LOG = Logger.getLogger(AbstractWriteClient.class.getName());

    private static Supplier<Double> jitterRandomSupplier;

    private static Supplier<Double> retryRandomSupplier;

    private final Throwable throwable;

    private final int count;

    private final RetryOptions writeOptions;

    RetryAttempt(final Throwable throwable, final int count, final RetryOptions retryOptions) {
        this.throwable = throwable;
        this.count = count;
        this.writeOptions = retryOptions;
    }

    /**
     * Sets the specific jitter random supplier.
     * @param supplier the hook supplier to set, null allowed
     */
    public static void setJitterRandomSupplier(@Nullable final Supplier<Double> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the specific retry random supplier.
     * @param supplier the hook supplier to set, null allowed
     */
    public static void setRetryRandomSupplier(@Nullable final Supplier<Double> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Is this request retryable?
     *
     * @return true if its retryable otherwise false
     */
    boolean isRetry() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get current retry interval.
     *
     * @return retry interval to sleep
     */
    long getRetryInterval() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return current throwable
     */
    Throwable getThrowable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    private String getRetryAfter() {
        if (throwable instanceof HttpException) {
            return ((HttpException) throwable).response().headers().get("Retry-After");
        }
        return null;
    }

    /**
     * @param jitterInterval batch flush jitter interval
     * @return randomized delay
     */
    static int jitterDelay(final int jitterInterval) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
