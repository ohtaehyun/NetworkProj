import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private Socket server;
	
	//local host 임시로 나에게 돌아오는 ip를 사용
	private String ip = "127.0.0.1";
	
	//임의의 port 넘버
	private int port = 10789;	
	
	//출력
	private PrintWriter writer;
	
	//전달한 메시지
	private String msg = "Hello world ";

	public void Init() {
		try {
		 server = new Socket(ip,port);
		 System.out.println("server connected");
		 writer = new PrintWriter(server.getOutputStream(),true);
		 send(msg);
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(server != null) {
				try {
					server.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void send(String msg) {
		writer.println(msg);
		System.out.println("sended msg");
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.Init();
	}
}
