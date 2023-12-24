package DroneSimulation;

import java.util.Random;

import DroneSimulation.Direction.NESW;

import java.util.ArrayList;

public class DroneArena {
	
	int xmax, ymax;
	Random randomGen = new Random();
	ArrayList<Drone> droneList = new ArrayList<>();
	
	public DroneArena(int i, int j) {
		xmax = i;
		ymax = j;
}
	/*
	 * Establishes a random generator and creates an array list for drone
	 * Establishes the maximum x and y border for drone arena 
	 */

	public static void main(String[] args) {
		DroneArena da = new DroneArena (10,15);
		System.out.println(da.toString());
		da.addDrone();
	}
	/*
	 * Adds drones into a list and outputs the string 
	 */
	
	
	
	
	public void addDrone() {
		int xPos = randomGen.nextInt(xmax-1);
		int yPos = randomGen.nextInt(ymax -1);
		//String str = "";
		//String xmaxstr = String.valueOf(xmax);
		//String ymaxstr = String.valueOf(ymax);
		
		if ((xPos == 0) || (xPos == xmax) || (yPos == 0) || (yPos == ymax)) {
			System.out.println("this cannot be placed");
		}
		else {
			Drone dl = new Drone(xPos, yPos, NESW.getRandomDirection());
			if (getDroneAt(xPos, yPos) == null) {
				droneList.add(dl);
				// for (Drone c : droneList)
					// str.concat(c.toString()).concat(" in the arena of size ").concat(xmaxstr).concat(", ").concat(ymaxstr).concat("\n");
				 System.out.println(dl);
			}
			else {
				System.out.println("it cannot be added");
			}
		}
	}
	/*
	 * Responsible for checking if current drone can be added to the list 
	 */
	
	
    public String toString() {
        StringBuilder info = new StringBuilder();
        for (Drone c : droneList)
            info.append(c.toString()).append(" in the arena of size ").append(xmax).append(", ").append(ymax).append("\n");
        return info.toString();
    }
    /*
     * Appends the drone variable from drone list to the string 
     */

	public Drone getDroneAt (int x, int y) {
		for (Drone d : droneList) {		// uses isHere to check if the current Drone does not share x and y with a Drone in the array list
			if (d.isHere(x,y) == true){
				return d;
			}
		} 
		return null;
	}
	
	
    public void showDrones(ConsoleCanvas c) {
        for (Drone e : droneList) {
            e.displayDronePos(c);
        }
    }
    /*
     * Display the drone position in console canvas
     */

	
	public int getXSize (DroneArena g) {
		return g.xmax;
	}
	
	public int getYSize(DroneArena g) {
		return g.ymax;
	}



	 
	 public boolean canGoHere (int x, int y) {
		   for (Drone c : droneList) {
	            if ((c.isHere(x, y)) || ((x == 0) || (x == (xmax - 1)) || (y == 0) || (y == (ymax - 1)))) {
	                return false;
	            }
	        }
	        return true; 

	 }
	 /* 
	  * Verify if drone position is valid 
	  */
	 
	   public void moveAllDrones(DroneArena arena) {
	        for (Drone c : droneList) {
	            c.moveDrone(arena);
	        }
	    }
	   /*
	    * Calls the move drone method using the current drone in the list
	    */


}
