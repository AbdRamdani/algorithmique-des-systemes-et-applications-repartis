package udptcp;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("donner la chaine : ");
			String ch = sc.next();
			//de p1 a p2 en tcp 
			
			Socket s = new Socket("localhost",2002);
			ObjectOutputStream outp1= new ObjectOutputStream(s.getOutputStream());
			
			outp1.writeObject(ch);
			
			outp1.close();
			s.close();
			
			
			
		}
		catch(Exception e) {
			System.out.println("exception p1 : "+e.toString());
		}

	}

}
