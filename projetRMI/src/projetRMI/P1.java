package projetRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class P1 {

	public static void main(String[] args) {
		
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			
			IntP2 r = (IntP2) reg.lookup("Refs");
			
			r.receiveMessage("Master RSD");  // send Master RSD
			int som = r.Calculer(10, 16); // send 15,25   --   receive 40
			System.out.println("som= "+som);
			
		}
		catch(Exception e) {
			System.out.println("Exception :"+e.toString());
		}
	}

}
