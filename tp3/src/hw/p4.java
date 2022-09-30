package hw;

import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class p4 {

	
		//p4 a p1 en mode udp
		//p4 2007
		
		public static List<Integer> cubCheck(int x) {
			int z,j;
			List<Integer> a = new ArrayList<>();
			//.get(0);
			//.remove(0);
			//.size();
			// for (String i : cars){
			
			for(int i =100;i<=(x%1000);i++) {
				j=i;
				z=0;
				while (j > 0) {
				    z=z+ (int) Math.pow(j%10,3);
				    j = j / 10;
				}
				
				if(z == i) { 
					System.out.println("%%% "+z);
					a.add(z);
					}
			}
			return a;
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Socket c;
			ObjectOutputStream out;
			byte[] data,data2,data3;
			int N,M=0,amicaux;
			String ch="";
			DatagramSocket s4;
			DatagramPacket p4,p42;
			List<Integer> cubique;
			try{
				while(true) {
				//server en mode tcp
				s4 = new DatagramSocket(2007);
				data = new byte[10];
				data2 = new byte[10];
				p4 = new DatagramPacket(data, data.length);
				System.out.println("server p4 ...");
				s4.receive(p4);
				
				// a la reception de packet
				ch = new String(p4.getData());
				N=Integer.parseInt(ch.trim());
				System.out.println("data N recu a p4 par p3 : "+N);
				Thread.sleep(1000);
				
				//M
				
				p42 = new DatagramPacket(data2, data2.length);
				s4.receive(p42);
				ch = new String(p42.getData());
				M=Integer.parseInt(ch.trim());
				
				//amicaux
				data = new byte[10];
				p4 = new DatagramPacket(data, data.length);
				System.out.println("server p4 ...");
				s4.receive(p4);
				ch = new String(p4.getData());
				amicaux=Integer.parseInt(ch.trim());
				
				System.out.println("amicaux retourner par p3 est : "+amicaux);
				s4.close();
				
				System.out.println("data M recu a p4 par p3 : "+M);
				//traitement
				
				cubique=cubCheck(N+M);
				System.out.println(cubique);
				
				System.out.println("le produit N*M : "+(N*M));
				
				//client en mode udp 
				c = new Socket("localhost",2004); //p1
				out = new ObjectOutputStream(c.getOutputStream());
				out.writeObject(Integer.toString(N));
				out.writeObject(Integer.toString(M));
				out.writeObject(Integer.toString(amicaux));
				out.writeObject(Integer.toString(cubique.size()));
				for(int i : cubique)
					out.writeObject(Integer.toString(i));
				//
				c.close();
				}
				
			}catch(Exception e) {
				System.out.println("erreur dans p4 : "+e.toString());
			}

		}

}
