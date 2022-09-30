
public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread first = new MyThread();
		MyThread second = new MyThread();
		
		System.out.println("1");
		first.start();
		second.start();
	}

}
