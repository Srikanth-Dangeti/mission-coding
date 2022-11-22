package DesignPatterns;

public class Dog extends Animal{
	
	public void digHole() {
		System.out.println("Dug a Hole");
	}
	
	public void changeVar(int randNum){
			
			randNum = 12;
			
			System.out.println("randNum in method value: " + randNum);
			
	}
	
	/* This private method can only be accessed through using other 
	 * methods in the class */
	
	private void bePrivate(){
		System.out.println("I am a Private Method in Dog");
	}
	
	public void accessPrivate() {
		bePrivate();
	}
	
	// The constructor initializes all objects
	
	public Dog() {
		
		// Executes the parents constructor
				// Every class has a constructor whether you make it or not
				
				super();
				
				// Sets bark for all Dog objects by default
				
				setSound("Bark");
		
		
	}
}
