// abstract factory
abstract class BookStore {
	abstract public IDistributor getDistributor();
	abstract public IAdvertiser getAdvertiser();
}

// concrete factory
class TextBookStore extends BookStore {
	public String type;
	
	public TextBookStore(String type) {
		this.type = type;
	}
	
	public IDistributor getDistributor() {
		if (type.equals("text"))
			return new DistributorA();
		else if (type.equals("comics"))
			return new DistributorB();
		else
			return null;
	}
	
	public IAdvertiser getAdvertiser() {
		if (type.equals("text"))
			return new TextBookAdvertiser();
		else if (type.equals("comics"))
			return new ComicsBookAdvertiser();
		else
			return null;
	}
}

// concrete factory
class ComicsBookStore extends BookStore {
	public String type;
	
	public ComicsBookStore(String type) {
		this.type = type;
	}
	
	public IDistributor getDistributor() {
		if (type.equals("text"))
			return new DistributorA();
		else if (type.equals("comics"))
			return new DistributorB();
		else
			return null;
	}
	
	public IAdvertiser getAdvertiser() {
		if (type.equals("text"))
			return new TextBookAdvertiser();
		else if (type.equals("comics"))
			return new ComicsBookAdvertiser();
		else
			return null;
	}
}

interface IDistributor {
	public void shipBook();
}

class DistributorA implements IDistributor {
	public void shipBook() {
		System.out.println("We are from A.");
	}
}

class DistributorB implements IDistributor {
	public void shipBook() {
		System.out.println("we are from B.");
	}
}

interface IAdvertiser {
	public void advertise();
}

class TextBookAdvertiser implements IAdvertiser {
	public void advertise() {
		System.out.println("Please buy text books!");
	}
}

class ComicsBookAdvertiser implements IAdvertiser {
	public void advertise() {
		System.out.println("Please buy comics books!");
	}
}

public class AbstractFactory {
	public static void main(String[] args) {
		BookStore store1 = new TextBookStore("text");
		store1.getDistributor().shipBook();
		store1.getAdvertiser().advertise();
		
		BookStore store2 = new ComicsBookStore("comics");
		store2.getDistributor().shipBook();
		store2.getAdvertiser().advertise();
	}
}
