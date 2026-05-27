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

import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;
import com.influxdb.LogLevel;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import com.influxdb.client.WriteOptions;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * The example how to write data every seconds to the InfluxDB.
 *
 * Usage:
 * <pre>
 * java WriteDataEverySecond --url http://localhost:9999 --token my-token --bucket my-bucket --org my-org
 * </pre>
 *
 * @author Jakub Bednar (06/10/2020 10:00)
 */
public class WriteDataEverySecond {

    public static void main(final String[] args) throws ParseException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Parse command line arguments.
     *
     * @param args the list of atomic option and value tokens
     * @return parsed args
     * @throws ParseException if there are any problems while parsing args
     */
    private static CommandLine parseArgs(final String[] args) throws ParseException {
        Options options = new Options().addOption("h", "help", false, "Print this help").addOption("u", "url", true, "The url to connect to the InfluxDB. Default 'http://localhost:9999'.").addOption("t", "token", true, "The token to use for the authorization. Default 'my-token'.").addOption("o", "org", true, "The name of an organization. Default 'my-org'.").addOption("b", "bucket", true, "The name of a bucket to write. Default 'my-bucket'.");
        CommandLineParser parser = new DefaultParser();
        CommandLine line = parser.parse(options, args);
        if (line.hasOption("help")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.setWidth(2000);
            formatter.printHelp("java WriteDataEverySecond", options, true);
            System.exit(0);
        }
        return line;
    }
}
