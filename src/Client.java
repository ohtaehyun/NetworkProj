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
		
		//local host �ӽ÷� ������ ���ƿ��� ip�� ���
		String ip = "127.0.0.1";
		
		//������ port �ѹ�
		int port = 10002;
		
<<<<<<< HEAD
		BufferedReader brForKeyboard;
		PrintWriter printWriter;
		BufferedReader brForServer;
		
		try {
			server = new Socket(ip, port);
			brForKeyboard = new BufferedReader(new InputStreamReader(System.in));
			printWriter = new PrintWriter(server.getOutputStream());
			brForServer = new BufferedReader(new InputStreamReader(server.getInputStream()));

=======
		//��ĳ��
		Scanner scanner = new Scanner(System.in);
		
		try {
			server = new Socket(ip, port);
			System.out.println("Connecting Server");
			System.out.println("Connected Server");

			InputStream in = server.getInputStream();
			OutputStream out = server.getOutputStream();
>>>>>>> cd43ec64e17e10a66ce5a44a058d10e018782a54
			while (true) {
				System.out.println("Enter the Msg to Server");
				String msg = brForKeyboard.readLine();
				printWriter.write(msg);
				System.out.println("Sent Msg");
				if(msg.equals("exit")) {
					System.out.println("logout");
					break;
				}
<<<<<<< HEAD
=======
				byte arr[] = new byte[100];
				in.read(arr);
				System.out.println("Server's Msg: "+new String(arr));
>>>>>>> cd43ec64e17e10a66ce5a44a058d10e018782a54
				
			}
			server.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
		}

	}

}
