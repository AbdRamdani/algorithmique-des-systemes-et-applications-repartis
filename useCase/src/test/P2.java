package test;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P2 {

	public static void main(String[] args) {
		try {
			int N ; 
			String s; 
			Socket c; 
			ObjectOutputStream out; 
			ObjectInputStream in ; 
			ServerSocket serv;
			Socket connexion;
			while(true) {
				serv=new ServerSocket(2004);
				System.out.println("Server P2 ...");
				connexion=serv.accept();
				in = new ObjectInputStream(connexion.getInputStream());
				//N=Integer.parseInt((String)in.readObject());
				s=(String)in.readObject();
				//System.out.println("la valeur recu a P2 par P1 est : "+N);
				System.out.println("le texte recu a P2 par P1 est : "+s);
			
				//client 
				c=new Socket("localhost",2003);
				out=new ObjectOutputStream(c.getOutputStream());
				//out.writeObject(Integer.toString(N+1));
				out.writeObject(s+" ok bb");
				System.out.println("fin client P2 ");
				serv.close();
				c.close();
			}
		}
		catch(Exception e ) {
			System.out.println("erreur dans p2 : "+e.toString());
		}

	}

}
