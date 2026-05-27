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

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.events.WriteErrorEvent;
import com.influxdb.exceptions.InfluxException;
import javax.annotation.Nonnull;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Logger;

public class WriteHttpExceptionHandled {

    static Logger Log = Logger.getLogger(WriteHttpExceptionHandled.class.getName());

    public static String resolveProperty(final String property, final String fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final String influxUrl = resolveProperty("INFLUX_URL", "http://localhost:8086");

    private static final char[] token = resolveProperty("INFLUX_TOKEN", "my-token").toCharArray();

    private static final String org = resolveProperty("INFLUX_ORG", "my-org");

    private static final String bucket = resolveProperty("INFLUX_DATABASE", "my-bucket");

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static String influxExceptionString(@Nonnull InfluxException e) {
        StringBuilder sBuilder = new StringBuilder().append("Handling InfluxException:\n");
        sBuilder.append("      ").append(e.getMessage());
        String headers = e.headers().keySet().stream().reduce("\n", (set, key) -> set.concat(String.format("        %s: %s\n", key, e.headers().get(key))));
        sBuilder.append("\n      HTTP Response Headers:");
        sBuilder.append(headers);
        return sBuilder.toString();
    }
}
