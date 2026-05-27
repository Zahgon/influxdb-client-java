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
import java.util.Objects;
import java.util.StringJoiner;
import javax.annotation.Nonnull;

/**
 * This class represents a column header specification of {@link FluxTable}.
 * <p>
 * The mapping data types for a column are:
 * <ul>
 * <li>"boolean" to {@link Boolean}</li>
 * <li>"unsignedLong" to {@link Long}</li>
 * <li>"long" to {@link Long}</li>
 * <li>"double" to {@link Double}</li>
 * <li>"string" to {@link String}</li>
 * <li>"base64Binary" to {@link byte}s array</li>
 * <li>"dateTime:RFC3339" to {@link java.time.Instant}</li>
 * <li>"dateTime:RFC3339Nano" to {@link java.time.Instant}</li>
 * <li>"duration" to {@link java.time.Duration}</li>
 * </ul>
 */
public final class FluxColumn implements Serializable {

    /**
     * Column index in record.
     */
    private int index;

    /**
     * The label of column (e.g., "_start", "_stop", "_time").
     */
    private String label;

    /**
     * The data type of column (e.g., "string", "long", "dateTime:RFC3339").
     */
    private String dataType;

    /**
     * Boolean flag indicating if the column is part of the table's group key.
     */
    private boolean group;

    /**
     * Default value to be used for rows whose string value is the empty string.
     */
    private String defaultValue;

    @Nonnull
    public String getDataType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDataType(final String dataType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getIndex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setIndex(final int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getLabel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLabel(final String label) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isGroup() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setGroup(final boolean group) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getDefaultValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDefaultValue(final String defaultValue) {
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
