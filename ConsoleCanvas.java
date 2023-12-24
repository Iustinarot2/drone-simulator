 package DroneSimulation;

public class ConsoleCanvas {
    String[][] arena;

    public ConsoleCanvas(int x, int y) {
        arena = new String[x][y];
        for (int ct = 0; ct < x; ct++) {
            for (int ct1 = 0; ct1 < y; ct1++) {
                arena[ct][ct1] = "#";
            }

        }
        /*
         * Uses the x and y of the arena to output # at the borders 
         */
      
        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {
                arena[i][j] = " ";
            }

        }
        
        /*
         * Fills the inside with empty spaces 
         */
        
    }

    public static void main(String[] args) {
        ConsoleCanvas c = new ConsoleCanvas(20, 20);       // create a canvas
        c.showIt(10, 6, "D");                              // add a Drone at 10,6 as the letter D
        System.out.println(c.toString());                  // display result
    }

    public void showIt(int xPos, int yPos, String z) {
        arena[xPos][yPos] = z;
    }

    public String toString() {
        StringBuilder info = new StringBuilder();
        for (String[] x : arena) {
            for (String y : x) {
                info.append(y).append(" ");
            }
            info.append("\n");
        }
        return info.toString();
    }

	public void showIt(int x, int y, char c) {
		// TODO Auto-generated method stub
		
	}

}
