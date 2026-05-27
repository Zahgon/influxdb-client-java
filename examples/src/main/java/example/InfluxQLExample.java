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
package example;

import java.math.BigDecimal;
import java.time.Instant;
import com.influxdb.LogLevel;
import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.InfluxQLQueryApi;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.InfluxQLQuery;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.query.InfluxQLQueryResult;

public class InfluxQLExample {

    private static char[] token = "my-token".toCharArray();

    private static String org = "my-org";

    private static String database = "my-bucket";

    public static void main(final String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void write(InfluxDBClient influxDBClient) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void dumpResult(InfluxQLQueryResult result) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Measurement(name = "influxql")
    public static class InfluxQLTestData {

        @Column(timestamp = true)
        Instant time;

        @Column
        Long free;

        @Column(tag = true)
        String machine;

        public InfluxQLTestData(Instant instant) {
            free = (long) (Math.random() * 100);
            machine = "test";
            time = instant;
        }
    }
}
