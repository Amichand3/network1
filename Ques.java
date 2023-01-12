// extract id , name and field 1 value

import java.net.HttpURLConnection;

import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Ques {
    public static void main(String[] args) {
       
       try  {

       URL url = new URL("https://api.thingspeak.com/channels/875453/feeds.json?api_key=1DSQ7R1XTT1OK0Z1&results=20");
        HttpURLConnection u2 = (HttpURLConnection)url.openConnection();
        u2.setRequestMethod("GET");
        InputStreamReader in= new InputStreamReader(u2.getInputStream());
        BufferedReader in1 = new BufferedReader(in);
       
        String st ="";

       while( st!=null){
         st = in1.readLine();
       System.out.println(st);
       in1.close();
       JSONParser par = new JSONParser();
       JSONObject obj = (JSONObject) par.parse(st);
       JSONObject obj1 = (JSONObject )obj.get("channel");
       System.out.println("Name : " + obj1.get("name")); 
       System.out.println("Id :  "+obj1.get("id")); 

       JSONArray arr = (JSONArray) obj.get("feeds");
       for (int i=0;i<arr.size();i++){
            JSONObject obj2 =  (JSONObject) arr.get(i);
            System.out.println("value of fields1 "+obj2.get("field1"));
       }
       

       

    }
}

    catch(Exception e){System.out.println(e);
        
    }

}
}
