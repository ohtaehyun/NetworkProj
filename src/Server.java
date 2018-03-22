import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;
public class Server {
	
	public static void main(String[] args) {
		Socket client = null;
		ServerSocket server =null;
		int port = 10002;
		Scanner scanner = new Scanner(System.in);
		BufferedReader br ;
		try {
			server = new ServerSocket(port);
			System.out.println("server is ready");

			System.out.println("wait for client");
			client = server.accept();
			System.out.println("client is ready");

			br = new BufferedReader(new InputStreamReader (client.getInputStream()));
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			while(true) {
				String msg = new String(br.readLine());
				if (msg.equals("exit")) {
					System.out.println("Client logout");
					break;
				}
				System.out.println("Client's Msg : "+ msg);
				System.out.println("Enter the Msg to Client :");
				msg = scanner.nextLine();
				out.write(msg.getBytes());
				System.out.println("Msg sent");
			}
			client.close();
			server.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			// TODO: handle finally clause
		}
	}
}