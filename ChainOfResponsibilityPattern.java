class Request {
	private int number1;
	private int number2;
	private String calculation;
	
	public Request(int number1, int number2, String calculation) {
		this.number1 = number1;
		this.number2 = number2;
		this.calculation = calculation;
	}
	
	public int getNumber1() {
		return number1;
	}
	
	public int getNumber2() {
		return number2;
	}
	
	public String getCalculation() {
		return calculation;
	}
}

interface Chain {
	public void setNext(Chain next);
	public void calculate(Request request);
}

class AddOperation implements Chain {
	private Chain next;
	
	public void setNext(Chain next) {
		this.next = next;
	}
	
	public void calculate(Request request) {
		if (request.getCalculation().equals("add"))
			System.out.println(request.getNumber1() + " " + request.getCalculation() + " " + request.getNumber2() + " equals " + (request.getNumber1() + request.getNumber2()));
		else
			next.calculate(request);
	}
}

class SubOperation implements Chain {
	private Chain next;
	
	public void setNext(Chain next) {
		this.next = next;
	}
	
	public void calculate(Request request) {
		if (request.getCalculation().equals("sub"))
			System.out.println(request.getNumber1() + " " + request.getCalculation() + " " + request.getNumber2() + " equals " + (request.getNumber1() - request.getNumber2()));
		else
			next.calculate(request);
	}
}

class MultOperation implements Chain {
	private Chain next;
	
	public void setNext(Chain next) {
		this.next = next;
	}
	
	public void calculate(Request request) {
		if (request.getCalculation().equals("mult"))
			System.out.println(request.getNumber1() + " " + request.getCalculation() + " " + request.getNumber2() + " equals " + (request.getNumber1() * request.getNumber2()));
		else
			next.calculate(request);
	}
}

class DivOperation implements Chain {
	private Chain next;
	
	public void setNext(Chain next) {
		this.next = next;
	}
	
	public void calculate(Request request) {
		if (request.getCalculation().equals("div"))
			System.out.println(request.getNumber1() + " " + request.getCalculation() + " " + request.getNumber2() + " equals " + (request.getNumber1() / request.getNumber2()));
		else
			System.out.println("No supported operation");
	}
}

public class ChainOfResponsibilityPattern {
	public static void main(String[] args) {
		Chain add = new AddOperation();
		Chain sub = new SubOperation();
		Chain mult = new MultOperation();
		Chain div = new DivOperation();
		add.setNext(sub);
		sub.setNext(mult);
		mult.setNext(div);
		
		Request r1 = new Request(1, 2, "add");
		Request r2 = new Request(1, 2, "sub");
		Request r3 = new Request(4, 2, "mult");
		Request r4 = new Request(9, 3, "div");
		Request r5 = new Request(9, 3, "log");
		
		add.calculate(r1);
		add.calculate(r2);
		add.calculate(r3);
		add.calculate(r4);
		add.calculate(r5);
	}
}
