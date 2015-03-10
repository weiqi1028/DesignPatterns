class NumberHolder {
	private static NumberHolder instance = null;
	int number = 0;

	private NumberHolder() {

	}

	public static synchronized NumberHolder getInstance() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (instance == null) {

			instance = new NumberHolder();
		}

		return instance;
	}

	public int get() {
		return this.number;
	}

	public void increase() {
		this.number++;
	}
}

class TestThread implements Runnable {
	public void run() {
		NumberHolder instance = NumberHolder.getInstance();
		instance.increase();
		System.out.println("Number: " + instance.get());

	}
}

public class Singleton {
	public static void main(String[] args) {
		Runnable run1 = new TestThread();
		Thread t1 = new Thread(run1);
		t1.start();
		Runnable run2 = new TestThread();
		Thread t2 = new Thread(run2);
		t2.start();
	}
}
