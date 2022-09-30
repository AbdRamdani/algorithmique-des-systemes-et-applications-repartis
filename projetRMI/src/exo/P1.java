package exo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import projetRMI.IntP2;

public class P1 {

	public static void main(String[] args) {
		// send to P2 rmi
		try {
			System.out.println("donner un valeur : ");
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			
			IntP r = (IntP) reg.lookup("Refs");
			
			r.receiveMessage(N);  // send N to p2
			
		}
		catch(Exception e) {
			System.out.println("Exception :"+e.toString());
		}

	}

}
