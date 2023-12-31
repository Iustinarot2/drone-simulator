package GUIVersion;

public class GameDrone extends Drone {

	double bAngle, bSpeed;			// angle and speed of travel
	/**
	 * 
	 */
	public GameDrone() {
		// TODO Auto-generated constructor stub
	}

	/** Create game drone, size ir ay ix,iy, moving at angle ia and speed is
	 * @param ix
	 * @param iy
	 * @param ir
	 * @param ia
	 * @param is
	 */
	public GameDrone(double ix, double iy, double ir, double ia, double is) {
		super(ix, iy, ir);
		bAngle = ia;
		bSpeed = is;
	}

	/**
	 * checkdrone - change angle of travel if hitting wall or another drone
	 * @param b   droneArena
	 */
	@Override
	protected void checkDrone(DroneArena d) {
		bAngle = d.CheckDroneAngle(x, y, rad, bAngle, droneID);
	}

	/**
	 * adjustdrone
	 * Here, move drone depending on speed and angle
	 */
	@Override
	protected void adjustDrone() {
		double radAngle = bAngle*Math.PI/180;		// put angle in radians
		x += bSpeed * Math.cos(radAngle);		// new X position
		y += bSpeed * Math.sin(radAngle);		// new Y position
	}
	/**
	 * return string defining drone type
	 */
	protected String getStrType() {
		return "Game drone";
	}

}
