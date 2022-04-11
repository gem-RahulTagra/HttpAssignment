import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;


public class httpClientPost {
    public static void main(String[] args) {
        try {
            String result = sendPost("https://gorest.co.in/public/v2/users");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String sendPost(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result="";

        HttpPost post = new HttpPost(url);
        post.addHeader("Accept","application/json");
        post.addHeader("Content-Type","application/json");
        post.addHeader("Authorization","Bearer 3dcb1b5b78f34a1ac036c9a7488c4d581c43c800f1eef19efc34e3ce0c3819c1");

        JSONObject obj = new JSONObject();
        obj.put("name", "Rahul");
        obj.put("email", "rtagra04@ex.com");
        obj.put("gender","Male");
        obj.put("status","active");



        post.setEntity(new StringEntity(obj.toString()));
        CloseableHttpResponse response = httpClient.execute(post);
        result = EntityUtils.toString(response.getEntity());
        return result;
    }
}