package intiro;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class P1 extends java.rmi.server.UnicastRemoteObject implements IntP1{
	
	protected P1() throws Exception {
		System.out.println("creation de server RMI P1");
			}

	
	public void ReceiveN(int S2) throws Exception {
		System.out.println("la valeur S2 est "+S2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner( System.in );
		int N ; 
		Socket s;
		ObjectOutputStream out;
		try {
			System.out.println("donner une valeur a N ");
			N=input.nextInt();
			//tcp client 
			System.out.println("P1 client ..");
			s = new Socket("localhost",2005);
			out = new ObjectOutputStream(s.getOutputStream());
			out.writeObject(Integer.toString(N));
			System.out.println("send data from P1 to P2 : "+N);
			s.close();
			
			//RMI servrer
			System.out.println("P1 rmi server ..");
			P1 p = new P1();
			Registry reg = LocateRegistry.createRegistry(2004);
			reg.rebind("refP1", p);	
			
		}
		catch(Exception e) {
			System.out.println("erreur p1: "+e.toString());
		}

	}

}
