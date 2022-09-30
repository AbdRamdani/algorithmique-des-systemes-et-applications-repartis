package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class P2 {

	public static void main(String[] args) {
		try {
			DatagramSocket s;
			InetAddress ip = InetAddress.getByName("localhost");
			byte[] thedata;
			byte[] thedata2;
			String ch ,ch2;
			DatagramPacket p;
			
			while(true) {
				//server 
				System.out.println("P2 server ..");
				s = new DatagramSocket(2004);
				thedata=new byte[10];
				p=new DatagramPacket(thedata,thedata.length);
				s.receive(p);
				
				ch=new String(p.getData());
				System.out.println("data recu de P1 a P2 est : "+ch);
				s.close();
				
				//client
				System.out.println("P2 client .. ");
				s=new DatagramSocket();
				//thedata= new byte[10];
				thedata=new byte[10];
				
				ch2="ok";
				thedata=ch2.getBytes();
				p=new DatagramPacket(thedata, thedata.length,ip,2003);
				s.send(p);
				s.close();
				System.out.println("data sent from P2 to P1 : "+ch2);
				
			}
		}
		catch(Exception e ) {
			System.out.println("erreur p2 : "+e.toString());
		}
	}

}
