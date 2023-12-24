package GUIVersion;

public class PaddleDrone extends Drone {

	/**
	 * Set up the paddle controlled by the user
	 */
	public PaddleDrone() {
		// TODO Auto-generated constructor stub
	}

	/**Set paddle drone size ir at ix,iy
	 * @param ix
	 * @param iy
	 * @param ir
	 */
	public PaddleDrone(double ix, double iy, double ir) {
		super(ix, iy, ir);
		col = 'b';
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void checkDrone(DroneArena b) {
	}

	@Override
	protected void adjustDrone() {
	}
	/**
	 *  return string description as paddle
	 */
	protected String getStrType() {
		return "Paddle";
	}	
}
