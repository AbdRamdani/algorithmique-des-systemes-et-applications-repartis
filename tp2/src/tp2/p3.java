package tp2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class p3 {



		public static void main(String[] args) {
			// TODO Auto-generated method stub
			try {
				//passer en client pour recuperer la valeur de p1
				ServerSocket serv=new ServerSocket(2004);
				System.out.println("p3 waiting for value ...");
				Socket connexion=serv.accept(); 
				
				ObjectInputStream in = new ObjectInputStream(connexion.getInputStream());
				//N=Integer.parseInt(in.readObject());
				int S1=Integer.parseInt((String)in.readObject());
				System.out.println("la valeur retournĂ© par p1 est "+S1);
				int S2=3*S1;
				System.out.println("la valeur de S1 est "+S2);
				
				
				
				
				// passer la valeur a p3
				// debut de client 
				System.out.println("demmande de connexion a P3 ..");
				Socket c = new Socket("",2004);
				
				ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
				out.writeObject(Integer.toString(S2));
				

			}
			catch(Exception e) {
				System.out.println("probleme p1 : "+e.toString());
			}

		}

	}
