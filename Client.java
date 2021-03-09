package week4day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	Socket s;
	BufferedReader br,in;
	PrintWriter out;
	public Client() {
		
		try {
			while(true) {
				s = new Socket("localhost",2000);
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String msg = br.readLine();
				System.out.println("Msg : "+msg);
				
			
				out = new PrintWriter(s.getOutputStream(),true);
				in = new BufferedReader(new InputStreamReader(System.in));
				String clientmsg = in.readLine();
				out.println(clientmsg);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		 new Client();
		
	}

}
