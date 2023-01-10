import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class ServerApp {
    public static void main(String[] args) {
       
        try {


            
            ServerSocket ss = new ServerSocket(2024);
            System.out.println("server is runing ..... .. ");

            while(true){
            Socket s = ss.accept();
            System.out.println("connected to server.,,,,");
           
            PrintStream ps = new PrintStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);
            Scanner sc = new Scanner(s.getInputStream());

        while(true){
            String st = "enter your name and department code and email";
           ps.println(st);
           String st2 = sc.nextLine();
           System.out.println("client :  "+st2);

           File obj = new File("Reg.txt");
           obj.createNewFile();
           FileWriter writer = new FileWriter("Reg.txt",true);
           writer.write(st2);
           writer.close();
           Random rm = new Random();
           int pass = rm.nextInt(2000,10000);
           ps.println(pass);
           System.out.println(pass);
        }

        }
        } catch (Exception e) {
            System.out.println(e);
        }
       

    }
    
}
