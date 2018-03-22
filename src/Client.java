import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Socket server = null;
		
		//local host 임시로 나에게 돌아오는 ip를 사용
		String ip = "127.0.0.1";
		
		//임의의 port 넘버
		int port = 10002;
		
		//스캐너
		Scanner scanner = new Scanner(System.in);
		
		try {
			server = new Socket(ip, port);
			System.out.println("Connecting Server");
			System.out.println("Connected Server");

			InputStream in = server.getInputStream();
			OutputStream out = server.getOutputStream();
			while (true) {
				System.out.println("Enter the Msg to Server");
				String msg = scanner.nextLine();
				out.write(msg.getBytes());
				System.out.println("Sent Msg");
				if(msg.equals("exit")) {
					System.out.println("logout");
					break;
				}
				byte arr[] = new byte[100];
				in.read(arr);
				System.out.println("Server's Msg: "+new String(arr));
				
			}
			server.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
		}

	}

}
