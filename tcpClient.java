import java.net.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.io.Scanner
public class tcpClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(system.in)
		System.oit.println("Enter a number ranging from 1-3");
		int input = scan.nextInt();
		scan.close();
		
		switch(input){
			case 0:
				system.out.println("System Shutdown");
				break:
				
			case 1:
				try {
					String host = "localhost";
					InetAddress theAddress = InetAddress.getByName(host);
					for (int i = 1; i < 65536; i++) {
						Socket connection = null;
						connection = new Socket(host, i);
						System.out.println("There is a server on port " + i + " of " + host);
						if (connection != null){
							connection.close();
						} // end if
					
					}//endfor
				}
				catch (Exception ex) {
					System.err.println(ex);
				}
				break:
			
			case 2:
				try{
					Socket socket = new Socket("time.nist.gov", 13);
					socket.setSoTimeout(15000);
					InputStream in = socket.getInputStream();
					int c;
					while ((c = in.read())!= -1)
						System.out.print((char)c);
					socket.close();
					 
				}
				catch (IOException ex) {
					System.err.println(ex);
				}
				break:
				
			case 3:
				try{
					int c;
					// Creates a socket connected to internic.net, port 43.
					Socket s = new Socket("whois.internic.net", 43);
					// Obtains the input and output streams.
					InputStream in = s.getInputStream();
					OutputStream out = s.getOutputStream();
					String str = "google.com"+ "\n";
					out.write(str.getBytes());
						while ((c = in.read())!= -1) 
							System.out.print((char)c);
							s.close();
				}
				catch (IOException ex) {
					System.err.println(ex);
				} 
				break:
		} 
	}
}