import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer implements Runnable {
   Socket csocket;
   MultiThreadServer(Socket csocket) {
      this.csocket = csocket;
   }
   public static void main(String args[]) throws Exception { 
      ServerSocket ssock = new ServerSocket(1234);
      System.out.println("Listening");
      
      while (true) {
         Socket sock = ssock.accept();
         System.out.println("Connected");
         new Thread(new MultiThreadServer(sock)).start();
      }
   }
   public void run() {
      try {
         PrintStream pstream = new PrintStream(csocket.getOutputStream());
         for (int i = 100; i >= 0; i--) {
            pstream.println(i + " bottles of beer on the wall");
         }
         pstream.close();
         csocket.close();
      } catch (IOException e) {
         System.out.println(e);
      }
   }
   
   final Thread outThread = new Thread() {
    @Override
    public void run() {
        System.out.println("Started...");
        PrintWriter out = null;
        Scanner sysIn = new Scanner(System.in);
        try {
            out = new PrintWriter(socket.getOutputStream());
            out.println(name);
            out.flush();

            while (sysIn.hasNext() && !isFinished.get()) {
                String line = sysIn.nextLine();
                if ("exit".equals(line)) {
                    synchronized (isFinished) {
                        isFinished.set(true);
                    }
                }
                out.println(line);
                out.flush();
                disconnect();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    };
};
outThread.start();
}