import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.function.ToDoubleFunction;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class UrlWeatherReport {
    static String city, state;
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter city");
            city = sc.nextLine();
            System.out.println("enter state");
            state = sc.nextLine();
            URL url1 = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+city+","+state+",+91&limit=1&appid=3ced127861920b8bd12a7da046f7df43");
            HttpURLConnection u1 = (HttpURLConnection)url1.openConnection();
            u1.setRequestMethod("GET");
            InputStreamReader in= new InputStreamReader(u1.getInputStream());
            BufferedReader in1 = new BufferedReader(in);
           
            String st ="";

           while( st!=null){
             st = in1.readLine();
            // System.out.println(st);

       
           in1.close();
        JSONParser pr = new JSONParser();
        JSONArray arr = (JSONArray) pr.parse(st);
        JSONObject obj = (JSONObject) arr.get(0);
        System.out.println(obj.get("lat"));
        System.out.println(obj.get("lon"));
        Object lat =  (obj.get("lat")) ;
        Object lon = (obj.get("lon"));
        Double lat1= (Double) lat;
        Double lon1= (Double) lon;

        URL url2 = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+lat1+"&lon="+lon1+"&appid=3ced127861920b8bd12a7da046f7df43");
        HttpURLConnection u2 =(HttpURLConnection)url2.openConnection();
        u2.setRequestMethod("GET");
        InputStreamReader rd = new InputStreamReader(u2.getInputStream());
        BufferedReader rd2 = new BufferedReader(rd);
        String st2 = "";
        String st3="";
        while(st2!=null){
            st2 = rd2.readLine();
           // System.out.println(st2);
            st3 = st3+st2;
            rd.close();

            JSONParser pr2 = new JSONParser();
        JSONObject obj1 = (JSONObject) pr2.parse(st3);
         
       // System.out.println(obj1.get("main"));
        System.out.println("visivility is :"+obj1.get("visibility"));
        System.out.println("Stations is :"+obj1.get("base"));

        JSONObject obj2 = (JSONObject) (obj1.get("main"));
         System.out.println("pressure is :"+obj2.get("pressure"));
        System.out.println("temp is : "+obj2.get("temp"));
        System.out.println("humidity is : "+obj2.get("humidity"));
       
        }


            }
        }  
        
        catch (Exception e) {
            System.out.println(e);}
        
        
       
}

    } 


    
