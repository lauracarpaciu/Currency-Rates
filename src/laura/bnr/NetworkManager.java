package laura.bnr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class NetworkManager {

    public String getXMLString(String url) throws MalformedURLException, ProtocolException, IOException {
        //Code to make a webservice HTTP request
        URL newurl = new URL(url);
        HttpURLConnection con = (HttpURLConnection) newurl.openConnection();
        con.setRequestMethod("GET");

        //Read the response.
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            // Write the HTTP message response to a String.
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = br.readLine()) != null) {
                content.append(line);
            }
            return content.toString();

        }
    }
}
