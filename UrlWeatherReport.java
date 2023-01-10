import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class UrlWeatherReport {
    public static void main(String[] args) {
        try {
            URL u1 = new URL("http://api.openweathermap.org/geo/1.0/direct?q=jaipur,Rajasthan,+91&limit=10&appid=3ced127861920b8bd12a7da046f7df43");
            HttpURLConnection u2 = (HttpURLConnection)u1.openConnection();
            u2.setRequestMethod("GET");
            InputStreamReader in= new InputStreamReader(u2.getInputStream());
            BufferedReader in1 = new BufferedReader(in);
           
            String st ="";

           while( st!=null){
             st = in1.readLine();
            System.out.println(st);
        }
           in1.close();
           }
    
        
        catch (Exception e) {
            System.out.println(e);}
        
        
       
}

    } 


    
