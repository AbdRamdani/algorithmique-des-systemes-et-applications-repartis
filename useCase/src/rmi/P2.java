package rmi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;





public class P2 extends java.rmi.server.UnicastRemoteObject implements intP2  {

	public P2() throws Exception {System.out.println("Lancement de Server Rmi ....");}
	
	//definition des fonction
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
