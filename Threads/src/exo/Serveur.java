package exo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur extends Thread  {
	
	ServerSocket s ; 
	Socket conx; 
	boolean turn = true ; 

	public void run() {
		try {
			setName("Server P1");
			s= new ServerSocket(2004);
			while(turn) {
				System.out.println("Server P1 waiting "+getName()+" ...");
				conx=s.accept();
				System.out.println("Server P1 accept "+getName());
				
				
			}
		}catch(Exception e ) {
			System.out.println("erreur dans le thread de server : "+e.toString());
		}
	}
	
	public void Stop() throws Exception {
		this.turn=false; 
		s.close();
	}
	

}
