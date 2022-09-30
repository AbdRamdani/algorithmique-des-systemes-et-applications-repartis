
public class TestThreadR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new MyThreadR());
		Thread t2 = new Thread(new MyThreadR());
		t.start();
		t2.start();
	}

}
