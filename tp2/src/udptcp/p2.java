package udptcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			ServerSocket s = new ServerSocket(2002);
			System.out.println("server p2 wait ..");
			Socket connexion = s.accept();
			
			ObjectInputStream inp2 = new ObjectInputStream(connexion.getInputStream());
			
			String ch =(String) inp2.readObject();
			inp2.close();
			
			String S1= Integer.toString( Integer.parseInt(ch)*2);
			
			Socket c = new Socket("localhost",2003);
			ObjectOutputStream outp2 = new ObjectOutputStream(c.getOutputStream());
			outp2.writeObject(S1);
			
			
			
			
		}
		catch(Exception e) {
			System.out.println("exception p2 : "+e.toString());
		}

	}

}
