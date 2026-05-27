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
package com.influxdb.query.dsl.functions;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import javax.annotation.Nonnull;
import com.influxdb.query.dsl.Flux;
import com.influxdb.utils.Arguments;

/**
 * Groups the results by a given time range.
 * <a href="http://bit.ly/flux-spec#window">See SPEC</a>.
 *
 * <p>
 * <b>Options</b>
 * <ul>
 * <li><b>every</b> - Duration of time between windows. Defaults to <i>period's</i> value. [duration]
 * <li><b>period</b> - Duration of the windowed partition. Defaults to <i>every's</i> value. [duration]
 * <li><b>offset</b> - The offset duration relative to the location offset. It can be negative,
 * indicating that the offset goes backwards in time.
 * The default aligns the window boundaries to line up with the <i>now</i> option time. [time]</li>
 * <li><b>timeColumn</b> - Name of the time column to use. Defaults to <i>_time</i>. [string]
 * <li><b>startColumn</b> - Name of the column containing the window start time. Defaults to <i>_start</i>. [string]
 * <li><b>stopColumn</b> - Name of the column containing the window stop time. Defaults to <i>_stop</i>. [string]
 * </ul>
 *
 * <p>
 * <b>Example</b>
 * <pre>
 * Flux flux = Flux
 *     .from("telegraf")
 *     .window(15L, ChronoUnit.MINUTES)
 *     .max();
 *
 * Flux flux = Flux
 *     .from("telegraf")
 *     .window(15L, ChronoUnit.MINUTES,
 *             20L, ChronoUnit.SECONDS,
 *             1L, ChronoUnit.SECONDS)
 *     .max();
 * </pre>
 *
 * @author Jakub Bednar (bednar@github) (27/06/2018 12:01)
 */
public final class WindowFlux extends AbstractParametrizedFlux {

    public WindowFlux(@Nonnull final Flux flux) {
        super(flux);
    }

    @Nonnull
    @Override
    protected String operatorName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param every     duration of time between windows
     * @param everyUnit a {@code ChronoUnit} determining how to interpret the {@code every}
     * @return this
     */
    @Nonnull
    public WindowFlux withEvery(@Nonnull final Long every, @Nonnull final ChronoUnit everyUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param every duration of time between windows
     * @return this
     */
    @Nonnull
    public WindowFlux withEvery(@Nonnull final String every) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param period     duration of the windowed partition
     * @param periodUnit a {@code ChronoUnit} determining how to interpret the {@code period}
     * @return this
     */
    @Nonnull
    public WindowFlux withPeriod(@Nonnull final Long period, @Nonnull final ChronoUnit periodUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param period duration of the windowed partition
     * @return this
     */
    @Nonnull
    public WindowFlux withPeriod(@Nonnull final String period) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param offset     The offset duration relative to the location offset.
     * @param offsetUnit a {@code ChronoUnit} determining how to interpret the {@code offset}
     * @return this
     */
    @Nonnull
    public WindowFlux withOffset(@Nonnull final Long offset, @Nonnull final ChronoUnit offsetUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param offset The offset duration relative to the location offset.
     * @return this
     */
    @Nonnull
    public WindowFlux withOffset(@Nonnull final Instant offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param offset The offset duration relative to the location offset.
     * @return this
     */
    @Nonnull
    public WindowFlux withOffset(@Nonnull final String offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param timeColumn name of the time column to use
     * @return this
     */
    @Nonnull
    public WindowFlux withTimeColumn(@Nonnull final String timeColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param startColumn name of the column containing the window start time
     * @return this
     */
    @Nonnull
    public WindowFlux withStartColumn(@Nonnull final String startColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @param stopColumn name of the column containing the window stop time
     * @return this
     */
    @Nonnull
    public WindowFlux withStopCol(@Nonnull final String stopColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
