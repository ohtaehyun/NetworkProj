import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;
public class Server {
	public static void main(String[] args) {
		Socket client = null;
		ServerSocket server = null;
		int port = 10002;
		Scanner scanner = new Scanner(System.in);
		try {
			server = new ServerSocket(port);
			System.out.println("server is ready");

			System.out.println("wait for client");
			client = server.accept();
			System.out.println("client is ready");

			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			while(true) {
				byte arr[] = new byte[100];
				in.read(arr);
				System.out.println("Client's Msg : "+new String(arr));
				System.out.println("Enter the Msg to Client :");
				String msg = scanner.nextLine();
				out.write(msg.getBytes());
				System.out.println("Msg sent");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			// TODO: handle finally clause
		}
	}
}