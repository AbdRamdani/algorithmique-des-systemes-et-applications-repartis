package tp2test;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			while(true) {
				System.out.println("test");
			
			//debut autant que client : 
			System.out.println("debut p1 , donner un entier N:");
			Scanner input = new Scanner( System.in );
			int N = input.nextInt();
			
			// passer la valeur a p2
			// debut de client 
			System.out.println("demmande de connexion ..");
			Socket c = new Socket("localhost",2004);
			
			
			ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
			out.writeObject(Integer.toString(N));
			//
			c.close();
			
			//passer en mode serveur pour recevoir la valeur de la part de p4
			ServerSocket serv=new ServerSocket(2003);
			System.out.println("p1 waiting for value ...");
			Socket connexion=serv.accept(); 
			
			ObjectInputStream in = new ObjectInputStream(connexion.getInputStream());
			//N=Integer.parseInt(in.readObject());
			N=Integer.parseInt((String)in.readObject());
			System.out.println("la valeur retourné par p4 est "+N);
			
			//s
			serv.close();
			
			
			System.out.println("la valeur est "+N);
			
			}
		}
		catch(Exception e) {
			System.out.println("probleme p1 : "+e.toString());
		}

	}


}
