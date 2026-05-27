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
package com.influxdb.query;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.influxdb.utils.Arguments;

/**
 * A record is a tuple of values. Each record in the table represents a single point in the series.
 *
 * <a href="http://bit.ly/flux-spec#record">Specification</a>.
 */
public final class FluxRecord implements Serializable {

    /**
     * The Index of the table that the record belongs.
     */
    private final Integer table;

    /**
     * The record's values.
     */
    private LinkedHashMap<String, Object> values = new LinkedHashMap<>();

    private List<Object> row = new ArrayList<>();

    public FluxRecord(@Nonnull final Integer table) {
        Arguments.checkNotNull(table, "Table index");
        this.table = table;
    }

    /**
     * @return the inclusive lower time bound of all records
     */
    @Nullable
    public Instant getStart() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the exclusive upper time bound of all records
     */
    @Nullable
    public Instant getStop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the time of the record
     */
    @Nullable
    public Instant getTime() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the value of the record
     */
    @Nullable
    public Object getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return get value with key <i>_field</i>
     */
    @Nullable
    public String getField() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return get value with key <i>_measurement</i>
     */
    @Nullable
    public String getMeasurement() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the index of table which contains the record
     */
    @Nonnull
    public Integer getTable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return tuple of values
     */
    @Nonnull
    public Map<String, Object> getValues() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return record's columns
     */
    @Nonnull
    public List<Object> getRow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get FluxRecord value by index.
     *
     * @param index of value in CSV response
     * @return value
     * @see ArrayIndexOutOfBoundsException
     */
    @Nullable
    public Object getValueByIndex(final int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get FluxRecord value by key.
     *
     * @param key of value in CSV response
     * @return value
     */
    @Nullable
    public Object getValueByKey(@Nonnull final String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(final Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
