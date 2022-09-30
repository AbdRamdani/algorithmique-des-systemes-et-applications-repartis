package exo;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Serveur s = new Serveur();		
		Client c1= new Client();
		Client c2= new Client();
		Client c3= new Client();
				
		s.start();
		if (c1.isAlive())  c1.start();
		c2.start();		
		c3.start();

	}

}
