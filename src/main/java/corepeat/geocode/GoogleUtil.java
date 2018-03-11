package corepeat.geocode;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

public class GoogleUtil {

    public static final String API_KEY = "AIzaSyBoA3Qs9R1M8zirSvX6NC5GpjM6AGNiSQM";

    public GoogleGeoCode getGeoCode(String address, boolean ssl) {
        StringBuilder url = new StringBuilder("http");
        if ( ssl ) {
            url.append("s");
        }
        url.append("://maps.googleapis.com/maps/api/geocode/json?");
        if (ssl) {
            url.append("key=");
            url.append(API_KEY);
            url.append("&");
        }
        url.append("sensor=false&address=");
        url.append(URLEncoder.encode(address));

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url.toString());

            request.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:31.0) Gecko/20100101 Firefox/31.0 Iceweasel/31.6.0");
            request.setHeader("Host", "maps.googleapis.com");
            request.setHeader("Connection", "keep-alive");
            request.setHeader("Accept-Language", "en-US,en;q=0.5");
            request.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            request.setHeader("Accept-Encoding", "gzip, deflate");

            try (CloseableHttpResponse response = httpclient.execute(request)) {
                HttpEntity entity = response.getEntity();

                StringBuilder result = new StringBuilder();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        result.append(inputLine);
                        result.append("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ObjectMapper mapper = new ObjectMapper();
                GoogleGeoCode geocode = null;
                try {
                    geocode = mapper.readValue(result.toString(), GoogleGeoCode.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return geocode;
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GoogleGeoCode();
    }
}
