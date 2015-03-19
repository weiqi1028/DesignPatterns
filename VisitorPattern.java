interface Visitor {
	public void visit(Circle circle);
	public void visit(Polygon polygon);
	public void visit(Rectangle rect);
}

class SaveASCIIVisitor implements Visitor {
	public void visit(Circle circle) {
		System.out.println(circle.getName() + " is saved to ASCII file.");
	}
	
	public void visit(Polygon polygon) {
		System.out.println(polygon.getName() + " is saved to ASCII file.");
	}
	
	public void visit(Rectangle rect) {
		System.out.println(rect.getName() + " is saved to ASCII file.");
	}
}

class SaveRasterVisitor implements Visitor {
	public void visit(Circle circle) {
		System.out.println(circle.getName() + " is saved to raster file.");
	}
	
	public void visit(Polygon polygon) {
		System.out.println(polygon.getName() + " is saved to raster file.");
	}
	
	public void visit(Rectangle rect) {
		System.out.println(rect.getName() + " is saved to raster file.");
	}
}

interface Visitable {
	public void accept(Visitor visitor);
}

class Circle implements Visitable {
	final private String name = "circle";
	
	public String getName() {
		return name;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class Rectangle implements Visitable {
	final private String name = "rectangle";
	
	public String getName() {
		return name;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class Polygon implements Visitable {
	final private String name = "polygon";
	
	public String getName() {
		return name;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

public class VisitorPattern {
	public static void main(String[] args) {
		SaveASCIIVisitor ascii = new SaveASCIIVisitor();
		SaveRasterVisitor raster = new SaveRasterVisitor();
		Circle circle = new Circle();
		Rectangle rect = new Rectangle();
		Polygon polygon = new Polygon();
		ascii.visit(circle);
		ascii.visit(rect);
		ascii.visit(polygon);
		raster.visit(circle);
		raster.visit(rect);
		raster.visit(polygon);
	}
}
