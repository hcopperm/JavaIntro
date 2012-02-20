/*
  Student s11ch, Hannah COPPERMAN
  Homework 5
  Usage: java StringDemo --p={substring} --i={true,false}
  Then follow instructions from command line
  Sample Output: 
    Looking for the substring "example"
    Ignoring case: true
    Enter a string for me to look in
    //user enters "some examples"
    It is true that "some examples" contains "example"
*/

import java.io.*;
import java.util.*;

//Class that processes flags from command line and matches substrings to strings
class Grep {
  
  //reads flags in from command line, puts them into a String array, and
  //prompts user to enter a word
  //Checks if that word contains the substring passed in as the --p flag
  public static void main(String[] args) throws IOException {
		HashMap<String, String> flags = Grep.processFlags(args);
		String substring = flags.get("p");
		boolean ignoreCase = flags.get("i").equals("true");
		BufferedReader br =
		    new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		while (line != null) {
      boolean foundMatch = Grep.contains(line, substring, ignoreCase);
      if (foundMatch) {
        System.out.println(line);
      }
      line = br.readLine();
    }
  }
  
  //Takes an array of Strings of the form "--p=abc" and turns it into a HashMap
  //where "p" is the key and "abc" is the value
  static HashMap<String, String> processFlags(String[] strArray) {
    HashMap<String, String> argMap = new HashMap<String, String>();
    for (String s: strArray) {
      String[] keyVal = s.split("=");
      if (!keyVal[0].startsWith("--")) {
        System.out.println(keyVal[0]);
      } else {
        String key = keyVal[0].replaceFirst("--", "");
        String val = keyVal[1];
        argMap.put(key, val);
      }
    }
    return argMap;
  }
  
  //takes two strings and sees if the first contains the second
  //also takes a boolean that determines whether case matters
  static boolean contains(String line, String substring, boolean ignoreCase) {
    if (ignoreCase) {
      return (line.toLowerCase().contains(substring.toLowerCase()));
    } else {
      return line.contains(substring);
    }
  }
  
}


