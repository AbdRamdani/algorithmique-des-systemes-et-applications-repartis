package tp0;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//serveur
public class p2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				ServerSocket s = new ServerSocket(2004);
				System.out.println("Serveur en attente ...");
				
				while(true) {
					Socket connection = s.accept();
					System.out.println("connexion accepté....");
					ObjectInputStream in= new ObjectInputStream(connection.getInputStream());
					String ch =(String) in.readObject(); 
					System.out.println("message recu par client "+ch);
					
					ObjectOutputStream out=new ObjectOutputStream(connection.getOutputStream());
					out.writeObject("message bien recu par server");
					
					//end de connexion 
					
				}
				//s.close(); connection.close(); in.close(); out.close();

			}
			catch(Exception e){
				System.out.println("erreur p2 "+e.toString()); 
			}
	}


}
