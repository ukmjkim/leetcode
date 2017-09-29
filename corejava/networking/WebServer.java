import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private static final String DOCUMENT_ROOT = System.getProperty("user.dir");
    private static final int PORT = 8000;

    private static boolean DEBUG;

    public static void main(String args[]) {
        DEBUG = Boolean.valueOf(System.getProperty("DEBUG", "false"));

        try (ServerSocket server = new ServerSocket(PORT)) {
            
            log("listening on port " + server.getLocalPort());

            int threadCount = 0;
            while (true) {
                Socket client = server.accept();
                ConnectionThread thread = new ConnectionThread(client, threadCount);
                thread.start();
                threadCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        System.out.println(message);
    }

    static class ConnectionThread extends Thread {
        private Socket client;
        private int counter;

        public ConnectionThread(Socket client, int counter) {
            this.client = client;
            this.counter = counter;
        }

        public void run() {
            if (DEBUG) {
                String clientIP = client.getInetAddress().toString();
                int clientPort = client.getPort();
                log("Connection " + counter + " : connected from " + clientIP + 
                    " with port " + clientPort + ".");
            }
            try (InputStream input = client.getInputStream();
                    OutputStream output = client.getOutputStream()) {

                String url = getRequestUrl(input);
                if (url == null) {
                    return;
                }

                String responseFilePath = DOCUMENT_ROOT + url;
                File file = new File(responseFilePath);
                if (!file.exists()) {
                    sendNotFound(output);
                    return;
                }
                sendHeader(output);
                sendFile(output, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String getRequestUrl(InputStream stream) {
            Scanner reader = (new Scanner(stream)).useDelimiter("\n");
            if (!reader.hasNext()) {
                return null;
            }

            String line = reader.next();
            String url = line.split(" ")[1];
            if (DEBUG) {
                while (reader.hasNext()) {
                    log(line);
                    line = reader.next();
                }
            }
            return url;
        }

        private void sendNotFound(OutputStream output) {
            PrintStream out = new PrintStream(output);
            out.println("HTTP/1.0 404 Not Found");
            out.println("");
            out.println("NOT FOUND");
        }

        private void sendHeader(OutputStream output) {
            PrintStream out = new PrintStream(output);
            out.println("HTTP/1.0 200 OK");
            out.println("MIME_version:1.0");
            out.println("Content_Type:text/htm1");
            out.println("");
        }

        private void sendFile(OutputStream output, File file) throws IOException{
            try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
                int len = (int)file.length();
                byte buf[] = new byte[len];
                in.readFully(buf);
                output.write(buf, 0, len);
            }
        }
    }
}
