class Robot {
	private String head;
	private String body;
	private String legs;
	
	public void setHead(String head) {
		this.head = head;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public void setLegs(String legs) {
		this.legs = legs;
	}
	
	public String getHead() {
		return head;
	}
	
	public String getBody() {
		return body;
	}
	
	public String getLegs() {
		return legs;
	}
}

interface RobotBuilder {
	public void buildHead();
	public void buildBody();
	public void buildLegs();
	public Robot getRobot();
}

class OldRobotBuilder implements RobotBuilder {
	private Robot robot = null;
	
	public OldRobotBuilder() {
		robot = new Robot();
	}
	
	public void buildHead() {
		robot.setHead("old head");
	}
	
	public void buildBody() {
		robot.setBody("old body");
	}
	
	public void buildLegs() {
		robot.setLegs("old legs");
	}
	
	public Robot getRobot() {
		return robot;
	}
	
}

class RobotEngineer {
	RobotBuilder builder;
	
	public RobotEngineer(RobotBuilder builder) {
		this.builder = builder;
	}
	
	public void makeRobot() {
		builder.buildHead();
		builder.buildBody();
		builder.buildLegs();
	}
	
	public Robot get() {
		return builder.getRobot();
	}
}

public class Builder {
	public static void main(String[] args) {
		RobotBuilder builder = new OldRobotBuilder();
		RobotEngineer engineer = new RobotEngineer(builder);
		engineer.makeRobot();
		Robot robot = engineer.get();
		System.out.println("Head: " + robot.getHead() + "\nBody: " + robot.getBody() + "\nLegs: " + robot.getLegs());
	}
}
