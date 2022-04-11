import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpUrlGet {




    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {

            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");

            String output="";
//			BufferedReader br= new BufferedReader();

            BufferedReader br= new BufferedReader (new InputStreamReader
                    (con. getInputStream()));

            while((output=br.readLine())!=null)
            {
                System.out.println(output);

            }

            con.disconnect();





            System.out.println("Successfully Got the response");

        }

        catch(Exception e)
        {
            System.out.println("Error in getting the response");
        }


    }

}