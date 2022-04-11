import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



/**
 * @author Crunchify.com
 *
 */

public class httpClientPatch {
    public static void main(String[] args) {

        try {

            String result = sendPATCH("https://gorest.co.in/public/v2/users/3494");
            System.out.println(result);

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }



    private static String sendPATCH(String url) throws IOException {
        // TODO Auto-generated method stub
        CloseableHttpClient httpClient =  HttpClients.createDefault();
        String result = "";
        //4076
        HttpPatch patch = new HttpPatch(url);
        patch.addHeader("Accept","application/json");
        patch.addHeader("Content-Type","application/json");
        patch.addHeader("Authorization","Bearer 3dcb1b5b78f34a1ac036c9a7488c4d581c43c800f1eef19efc34e3ce0c3819c1");



        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"name\":\"Karan\",");
        json.append("\"email\":\"karan@gmail.com\"");
		/*json.append("\"gender\":\"male\",");
		
		json.append("\"status\":\"active\",");*/
        json.append("}");

//		StringEntity--raw data that you send in a request
        //setEntity--to set the data
        patch.setEntity(new StringEntity(json.toString()));

        CloseableHttpResponse response = httpClient.execute(patch);//to execute req and get response

        result = EntityUtils.toString(response.getEntity());//to get result as a string
        return result;
    }
}