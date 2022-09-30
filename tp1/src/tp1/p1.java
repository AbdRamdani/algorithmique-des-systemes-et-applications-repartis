package tp1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			//on se lance comme un client 
			System.out.println("demande de connexion");
			Socket c1 = new Socket("192.168.4.206",2004); // serveur 
			System.out.println("demmande de connexion accepté ");
			
			ObjectOutputStream out1 = new ObjectOutputStream(c1.getOutputStream());
			out1.writeObject("debut envoie de p1 a p2");	
			
			
			while(true) {
				//passer a serveur 
				ServerSocket s = new ServerSocket(2004);
				System.out.println("Server p1 waiting ...");
				Socket connexion=s.accept(); // en attendant un client
				System.out.println("connexion accepté par p1");
				//recuperation de message
				ObjectInputStream in = new ObjectInputStream(connexion.getInputStream());
				String ch = (String) in.readObject();
				System.out.println("message recu par p1");
				
				//passer en client 
				
				Socket client = new Socket("192.168.4.206",2004);
				ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
				System.out.println("message envoyé au serveur p2 .. fin ");
				out.writeObject(ch);
				client.close();
				s.close();
				
				
				
				
			}
			
		}
		catch(Exception e ) {
			System.out.println("probleme p1 : "+e.toString());
			
		}

	}

}
