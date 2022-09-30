
public class TestThreadPrio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread first = new MyThread();
		MyThread second = new MyThread();
		first.setPriority(1);
		second.setPriority(2);
		first.start();
		second.start();
		System.out.println("thread min prio " +first.MIN_PRIORITY);
		System.out.println("thread max prion "+first.MAX_PRIORITY);
		System.out.println("thread norm prion "+first.NORM_PRIORITY);
		System.out.println("thread first prio "+first.getPriority());
	}

}
