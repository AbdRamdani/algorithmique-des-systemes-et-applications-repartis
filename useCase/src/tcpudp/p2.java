package tcpudp;

import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket s ; 
			Socket connexion ; 
			int n ; 
			ObjectInputStream in ; 
			
			DatagramSocket sudp ; 
			DatagramPacket p ; 
			byte[]  thedata; 
			InetAddress ip = InetAddress.getByName("localhost");
			while(true) {
				//tcp  server
				System.out.println("server P2 .. ");
				s=new ServerSocket(2004);
				connexion=s.accept();
				
				in = new ObjectInputStream(connexion.getInputStream());
				n=Integer.parseInt((String)in.readObject());
				s.close();
				
				// upd client
				System.out.println("client P2");
				sudp=new DatagramSocket();
				thedata= new byte[10];
				thedata=(Integer.toString(n+1)).getBytes();
				p=new DatagramPacket(thedata, thedata.length,ip ,2003);
				sudp.send(p);
				sudp.close();
				
			}
		}
		catch(Exception e ) {
			System.out.println("erreur P1 : "+e.toString());
		}
	}

}
