import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class httpUrlPost {

    public static void main(String[] args) {

        try {

            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();//type casting 
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Content-Type","application/json");

            JSONObject json = new JSONObject();
            json.put("name", "aman bro");
            json.put("email", "aman1@gmail.com");

            System.out.println(json);

            OutputStream os = conn.getOutputStream();

            OutputStreamWriter osw = new OutputStreamWriter(os, Charset.defaultCharset());
            json.write(osw);
            os.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output="";
            while((output = br.readLine()) != null)
            {
                System.out.println(output);
            }
            System.out.println(conn.getResponseCode());
            conn.disconnect();


        }

        catch(Exception e)
        {
            System.out.println("error");
        }

    }
}