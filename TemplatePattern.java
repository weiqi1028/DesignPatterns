abstract class Framework {
	public void doWork() {
		step1();
		step2();
		step3();
	}
	
	void step1() {
		System.out.println("Common step 1");
	}
	abstract void step2();
	abstract void step3();
}

class ApplicationOne extends Framework {
	void step2() {
		System.out.println("Application 1 step 2");
	}
	
	void step3() {
		System.out.println("Application 1 step 3");
	}
}

class ApplicationTwo extends Framework {
	void step2() {
		System.out.println("Application 2 step 2");
	}
	
	void step3() {
		System.out.println("Application 3 step 3");
	}
}

public class TemplatePattern {
	public static void main(String[] args) {
		Framework app1 = new ApplicationOne();
		app1.doWork();
		Framework app2 = new ApplicationTwo();
		app2.doWork();
	}
}
