package GUIVersion;

public class TargetDrone extends Drone {
	private int score;
	/**
	 * 
	 */
	public TargetDrone() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ix
	 * @param iy
	 * @param ir
	 */
	public TargetDrone(double ix, double iy, double ir) {
		super(ix, iy, ir);
		score = 0;
		col = 'g';
	}

	/** 
	 * checkdrone in arena 
	 * @param b droneArena
	 */
	@Override
	protected void checkDrone(DroneArena d) {
		if (d.checkHit(this)) score++;			// if been hit, then increase score
	}
	/**
	 * draw drone and display score
	 */
	public void drawdrone(MyCanvas mc) {
		super.drawDrone(mc);
		mc.showInt(x, y, score);
	}

	/**
	 * adjustdrone
	 * for moving the drone - not needed here
	 */
	@Override
	protected void adjustDrone() {
				// nothing to do at the moment...
	}
	/**
	 * return string defining drone ... here as target
	 */
	protected String getStrType() {
		return "Target";
	}	
}
