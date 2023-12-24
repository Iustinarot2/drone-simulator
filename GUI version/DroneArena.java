package GUIVersion;

import java.util.ArrayList;

public class DroneArena {	
	double xSize, ySize;						// size of arena
	private ArrayList<Drone> allDrones;			// array list of all drones in arena
	/**
	 * construct an arena
	 */
	DroneArena() {
		this(500, 400);			// default size
	}
	/**
	 * construct arena of size xS by yS
	 * @param xS
	 * @param yS
	 */
	DroneArena(double xS, double yS){
		xSize = xS;
		ySize = yS;
		allDrones = new ArrayList<Drone>();					// list of all drones, initially empty
		allDrones.add(new GameDrone(xS/2, yS/2, 10, 45, 10));	// add game drone
		allDrones.add(new TargetDrone(xS/2, 30, 15));			// add target drone
		allDrones.add(new PaddleDrone(xS/2, yS-20, 20));		// add paddle
		allDrones.add(new Blocker(xS/3, yS/4, 15));		// add blocker
		allDrones.add(new Blocker(2*xS/3, yS/4, 15));	// add blocker
	}
	/**
	 * return arena size in x direction
	 * @return
	 */
	public double getXSize() {
		return xSize;
	}
	/** 
	 * return arena size in y direction
	 * @return
	 */
	public double getYSize() {
		return ySize;
	}
	/**
	 * draw all balls in the arena into interface bi
	 * @param bi
	 */
	public void drawArena(MyCanvas mc) {
		for (Drone d : allDrones) d.drawDrone(mc);		// draw all drones
	}
	/**
	 * check all balls .. see if need to change angle of moving balls, etc 
	 */
	public void checkDrones() {
		for (Drone d : allDrones) d.checkDrone(this);	// check all drones
	}
	/**
	 * adjust all balls .. move any moving ones
	 */
	public void adjustDrones() {
		for (Drone d : allDrones) d.adjustDrone();
	}
	/** 
	 * set the paddle ball at x,y
	 * @param x
	 * @param y
	 */
	public void setPaddle(double x, double y) {
		for (Drone b : allDrones)
			if (b instanceof PaddleDrone) b.setXY(x, y);
	}
	/**
	 * return list of strings defining each ball
	 * @return
	 */
	public ArrayList<String> describeAll() {
		ArrayList<String> ans = new ArrayList<String>();		// set up empty arraylist
		for (Drone b : allDrones) ans.add(b.toString());			// add string defining each drone
		return ans;												// return string list
	}
	/** 
	 * Check angle of ball ... if hitting wall, rebound; if hitting ball, change angle
	 * @param x				ball x position
	 * @param y				y
	 * @param rad			radius
	 * @param ang			current angle
	 * @param notID			identify of ball not to be checked
	 * @return				new angle 
	 */
	public double CheckDroneAngle(double x, double y, double rad, double ang, int notID) {
		double ans = ang;
		if (x < rad || x > xSize - rad) ans = 180 - ans;
			// if drone hit (tried to go through) left or right walls, set mirror angle, being 180-angle
		if (y < rad || y > ySize - rad) ans = - ans;
			// if try to go off top or bottom, set mirror angle
		
		for (Drone d : allDrones) 
			if (d.getID() != notID && d.hitting(x, y, rad)) ans = 180*Math.atan2(y-d.getY(), x-d.getX())/Math.PI;
				// check all drones except one with given id
				// if hitting, return angle between the other drone and this one.
		
		return ans;		// return the angle
	}

	/**
	 * check if the target ball has been hit by another ball
	 * @param target	the target ball
	 * @return 	true if hit
	 */
	public boolean checkHit(Drone target) {
		boolean ans = false;
		for (Drone b : allDrones)
			if (b instanceof GameDrone && b.hitting(target)) ans = true;
				// try all drones, if GameDrone, check if hitting the target
		return ans;
	}
	
	public void addDrone() {
		allDrones.add(new GameDrone(xSize/2, ySize/2, 10, 60, 5));
	}
}
