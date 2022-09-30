
public class MyThread extends Thread {

	public void run() {
		for(int count=0; count<10 ; count++) {
			System.out.println(count+" from : "+getName());
		}
	}
	
}
