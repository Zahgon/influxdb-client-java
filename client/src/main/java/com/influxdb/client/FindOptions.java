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

import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import okhttp3.HttpUrl;

/**
 * FindOptions represents options passed to all find methods with multiple results.
 *
 * @author Jakub Bednar (bednar@github) (30/01/2019 07:41)
 */
public final class FindOptions {

    public static final String LIMIT_KEY = "limit";

    public static final String OFFSET_KEY = "offset";

    public static final String SORT_BY_KEY = "sortBy";

    public static final String DESCENDING_KEY = "descending";

    public static final String AFTER_KEY = "after";

    private Integer limit;

    private Integer offset;

    private String sortBy;

    private Boolean descending;

    private String after;

    @Nonnull
    public static FindOptions create(@Nullable final String link) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer getLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLimit(final Integer limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Integer getOffset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setOffset(final Integer offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getSortBy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSortBy(final String sortBy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Boolean getDescending() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDescending(final Boolean descending) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getAfter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAfter(final String after) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
