package DesignPatterns;

public class Cat extends Animal {
	
	public Cat() {
		
		super();
		
		setSound("Meow");
	}
	
	// If you want to make sure a method isn't overridden mark it as Final
	
		final void attack(){
			// Do stuff that can never change
		}
		
		// A field marked with final can't be changed
		
		public static final double FAVNUMBER = 3.14;
		
		// A class labeled as final can't be extended

}
