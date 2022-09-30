
public class MyThread2 extends Thread{

	private boolean actif = true; 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MyThread2 t = new MyThread2(); 
			t.start();
			System.in.read();
			t.arreter();
			
			
		}catch(Exception e ) {
			System.out.println("erreur dans le thread "+e.toString());
		}
		

	}
	public void run() {
		int i=0 ; 
		while(actif) {
			System.out.println(i +" par : "+getClass());
		}
	}
	public void arreter() {
		actif=false; 
		System.out.println("system arreter");
	}

}
