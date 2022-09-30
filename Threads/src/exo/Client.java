package exo;

import java.net.Socket;

public class Client extends Thread {
	
	static int c=1; 
	
	public void run() {
		setName("Client "+c);
		c++;
		try {
			Socket c = new Socket("localhost", 2004);
			System.out.println("Connected ...."+getName());	
		}catch(Exception e) {
			System.out.println("erreur dans le client "+c+" : "+e.toString());
		}
	
	}



}
