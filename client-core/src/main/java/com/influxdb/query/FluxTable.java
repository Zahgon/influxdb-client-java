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
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;

/**
 * This class represents the table structure of the Flux CSV Response.
 *
 * <a href="http://bit.ly/flux-spec#table">Specification</a>.
 */
public final class FluxTable implements Serializable {

    /**
     * Table column's labels and types.
     */
    private List<FluxColumn> columns = new ArrayList<>();

    /**
     * Table records.
     */
    private List<FluxRecord> records = new ArrayList<>();

    /**
     * @see #columns
     */
    @Nonnull
    public List<FluxColumn> getColumns() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A table's group key is subset of the entire columns dataset that assigned to the table.
     * As such, all records within a table will have the same values for each column that is part of the group key.
     */
    @Nonnull
    public List<FluxColumn> getGroupKey() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @see #records
     */
    @Nonnull
    public List<FluxRecord> getRecords() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
