package DroneSimulation;

import java.util.Scanner;

public class DroneInterface {
 
	private Scanner s;
	private DroneArena myArena;
  
    public DroneInterface() {
    	 s = new Scanner(System.in);	
    	 
    	
    	// myArena = new DroneArena(10, 20);	
    	// myArena.addDrone(5, 7);
    	// System.out.print(myArena.showIt());
    	// myArena.moveDrone();
    	// System.out.print(myArena.showIt());
    	 
    	
        char ch = ' ';
        do {
        	System.out.print("Enter (A)dd drone, get (I)nformation or e(X)it > ");
        	ch = s.next().charAt(0);
        	s.nextLine();
        	switch (ch) {
    			case 'A' :
    			case 'a' :
        					myArena.addDrone();
        					break;
        		case 'I' :
        		case 'i' :
        					System.out.print(myArena.toString());
            				break;
        		case 'x' : 	ch = 'X';				
        					break;
        	}
    		} while (ch != 'X');						
        
       s.close();									
    }
    
	public static void main(String[] args) {
	new DroneInterface();	
	}
	
}
