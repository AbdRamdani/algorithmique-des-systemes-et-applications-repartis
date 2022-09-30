package tcpudp;

import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.Scanner;

public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner input ; 
			int n ; 
			Socket s ; 
			ObjectOutputStream out; 
			
			DatagramSocket sudp;
			DatagramPacket p ; 
			byte[] thedata;
			String ch ; 
			
			
			while(true) {
				//tcp client 
				System.out.println("donner une valeur a n ");
				input= new Scanner(System.in);
				n=input.nextInt();
				System.out.println("P1 client ..");
				s=new Socket("localhost",2004);
				out= new ObjectOutputStream(s.getOutputStream());
				out.writeObject(Integer.toString(n));
				System.out.println("la valeur envoye de P1 a P2 : "+n);
				s.close();
				
				// udp server 
				System.out.println("server P1 ..");
				sudp=new DatagramSocket(2003);
				thedata = new byte[10];
				p= new DatagramPacket(thedata,thedata.length);
				sudp.receive(p);
				ch = new String(p.getData());
				n= Integer.parseInt(ch.trim());
				System.out.println("datarecu de P2 a P1 : "+n);
				sudp.close();
				
				
			}
		}
		catch(Exception e ) {
			System.out.println("erreur P1 : "+e.toString());
		}
	}

}
