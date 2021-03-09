package week4day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket ss;	
	Socket s;
	PrintWriter out;
	BufferedReader br,in;
	
	public Server() {
		
		try {
			ss = new ServerSocket(2000);
			System.out.println("server ready");
			while(true) {
				s = ss.accept();
				System.out.println(s);
				out = new PrintWriter(s.getOutputStream(),true);
				in = new BufferedReader(new InputStreamReader(System.in));
				String servermsg = in.readLine();
				out.println(servermsg);
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String msg = br.readLine();
				System.out.println("Msg frm Client : "+msg);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		new Server();
		
	}

}
