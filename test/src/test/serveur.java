package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class serveur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			DatagramSocket s = new DatagramSocket(9876);
			byte[] receiveData = new byte[10];
			
			//creation de packet
			DatagramPacket p = new DatagramPacket(receiveData, receiveData.length);
			System.out.println("serveur wait ...");
			s.receive(p);
			
			String ch = new String(p.getData());
			
			// pour afficher l'@ ip de sender 
			System.out.println("l'@ ip de sender est : "+p.getAddress());
			System.out.println("le numero de porte est : "+p.getPort());
			
			//pour repondre au client 
			
			ch=ch.toUpperCase(); // juste pour changer la forme de la chaine 
			byte[] sendData = new byte[10];
			sendData=ch.getBytes();
			
			DatagramPacket p1 = new DatagramPacket(sendData, sendData.length,p.getAddress(),p.getPort());
			//pour envoyer le packet
			s.send(p);
			
			
			s.close();
			
		}
		catch(Exception e ) {
			System.out.println("exception serveur : "+e.toString());
		}

	}

}
