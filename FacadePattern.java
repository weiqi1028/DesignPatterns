class CPU {
	public void execute() {
		System.out.println("Execute CPU");
	}
}

class Disk {
	public void read() {
		System.out.println("Read disk");
	}
}

class RAM {
	public void load(Disk disk) {
		disk.read();
		System.out.println("Load RAM");
	}
}

class Computer {
	private CPU cpu = new CPU();
	private RAM ram = new RAM();
	private Disk disk = new Disk();
	
	public void start() {
		cpu.execute();
		ram.load(disk);
	}
}

public class FacadePattern {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.start();
	}
}
