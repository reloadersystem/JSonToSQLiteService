package apptablet.sacooliveros.edu.pe.bdatossemana.WebServices;

import android.util.Log;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServiceTools {
    private ProgressBar progressBar;
    private String host = "192.168.1.4";
    private Integer port = 9450;
    public static final String WEB_SERVICE_NOT_CONNECTED = "Not Connected";

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    static String requestFromWebService(String host, Integer port, String method, String... params) {
        String rString = "";
        int response;
        StringBuilder resSBuilder;
        try {

            String urlRequest = "http://tablet.sacooliveros.edu.pe/APP/2/1/VIDEO_HELICO_SEMINARIO/TOMO1/CAPITULO1/ALGEBRA1T1_C1.json";

            Log.d("URLDATA", urlRequest);
            URL wsURL = new URL(urlRequest);

            HttpURLConnection conn = (HttpURLConnection) wsURL.openConnection();

            response = conn.getResponseCode();

            Log.d("response", String.valueOf(response));

            resSBuilder = new StringBuilder();

            if (response == HttpURLConnection.HTTP_OK) {
                InputStream iStream = new BufferedInputStream(conn.getInputStream());
                BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));

                String rowString;
                int cnt = 0;
                while ((rowString = bReader.readLine()) != null) {
                    cnt += 1;
                    resSBuilder.append(rowString);
                }
                rString = resSBuilder.toString();
            }
        } catch (IOException errString) {
            rString = WEB_SERVICE_NOT_CONNECTED;
        } catch (Exception errString) {
            rString = WEB_SERVICE_NOT_CONNECTED;
        }
//        Log.i("WebServiceResponse", rString);
        return rString;
    }

    static Boolean isValidResponse(String rString) {
        if (rString == null) {
            return false;
        }
        if (rString.isEmpty()) {
            return false;
        }
        return !rString.equals(WEB_SERVICE_NOT_CONNECTED);
    }

}
