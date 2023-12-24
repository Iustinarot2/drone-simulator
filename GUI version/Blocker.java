package GUIVersion;

public class Blocker extends Drone {

	/**
	 * 
	 */
	public Blocker() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ix
	 * @param iy
	 * @param ir
	 */
	public Blocker(double ix, double iy, double ir) {
		super(ix, iy, ir);
		col = 'o';
	}

	
	@Override
	protected void checkDrone(DroneArena b) {

	}

	@Override
	protected void adjustDrone() {

	}
	protected String getStrType() {
		return "Blocker";
	}	

}
