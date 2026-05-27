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
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import com.influxdb.client.WriteOptions;
import com.influxdb.client.domain.Authorization;
import com.influxdb.client.domain.Bucket;
import com.influxdb.client.domain.Organization;
import com.influxdb.client.domain.Permission;
import com.influxdb.client.domain.PermissionResource;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.client.write.events.WriteSuccessEvent;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;

/*
  InfluxDB 2.x onboarding tasks (create default user, organization and bucket) :

  curl -i -X POST http://localhost:8086/api/v2/setup -H 'accept: application/json' \
      -d '{
              "username": "my-user",
              "password": "my-password",
              "org": "my-org",
              "bucket": "my-bucket"
          }'
 */
@SuppressWarnings("CheckStyle")
public class PlatformExample {

    @Measurement(name = "temperature")
    private static class Temperature {

        @Column(tag = true)
        String location;

        @Column
        Double value;

        @Column(timestamp = true)
        Instant time;
    }

    public static void main(final String[] args) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static String findToken() throws Exception {
        InfluxDBClient influxDBClient = InfluxDBClientFactory.create("http://localhost:8086", "my-user", "my-password".toCharArray());
        String token = influxDBClient.getAuthorizationsApi().findAuthorizations().stream().filter(authorization -> authorization.getPermissions().stream().map(Permission::getResource).anyMatch(resource -> resource.getType().equals(PermissionResource.TYPE_ORGS) && resource.getId() == null && resource.getOrgID() == null)).findFirst().orElseThrow(IllegalStateException::new).getToken();
        influxDBClient.close();
        return token;
    }
}
