import java.util.ArrayList;
import java.util.List;

interface Subject {
	public void register(Observer obs);
	public void unregister(Observer obs);
	public void notifyObservers();
	public void setChanged(int number);
}

interface Observer {
	public void update(int number);
}

class NumberSource implements Subject {
	List<Observer> observers;
	int number;
	
	public NumberSource() {
		observers = new ArrayList<Observer>();
	}
	
	public void register(Observer obs) {
		observers.add(obs);
	}
	
	public void unregister(Observer obs) {
		observers.remove(obs);
	}
	
	public void notifyObservers() {
		for (Observer obs: observers)
			obs.update(number);
	}
	
	public void setChanged(int number) {
		this.number = number;
		notifyObservers();
	}
}

class NumberObserver implements Observer {
	public void update(int number) {
		System.out.println("Number changed to " + number);
	}
}


public class SelfImplementedObserver {
	public static void main(String[] args) {
		Subject source = new NumberSource();
		Observer obs = new NumberObserver();
		Observer obs2 = new NumberObserver();
		source.register(obs);
		source.register(obs2);
		source.setChanged(1);
		source.setChanged(2);
		source.setChanged(3);
	}
}
