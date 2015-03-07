interface CanFly {
    public void canIFly();
}

class Fly implements CanFly {
    public void canIFly() {
        System.out.println("I can fly!");
    }
}

class NotFly implements CanFly {
    public void canIFly() {
        System.out.println("I can not fly");
    }
}

class Animal {
    private CanFly flyObj;
    private String name;
    public void setFly(CanFly flyObj) {
        this.flyObj = flyObj;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void fly() {
        flyObj.canIFly();
    }
}

class Bird extends Animal {
    public Bird() {
        setName("bird");
        CanFly canFly = new Fly();
        setFly(canFly);
    }
}

class Dog extends Animal {
    public Dog() {
        setName("dog");
        CanFly canFly = new NotFly();
        setFly(canFly);
    }
}

public class Strategy {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        Dog dog = new Dog();
        dog.fly();
        CanFly canFly = new Fly();
        dog.setFly(canFly);
        dog.fly();
    }
}