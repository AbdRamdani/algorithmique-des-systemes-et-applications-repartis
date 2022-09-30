package exo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.ObjectInputStream;
//port 2006
public class P4 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		DatagramSocket s;
		byte[] data;
		int S2,S3;
		DatagramPacket p4;
		Socket connexion ; 
		ServerSocket serv;
		ObjectInputStream in;
		
		
		try {
			InetAddress ipadr = InetAddress.getByName("localhost");
			//server udp 

			serv=new ServerSocket(2006);
			System.out.println("server p4 ...");
			connexion=serv.accept(); 
			in = new ObjectInputStream(connexion.getInputStream());
			S2=Integer.parseInt((String)in.readObject());
			S3=S2*4;
			System.out.println("la valeur recu S2 est : "+S2);
			System.out.println("la valeur apres calcules S3 est : "+S3);
			serv.close();
			connexion.close();
			
			
			// client tcp 
			s = new DatagramSocket();
			data = new byte[4];
			data=(Integer.toString(S3)).getBytes();
			p4= new DatagramPacket(data, data.length,ipadr,2005); //2005 = tcp P1
			System.out.println("fin envoie de S3 a P2");
			s.send(p4);
			s.close();
			
		}
		catch(Exception e) {
			System.out.println("erreur p4 : "+e.toString());
			
		}

	}

}
