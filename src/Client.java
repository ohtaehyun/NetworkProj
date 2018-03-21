import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Socket client = null;
		String ip = "127.0.0.1";
		int port = 10002;
		Scanner scanner = new Scanner(System.in);
		
		try {
			client = new Socket(ip, port);
			while (true) {

				System.out.println("Connecting Server");
				
				System.out.println("Connected Server");
				
				InputStream in = client.getInputStream();
				OutputStream out = client.getOutputStream();
				
				System.out.println("Enter the Msg to Server");
				String msg = scanner.nextLine();
				out.write(msg.getBytes());
				System.out.println("Sent Msg");
				byte arr[] = new byte[100];
				in.read(arr);
				System.out.println("Client's Msg: "+new String(arr));

				System.out.println("Bye Server");
				if(false) {
					break;
				}
			}
			client.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
		}

	}

}
