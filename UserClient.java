import java.io.PrintStream;
import java.net.Socket;

import java.util.Scanner;



public class UserClient {

    
   
    public static void main(String[] args) {


        try {
            Socket s = new Socket("localhost",2024);
            System.out.println("client is connected to application server");

            while(true){
            Scanner sc = new Scanner(s.getInputStream());
            Scanner input = new Scanner(System.in);
            PrintStream ps = new PrintStream(s.getOutputStream());

            while(true){
                String st = sc.nextLine();
                 System.out.println("server replying : "+st);
                 String st2 = input.nextLine();
                 ps.println(st2);
                 
            }
            
        }
        
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
