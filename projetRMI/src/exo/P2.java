package exo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//port 1099 rmi 
// port 2005 udp
public class P2 extends java.rmi.server.UnicastRemoteObject implements IntP {
	
	private int N,S1,S3;
	public P2() throws Exception {
		System.out.println("Lancement de Server P2 ....");}

	public void receiveMessage(int n) throws Exception {
		// TODO Auto-generated method stub
		this.N=n;
		
		this.S1=this.Calculer(this.N);
		System.out.println("la valeur calculer est : "+this.S1 );
		
		
		// client RMI
		
		Registry regS = LocateRegistry.getRegistry("localhost", 1100);
		
		IntP r = (IntP) regS.lookup("Refs");
		
		r.receiveMessage(this.S1);
		System.out.println("fin d'envoie de P1 a p2");
		//lance tcp server
		this.LanceUdp();

	}

	public int Calculer(int a) throws Exception {
		// TODO Auto-generated method stub
		return a*2 ;
	}
	public void LanceUdp() {
		DatagramSocket s2;
		byte[] data;
		DatagramPacket p2;
		String ch ;
		try{
		s2 = new DatagramSocket(2005);
		data = new byte[4];
		p2 = new DatagramPacket(data, data.length);
		System.out.println("server p2  ...");
		s2.receive(p2);
		
		// a la reception de packet
		ch=new String(p2.getData());
		s2.close();
		System.out.println("data recu a p2 par p4: "+ch);
		this.S3= Integer.parseInt(ch.trim());
		System.out.println("S3 recu :  "+this.S3);
		}catch(Exception e ) {
			System.out.println("erreur dans server tcp p2 "+e.toString());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 1099;
		try {
			//server RMI
			P2 p = new P2();
			Registry reg = LocateRegistry.createRegistry(port);
			reg.rebind("Refs", p);	
			
			// recevoir la valeur , appliques les calcule
			/*
			p.S1=p.Calculer(p.N);
			System.out.println("la valeur calculer est : "+p.S1 );
			
			
			// client RMI
			
			Registry regS = LocateRegistry.getRegistry("localhost", 1100);
			
			IntP r = (IntP) regS.lookup("Refs");
			
			r.receiveMessage(p.S1);  // send S1 to p3
			
			*/
			//serveur tcp 
			/*
			DatagramSocket s2;
			byte[] data;
			DatagramPacket p2;
			String ch ;
			
			s2 = new DatagramSocket(2005);
			data = new byte[4];
			p2 = new DatagramPacket(data, data.length);
			System.out.println("server p2  ...");
			s2.receive(p2);
			
			// a la reception de packet
			ch=new String(p2.getData());
			s2.close();
			System.out.println("data recu a p2 par p4: "+ch);
			p.S3= Integer.parseInt(ch.trim());
			System.out.println("$!$! "+p.S3);
			*/
			
		}catch(Exception e ) {
			System.out.println("erreur p2 : "+e.toString());
		}

	}

	
	

}
