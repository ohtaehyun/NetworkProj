import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;
public class Server {
	public static void main(String[] args) {
		Socket client = null;
		ServerSocket server = null;
		int port = 10002;
		try {
			server = new ServerSocket(port);
			System.out.println("server is ready");

			System.out.println("wait for client");
			client = server.accept();
			System.out.println("client is ready");

			BufferedReader br = new BufferedReader( new InputStreamReader(client.getInputStream()));
			while(true) {
				String msg= br.readLine();
				if (msg.equals("exit")) {
					break;
				}
				System.out.println("Client's Msg : "+ msg);
			}
			client.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			// TODO: handle finally clause
		}
	}
}