interface Sub {
	public String getDescription();
	public double getPrice();
}

class EmptySub implements Sub {
	public EmptySub() {
		System.out.println("Creating an empty sub.");
	}
	
	public String getDescription() {
		return "Empty Sub";
	}
	
	public double getPrice() {
		return 5.0;
	}
}

abstract class SubDecorator implements Sub {
	protected Sub sub;
	
	public SubDecorator(Sub sub) {
		this.sub = sub;
	}
	
	public String getDescription() {
		return sub.getDescription();
	}
	
	public double getPrice() {
		return sub.getPrice();
	}
}

class BeefSub extends SubDecorator {
	public BeefSub(Sub sub) {
		super(sub);
		System.out.println("Add beef");
	}
	
	public String getDescription() {
		return sub.getDescription() + ", beef";
	}
	
	public double getPrice() {
		return sub.getPrice() + 2.0;
	}
}

class TomatoSub extends SubDecorator {
	public TomatoSub(Sub sub) {
		super(sub);
		System.out.println("Add tomato");
	}
	
	public String getDescription() {
		return sub.getDescription() + ", tomato";
	}
	
	public double getPrice() {
		return sub.getPrice() + 1.5;
	}
}


public class Decorator {
	public static void main(String[] args) {
		Sub tomatoAndBeefSub = new TomatoSub(new BeefSub(new EmptySub()));
		System.out.println(tomatoAndBeefSub.getDescription());
		System.out.println(tomatoAndBeefSub.getPrice());
	}
}
