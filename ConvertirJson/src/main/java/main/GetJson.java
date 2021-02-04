package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GetJson {
    public String getJson(String api){
        URL url = null;
        String inputLine, data=null;
        StringBuffer response = new StringBuffer();
        try {
            url = new URL(api);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            HttpURLConnection.setFollowRedirects(true);
            //urlConnection.setInstanceFollowRedirects(true);

            //obtener codigo de respuesta
            int responseCode = urlConnection.getResponseCode();
            System.out.println("GET Response code :: "+responseCode);
            if(responseCode==HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                while((inputLine=reader.readLine())!=null){
                    response.append(inputLine);
                }
                reader.close();

            }else{
                System.out.println("GET REQUEST NOT WORKED");
            }
            data = response.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
