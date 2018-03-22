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
<<<<<<< HEAD
=======
		Scanner scanner = new Scanner(System.in);
		BufferedReader br ;
>>>>>>> cd43ec64e17e10a66ce5a44a058d10e018782a54
		try {
			server = new ServerSocket(port);
			System.out.println("server is ready");

			System.out.println("wait for client");
			client = server.accept();
			System.out.println("client is ready");

<<<<<<< HEAD
			BufferedReader br = new BufferedReader( new InputStreamReader(client.getInputStream()));
			while(true) {
				String msg= br.readLine();
				if (msg.equals("exit")) {
					break;
				}
				System.out.println("Client's Msg : "+ msg);
			}
			client.close();
=======
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
>>>>>>> cd43ec64e17e10a66ce5a44a058d10e018782a54
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			// TODO: handle finally clause
		}
	}
}