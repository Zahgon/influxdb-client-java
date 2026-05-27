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
package com.influxdb.query.dsl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.query.dsl.functions.AbstractFunctionCallFlux;
import com.influxdb.query.dsl.functions.AbstractFunctionFlux;
import com.influxdb.query.dsl.functions.AbstractParametrizedFlux;
import com.influxdb.query.dsl.functions.AggregateWindow;
import com.influxdb.query.dsl.functions.ArrayFromFlux;
import com.influxdb.query.dsl.functions.ColumnsFlux;
import com.influxdb.query.dsl.functions.CountFlux;
import com.influxdb.query.dsl.functions.CovarianceFlux;
import com.influxdb.query.dsl.functions.CumulativeSumFlux;
import com.influxdb.query.dsl.functions.DerivativeFlux;
import com.influxdb.query.dsl.functions.DifferenceFlux;
import com.influxdb.query.dsl.functions.DistinctFlux;
import com.influxdb.query.dsl.functions.DropFlux;
import com.influxdb.query.dsl.functions.DuplicateFlux;
import com.influxdb.query.dsl.functions.ElapsedFlux;
import com.influxdb.query.dsl.functions.ExpressionFlux;
import com.influxdb.query.dsl.functions.FillFlux;
import com.influxdb.query.dsl.functions.FilterFlux;
import com.influxdb.query.dsl.functions.FirstFlux;
import com.influxdb.query.dsl.functions.FromFlux;
import com.influxdb.query.dsl.functions.GroupFlux;
import com.influxdb.query.dsl.functions.IntegralFlux;
import com.influxdb.query.dsl.functions.InterpolateLinearFlux;
import com.influxdb.query.dsl.functions.JoinFlux;
import com.influxdb.query.dsl.functions.KeepFlux;
import com.influxdb.query.dsl.functions.LastFlux;
import com.influxdb.query.dsl.functions.LimitFlux;
import com.influxdb.query.dsl.functions.MapFlux;
import com.influxdb.query.dsl.functions.MaxFlux;
import com.influxdb.query.dsl.functions.MeanFlux;
import com.influxdb.query.dsl.functions.MinFlux;
import com.influxdb.query.dsl.functions.PivotFlux;
import com.influxdb.query.dsl.functions.QuantileFlux;
import com.influxdb.query.dsl.functions.RangeFlux;
import com.influxdb.query.dsl.functions.ReduceFlux;
import com.influxdb.query.dsl.functions.RenameFlux;
import com.influxdb.query.dsl.functions.SampleFlux;
import com.influxdb.query.dsl.functions.SetFlux;
import com.influxdb.query.dsl.functions.SkewFlux;
import com.influxdb.query.dsl.functions.SortFlux;
import com.influxdb.query.dsl.functions.SpreadFlux;
import com.influxdb.query.dsl.functions.StddevFlux;
import com.influxdb.query.dsl.functions.SumFlux;
import com.influxdb.query.dsl.functions.TailFlux;
import com.influxdb.query.dsl.functions.TimeShiftFlux;
import com.influxdb.query.dsl.functions.ToBoolFlux;
import com.influxdb.query.dsl.functions.ToDurationFlux;
import com.influxdb.query.dsl.functions.ToFloatFlux;
import com.influxdb.query.dsl.functions.ToFlux;
import com.influxdb.query.dsl.functions.ToIntFlux;
import com.influxdb.query.dsl.functions.ToStringFlux;
import com.influxdb.query.dsl.functions.ToTimeFlux;
import com.influxdb.query.dsl.functions.ToUIntFlux;
import com.influxdb.query.dsl.functions.TruncateTimeColumnFlux;
import com.influxdb.query.dsl.functions.UnionFlux;
import com.influxdb.query.dsl.functions.WindowFlux;
import com.influxdb.query.dsl.functions.YieldFlux;
import com.influxdb.query.dsl.functions.properties.FunctionsParameters;
import com.influxdb.query.dsl.functions.properties.TimeInterval;
import com.influxdb.query.dsl.functions.restriction.Restrictions;
import com.influxdb.query.dsl.utils.ImportUtils;
import com.influxdb.utils.Arguments;

/**
 * <a href="http://bit.ly/flux-spec#basic-syntax">Flux</a> - Data Scripting Language.
 * <br>
 * <a href="http://bit.ly/flux-spec">Flux Specification</a>
 *
 * <p>
 * <b>The functions:</b>
 * <ul>
 * <li>{@link AggregateWindow}</li>
 * <li>{@link FromFlux}</li>
 * <li>{@link CountFlux}</li>
 * <li>{@link CovarianceFlux}</li>
 * <li>{@link CumulativeSumFlux}</li>
 * <li>{@link DerivativeFlux}</li>
 * <li>{@link DifferenceFlux}</li>
 * <li>{@link DistinctFlux}</li>
 * <li>{@link DropFlux}</li>
 * <li>{@link DuplicateFlux}</li>
 * <li>{@link ElapsedFlux}</li>
 * <li>{@link FillFlux}</li>
 * <li>{@link FilterFlux}</li>
 * <li>{@link FirstFlux}</li>
 * <li>{@link GroupFlux}</li>
 * <li>{@link IntegralFlux}</li>
 * <li>{@link JoinFlux}</li>
 * <li>{@link KeepFlux}</li>
 * <li>{@link LastFlux}</li>
 * <li>{@link LimitFlux}</li>
 * <li>{@link MapFlux}</li>
 * <li>{@link MaxFlux}</li>
 * <li>{@link MeanFlux}</li>
 * <li>{@link MinFlux}</li>
 * <li>{@link QuantileFlux}</li>
 * <li>{@link PivotFlux}</li>
 * <li>{@link RangeFlux}</li>
 * <li>{@link RenameFlux}</li>
 * <li>{@link SampleFlux}</li>
 * <li>{@link SetFlux}</li>
 * <li>{@link TimeShiftFlux}</li>
 * <li>{@link SkewFlux}</li>
 * <li>{@link SortFlux}</li>
 * <li>{@link SpreadFlux}</li>
 * <li>{@link StddevFlux}</li>
 * <li>{@link SumFlux}</li>
 * <li>{@link ToFlux}</li>
 * <li>{@link ToBoolFlux}</li>
 * <li>{@link ToIntFlux}</li>
 * <li>{@link ToFloatFlux}</li>
 * <li>{@link ToDurationFlux}</li>
 * <li>{@link ToStringFlux}</li>
 * <li>{@link ToTimeFlux}</li>
 * <li>{@link ToUIntFlux}</li>
 * <li>{@link WindowFlux}</li>
 * <li>{@link YieldFlux}</li>
 * <li>{@link ExpressionFlux}</li>
 * </ul>
 *
 * @author Jakub Bednar (bednar@github) (22/06/2018 10:16)
 */
@SuppressWarnings({ "FileLength" })
public abstract class Flux implements HasImports, Expression {

    protected FunctionsParameters functionsParameters = FunctionsParameters.of();

    protected Set<String> imports;

