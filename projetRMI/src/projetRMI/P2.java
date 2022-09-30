package projetRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class P2 extends java.rmi.server.UnicastRemoteObject implements IntP2 {

	
	public P2() throws Exception {System.out.println("Lancement de Server Rmi ....");}
	public void receiveMessage(String x) throws Exception {
		System.out.println("method inv :"+x); // receive Master RSD
	}

	public int Calculer(int a, int b) throws Exception{ // receive 15, 25
		return a+b; // send 40 
	}

	public static void main(String[] args) {
		int port =1099;
		try {
			P2 p = new P2();
			Registry reg = LocateRegistry.createRegistry(port);
			reg.rebind("Refs", p);			
		}
		catch(Exception e) {
			System.out.println("erreur server :"+e.toString());
		}

	}

}
