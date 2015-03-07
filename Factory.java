abstract class SpaceShip {
    private String name;
    private int damage;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public String getName() {
        return name;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void display() {
        System.out.println(getName() + " is coming, is has " + getDamage() + " damage.");
    }
}

class UFOSpaceShip extends SpaceShip {
    public UFOSpaceShip() {
        setName("UFO space ship");
        setDamage(20);
    }
}

class RocketSpaceShip extends SpaceShip {
    public RocketSpaceShip() {
        setName("Rocket space ship");
        setDamage(10);
    }
}

class SpaceShipFactory {
    public SpaceShip makeSpaceShip(String type) {
        if (type.equals("u"))
            return new UFOSpaceShip();
        else if (type.equals("r"))
            return new RocketSpaceShip();
        else
            return null;
    }
}

public class Factory {
    public static void main(String[] args) {
        SpaceShipFactory factory = new SpaceShipFactory();
        SpaceShip ufo = factory.makeSpaceShip("u");
        ufo.display();
        SpaceShip rocket = factory.makeSpaceShip("r");
        rocket.display();
    }
}