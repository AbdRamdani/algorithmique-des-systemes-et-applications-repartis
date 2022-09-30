package hw;

import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class p3 {

	public static int nbDiv(int x) {
		int y=x; 
		for(int i =1; i<=(x/2);i++) {
			if(x%i==0) y+=i;
		}
		return y;
	}
	//p3 a p4 en mode udp
	//p3 2006
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			byte[] data,data2;
			int N,M=0,amicaux=0;
			String ch="";
			DatagramSocket s3;
			DatagramPacket p3,p32;
			Socket connexion ; 
			ServerSocket serv;
			ObjectInputStream in;
			InetAddress ip = InetAddress.getByName("localhost");
			while(true) {
				//udp client 
				serv=new ServerSocket(2006);
				System.out.println("server p3 ...");
				connexion=serv.accept(); 
				
				in = new ObjectInputStream(connexion.getInputStream());
				
				N=Integer.parseInt((String)in.readObject());
				Thread.sleep(1000);
				M=Integer.parseInt((String)in.readObject());
				System.out.println("la valeur N recu a p3 par p2 est "+N);
				System.out.println("la valeur M recu a p3 par p2 est "+M);
				serv.close();
				connexion.close();
				
				//traitement
				System.out.println("la somme de N+M est : "+(N+M));
				
				
				
				if(nbDiv(N)==nbDiv(M)) {
					amicaux=1;
				}
				
				
				
				//tcp client
				System.out.println("P3 client ");
				s3 = new DatagramSocket();
				
				data = new byte[10];
				data2= new byte[10];
				data=(Integer.toString(N)).getBytes();
				data2=(Integer.toString(M)).getBytes();
				
				p3= new DatagramPacket(data, data.length,ip,2007);
				s3.send(p3);
				data2=(Integer.toString(M)).getBytes();
				p32= new DatagramPacket(data2, data2.length,ip,2007);
				s3.send(p32);
				
				//
				System.out.println("p3 : la valeur de amicaux est : "+amicaux);
				data2=(Integer.toString(amicaux)).getBytes();
				p32= new DatagramPacket(data2, data2.length,ip,2007);
				s3.send(p32);
				
				s3.close();
				
			}
			
		}catch(Exception e) {
			System.out.println("erreur dans p3 : "+e.toString());
		}

	}
	}


