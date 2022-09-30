package tp2test;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class p4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			while(true) {
			//passer en client pour recuperer la valeur de p3
			ServerSocket serv=new ServerSocket(2006);
			System.out.println("p4 waiting for value ...");
			Socket connexion=serv.accept(); 
			
			ObjectInputStream in = new ObjectInputStream(connexion.getInputStream());
			//N=Integer.parseInt(in.readObject());
			int S2=Integer.parseInt((String)in.readObject());
			System.out.println("la valeur retourné par p3 est "+S2);
			int S3=4*S2;
			System.out.println("la valeur de S3 est "+S3);
			serv.close();
			
			
			
			
			// passer la valeur a p1
			// debut de client 
			System.out.println("demmande de connexion a P1 ..");
			Socket c = new Socket("localhost",2003);
			 
			ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
			out.writeObject(Integer.toString(S3));
			System.out.println("fin p4");
			c.close();
			}
			

		}
		catch(Exception e) {
			System.out.println("probleme p1 : "+e.toString());
		}

	}

}
