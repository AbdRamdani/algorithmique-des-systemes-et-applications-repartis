package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		try {
			Scanner input;
			DatagramSocket s;
			InetAddress ip = InetAddress.getByName("localhost");
			byte[] thedata;
			String ch ;
			DatagramPacket p;
			
			while(true) {
				//client
				System.out.println("client P1 ..");
				s=new DatagramSocket();
				thedata= new byte[10];
				System.out.println("donner une chaine");
				input=new Scanner(System.in);
				ch=input.nextLine();
				thedata=ch.getBytes();
				p=new DatagramPacket(thedata, thedata.length,ip,2004);
				s.send(p);
				s.close();
				System.out.println("data sent from P1 to P2 : "+ch);
				
				
				//server
				System.out.println("P1 server ..");
				s = new DatagramSocket(2003);
				thedata=new byte[10];
				p=new DatagramPacket(thedata,thedata.length);
				s.receive(p);
				
				ch=new String(p.getData());
				System.out.println("data recu de P2 a P1 est : "+ch);
				s.close();
				
				
			}
		}
		catch(Exception e ) {
			System.out.println("erreur p1 : "+e.toString());
		}
	}

}
