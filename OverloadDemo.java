/*
  Student s11ch, Hannah COPPERMAN
  Homework 6
  Usage: java OverloadDemo
  Then follow instructions from command line
  Sample Output: "9, 32"
*/

//Overload class has a number instance variable
//two constructors
//and two methods
class Overload {
  
  int number;

  //constructor overload 1--takes no arguments
  Overload() {
    this.number = 3;
  }

  //constructor overload 2--takes an int argument
  Overload(int num) {
   this.number = num; 
  }
  
  //method overload 1--takes no arguments
  void multiply() {
   System.out.println(this.number * 3);
  }
  
  //method overload 2--takes an int argument
  void multiply(int num) {
   System.out.println(this.number * num); 
  }
}

//Overload Demo class
class OverloadDemo {
   
  //creates an instance of Overload with each constructor
  //calls each multiply method
  public static void main(String[] args) {
    Overload overloadOne = new Overload();
    Overload overloadTwo = new Overload(4);
    overloadOne.multiply();
    overloadTwo.multiply(8);
  } 
}
