package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("client ..");
			DatagramSocket c= new DatagramSocket();
			InetAddress ip = InetAddress.getByName("localhost");
			byte [] sendData = new byte[10];
			String ch = "rsd";
			sendData=ch.getBytes();
			
			DatagramPacket p  = new DatagramPacket(sendData, sendData.length,ip,9876);
			c.send(p);
			
			// pour recevoir le packet
			byte [] receiveData = new byte[10];
			DatagramPacket p1 = new DatagramPacket(receiveData, receiveData.length);
			c.receive(p1);
			
			ch=new String(p1.getData());
			System.out.println("la chaine recu : "+ch);
			System.out.println("l'@ de destination "+p1.getAddress());
			System.out.println("le numero de porte est "+p1.getPort());
			
			// fin 
			c.close();
		}
		catch(Exception e) {
			System.out.println("exeption :: "+e.toString());
			
		}

	}

}
