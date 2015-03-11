interface Command {
	public void execute();
}

interface Hero {
	public void up();
	public void down();
	public void left();
	public void right();
	public int getX();
	public int getY();
	public String getName();
}

class Mario implements Hero {
	private int x;
	private int y;
	private String name;
	
	public Mario() {
		x = 0;
		y = 0;
		name = "Mario";
	}
	
	public void up() {
		y++;
	}
	
	public void down() {
		y--;
	}
	
	public void left() {
		x--;
	}
	
	public void right() {
		x++;
	}
	
	public String getName() {
		return name;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}

class MoveUp implements Command {
	private Hero hero;
	
	public MoveUp(Hero hero) {
		this.hero = hero;
	}
	
	public void execute() {
		System.out.println("Move up");
		hero.up();
	}
}

class MoveDown implements Command {
	private Hero hero;
	
	public MoveDown(Hero hero) {
		this.hero = hero;
	}
	
	public void execute() {
		System.out.println("Move down");
		hero.down();
	}
}

class MoveLeft implements Command {
	private Hero hero;
	
	public MoveLeft(Hero hero) {
		this.hero = hero;
	}
	
	public void execute() {
		System.out.println("Move left");
		hero.left();
	}
}

class MoveRight implements Command {
	private Hero hero;
	
	public MoveRight(Hero hero) {
		this.hero = hero;
	}
	
	public void execute() {
		System.out.println("Move right");
		hero.right();
	}
}

class ControllerButton {
	private Command command;
	
	public ControllerButton(Command command) {
		this.command = command;
	}
	
	public void press() {
		command.execute();
	}
}

public class CommandPattern {
	public static void main(String[] args) {
		Hero mario = new Mario();
		Command upCommand = new MoveUp(mario);
		Command downCommand = new MoveDown(mario);
		Command leftCommand = new MoveLeft(mario);
		Command rightCommand = new MoveRight(mario);
		ControllerButton button = new ControllerButton(upCommand);
		
		// play with Mario
		button.press();
		System.out.println(mario.getName() + " is at: " + mario.getX() + ", " + mario.getY());
		button = new ControllerButton(downCommand);
		button.press();
		System.out.println(mario.getName() + " is at: " + mario.getX() + ", " + mario.getY());
		button = new ControllerButton(leftCommand);
		button.press();
		System.out.println(mario.getName() + " is at: " + mario.getX() + ", " + mario.getY());
		button = new ControllerButton(rightCommand);
		button.press();
		System.out.println(mario.getName() + " is at: " + mario.getX() + ", " + mario.getY());
	}
}
