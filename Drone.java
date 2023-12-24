package DroneSimulation;

import DroneSimulation.Direction.NESW;
public class Drone {
	
	private int x,y, droneId, dx, dy;   
	private static int droneCount = 0;
	private NESW test;
	public Drone (int dx, int dy, NESW w) {
		x = dx;
		y = dy;
		droneId = droneCount++;
		test = w;
	}
	/*
	 * Drone class responsible for establishing the drone position, id and direction
	 */
	
	public static void main(String[] args) {
		
		Drone d = new Drone (5, 3, NESW.South);
		System.out.println(d.toString());
		Drone d2 =new Drone (8, 12, NESW.North);
		System.out.println(d2.toString());

	}
	/*
	 * Outputs test positions
	 */

	
	public int getX() {
		return x;
	}
	
	public int getY () {
		return y;
	}
	/*
	 * Gets the value of x and y and returns it
	 */
	
	public void setXY (int nx, int ny) {
		x = nx;
		y = ny;
	}
	
	public String toString() {
		return "Drone " + droneId + " at " + x + ", " + y + " travelling " + test.name(); // Outputs all the variables into a string 
	}
	
	public void showDrone (ConsoleCanvas c) {
		c.showIt(x, y, 'D');                       // Outputs the drone position into console canvas
	}
	
	public boolean isHere(int mx, int my) {
		return (x == mx) && (y == my);             // Checks if current drones shares position with different drone
		
	}
	
	public void displayDronePos(ConsoleCanvas c) {
		c.showIt(dx, dy, "D");
	}
	
	public void moveDrone (DroneArena da) {
			int directionX;
			int directionY;
			switch(test.name()) {
			case "North":
				directionX = -1;
				if ((da.canGoHere(x + directionX, y))) {
					x = x +directionX;
				} 
				else {
					test = test.getNextDirection();
				}
					break;
			case "East":
				directionY = 1;
				if ((da.canGoHere(x, y + directionY))) {
					y = y + directionY;
				}
				else {
					test = test.getNextDirection();
				}
				break;
			case "South":
				directionX = 1;
				if((da.canGoHere(x + directionX, y))) {
					x = x + directionX;
				}
				else {
					test = test.getNextDirection();
				}
				break;
			case "West":
				directionY = -1;
				if ((da.canGoHere(x, y + directionY))) {
					y = y+directionY;
				}
				else {
					test = test.getNextDirection();
				}
				break;
			
			}
			/*
			 * Checks which direction the drone moves 
			 */
	}
	

}
