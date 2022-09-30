package hw;

import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Scanner sc = new Scanner(System.in);
			byte[] data;
			int N,M;
			String ch=""; 
			DatagramSocket s2;
			DatagramPacket p2;
			ObjectOutputStream out;
			Socket c;
			
			while(true) {
				s2 = new DatagramSocket(2005);
				data = new byte[4];
				p2 = new DatagramPacket(data, data.length);
				System.out.println("server p2  ...");
				s2.receive(p2);
				
				// a la reception de packet
				ch=new String(p2.getData());
				s2.close();
				System.out.println("data recu a p2 par p1: "+ch);
				N= Integer.parseInt(ch.trim());
				System.out.println("$!$! "+N);
				
				System.out.println("Donner une valeur a M : ");
				M=sc.nextInt();
				
				
				//udp client 
				c = new Socket("localhost",2006);//p3
				out = new ObjectOutputStream(c.getOutputStream());
				System.out.println("N:"+N);
				out.writeObject(Integer.toString(N));
				System.out.println("M: "+M);
				out.writeObject(Integer.toString(M));
				c.close();
			}
			
		}catch(Exception e) {
			System.out.println("erreur dans p2 : "+e.toString());
		}

	}

}
