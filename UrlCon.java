import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class UrlCon{

    public static void main(String[] args) {

        try {
            URL u1 = new URL("https://web.whatsapp.com/");
            HttpURLConnection u2 = (HttpURLConnection)u1.openConnection();
            u2.setRequestMethod("GET");
            InputStreamReader in= new InputStreamReader(u2.getInputStream());
            BufferedReader in1 = new BufferedReader(in);
           
            String st ="";

           while( st!=null){
             st = in1.readLine();
            System.out.println(st);
           in1.close();
           File obj=new File("newFile.txt");
           
            if(obj.createNewFile()){
                System.out.println("succesfully created ");
            }
            else{
                System.out.println("already exist");
            }
           
            FileWriter writer = new FileWriter("newFile.txt",true);
           
             writer.write(st);
             System.out.println("\n");
             System.out.println(st);
             System.out.println("data saved");

           writer.close();
           }}
    
        
        catch (Exception e) {
            System.out.println(e);}
        
        
       
}

    } 

