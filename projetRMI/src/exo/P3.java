package exo;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//port 1100
public class P3 extends java.rmi.server.UnicastRemoteObject implements IntP {
	
	private int S1,S2;
	
	public P3() throws Exception {
		System.out.println("Lancement de Server P3 ....");}

	public void receiveMessage(int n) throws Exception {
		System.out.println("valeur recu par P2 est " +n);
		this.S1=n;
		// calculer la valeur 
		this.S2=this.Calculer(this.S1);
		System.out.println("la valeur calculer est : "+this.S2 );
		Socket c; 
		ObjectOutputStream out; 
		c = new Socket("localhost",2006);//p4 udp port 
		out = new ObjectOutputStream(c.getOutputStream());
		
		out.writeObject(Integer.toString(this.S2));
		System.out.println("fin envoie S2 a P4");
		//
		c.close();

	}

	
	public int Calculer(int a) throws Exception {
		// TODO Auto-generated method stub
		return a*3;
	}

	public static void main(String[] args) {
		int port = 1100;
		Socket c; 
		ObjectOutputStream out; 
		try {
			//server RMI
			P3 p = new P3();
			Registry reg = LocateRegistry.createRegistry(port);
			reg.rebind("Refs", p);	
			// recevoir la valeur , appliques les calcule
			/*
			p.S2=p.Calculer(p.S1);
			System.out.println("la valeur calculer est : "+p.S2 );
			*/
			
			//client udp
			/*
			c = new Socket("localhost",2006);//p4 udp port 
			out = new ObjectOutputStream(c.getOutputStream());
			
			out.writeObject(Integer.toString(p.S2));
			System.out.println("fin envoie S2 a P4");
			//
			c.close();
			*/
			
			
			
		}catch(Exception e ) {
			System.out.println("erreur p2 : "+e.toString());
		}

	}

}
