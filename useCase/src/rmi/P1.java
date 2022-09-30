package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			intP2 r = (intP2) reg.lookup("Refs");
			//r.receiveMessage("Master RSD");  // send Master RSD
			//int som = r.Calculer(10, 16); // send 15,25   --   receive 40
			//System.out.println("som= "+som);
		}
		catch(Exception e ) {
			System.out.println("erreur p1 : "+e.toString());
		}
	}

}
