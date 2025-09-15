import java.util.*;

class PetService {
    private static final double BASE_FEE = 50.0;
    private static final double VACCINATION_FEE = 25.0;
    private static final double GROOMING_FEE = 30.0;

    public double calculateFee() {
        return BASE_FEE;
    }

    public double calculateFee(boolean withVaccination) {
        if (withVaccination) {
            return BASE_FEE + VACCINATION_FEE;
        }
        return BASE_FEE;
    }

    public double calculateFee(boolean withVaccination, boolean withGrooming) {
        double fee = BASE_FEE;
        if (withVaccination) fee += VACCINATION_FEE;
        if (withGrooming) fee += GROOMING_FEE;
        return fee;
    }

    public double calculateFee(String emergencyType) {
        return 200.0;
    }
}

abstract class Pet {
    protected String name;
    protected int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();

    public void displayInfo() {
        System.out.println("Pet Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Dog extends Pet implements Trainable {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }

    @Override
    public void performTrick() {
        System.out.println("Training " + name + ": Sits and shakes");
    }
}

class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow! Meow!");
    }
}

class Bird extends Pet implements Trainable {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet! Tweet!");
    }

    @Override
    public void performTrick() {
        System.out.println("Training " + name + ": Flies in circles and lands on perch");
    }
}

interface Trainable {
    void performTrick();
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PET SERVICE FEES ===");
        PetService service = new PetService();
        System.out.println("Basic checkup: $" + service.calculateFee());
        System.out.println("Checkup with vaccination: $" + service.calculateFee(true));
        System.out.println("Full service (vaccination + grooming): $" + service.calculateFee(true, true));
        System.out.println("Emergency service: $" + service.calculateFee("critical"));
        System.out.println();

        System.out.println("=== PET INFORMATION ===");
        Pet dog = new Dog("Buddy", 3);
        Pet cat = new Cat("Whiskers", 2);
        Pet bird = new Bird("Tweety", 1);

        dog.displayInfo();
        dog.makeSound();
        System.out.println();

        cat.displayInfo();
        cat.makeSound();
        System.out.println();

        bird.displayInfo();
        bird.makeSound();
        System.out.println();

        System.out.println("=== TRAINING PETS ===");
        Trainable trainDog = (Trainable) dog;
        Trainable trainBird = (Trainable) bird;

        trainDog.performTrick();
        trainBird.performTrick();
    }
    }