    /**
     * Get data from the specified database.
     *
     * @param bucket Bucket name
     * @return {@link FromFlux}
     */
    @Nonnull
    public static FromFlux from(@Nonnull final String bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get data from the specified database.
     *
     * @param bucket Bucket name
     * @param hosts  the Fluxd hosts
     * @return {@link FromFlux}
     */
    @Nonnull
    public static FromFlux from(@Nonnull final String bucket, @Nonnull final Collection<String> hosts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get data from the specified database.
     *
     * @param bucket Bucket name
     * @param hosts  the Fluxd hosts
     * @return {@link FromFlux}
     */
    @Nonnull
    public static FromFlux from(@Nonnull final String bucket, @Nonnull final String[] hosts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Applies an aggregate or selector function to fixed windows of time.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link AggregateWindow#withEvery(Long, ChronoUnit)}</li>
     * <li>{@link AggregateWindow#withEvery(String)}</li>
     * <li>{@link AggregateWindow#withFunction(String, Object)}</li>
     * <li>{@link AggregateWindow#withAggregateFunction(String)}</li>
     * <li>{@link AggregateWindow#withColumn(String)}</li>
     * <li>{@link AggregateWindow#withTimeSrc(String)}</li>
     * <li>{@link AggregateWindow#withTimeDst(String)}</li>
     * <li>{@link AggregateWindow#withCreateEmpty(boolean)}</li>
     * </ul>
     *
     * @return {@link AggregateWindow}
     */
    public final AggregateWindow aggregateWindow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Applies an aggregate or selector function to fixed windows of time.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link AggregateWindow#withEvery(Long, ChronoUnit)}</li>
     * <li>{@link AggregateWindow#withEvery(String)}</li>
     * <li>{@link AggregateWindow#withFunction(String, Object)}</li>
     * <li>{@link AggregateWindow#withAggregateFunction(String)}</li>
     * <li>{@link AggregateWindow#withColumn(String)}</li>
     * <li>{@link AggregateWindow#withTimeSrc(String)}</li>
     * <li>{@link AggregateWindow#withTimeDst(String)}</li>
     * <li>{@link AggregateWindow#withCreateEmpty(boolean)}</li>
     * </ul>
     *
     * @param every         The duration of windows.
     * @param everyUnit     a {@code ChronoUnit} determining how to interpret the {@code every}.
     * @param namedFunction specifies the named aggregate operation to perform.
     * @return {@link AggregateWindow}
     */
    @Nonnull
    public final AggregateWindow aggregateWindow(@Nonnull final Long every, @Nonnull final ChronoUnit everyUnit, @Nonnull final String namedFunction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Constructs a table from an array of records.
     *
     * @return {@link ArrayFromFlux}
     */
    @Nonnull
    public static ArrayFromFlux arrayFrom() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Constructs a table from an array of records.
     *
     * @param rows Array of records to construct a table with.
     * @return {@link ArrayFromFlux}
     */
    @SafeVarargs
    @Nonnull
    public static ArrayFromFlux arrayFrom(@Nonnull final Map<String, Object>... rows) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Join two time series together on time and the list of tags.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link JoinFlux#withTable(String, Flux)}</li>
     * <li>{@link JoinFlux#withOn(String)}</li>
     * <li>{@link JoinFlux#withOn(String[])}</li>
     * <li>{@link JoinFlux#withOn(Collection)}</li>
     * <li>{@link JoinFlux#withMethod(String)}</li>
     * <li>{@link JoinFlux#withPropertyNamed(String)}</li>
     * <li>{@link JoinFlux#withPropertyNamed(String, String)}</li>
     * </ul>
     *
     * @return {@link JoinFlux}
     */
    @Nonnull
    public static JoinFlux join() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Join two time series together on time and the list of tags.
     *
     * @param name1  table 1 name
     * @param table1 table 1 Flux script
     * @param name2  table 2 name
     * @param table2 table 2 Flux script
     * @param tag    tag key to join
     * @param method the type of join to be performed
     * @return {@link JoinFlux}
     */
    @Nonnull
    public static JoinFlux join(@Nonnull final String name1, @Nonnull final Flux table1, @Nonnull final String name2, @Nonnull final Flux table2, @Nonnull final String tag, @Nonnull final String method) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * It will return a table containing only columns that are specified.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link KeepFlux#withColumns(String[])}</li>
     * <li>{@link KeepFlux#withFunction(String)}</li>
     * <li>{@link KeepFlux#withPropertyNamed(String)}</li>
     * <li>{@link KeepFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link KeepFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link KeepFlux}
     */
    @Nonnull
    public final KeepFlux keep() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * It will return a table containing only columns that are specified.
     *
     * @param columns The list of columns that should be included in the resulting table.
     * @return {@link KeepFlux}
     */
    @Nonnull
    public final KeepFlux keep(@Nonnull final Collection<String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * It will return a table containing only columns that are specified.
     *
     * @param columns The list of columns that should be included in the resulting table.
     * @return {@link DropFlux}
     */
    @Nonnull
    public final KeepFlux keep(@Nonnull final String[] columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * It will return a table containing only columns that are specified.
     *
     * @param function The function which takes a column name as a parameter and returns a boolean indicating whether
     *                 or not the column should be included in the resulting table.
     * @return {@link DropFlux}
     */
    @Nonnull
    public final KeepFlux keep(@Nonnull final String function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Lists the column labels of input tables.
     *
     * @return {@link ColumnsFlux}
     */
    @Nonnull
    public final ColumnsFlux columns() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Lists the column labels of input tables.
     *
     * @param column The name of the output column in which to store the column labels.
     * @return {@link ColumnsFlux}
     */
    @Nonnull
    public final ColumnsFlux columns(@Nonnull final String column) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Counts the number of results.
     *
     * @return {@link CountFlux}
     */
    @Nonnull
    public final CountFlux count() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Counts the number of results.
     *
     * @param column The column to aggregate.
     * @return {@link CountFlux}
     */
    @Nonnull
    public final CountFlux count(@Nonnull final String column) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Covariance computes the covariance between two columns.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link CovarianceFlux#withColumns(String[])}</li>
     * <li>{@link CovarianceFlux#withColumns(Collection)}</li>
     * <li>{@link CovarianceFlux#withPearsonr(boolean)}</li>
     * <li>{@link CovarianceFlux#withValueDst(String)}</li>
     * <li>{@link CovarianceFlux#withPropertyNamed(String)}</li>
     * <li>{@link CovarianceFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link CovarianceFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link CovarianceFlux}
     */
    @Nonnull
    public final CovarianceFlux covariance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Covariance computes the covariance between two columns.
     *
     * @param columns list of columns on which to compute the covariance. Exactly two columns must be provided.
     * @return {@link CovarianceFlux}
     */
    @Nonnull
    public final CovarianceFlux covariance(@Nonnull final Collection<String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Covariance computes the covariance between two columns.
     *
     * @param columns list of columns on which to compute the covariance. Exactly two columns must be provided.
     * @return {@link CovarianceFlux}
     */
    @Nonnull
    public final CovarianceFlux covariance(@Nonnull final String[] columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Covariance computes the covariance between two columns.
     *
     * @param columns  list of columns on which to compute the covariance. Exactly two columns must be provided.
     * @param pearsonr indicates whether the result should be normalized to be the Pearson R coefficient
     * @return {@link CovarianceFlux}
     */
    @Nonnull
    public final CovarianceFlux covariance(@Nonnull final Collection<String> columns, final boolean pearsonr) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Covariance computes the covariance between two columns.
     *
     * @param columns  list of columns on which to compute the covariance. Exactly two columns must be provided.
     * @param pearsonr indicates whether the result should be normalized to be the Pearson R coefficient
     * @return {@link CovarianceFlux}
     */
    @Nonnull
    public final CovarianceFlux covariance(@Nonnull final String[] columns, final boolean pearsonr) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Covariance computes the covariance between two columns.
     *
     * @param columns  list of columns on which to compute the covariance. Exactly two columns must be provided.
     * @param valueDst column into which the result will be placed.
     * @return {@link CovarianceFlux}
     */
    @Nonnull
    public final CovarianceFlux covariance(@Nonnull final Collection<String> columns, @Nonnull final String valueDst) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Covariance computes the covariance between two columns.
     *
     * @param columns  list of columns on which to compute the covariance. Exactly two columns must be provided.
     * @param valueDst column into which the result will be placed.
     * @return {@link CovarianceFlux}
     */
    @Nonnull
    public final CovarianceFlux covariance(@Nonnull final String[] columns, @Nonnull final String valueDst) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Covariance computes the covariance between two columns.
     *
     * @param columns  list of columns on which to compute the covariance. Exactly two columns must be provided.
     * @param pearsonr indicates whether the result should be normalized to be the Pearson R coefficient
     * @param valueDst column into which the result will be placed.
     * @return {@link CovarianceFlux}
     */
    @Nonnull
    public final CovarianceFlux covariance(@Nonnull final Collection<String> columns, final boolean pearsonr, @Nonnull final String valueDst) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Covariance computes the covariance between two columns.
     *
     * @param columns  list of columns on which to compute the covariance. Exactly two columns must be provided.
     * @param pearsonr indicates whether the result should be normalized to be the Pearson R coefficient
     * @param valueDst column into which the result will be placed.
     * @return {@link CovarianceFlux}
     */
    @Nonnull
    public final CovarianceFlux covariance(@Nonnull final String[] columns, final boolean pearsonr, @Nonnull final String valueDst) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Computes a running sum for non null records in the table.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link CumulativeSumFlux#withColumns(String[])}</li>
     * <li>{@link CumulativeSumFlux#withColumns(Collection)}</li>
     * <li>{@link CumulativeSumFlux#withPropertyNamed(String)}</li>
     * <li>{@link CumulativeSumFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link CumulativeSumFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link CumulativeSumFlux}
     */
    @Nonnull
    public final CumulativeSumFlux cumulativeSum() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Computes a running sum for non null records in the table.
     *
     * @param columns the columns on which to operate
     * @return {@link CumulativeSumFlux}
     */
    @Nonnull
    public final CumulativeSumFlux cumulativeSum(@Nonnull final String[] columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Computes a running sum for non null records in the table.
     *
     * @param columns the columns on which to operate
     * @return {@link CumulativeSumFlux}
     */
    @Nonnull
    public final CumulativeSumFlux cumulativeSum(@Nonnull final Collection<String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Computes the time based difference between subsequent non null records.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link DerivativeFlux#withUnit(Long, ChronoUnit)}</li>
     * <li>{@link DerivativeFlux#withNonNegative(boolean)}</li>
     * <li>{@link DerivativeFlux#withColumns(String[])}</li>
     * <li>{@link DerivativeFlux#withTimeColumn(String)}</li>
     * <li>{@link DerivativeFlux#withPropertyNamed(String)}</li>
     * <li>{@link DerivativeFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link DerivativeFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link DerivativeFlux}
     */
    @Nonnull
    public final DerivativeFlux derivative() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Computes the time based difference between subsequent non null records.
     *
     * @param duration the time duration to use for the result
     * @param unit     a {@code ChronoUnit} determining how to interpret the {@code duration} parameter
     * @return {@link DerivativeFlux}
     */
    @Nonnull
    public final DerivativeFlux derivative(@Nonnull final Long duration, @Nonnull final ChronoUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Difference computes the difference between subsequent non null records.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link DifferenceFlux#withNonNegative(boolean)}</li>
     * <li>{@link DifferenceFlux#withColumns(String[])}</li>
     * <li>{@link DifferenceFlux#withColumns(Collection)}</li>
     * <li>{@link DifferenceFlux#withPropertyNamed(String)}</li>
     * <li>{@link DifferenceFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link DifferenceFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link DifferenceFlux}
     */
    @Nonnull
    public final DifferenceFlux difference() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Difference computes the difference between subsequent non null records.
     *
     * @param nonNegative indicates if the derivative is allowed to be negative
     * @return {@link DifferenceFlux}
     */
    @Nonnull
    public final DifferenceFlux difference(final boolean nonNegative) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Difference computes the difference between subsequent non null records.
     *
     * @param columns list of columns on which to compute the difference
     * @return {@link DifferenceFlux}
     */
    @Nonnull
    public final DifferenceFlux difference(@Nonnull final Collection<String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Difference computes the difference between subsequent non null records.
     *
     * @param columns list of columns on which to compute the difference
     * @return {@link DifferenceFlux}
     */
    @Nonnull
    public final DifferenceFlux difference(@Nonnull final String[] columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Difference computes the difference between subsequent non null records.
     *
     * @param nonNegative indicates if the derivative is allowed to be negative
     * @param columns     list of columns on which to compute the difference
     * @return {@link DifferenceFlux}
     */
    @Nonnull
    public final DifferenceFlux difference(@Nonnull final Collection<String> columns, final boolean nonNegative) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Difference computes the difference between subsequent non null records.
     *
     * @param nonNegative indicates if the derivative is allowed to be negative
     * @param columns     list of columns on which to compute the difference
     * @return {@link DifferenceFlux}
     */
    @Nonnull
    public final DifferenceFlux difference(@Nonnull final String[] columns, final boolean nonNegative) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Distinct produces the unique values for a given column.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link DistinctFlux#withColumn(String)}</li>
     * <li>{@link DistinctFlux#withPropertyNamed(String)}</li>
     * <li>{@link DistinctFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link DistinctFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link DistinctFlux}
     */
    @Nonnull
    public final DistinctFlux distinct() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Distinct produces the unique values for a given column.
     *
     * @param column The column on which to track unique values.
     * @return {@link DistinctFlux}
     */
    @Nonnull
    public final DistinctFlux distinct(@Nonnull final String column) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Drop will exclude specified columns from a table.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link DropFlux#withColumns(String[])}</li>
     * <li>{@link DropFlux#withFunction(String)}</li>
     * <li>{@link DropFlux#withPropertyNamed(String)}</li>
     * <li>{@link DropFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link DropFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link DropFlux}
     */
    @Nonnull
    public final DropFlux drop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Drop will exclude specified columns from a table.
     *
     * @param columns The list of columns which should be excluded from the resulting table.
     * @return {@link DropFlux}
     */
    @Nonnull
    public final DropFlux drop(@Nonnull final Collection<String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Drop will exclude specified columns from a table.
     *
     * @param columns The list of columns which should be excluded from the resulting table.
     * @return {@link DropFlux}
     */
    @Nonnull
    public final DropFlux drop(@Nonnull final String[] columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Drop will exclude specified columns from a table.
     *
     * @param function The function which takes a column name as a parameter and returns a boolean indicating whether
     *                 or not the column should be excluded from the resulting table.
     * @return {@link DropFlux}
     */
    @Nonnull
    public final DropFlux drop(@Nonnull final String function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Duplicate will duplicate a specified column in a table.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link DuplicateFlux#withAs(String)}</li>
     * <li>{@link DuplicateFlux#withColumn(String)} (String)}</li>
     * <li>{@link DuplicateFlux#withPropertyNamed(String)}</li>
     * <li>{@link DuplicateFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link DuplicateFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link DuplicateFlux}
     */
    @Nonnull
    public final DuplicateFlux duplicate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Duplicate will duplicate a specified column in a table.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link DuplicateFlux#withAs(String)}</li>
     * <li>{@link DuplicateFlux#withColumn(String)} (String)}</li>
     * <li>{@link DuplicateFlux#withPropertyNamed(String)}</li>
     * <li>{@link DuplicateFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link DuplicateFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @param column the column to duplicate
     * @param as     the name that should be assigned to the duplicate column
     * @return {@link DuplicateFlux}
     */
    @Nonnull
    public final DuplicateFlux duplicate(@Nonnull final String column, @Nonnull final String as) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Elapsed will add a column "elapsed" which measures the time elapsed since the last reading in the series.
     * <p>The unit parameter is defined by {@link ElapsedFlux#withDuration}.
     *
     * @param unit the {@link TimeInterval} used for measuring elapsed time.
     * @return an {@link ElapsedFlux} object.
     */
    @Nonnull
    public final ElapsedFlux elapsed(@Nonnull final TimeInterval unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Elapsed will add a column "elapsed" which measures the time elapsed since the last reading in the series.
     * <p> The unit parameter is defined by {@link ElapsedFlux#withDuration}.
     *
     * @param count the number of ChronoUnits used for measuring elapsed time.
     * @param unit {@link java.time.temporal.ChronoUnit}
     * @return an {@link ElapsedFlux} object.
     */
    @Nonnull
    public final ElapsedFlux elapsed(@Nonnull final int count, @Nonnull final ChronoUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Elapsed will add a column "elapsed" which measures the time elapsed since the last reading in the series.
     * <p>In this version the default count is 1.  So the interval will be measured only in the provided ChronoUnit.
     * <p>Internally, the unit parameter is defined by {@link ElapsedFlux#withDuration}.
     *
     * @param unit the {@link java.time.temporal.ChronoUnit} used for measuring elapsed time.
     * @return an {@link ElapsedFlux} object.
     */
    @Nonnull
    public final ElapsedFlux elapsed(@Nonnull final ChronoUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Elapsed will add a column "elapsed" which measures the time elapsed since the last reading in the series
     * (this method defaults to units of 1 ms).
     * <p>This version defaults to single millisecond time units.
     *
     * @return an {@link ElapsedFlux} object.
     */
    @Nonnull
    public final ElapsedFlux elapsed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Replaces all null values in input tables with a non-null value.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link FillFlux#withUsePrevious(Boolean)}</li>
     * <li>{@link FillFlux#withColumn(String)}</li>
     * <li>{@link FillFlux#withValue(Object)}</li>
     * </ul>
     *
     * @return {@link FillFlux}
     */
    @Nonnull
    public final FillFlux fill() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Replaces all null values in input tables with a non-null value.
     *
     * @param value The constant value to use in place of nulls. The type must match the type of the valueColumn.
     * @return {@link FillFlux}
     */
    @Nonnull
    public final FillFlux fill(@Nonnull final Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the first result of the query.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link FilterFlux#withRestrictions(Restrictions)}</li>
     * <li>{@link FilterFlux#withPropertyNamed(String)}</li>
     * <li>{@link FilterFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link FilterFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link FilterFlux}
     */
    @Nonnull
    public final FilterFlux filter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the first result of the query.
     *
     * @param restrictions filter restrictions
     * @return {@link FilterFlux}
     */
    @Nonnull
    public final FilterFlux filter(@Nonnull final Restrictions restrictions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the first result of the query.
     *
     * @return {@link FirstFlux}
     */
    @Nonnull
    public final FirstFlux first() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Groups results by a user-specified set of tags.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link GroupFlux#withBy(String[])}</li>
     * <li>{@link GroupFlux#withBy(Collection)}</li>
     * <li>{@link GroupFlux#withExcept(String[])}</li>
     * <li>{@link GroupFlux#withExcept(Collection)}</li>
     * <li>{@link GroupFlux#withPropertyNamed(String)}</li>
     * <li>{@link GroupFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link GroupFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link GroupFlux}
     */
    @Nonnull
    public final GroupFlux group() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Groups results by a user-specified set of tags.
     *
     * @param groupBy Group by these specific tag name.
     * @return {@link GroupFlux}
     */
    @Nonnull
    public final GroupFlux groupBy(@Nonnull final String groupBy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Groups results by a user-specified set of tags.
     *
     * @param groupBy Group by these specific tag names.
     * @return {@link GroupFlux}
     */
    @Nonnull
    public final GroupFlux groupBy(@Nonnull final Collection<String> groupBy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Groups results by a user-specified set of tags.
     *
     * @param groupBy Group by these specific tag names.
     * @return {@link GroupFlux}
     */
    @Nonnull
    public final GroupFlux groupBy(@Nonnull final String[] groupBy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Groups results by a user-specified set of tags.
     *
     * @param except Group by all but these tag keys Cannot be used.
     * @return {@link GroupFlux}
     */
    @Nonnull
    public final GroupFlux groupExcept(@Nonnull final Collection<String> except) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Groups results by a user-specified set of tags.
     *
     * @param except Group by all but these tag keys Cannot be used.
     * @return {@link GroupFlux}
     */
    @Nonnull
    public final GroupFlux groupExcept(@Nonnull final String except) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Groups results by a user-specified set of tags.
     *
     * @param except Group by all but these tag keys Cannot be used.
     * @return {@link GroupFlux}
     */
    @Nonnull
    public final GroupFlux groupExcept(@Nonnull final String[] except) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * For each aggregate column, it outputs the area under the curve of non null records.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link IntegralFlux#withUnit(Long, ChronoUnit)}</li>
     * <li>{@link IntegralFlux#withPropertyNamed(String)}</li>
     * <li>{@link IntegralFlux#withPropertyNamed(String, String)}</li>
     * </ul>
     *
     * @return {@link IntegralFlux}
     */
    @Nonnull
    public final IntegralFlux integral() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * For each aggregate column, it outputs the area under the curve of non null records.
     *
     * @param duration Time duration to use when computing the integral
     * @param unit     a {@code ChronoUnit} determining how to interpret the {@code duration} parameter
     * @return {@link IntegralFlux}
     */
    @Nonnull
    public final IntegralFlux integral(@Nonnull final Long duration, @Nonnull final ChronoUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The `interpolate.linear` function inserts rows at regular intervals using linear interpolation to determine
     * values for inserted rows.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link InterpolateLinearFlux#withEvery(long, ChronoUnit)}</li>
     * <li>{@link InterpolateLinearFlux#withPropertyNamed(String)}</li>
     * <li>{@link InterpolateLinearFlux#withPropertyNamed(String, String)}</li>
     * </ul>
     *
     * @return {@link InterpolateLinearFlux}
     */
    @Nonnull
    public final InterpolateLinearFlux interpolateLinear() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The `interpolate.linear` function inserts rows at regular intervals using linear interpolation to determine
     * values for inserted rows.
     *
     * @param duration Time duration to use when computing the interpolation
     * @param unit     a {@code ChronoUnit} determining how to interpret the {@code duration} parameter
     * @return {@link InterpolateLinearFlux}
     */
    @Nonnull
    public final InterpolateLinearFlux interpolateLinear(@Nonnull final Long duration, @Nonnull final ChronoUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the last result of the query.
     *
     * @return {@link LastFlux}
     */
    @Nonnull
    public final LastFlux last() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the last result of the query.
     *
     * @param column The column used to verify the existence of a value.
     * @return {@link LastFlux}
     */
    @Nonnull
    public final LastFlux last(@Nonnull final String column) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Restricts the number of rows returned in the results.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link LimitFlux#withN(int)}</li>
     * <li>{@link LimitFlux#withPropertyNamed(String)}</li>
     * <li>{@link LimitFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link LimitFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link LimitFlux}
     */
    @Nonnull
    public final LimitFlux limit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Restricts the number of rows returned in the results.
     *
     * @param numberOfResults The number of results
     * @return {@link LimitFlux}
     */
    @Nonnull
    public final LimitFlux limit(final int numberOfResults) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Restricts the number of rows returned in the results.
     *
     * @param numberOfResults The number of results
     * @param offset          The number of records to skip per table.
     * @return {@link LimitFlux}
     */
    @Nonnull
    public final LimitFlux limit(final int numberOfResults, final int offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Applies a function to each row of the table.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link MapFlux#withFunction(String)}</li>
     * <li>{@link MapFlux#withPropertyNamed(String)}</li>
     * <li>{@link MapFlux#withPropertyNamed(String, String)}</li>
     * </ul>
     *
     * @return {@link MapFlux}
     */
    @Nonnull
    public final MapFlux map() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Applies a function to each row of the table.
     *
     * @param function The function for map row of table. Example: "r._value * r._value".
     * @return {@link MapFlux}
     */
    @Nonnull
    public final MapFlux map(@Nonnull final String function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the max value within the results.
     *
     * @return {@link MaxFlux}
     */
    @Nonnull
    public final MaxFlux max() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the max value within the results.
     *
     * @param column The column to use to calculate the maximum value.
     * @return {@link MaxFlux}
     */
    @Nonnull
    public final MaxFlux max(@Nonnull final String column) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the mean of the values within the results.
     *
     * @return {@link MeanFlux}
     */
    @Nonnull
    public final MeanFlux mean() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the mean of the values within the results.
     *
     * @param column The column to use to compute the mean.
     * @return {@link MeanFlux}
     */
    @Nonnull
    public final MeanFlux mean(final String column) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the min value within the results.
     *
     * @return {@link MinFlux}
     */
    @Nonnull
    public final MinFlux min() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the min value within the results.
     *
     * @param column The column to use to calculate the minimum value.
     * @return {@link MinFlux}
     */
    @Nonnull
    public final MinFlux min(@Nonnull final String column) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Quantile is both an aggregate operation and a selector operation depending on selected options.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link QuantileFlux#withColumn(String)}</li>
     * <li>{@link QuantileFlux#withQuantile(Float)}</li>
     * <li>{@link QuantileFlux#withCompression(Float)}</li>
     * <li>{@link QuantileFlux#withMethod(String)}</li>
     * <li>{@link QuantileFlux#withMethod(QuantileFlux.MethodType)}</li>
     * <li>{@link QuantileFlux#withPropertyNamed(String)}</li>
     * <li>{@link QuantileFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link QuantileFlux#withPropertyValueEscaped(String, String)}</li>
     * <li>{@link QuantileFlux#withFunction(String, Object)}</li>
     * <li>{@link QuantileFlux#withFunctionNamed(String, String)}</li>
     * </ul>
     *
     * @return {@link QuantileFlux}
     */
    @Nonnull
    public final QuantileFlux quantile() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Quantile is both an aggregate operation and a selector operation depending on selected options.
     *
     * @param quantile value between 0 and 1 indicating the desired quantile
     * @return {@link QuantileFlux}
     */
    @Nonnull
    public final QuantileFlux quantile(@Nonnull final Float quantile) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Quantile is both an aggregate operation and a selector operation depending on selected options.
     *
     * @param quantile value between 0 and 1 indicating the desired quantile
     * @param method   method to aggregate
     * @return {@link QuantileFlux}
     */
    @Nonnull
    public final QuantileFlux quantile(@Nonnull final Float quantile, @Nonnull final QuantileFlux.MethodType method) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Quantile is both an aggregate operation and a selector operation depending on selected options.
     *
     * @param quantile    value between 0 and 1 indicating the desired quantile
     * @param method      method to aggregate
     * @param compression indicates how many centroids to use when compressing the dataset
     * @return {@link QuantileFlux}
     */
    @Nonnull
    public final QuantileFlux quantile(@Nonnull final Float quantile, @Nonnull final QuantileFlux.MethodType method, @Nonnull final Float compression) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Quantile is both an aggregate operation and a selector operation depending on selected options.
     *
     * @param column      specifies a column to aggregate
     * @param quantile    value between 0 and 1 indicating the desired quantile
     * @param method      method to aggregate
     * @param compression indicates how many centroids to use when compressing the dataset.
     * @return {@link QuantileFlux}
     */
    @Nonnull
    public final QuantileFlux quantile(@Nonnull final String column, @Nonnull final Float quantile, @Nonnull final QuantileFlux.MethodType method, @Nonnull final Float compression) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Pivot collects values stored vertically (column-wise) in a table
     * and aligns them horizontally (row-wise) into logical sets.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link PivotFlux#withRowKey(String[])}</li>
     * <li>{@link PivotFlux#withRowKey(Collection)}</li>
     * <li>{@link PivotFlux#withColumnKey(String[])}</li>
     * <li>{@link PivotFlux#withColumnKey(Collection)}</li>
     * <li>{@link PivotFlux#withValueColumn(String)}</li>
     * <li>{@link PivotFlux#withPropertyNamed(String)}</li>
     * <li>{@link PivotFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link PivotFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link PivotFlux}
     */
    @Nonnull
    public final PivotFlux pivot() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Pivot collects values stored vertically (column-wise) in a table
     * and aligns them horizontally (row-wise) into logical sets.
     *
     * @param rowKey      the columns used to uniquely identify a row for the output
     * @param columnKey   the columns used to pivot values onto each row identified by the rowKey.
     * @param valueColumn the single column that contains the value to be moved around the pivot
     * @return {@link PivotFlux}
     */
    @Nonnull
    public final PivotFlux pivot(@Nonnull final String[] rowKey, @Nonnull final String[] columnKey, @Nonnull final String valueColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Pivot collects values stored vertically (column-wise) in a table
     * and aligns them horizontally (row-wise) into logical sets.
     *
     * @param rowKey      the columns used to uniquely identify a row for the output
     * @param columnKey   the columns used to pivot values onto each row identified by the rowKey.
     * @param valueColumn the single column that contains the value to be moved around the pivot
     * @return {@link PivotFlux}
     */
    @Nonnull
    public final PivotFlux pivot(@Nonnull final Collection<String> rowKey, @Nonnull final Collection<String> columnKey, @Nonnull final String valueColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filters the results by time boundaries.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link RangeFlux#withStart(Instant)}</li>
     * <li>{@link RangeFlux#withStart(Long, ChronoUnit)}</li>
     * <li>{@link RangeFlux#withStop(Instant)}</li>
     * <li>{@link RangeFlux#withStop(Long, ChronoUnit)}</li>
     * <li>{@link RangeFlux#withPropertyNamed(String)}</li>
     * <li>{@link RangeFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link RangeFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link RangeFlux}
     */
    @Nonnull
    public final RangeFlux range() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filters the results by time boundaries.
     *
     * @param start Specifies the oldest time to be included in the results
     * @return {@link RangeFlux}
     */
    @Nonnull
    public final RangeFlux range(@Nonnull final Instant start) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filters the results by time boundaries.
     *
     * @param start Specifies the oldest time to be included in the results
     * @param stop  Specifies the exclusive newest time to be included in the results
     * @return {@link RangeFlux}
     */
    @Nonnull
    public final RangeFlux range(@Nonnull final Instant start, @Nonnull final Instant stop) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filters the results by time boundaries.
     *
     * @param start Specifies the oldest time to be included in the results
     * @param unit  a {@code ChronoUnit} determining how to interpret the {@code start} parameter
     * @return {@link RangeFlux}
     */
    @Nonnull
    public final RangeFlux range(@Nonnull final Long start, @Nonnull final ChronoUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filters the results by time boundaries.
     *
     * @param start Specifies the oldest time to be included in the results
     * @param stop  Specifies the exclusive newest time to be included in the results
     * @param unit  a {@code ChronoUnit} determining how to interpret the {@code start} and {@code stop} parameter
     * @return {@link RangeFlux}
     */
    @Nonnull
    public final RangeFlux range(@Nonnull final Long start, @Nonnull final Long stop, @Nonnull final ChronoUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filters the results by time boundaries.
     *
     * @param start Specifies the oldest time (Unix timestamp in seconds) to be included in the results
     * @param stop  Specifies the exclusive newest time (Unix timestamp in seconds) to be included in the results
     * @return {@link RangeFlux}
     */
    @Nonnull
    public final RangeFlux range(final Long start, final Long stop) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filters the results by time boundaries.
     *
     * @param start Specifies the oldest time (Unix timestamp in seconds) to be included in the results
     * @return {@link RangeFlux}
     */
    @Nonnull
    public final RangeFlux range(final Long start) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reduce aggregates records in each table according to the reducer.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link ReduceFlux#withFunction(String)} </li>
     * <li>{@link ReduceFlux#withIdentity(String)}</li>
     * </ul>
     *
     * @return {@link ReduceFlux}
     */
    public final ReduceFlux reduce() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reduce aggregates records in each table according to the reducer.
     *
     * @param function Function to apply to each record. Example: "{sum: r._value + accumulator.sum}".
     * @param identity An initial value to use when creating a reducer. Example: "{sum: 0.0}".
     * @return {@link ReduceFlux}
     */
    public final ReduceFlux reduce(@Nonnull final String function, @Nonnull final String identity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Rename will rename specified columns in a table.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link RenameFlux#withColumns(Map)} </li>
     * <li>{@link RenameFlux#withFunction(String)}</li>
     * <li>{@link RenameFlux#withPropertyNamed(String)}</li>
     * <li>{@link RenameFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link RenameFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link RenameFlux}
     */
    @Nonnull
    public final RenameFlux rename() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Rename will rename specified columns in a table.
     *
     * @param columns The map of columns to rename and their corresponding new names.
     * @return {@link RenameFlux}
     */
    @Nonnull
    public final RenameFlux rename(@Nonnull final Map<String, String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Rename will rename specified columns in a table.
     *
     * @param function The function which takes a single string parameter (the old column name) and
     *                 returns a string representing the new column name.
     * @return {@link RenameFlux}
     */
    @Nonnull
    public final RenameFlux rename(@Nonnull final String function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sample values from a table.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link SampleFlux#withN(int)}</li>
     * <li>{@link SampleFlux#withPos(int)}</li>
     * <li>{@link SampleFlux#withPropertyNamed(String)}</li>
     * <li>{@link SampleFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link SampleFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link SampleFlux}
     */
    @Nonnull
    public final SampleFlux sample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sample values from a table.
     *
     * @param n Sample every Nth element.
     * @return {@link SampleFlux}
     */
    @Nonnull
    public final SampleFlux sample(final int n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sample values from a table.
     *
     * @param n   Sample every Nth element.
     * @param pos Position offset from start of results to begin sampling. Must be less than @{code n}.
     * @return {@link SampleFlux}
     */
    @Nonnull
    public final SampleFlux sample(final int n, final int pos) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Assigns a static value to each record.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link SetFlux#withKeyValue(String, String)}</li>
     * <li>{@link SetFlux#withPropertyNamed(String)}</li>
     * <li>{@link SetFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link SetFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link SetFlux}
     */
    @Nonnull
    public final SetFlux set() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Assigns a static value to each record.
     *
     * @param key   label for the column. Has to be defined.
     * @param value value for the column. Has to be defined.
     * @return {@link SetFlux}
     */
    @Nonnull
    public final SetFlux set(@Nonnull final String key, @Nonnull final String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shift add a fixed duration to time columns.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link TimeShiftFlux#withDuration(Long, ChronoUnit)}</li>
     * <li>{@link TimeShiftFlux#withColumns(String[])}</li>
     * <li>{@link TimeShiftFlux#withColumns(Collection)} )}</li>
     * <li>{@link TimeShiftFlux#withPropertyNamed(String)}</li>
     * <li>{@link TimeShiftFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link TimeShiftFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link TimeShiftFlux}
     */
    @Nonnull
    public final TimeShiftFlux timeShift() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shift add a fixed duration to time columns.
     *
     * @param amount The amount to add to each time value
     * @param unit   a {@code ChronoUnit} determining how to interpret the {@code amount} parameter
     * @return {@link TimeShiftFlux}
     */
    @Nonnull
    public final TimeShiftFlux timeShift(@Nonnull final Long amount, @Nonnull final ChronoUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shift add a fixed duration to time columns.
     *
     * @param amount  The amount to add to each time value
     * @param unit    a {@code ChronoUnit} determining how to interpret the {@code amount} parameter
     * @param columns The list of all columns that should be shifted.
     * @return {@link TimeShiftFlux}
     */
    @Nonnull
    public final TimeShiftFlux timeShift(@Nonnull final Long amount, @Nonnull final ChronoUnit unit, @Nonnull final String[] columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shift add a fixed duration to time columns.
     *
     * @param amount  The amount to add to each time value
     * @param unit    a {@code ChronoUnit} determining how to interpret the {@code amount} parameter
     * @param columns The list of all columns that should be shifted.
     * @return {@link TimeShiftFlux}
     */
    @Nonnull
    public final TimeShiftFlux timeShift(@Nonnull final Long amount, @Nonnull final ChronoUnit unit, @Nonnull final Collection<String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Skew of the results.
     *
     * @return {@link SkewFlux}
     */
    @Nonnull
    public final SkewFlux skew() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Skew of the results.
     *
     * @param column The column on which to operate.
     * @return {@link SkewFlux}
     */
    @Nonnull
    public final SkewFlux skew(@Nonnull final String column) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sorts the results by the specified columns Default sort is ascending.
     *
     * @return {@link SortFlux}
     */
    @Nonnull
    public final SortFlux sort() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sorts the results by the specified columns Default sort is ascending.
     *
     * @param desc use the descending sorting
     * @return {@link SortFlux}
     */
    @Nonnull
    public final SortFlux sort(final boolean desc) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sorts the results by the specified columns Default sort is ascending.
     *
     * @param columns columns used to sort
     * @return {@link SortFlux}
     */
    @Nonnull
    public final SortFlux sort(@Nonnull final String[] columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sorts the results by the specified columns Default sort is ascending.
     *
     * @param columns columns used to sort
     * @return {@link SortFlux}
     */
    @Nonnull
    public final SortFlux sort(@Nonnull final Collection<String> columns) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sorts the results by the specified columns Default sort is ascending.
     *
     * @param columns columns used to sort
     * @param desc    use the descending sorting
     * @return {@link SortFlux}
     */
    @Nonnull
    public final SortFlux sort(@Nonnull final String[] columns, final boolean desc) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sorts the results by the specified columns Default sort is ascending.
     *
     * @param columns columns used to sort
     * @param desc    use the descending sorting
     * @return {@link SortFlux}
     */
    @Nonnull
    public final SortFlux sort(@Nonnull final Collection<String> columns, final boolean desc) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Difference between min and max values.
     *
     * @return {@link SpreadFlux}
     */
    @Nonnull
    public final SpreadFlux spread() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Difference between min and max values.
     *
     * @param column The column on which to operate.
     * @return {@link SpreadFlux}
     */
    @Nonnull
    public final SpreadFlux spread(@Nonnull final String column) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Standard Deviation of the results.
     *
     * @return {@link StddevFlux}
     */
    @Nonnull
    public final StddevFlux stddev() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Standard Deviation of the results.
     *
     * @param column The column on which to operate.
     * @return {@link StddevFlux}
     */
    @Nonnull
    public final StddevFlux stddev(@Nonnull final String column) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sum of the results.
     *
     * @return {@link SumFlux}
     */
    @Nonnull
    public final SumFlux sum() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sum of the results.
     *
     * @param column The column on which to operate.
     * @return {@link SumFlux}
     */
    @Nonnull
    public final SumFlux sum(@Nonnull final String column) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Caps the number of records in output tables.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link TailFlux#withN(int)}</li>
     * <li>{@link TailFlux#withPropertyNamed(String)}</li>
     * <li>{@link TailFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link TailFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link TailFlux}
     */
    @Nonnull
    public final TailFlux tail() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Caps the number of records in output tables.
     *
     * @param numberOfResults The number of results
     * @return {@link TailFlux}
     */
    @Nonnull
    public final TailFlux tail(final int numberOfResults) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Caps the number of records in output tables.
     *
     * @param numberOfResults The number of results
     * @param offset          The number of records to skip per table.
     * @return {@link TailFlux}
     */
    @Nonnull
    public final TailFlux tail(final int numberOfResults, final int offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * To operation takes data from a stream and writes it to a bucket.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link ToFlux#withBucket(String)}</li>
     * <li>{@link ToFlux#withBucketID(String)}</li>
     * <li>{@link ToFlux#withOrg(String)}</li>
     * <li>{@link ToFlux#withOrgID(String)}</li>
     * <li>{@link ToFlux#withHost(String)}</li>
     * <li>{@link ToFlux#withToken(String)}</li>
     * <li>{@link ToFlux#withTimeColumn(String)}</li>
     * <li>{@link ToFlux#withTagColumns(Collection)}</li>
     * <li>{@link ToFlux#withTagColumns(String[])}</li>
     * <li>{@link ToFlux#withFieldFunction(String)}</li>
     * <li>{@link ToFlux#withPropertyNamed(String)}</li>
     * <li>{@link ToFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link ToFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link ToFlux}
     */
    @Nonnull
    public final ToFlux to() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * To operation takes data from a stream and writes it to a bucket.
     *
     * @param bucket The bucket to which data will be written.
     * @return {@link ToFlux}
     */
    @Nonnull
    public final ToFlux to(@Nonnull final String bucket) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * To operation takes data from a stream and writes it to a bucket.
     *
     * @param bucket The bucket to which data will be written.
     * @param org    The organization name of the above bucket.
     * @return {@link ToFlux}
     */
    @Nonnull
    public final ToFlux to(@Nonnull final String bucket, @Nonnull final String org) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * To operation takes data from a stream and writes it to a bucket.
     *
     * @param bucket  The bucket to which data will be written.
     * @param org     The organization name of the above bucket.
     * @param fieldFn Function that takes a record from the input table and returns an object.
     * @return {@link ToFlux}
     */
    @Nonnull
    public final ToFlux to(@Nonnull final String bucket, @Nonnull final String org, @Nonnull final String fieldFn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * To operation takes data from a stream and writes it to a bucket.
     *
     * @param bucket     The bucket to which data will be written.
     * @param org        The organization name of the above bucket.
     * @param tagColumns The tag columns of the output.
     * @param fieldFn    Function that takes a record from the input table and returns an object.
     * @return {@link ToFlux}
     */
    @Nonnull
    public final ToFlux to(@Nonnull final String bucket, @Nonnull final String org, @Nonnull final String[] tagColumns, @Nonnull final String fieldFn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * To operation takes data from a stream and writes it to a bucket.
     *
     * @param bucket     The bucket to which data will be written.
     * @param org        The organization name of the above bucket.
     * @param tagColumns The tag columns of the output.
     * @param fieldFn    Function that takes a record from the input table and returns an object.
     * @return {@link ToFlux}
     */
    @Nonnull
    public final ToFlux to(@Nonnull final String bucket, @Nonnull final String org, @Nonnull final Collection<String> tagColumns, @Nonnull final String fieldFn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * To operation takes data from a stream and writes it to a bucket.
     *
     * @param bucket     The bucket to which data will be written.
     * @param org        The organization name of the above bucket.
     * @param host       The remote host to write to.
     * @param token      The authorization token to use when writing to a remote host.
     * @param timeColumn The time column of the output.
     * @param tagColumns The tag columns of the output.
     * @param fieldFn    Function that takes a record from the input table and returns an object.
     * @return {@link ToFlux}
     */
    @Nonnull
    public final ToFlux to(@Nonnull final String bucket, @Nonnull final String org, @Nonnull final String host, @Nonnull final String token, @Nonnull final String timeColumn, @Nonnull final String[] tagColumns, @Nonnull final String fieldFn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * To operation takes data from a stream and writes it to a bucket.
     *
     * @param bucket     The bucket to which data will be written.
     * @param org        The organization name of the above bucket.
     * @param host       The remote host to write to.
     * @param token      The authorization token to use when writing to a remote host.
     * @param timeColumn The time column of the output.
     * @param tagColumns The tag columns of the output.
     * @param fieldFn    Function that takes a record from the input table and returns an object.
     * @return {@link ToFlux}
     */
    @Nonnull
    public final ToFlux to(@Nonnull final String bucket, @Nonnull final String org, @Nonnull final String host, @Nonnull final String token, @Nonnull final String timeColumn, @Nonnull final Collection<String> tagColumns, @Nonnull final String fieldFn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a value to a bool.
     *
     * @return {@link ToBoolFlux}
     */
    @Nonnull
    public final ToBoolFlux toBool() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a value to a int.
     *
     * @return {@link ToIntFlux}
     */
    @Nonnull
    public final ToIntFlux toInt() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a value to a float.
     *
     * @return {@link ToFloatFlux}
     */
    @Nonnull
    public final ToFloatFlux toFloat() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a value to a duration.
     *
     * @return {@link ToDurationFlux}
     */
    @Nonnull
    public final ToDurationFlux toDuration() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a value to a string.
     *
     * @return {@link ToStringFlux}
     */
    @Nonnull
    public final ToStringFlux toStringConvert() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a value to a time.
     *
     * @return {@link ToTimeFlux}
     */
    @Nonnull
    public final ToTimeFlux toTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Convert a value to a uint.
     *
     * @return {@link ToUIntFlux}
     */
    @Nonnull
    public final ToUIntFlux toUInt() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Truncates all input time values in the _time to a specified unit.
     *
     * @param unit Unit of time to truncate to. Has to be defined.
     * @return {@link TruncateTimeColumnFlux}
     */
    @Nonnull
    public final TruncateTimeColumnFlux truncateTimeColumn(@Nonnull final ChronoUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Merges two or more input streams into a single output stream.
     *
     * @param tables the tables to union
     * @return {@link UnionFlux}
     */
    public static UnionFlux union(@Nonnull final Flux... tables) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Groups the results by a given time range.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link WindowFlux#withEvery(Long, ChronoUnit)}</li>
     * <li>{@link WindowFlux#withPeriod(Long, ChronoUnit)}</li>
     * <li>{@link WindowFlux#withOffset(Long, ChronoUnit)}</li>
     * <li>{@link WindowFlux#withOffset(Instant)}</li>
     * <li>{@link WindowFlux#withTimeColumn(String)}</li>
     * <li>{@link WindowFlux#withStartColumn(String)}</li>
     * <li>{@link WindowFlux#withStartColumn(String)}</li>
     * <li>{@link WindowFlux#withPropertyNamed(String)}</li>
     * <li>{@link WindowFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link WindowFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link WindowFlux}
     */
    @Nonnull
    public final WindowFlux window() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Groups the results by a given time range.
     *
     * @param every     duration of time between windows
     * @param everyUnit a {@code ChronoUnit} determining how to interpret the {@code every}
     * @return {@link WindowFlux}
     */
    @Nonnull
    public final WindowFlux window(@Nonnull final Long every, @Nonnull final ChronoUnit everyUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Groups the results by a given time range.
     *
     * @param every      duration of time between windows
     * @param everyUnit  a {@code ChronoUnit} determining how to interpret the {@code every}
     * @param period     duration of the windowed partition
     * @param periodUnit a {@code ChronoUnit} determining how to interpret the {@code period}
     * @return {@link WindowFlux}
     */
    @Nonnull
    public final WindowFlux window(@Nonnull final Long every, @Nonnull final ChronoUnit everyUnit, @Nonnull final Long period, @Nonnull final ChronoUnit periodUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Groups the results by a given time range.
     *
     * @param every      duration of time between windows
     * @param everyUnit  a {@code ChronoUnit} determining how to interpret the {@code every}
     * @param period     duration of the windowed partition
     * @param periodUnit a {@code ChronoUnit} determining how to interpret the {@code period}
     * @param offset     The offset duration relative to the location offset
     * @return {@link WindowFlux}
     */
    @Nonnull
    public final WindowFlux window(@Nonnull final Long every, @Nonnull final ChronoUnit everyUnit, @Nonnull final Long period, @Nonnull final ChronoUnit periodUnit, @Nonnull final Instant offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Groups the results by a given time range.
     *
     * @param every      duration of time between windows
     * @param everyUnit  a {@code ChronoUnit} determining how to interpret the {@code every}
     * @param period     duration of the windowed partition
     * @param periodUnit a {@code ChronoUnit} determining how to interpret the {@code period}
     * @param offset     The offset duration relative to the location offset
     * @param offsetUnit a {@code ChronoUnit} determining how to interpret the {@code offset}
     * @return {@link WindowFlux}
     */
    @Nonnull
    public final WindowFlux window(@Nonnull final Long every, @Nonnull final ChronoUnit everyUnit, @Nonnull final Long period, @Nonnull final ChronoUnit periodUnit, @Nonnull final Long offset, @Nonnull final ChronoUnit offsetUnit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Partitions the results by a given time range.
     *
     * @param every       duration of time between windows
     * @param everyUnit   a {@code ChronoUnit} determining how to interpret the {@code every}
     * @param period      duration of the windowed partition
     * @param periodUnit  a {@code ChronoUnit} determining how to interpret the {@code period}
     * @param offset      The offset duration relative to the location offset
     * @param offsetUnit  a {@code ChronoUnit} determining how to interpret the {@code offset}
     * @param timeColumn  name of the time column to use
     * @param startColumn name of the column containing the window start time
     * @param stopColumn  name of the column containing the window stop time
     * @return {@link WindowFlux}
     */
    @Nonnull
    public final WindowFlux window(@Nonnull final Long every, @Nonnull final ChronoUnit everyUnit, @Nonnull final Long period, @Nonnull final ChronoUnit periodUnit, @Nonnull final Long offset, @Nonnull final ChronoUnit offsetUnit, @Nonnull final String timeColumn, @Nonnull final String startColumn, @Nonnull final String stopColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Partitions the results by a given time range.
     *
     * @param every       duration of time between windows
     * @param everyUnit   a {@code ChronoUnit} determining how to interpret the {@code every}
     * @param period      duration of the windowed partition
     * @param periodUnit  a {@code ChronoUnit} determining how to interpret the {@code period}
     * @param offset      The offset duration relative to the location offset
     * @param timeColumn  name of the time column to use
     * @param startColumn name of the column containing the window start time
     * @param stopColumn  name of the column containing the window stop time
     * @return {@link WindowFlux}
     */
    @Nonnull
    public final WindowFlux window(@Nonnull final Long every, @Nonnull final ChronoUnit everyUnit, @Nonnull final Long period, @Nonnull final ChronoUnit periodUnit, @Nonnull final Instant offset, @Nonnull final String timeColumn, @Nonnull final String startColumn, @Nonnull final String stopColumn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Yield a query results to yielded results.
     *
     * <p>
     * <b>The parameters had to be defined by:</b>
     * <ul>
     * <li>{@link YieldFlux#withName(String)}</li>
     * <li>{@link YieldFlux#withPropertyNamed(String)}</li>
     * <li>{@link YieldFlux#withPropertyNamed(String, String)}</li>
     * <li>{@link YieldFlux#withPropertyValueEscaped(String, String)}</li>
     * </ul>
     *
     * @return {@link YieldFlux}
     */
    @Nonnull
    public final YieldFlux yield() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Yield a query results to yielded results.
     *
     * @param name The unique name to give to yielded results. Has to be defined.
     * @return {@link YieldFlux}
     */
    @Nonnull
    public final YieldFlux yield(@Nonnull final String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Write the custom Flux expression.
     *
     * @param expression flux expression
     * @return {@link ExpressionFlux}
     */
    @Nonnull
    public final ExpressionFlux expression(@Nonnull final String expression) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create new function with type {@code type}.
     *
     * <pre>
     * Flux flux = Flux
     *      .from("telegraf")
     *      .function(FilterMeasurement.class)
     *          .withName("cpu")
     *      .sum();
     * </pre>
     *
     * @param type function type
     * @param <F>  function type
     * @return function with {@code type}
     */
    @Nonnull
    public final <F extends AbstractParametrizedFlux> F function(@Nonnull final Class<F> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a piped function call.
     *
     * <p>
     * <b>Example Definition</b>
     * <pre>
     * public static class MultByXFunction extends AbstractFunctionFlux&lt;MultByXFunction.MultByXFunctionCall&gt; {
     *
     *     public MultByXFunction() {
     *         super("multByX",
     *                 new FreestyleExpression("tables")
     *                         .map("(r) =&gt; ({r with _value: r._value * x})"),
     *                 MultByXFunctionCall::new,
     *                 new Parameter("tables").withPipeForward(true),
     *                 new Parameter("x"));
     *     }
     *
     *     public static class MultByXFunctionCall extends AbstractFunctionCallFlux {
     *
     *         public MultByXFunctionCall(@Nonnull String name) {
     *             super(name);
     *         }
     *
     *         public MultByXFunctionCall withX(final Number x) {
     *             this.withPropertyValue("x", x);
     *             return this;
     *         }
     *     }
     * }
     * </pre>
     * <p>
     * <b>Example Usage</b>
     * <pre>
     * MultByXFunction multByX = new MultByXFunction();
     *
     * Expressions flux = new Expressions(
     *         multByX,
     *         Flux.from("telegraph")
     *                 .withPipedFunction(multByX)
     *                 .withX(42.)
     *                 .count()
     * );
     * </pre>
     *
     * @param fun    the function to be piped
     * @param <CALL> the type of the invocation
     * @return the invocation
     */
    public <CALL extends AbstractFunctionCallFlux> CALL withPipedFunction(final AbstractFunctionFlux<CALL> fun) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add named property to current function.
     *
     * <pre>
     *  FluxChain fluxChain = new FluxChain()
     *      .withPropertyNamed("every", 15, ChronoUnit.MINUTES)
     *      .withPropertyNamed("period", 20L, ChronoUnit.SECONDS)
     *      .withPropertyNamed("start", -50, ChronoUnit.DAYS)
     *      .withPropertyNamed("round", 1L, ChronoUnit.HOURS);
     *
     *  Flux flux = Flux.from("telegraf")
     *      .window()
     *          .withPropertyNamed("every")
     *          .withPropertyNamed("period")
     *          .withPropertyNamed("start")
     *          .withPropertyNamed("round")
     *      .sum();
     *
     * flux.print(fluxChain);
     * </pre>
     *
     * @param property name in Flux query and in named properties
     * @return a current function.
     */
    @Nonnull
    public final Flux withPropertyNamed(@Nonnull final String property) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add named property to current function.
     *
     * <pre>
     * Flux flux = Flux
     *      .from("telegraf")
     *      .limit()
     *          .withPropertyNamed("n", "limit")
     *      .sum();
     *
     * FluxChain fluxChain = new FluxChain()
     *      .withPropertyNamed("limit", 15);
     *
     * flux.print(fluxChain);
     * </pre>
     *
     * @param fluxName      name in Flux query
     * @param namedProperty name in named properties
     * @return a current function
     */
    @Nonnull
    public final Flux withPropertyNamed(@Nonnull final String fluxName, @Nonnull final String namedProperty) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add property value to current function.
     *
     * <pre>
     * Flux flux = Flux
     *      .from("telegraf")
     *      .limit()
     *          .withPropertyValue("n", 5)
     *      .sum();
     * </pre>
     *
     * @param propertyName name in Flux query
     * @param value        value of property. If null than ignored.
     * @return a current function
     */
    @Nonnull
    public final Flux withPropertyValue(@Nonnull final String propertyName, @Nullable final Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add named function to current function.
     *
     * <pre>
     * Flux flux = Flux
     *      .from("telegraf")
     *      .drop()
     *           .withFunction("fn", "column =~ free*");
     * </pre>
     *
     * @param functionName name in Flux query
     * @param function     defined function
     * @return a current function
     */
    @Nonnull
    public final Flux withFunction(@Nonnull final String functionName, @Nullable final Object function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add named function to current function.
     *
     * <pre>
     * Map&lt;String, Object&gt; parameters = new HashMap&lt;&gt;();
     * parameters.put("function", "r._value * 10");
     *
     * Flux flux = Flux
     *     .from("telegraf")
     *     .range(-12L, ChronoUnit.HOURS)
     *     .map()
     *          .withFunctionNamed("fn: (r)", "function");
     * </pre>
     *
     * @param functionName  name in Flux query
     * @param namedProperty name in named properties
     * @return a current function
     */
    @Nonnull
    public final Flux withFunctionNamed(@Nonnull final String functionName, @Nonnull final String namedProperty) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add string property value to current function that will be quoted (value =&gt; "value").
     *
     * <pre>
     * Flux flux = Flux
     *      .from("telegraf")
     *      .window(5, ChronoUnit.MINUTES)
     *          .withPropertyValueEscaped("startColumn", "differentCol")
     *      .sum();
     * </pre>
     *
     * @param property name of property in Flux query
     * @param amount   the amount of the duration, measured in terms of the unit, positive or negative
     * @param unit     the unit that the duration is measured in, must have an exact duration.  If null than ignored.
     * @return a current function
     */
    @Nonnull
    public final Flux withPropertyValue(@Nonnull final String property, @Nullable final Long amount, @Nullable final ChronoUnit unit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add string property value to current function that will be quoted (value =&gt; "value").
     *
     * <pre>
     * Flux flux = Flux
     *      .from("telegraf")
     *      .window(5, ChronoUnit.MINUTES)
     *          .withPropertyValueEscaped("startColumn", "differentCol")
     *      .sum();
     * </pre>
     *
     * @param property name of property in Flux query
     * @param value    value of property. If null than ignored.
     * @return a current function
     */
    @Nonnull
    public final Flux withPropertyValueEscaped(@Nonnull final String property, @Nullable final String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Append actual Flux function to Flux query.
     *
     * @param parameters named parameters for Flux query
     * @param builder    Flux query chaing
     */
    public abstract void appendActual(@Nonnull final Map<String, Object> parameters, @Nonnull final StringBuilder builder);

    /**
     * Create the Flux query that can be executed by FluxService.
     *
     * @return Flux query
     */
    @Nonnull
    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create the Flux query that can be executed by FluxService.
     *
     * @param parameters flux query named parameters
     * @return Flux query
     */
    @Nonnull
    public String toString(@Nonnull final Map<String, Object> parameters) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString(@Nonnull final Map<String, Object> parameters, final boolean prependImports) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts this flux to a variable assignment so multiple fluxes can be used in conjunction with
     * {@link Expressions}.
     *
     * @param name the name of the variable
     * @return a variable assignment
     * @see Expressions
     */
    public VariableAssignment asVariable(final String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return all used imports of this flux
     */
    @Override
    public Set<String> getImports() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Collects all imports of the flux.
     *
     * @param collectedImports a set to be filled by the used imports
     */
    public void collectImports(@Nonnull final Set<String> collectedImports) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds a new import to this flux.
     *
     * @param pImport the import to be added
     * @return this
     */
    protected Flux addImport(final String pImport) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
