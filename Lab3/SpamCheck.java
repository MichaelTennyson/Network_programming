import java.net.*;
import java.util.Scanner;

public class SpamCheck {
     public static void main(String[] args) throws Exception {
		 Scanner scan = new Scanner(System.in);
		 System.out.println("enter the IP of a known spam site")
	     String IP = scan.nextLine();
		 String website = scan.nextLine();
		 scan.close();
		 String query;
		 try {
			 query = IP + website;
			 InetAddress.getByName(query);
			 System.out.println( IP + " is a known spammer.");
			}
		 catch (Exception e) {
			 System.out.println(IP + " appears legitimate");
	}	}   }
 

