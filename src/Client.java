import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Socket server = null;
		
		//local host 임시로 나에게 돌아오는 ip를 사용
		String ip = "127.0.0.1";
		
		//임의의 port 넘버
		int port = 10002;
		
		BufferedReader brForKeyboard;
		PrintWriter printWriter;
		BufferedReader brForServer;
		
		try {
			server = new Socket(ip, port);
			brForKeyboard = new BufferedReader(new InputStreamReader(System.in));
			printWriter = new PrintWriter(server.getOutputStream());
			brForServer = new BufferedReader(new InputStreamReader(server.getInputStream()));

			while (true) {
				System.out.println("Enter the Msg to Server");
				String msg = brForKeyboard.readLine();
				printWriter.write(msg);
				System.out.println("Sent Msg");
				if(msg.equals("exit")) {
					System.out.println("logout");
					break;
				}
				
			}
			server.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
		}

	}

}
