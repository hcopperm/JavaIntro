import animal.*;
  /*
  Student s11ch, Hannah COPPERMAN
  Homework 8
  Usage: java -jar animal.jar 
  Sample Output: 
    Doggy says woof!
    Kitty says om nom nom nom      
*/

//AnimalDemo class;
//creates new Dog and new Cat
public class AnimalDemo {
 
  //calls speak method on Dog 
  public static void main(String[] args) {
    Dog ruft = new Dog();
    ruft.speak();
    Cat wush = new Cat();
    wush.eat();
  }
}
