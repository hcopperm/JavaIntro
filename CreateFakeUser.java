/*
  Student s11ch, Hannah COPPERMAN
  Homework 4
  Usage: java Demo
  Then follow instructions from command line
  Sample Output: ""Type \"create\" to create	a new user, \"see\" to" 
		      + " see your current user list, and \"q\" to quit""
*/

import java.io.*;
import java.util.*;

//User class. Takes a username and password and returns a User object
class User {
    
  static final int MIN_LENGTH = 2;
  static final int MAX_LENGTH = 6;
  
  String username;
  String password;
  
  //User constructor; pass in a username and password
  public User(String un, String pw) {
    username = un;
    password = pw;
  }
  
  //Validates username
  public static boolean isUserNameValid(String un) {
    return isShort(un);
  }
  
  //Validates password
  public static boolean isPasswordValid(String pw) {
    return isShort(pw) && isLowercase(pw);
  }
  
	//Takes in a string and checks to see if it is between 2 and 6 chars
	private static boolean isShort(String input) {
	  if (input.length() > MAX_LENGTH) {
	    System.out.println("Too long.");
	    return false;
	  } else if (input.length() < MIN_LENGTH) {
	    System.out.println("Too short.");
	    return false; 
	  } else {
	    return true;
	  }
	}
	
	//Takes in a string and checks to see if it's between "a" and "z" (ie is it
	//lowercase
	private static boolean isLowercase(String input) {
	  int numNonLetters = 0;
    for (int i = 0; i < input.length(); i++) {
      if (!(input.charAt(i) >= 'a') || !(input.charAt(i) <= 'z')) {
        numNonLetters += 1;
      }
    }
  	  
    if (numNonLetters > 0) {
      System.out.println("Only use lowercase letters.");
      return false;
    } else {
      return true;
    }
  }

}

// Database class. Saves User objects to an ArrayList.
class Database {
  
  private final ArrayList<User> userList; 
  private final String dbName;
  
  //Constructor takes a string and assigns it to the property "dbName"
  public Database(String name) {
    userList = new ArrayList<User>();
    dbName = name;
  }
  
  //Adds User object to the list of users
  public void addUser(User user) {
    userList.add(user);
  }
  
  //Loops through the list of users and prints out info for each one
  public void printUserInfo() {
    System.out.println("DB " + dbName + ": " + userList.size() + " users");
    for (User user: userList) {
      System.out.println("Username: " + user.username);
      System.out.println("Password: " + user.password);
    }
  }
}

//CreateFakeUser class. Instantiates User and Database objects
class CreateFakeUser {
  
  //Main method creates a new Database, and adds Users to it as desired.
	public static void main(String[] args) throws IOException {
	  boolean quit = false;
	  BufferedReader br =
		    new BufferedReader(new InputStreamReader(System.in));
		System.out.println("This is UserCreator3000. Enter your database name");
		
		//Read in user input
		Database db = new Database(br.readLine());
		
		//Until user says to quit, execute code as they desire
		while (!quit) {
		  System.out.println("Type \"create\" to create	a new user, \"see\" to" 
		      + " see your current user list, and \"q\" to quit");
		  String str = br.readLine();
		  if (str.equals("create")) {
		    createUser(db, br);
		  } else if (str.equals("see")) {
        db.printUserInfo();
      } else if (str.equals("q")) {
        quit = true;
      } else {
        System.out.println("I don't understand. Try again.");
      } 
    }
    System.out.println("Goodbye");
	}
	
	//Validates usernames and passwords, and if they are valid, passes them into
	//the User constructor.
	static void createUser(Database db, BufferedReader br) throws IOException {
    System.out.println("Please enter your username");
    String un = br.readLine();
    while (!User.isUserNameValid(un)) {
      un = br.readLine();
    }
    System.out.println("Username valid");
    System.out.println("Please enter your password");
    String pw = br.readLine();
    while (!User.isPasswordValid(pw)) {
      pw = br.readLine();
    }
    System.out.println("Password valid");
    db.addUser(new User(un, pw));
    System.out.println("User added.");
	}
}
