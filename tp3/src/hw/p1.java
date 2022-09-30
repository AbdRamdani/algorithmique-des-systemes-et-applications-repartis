package hw;

import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			// la premiere initialisation 
			
			DatagramSocket s1;
			byte[] data;
			Scanner sc = new Scanner(System.in);
			DatagramPacket p1;
			int N,amicaux,M,sizec;
			int[] listec;
			Socket connexion ; 
			ServerSocket serv;
			ObjectInputStream in;
			InetAddress ip = InetAddress.getByName("localhost");
			
			while(true) {
				//tcp client : 
				
				s1 = new DatagramSocket();
				data = new byte[4];
				System.out.println("donner un valeur : ");
				N = sc.nextInt();
				data=(Integer.toString(N)).getBytes();
				p1= new DatagramPacket(data, data.length,ip,2005);
				s1.send(p1);
				s1.close();
				
				
				//udp server
				serv=new ServerSocket(2004);//p1
				System.out.println("server p1 ...");
				connexion=serv.accept(); 
				in = new ObjectInputStream(connexion.getInputStream());
				N=Integer.parseInt((String)in.readObject());
				M=Integer.parseInt((String)in.readObject());
				amicaux=Integer.parseInt((String)in.readObject());
				sizec=Integer.parseInt((String)in.readObject());
				System.out.println("la valeur de N : "+N);
				System.out.println("la valeur de M : "+M);
				if(amicaux==1) System.out.println("les chiffres sont amicaux");
				else System.out.println("les chiffres ne sont pas amicaux");
				
				listec=new int[sizec];
				for(int i =0; i<sizec;i++) {
					listec[i]=Integer.parseInt((String)in.readObject());
				}
				System.out.println("la liste des valeur cubique inferier a  "+(N+M)+" est :");
				for(int i =0; i<sizec;i++) {
					System.out.println(listec[i]);
				}
				serv.close();
				
			}
			
		}catch(Exception e) {
			System.out.println("erreur dans p1 : "+e.toString());
		}

	}

}
