package animal;
//Class Dog implements IAnimal interface
//Is part of Animal package
public class Dog implements IAnimal {
 
  public void speak() {
    System.out.println("Doggy says woof!");
  }
  
  public void eat() {
    System.out.println("Doggy says nom nom nom");
  }
  
}
