package tp2test;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class p3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			while(true) {
			//passer en client pour recuperer la valeur de p2
			ServerSocket serv=new ServerSocket(2005);
			System.out.println("p3 waiting for value ...");
			Socket connexion=serv.accept(); 
			
			ObjectInputStream in = new ObjectInputStream(connexion.getInputStream());
			//N=Integer.parseInt(in.readObject());
			int S1=Integer.parseInt((String)in.readObject());
			System.out.println("la valeur retourné par p2 est "+S1);
			int S2=3*S1;
			System.out.println("la valeur de S2 est "+S2);
			
			serv.close();
			
			
			// passer la valeur a p4
			// debut de client 
			System.out.println("demmande de connexion a P4 ..");
			Socket c = new Socket("localhost",2006);
			
			ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
			out.writeObject(Integer.toString(S2));
			System.out.println("fin p3");
			c.close();
			}

		}
		catch(Exception e) {
			System.out.println("probleme p1 : "+e.toString());
		}

	}

}
