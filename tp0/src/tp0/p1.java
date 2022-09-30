package tp0;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//client
public class p1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				System.out.println("demande de connexion");
				Socket c = new Socket("localhost",2004);
				System.out.println("demmande de connexion accepté ");
				
				//classe de flux
				ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
				out.writeObject("test sending to server from p1");	
				
				ObjectInputStream in = new ObjectInputStream(c.getInputStream());
				String ch= (String) in.readObject();
				System.out.println("repose de server :: "+ch);
				
				//terminer la connexion
				c.close(); in.close(); out.close();
			}
			catch(Exception e){ 
				System.out.println("erreur p1 "+e.toString());
			}
	}

}
