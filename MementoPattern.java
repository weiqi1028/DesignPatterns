import java.util.ArrayList;

class Memento {
	private String state;
	
	public Memento(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
}

class Originator {
	private String state = "";
	
	public void setState(String curState) {
		System.out.println("set state to " + curState);
		state = curState;
	}
	
	public Memento store() {
		System.out.println("store state " + state);
		return new Memento(state);
	}
	
	public String restore(Memento memento) {
		if (memento == null) {
			System.out.println("invalid memento");
			return "";
		}
		System.out.println("restore state");
		setState(memento.getState());
		return state;
	}
}

class CareTaker {
	private ArrayList<Memento> states = new ArrayList<Memento>();
	
	public void save(Memento memento) {
		states.add(memento);
	}
	
	public Memento undo(int index) {
		if (index < 0 || index > states.size() - 1) {
			System.out.println("index out of range");
			return null;
		}
		return states.get(index);
	}
}
public class MementoPattern {
	public static void main(String[] args) {
		CareTaker careTaker = new CareTaker();
		Originator originator = new Originator();
		originator.setState("state1");
		careTaker.save(originator.store());
		originator.setState("state2");
		originator.setState("state3");
		careTaker.save(originator.store());
		originator.restore(careTaker.undo(0));
	}
}
