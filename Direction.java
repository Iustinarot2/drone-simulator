package DroneSimulation;

import java.util.Random;

public class Direction {
    static Random randomDir = new Random();

    public enum NESW {North, East, South, West;

        private static final NESW[] val = values();

        public static NESW getRandomDirection() {
            return values()[randomDir.nextInt(values().length)];
        }

        public NESW getNextDirection() {
            return val[(this.ordinal() + 1) % val.length];
        }
    }
}
