import java.util.ArrayList;

interface IMediator {
	public void sendMessage(User user, String msg);
	public void sendTo(String to, String msg);
	public void addUser(User user);
}

interface IUser {
	public void send(String msg);
	public void sendTo(String to, String msg);
	public void receive(String msg);
}

class User implements IUser {
	protected IMediator mediator;
	protected String name;
	
	public User(IMediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}
	
	public void send(String msg) {
		System.out.println(name + " send to all: " + msg);
		mediator.sendMessage(this, msg);
	}
	
	public void receive(String msg) {
		System.out.println(name + " receive message: " + msg);
	}
	
	public void sendTo(String to, String msg) {
		System.out.println(this.name + " send to " + to + ": " + msg);
		mediator.sendTo(to, msg);
	}
	
	public String getName() {
		return name;
	}
}

class Mediator implements IMediator {
	private ArrayList<User> users = new ArrayList<User>();
	
	public void sendMessage(User user, String msg) {
		for (User u : users) {
			if (user != u)
				u.receive(msg);
		}
	}
	
	public void sendTo(String to, String msg) {
		for (User u : users) {
			if (u.getName().equals(to)) {
				u.receive(msg);
				break;
			}
		}
	}
	
	public void addUser(User user) {
		System.out.println(user.getName() + " is connected");
		users.add(user);
	}
}

public class MediatorPattern {
	public static void main(String[] args) {
		IMediator mediator = new Mediator();
		User user1 = new User(mediator, "Weiqi");
		User user2 = new User(mediator, "Lucy");
		User user3 = new User(mediator, "Mike");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		user1.send("Hello all");
		user1.sendTo("Mike", "Hello Mike");
	}
}
