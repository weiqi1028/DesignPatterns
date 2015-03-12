interface Enemy {
	public void shoot();
	public void driveForward();
}

class EnemyCar implements Enemy {
	public void shoot() {
		System.out.println("Enemy car shoots, does 10 damage.");
	}
	
	public void driveForward() {
		System.out.println("Enemy car drives forward 10 spaces.");
	}
}

class EnemyRobot {
	public void hit() {
		System.out.println("Enemy robot hits, does 5 damage.");
	}
	
	public void moveForward() {
		System.out.println("Enemy robot move forward 15 spaces.");
	}
}

class AttackerAdapter implements Enemy {
	private EnemyRobot robot = new EnemyRobot();
	
	public AttackerAdapter(EnemyRobot robot) {
		this.robot = robot;
	}
	
	public void shoot() {
		robot.hit();
	}
	
	public void driveForward() {
		robot.moveForward();
	}
}
public class AdapterPattern {
	public static void main(String[] args) {
		EnemyCar car = new EnemyCar();
		car.driveForward();
		car.shoot();
		
		EnemyRobot robot = new EnemyRobot();
		robot.moveForward();
		robot.hit();
		
		Enemy adapter = new AttackerAdapter(robot);
		adapter.driveForward();
		adapter.shoot();
	}
	
}
