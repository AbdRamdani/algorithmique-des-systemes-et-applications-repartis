package test;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		try {
			Scanner input; 
			int N ; 
			String s; 
			Socket c; 
			ObjectOutputStream out; 
			ObjectInputStream in ; 
			ServerSocket serv;
			Socket connexion;
		while(true) {
			System.out.println("donner une valeur ");
			input=new Scanner(System.in);
			//N=input.nextInt();
			s=input.nextLine();
			
			//initialisation de client 
			c=new Socket("localhost",2004);
			out=new ObjectOutputStream(c.getOutputStream());
			//out.writeObject(Integer.toString(N));
			out.writeObject(s);
			//System.out.println("la valeur :"+N+" est bien envoyé a P2");
			System.out.println("la texte :"+s+" est bien envoyé a P2");
			System.out.println("fin client P1");
			
			// initialisation de server 
			serv= new ServerSocket(2003);
			System.out.println("server P1 ...");
			connexion = serv.accept();
			in = new ObjectInputStream(connexion.getInputStream());
			//N=Integer.parseInt((String)in.readObject());
			s=(String) in.readObject();
			//System.out.println("la valeur recu a P1 par P2 est : "+N);
			System.out.println("le texte recu a P1 par P2 est : "+s);
			serv.close();
			c.close();
			//connexion.close();
			
			
			
			
			
		}
		}
		catch(Exception e ) {
			System.out.println("erreur dans p1 : "+e.toString());
		}

	}

}
