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

import javax.annotation.Nullable;

public class BucketsQuery {

    /**
     * Offset. (optional)
     */
    @Nullable
    private Integer offset;

    /**
     * Limit. (optional, default to 20)
     */
    @Nullable
    private Integer limit;

    /**
     * The last resource ID from which to seek from (but not including).
     * This is to be used instead of &#x60;offset&#x60;. (optional)
     */
    @Nullable
    private String after;

    /**
     * The name of the organization. (optional)
     */
    @Nullable
    private String org;

    /**
     * The organization ID. (optional)
     */
    @Nullable
    private String orgID;

    /**
     * Only returns buckets with a specific name. (optional)
     */
    @Nullable
    private String name;

    /**
     * Only returns buckets with a specific ID. (optional)
     */
    @Nullable
    private String id;

    @Nullable
    public Integer getOffset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setOffset(@Nullable final Integer offset) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    public Integer getLimit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setLimit(@Nullable final Integer limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    public String getAfter() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAfter(@Nullable final String after) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    public String getOrg() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setOrg(@Nullable final String org) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    public String getOrgID() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setOrgID(@Nullable final String orgID) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    public String getName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setName(@Nullable final String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    public String getId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setId(@Nullable final String id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
