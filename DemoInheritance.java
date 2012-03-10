//Abstract Restaurant class that implements a getPretaxPrice method
//Doesn't implement calculateTax method, but all its subclasses must
abstract class AbstractRestaurant {
  
  //subclasses must implement this method
  abstract double calculateTax(double preTax);
  
  //subclasses get this method for free
  double getPretaxPrice(double... items) {
    double total = 0.0;
    for (double i: items) {
      total = total + i;
    }
    return total;
  }
}

//Is a subclass of the abstract Restaurant class
//Implements only calculateTax method
class NewYorkStateRestaurant extends AbstractRestaurant {
  
  double calculateTax(double preTotal) {
    return (preTotal * 0.04);
  }
}

//Is a subclass of NewYorkStateRestaurant class
//Implements calculateTax method
//Also calls calculateTax of its superclass
class NewYorkCityRestaurant extends NewYorkStateRestaurant {
  
  double calculateTax(double preTotal) {
    return (preTotal * 0.12875);  
  } 
  
  //uses getPretaxPrice method from the AbstractRestaurant class
  //Uses calculateTax method from its superclass
  //Uses its own calculateTax method
  void calculateAllPrices(double preTotal) {
    double preTax = this.getPretaxPrice(preTotal);
    double cityTax = this.calculateTax(preTax);
    double stateTax = super.calculateTax(preTax);
    System.out.println("Pretax price: " + preTax);
    System.out.println("City tax: " + cityTax);
    System.out.println("State tax: " + stateTax);
  }
}

//Demo class
class DemoInheritance {
  
  //creates a new NewYorkCityRestaurant and calls calculateAllPrices method
  public static void main(String[] args) {
    NewYorkCityRestaurant resto = new NewYorkCityRestaurant();
    double preTax = resto.getPretaxPrice(12.3, 4.45, 9.90);
    resto.calculateAllPrices(preTax); 
  }
 
}
