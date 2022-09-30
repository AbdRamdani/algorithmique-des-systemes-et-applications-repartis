package udptcp;

import java.net.ServerSocket;
import java.net.Socket;

public class p3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket s = new ServerSocket(2003);
			System.out.println("p3 ..");
		}
		catch(Exception e) {
			System.out.println("exception p3 : "+e.toString());
		}

	}

}
