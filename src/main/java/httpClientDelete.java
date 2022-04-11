import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class httpClientDelete {
    public static void main(String[] args) {
        try {
            String result = sendDelete("https://gorest.co.in/public/v2/users/3494");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String sendDelete(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result="";

        HttpDelete delete = new HttpDelete(url);

        delete.addHeader( "Authorization",  "Bearer 3dcb1b5b78f34a1ac036c9a7488c4d581c43c800f1eef19efc34e3ce0c3819c1");


        CloseableHttpResponse response = httpClient.execute(delete);
        result = String.valueOf(response.getStatusLine().getStatusCode());
        return result;
    }
}