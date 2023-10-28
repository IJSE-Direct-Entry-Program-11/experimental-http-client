package lk.ijse.dep11.http;

import java.io.*;
import java.net.Socket;

public class MyHttpClient {
    public static void main(String[] args) throws IOException {
        // http://google.lk

        Socket remoteSocket = new Socket("172.93.133.117", 80);
        System.out.println("Connected to google web server...");

        new Thread(() -> {
            try {
                InputStream is = remoteSocket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        OutputStream os = remoteSocket.getOutputStream();
        os.write("GET / HTTP/1.1\r\n".getBytes());
        os.write("Host: ijse.lk\r\n".getBytes());
        os.write("\r\n".getBytes());
    }
}
