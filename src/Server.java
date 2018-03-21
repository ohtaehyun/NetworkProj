import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
public class Server {
	public static void main(String[] args) {
		Socket client = null;
		ServerSocket server = null;
		int port = 10002;
		try {
			server = new ServerSocket(port);
			System.out.println("server is ready");
			while(true) {
				System.out.println("ready for client");
				client = server.accept();
				System.out.println("client is ready");
				InputStream in = client.getInputStream();
				OutputStream out = client.getOutputStream();
				byte arr[] = new byte[100];
				in.read(arr);
				System.out.println("Hello Client");
				System.out.println("Client's Msg: "+new String(arr));
				client.close();
				System.out.println("Client Out");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			// TODO: handle finally clause
		}
	}
}