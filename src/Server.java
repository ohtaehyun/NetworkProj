import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.*;
import java.util.Scanner;
public class Server {
	//클라이언트 
	private Socket client;
	
	//서버
	private ServerSocket server;
	
	//포트넘버
	private int port = 10789;
	
	//입력
	private BufferedReader reader;
	
	//출력
	private String msg;
	
	public void Init() {
		try {
			server = new ServerSocket(port);
			System.out.println("server is ready");
			client = server.accept();
			if(client != null) {
				System.out.println("client is ready:" + client.toString());
			}
			
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			ReadMsg();
			System.out.println("Client: "+msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(client != null) {
				try {
					client.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
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
	
	public void ReadMsg() {
		try {
			msg = reader.readLine();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Server server = new Server();
		server.Init();
	}
}