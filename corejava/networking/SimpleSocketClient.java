import java.net.*;
import java.io.*;

public class SimpleSocketClient {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Usage: SimpleSocketClient <server> <port>");
      System.exit(0);
    }
    String serverName = args[0];
    int port = Integer.parseInt(args[1]);

    System.out.println("Echo Client 1.0" + serverName);

    try {
      Socket client = new Socket(serverName, port);

      // Create input and output streams to read from and write to the server
      PrintStream out = new PrintStream(client.getOutputStream());
      BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

      // Read data from the server until we finish reading the document
      String line;
      while (true) {
        line = in.readLine();
        if (line != null)
          System.out.println(line);
        line = console.readLine();
        if (line.equals("bye")) break;
        out.println(line);
      }

      // Close our streams
      in.close();
      out.close();
      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
