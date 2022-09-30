package intiro;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket s;
			byte[] receiveData ;
			DatagramPacket p;
			int N , S1,S2 ; 
			String ch;
			//udp server 
			

			//creation de packet
			s = new DatagramSocket(2006);
			receiveData = new byte[10];
			//N
			p = new DatagramPacket(receiveData, receiveData.length);
			System.out.println("serveur udp P3 ..");
			s.receive(p);
			ch = new String(p.getData());
			N= Integer.parseInt(ch.trim());
			System.out.println("valeur N recu par P2 est : "+N);
			
			//S1
			p = new DatagramPacket(receiveData, receiveData.length);
			s.receive(p);
			ch = new String(p.getData());
			S1= Integer.parseInt(ch.trim());
			System.out.println("valeur S1 recu par P2 est : "+S1);
			
			s.close();
			
			//traitement 
			S2= S1*3+N; 
			System.out.println("le resultat de calcule est : "+S2);
			
			
			//rmi client 
			System.out.println("P3 rmi client  ");
			
			Registry r = LocateRegistry.getRegistry("localhost",2004);
			IntP1 ip2 =(IntP1) r.lookup("refP1");
			ip2.ReceiveN(S2);
			System.out.println("valeur envoyé  a p2 eset : "+S2);
			
			
			
		}catch(Exception e ) {
			System.out.println("erreur P1 : "+e.toString());
		}

	}

}
