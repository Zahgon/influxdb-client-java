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
package com.influxdb.query.dsl.functions.restriction;

import java.util.StringJoiner;
import java.util.stream.Stream;
import javax.annotation.Nonnull;

/**
 * @author Jakub Bednar (bednar@github) (28/06/2018 13:03)
 */
public abstract class Restrictions {

    Restrictions() {
    }

    @Nonnull
    public static Restrictions and(@Nonnull final Restrictions... restrictions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    public static Restrictions or(@Nonnull final Restrictions... restrictions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nonnull
    public static Restrictions not(@Nonnull final Restrictions restrictions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create Record measurement restriction.
     *
     * @return restriction
     */
    @Nonnull
    public static ColumnRestriction measurement() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create Record field restriction.
     *
     * @return restriction
     */
    @Nonnull
    public static ColumnRestriction field() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create Record start restriction.
     *
     * @return restriction
     */
    @Nonnull
    public static ColumnRestriction start() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create Record stop restriction.
     *
     * @return restriction
     */
    @Nonnull
    public static ColumnRestriction stop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create Record time restriction.
     *
     * @return restriction
     */
    @Nonnull
    public static ColumnRestriction time() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create Record value restriction.
     *
     * @return restriction
     */
    @Nonnull
    public static ColumnRestriction value() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create Record tag restriction.
     *
     * @param tagName tag name
     * @return restriction
     */
    @Nonnull
    public static ColumnRestriction tag(@Nonnull final String tagName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create Record column restriction.
     *
     * @param columnName column name
     * @return restriction
     */
    @Nonnull
    public static ColumnRestriction column(@Nonnull final String columnName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class Logical extends Restrictions {

        private final String operator;

        private final Restrictions[] restrictions;

        Logical(@Nonnull final String operator, @Nonnull final Restrictions... restrictions) {
            super();
            this.operator = operator;
            this.restrictions = restrictions;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class Not extends Restrictions {

        private final Restrictions restriction;

        Not(@Nonnull final Restrictions restrictions) {
            super();
            this.restriction = restrictions;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
