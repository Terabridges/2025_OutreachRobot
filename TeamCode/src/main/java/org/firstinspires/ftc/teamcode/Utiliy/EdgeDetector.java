package org.firstinspires.ftc.teamcode.Utiliy;

public class EdgeDetector {
    public boolean isPressed = false;
    public FallingFunc func;
    public boolean isRunning = false;
    public boolean isFallingDetector;

    //Constructor
    public EdgeDetector(FallingFunc f) {
        func = f;
        isFallingDetector = false;
    }

    public EdgeDetector(FallingFunc f, boolean isFalling) {
        func = f;
        isFallingDetector = isFalling;
    }

    public void update(boolean cond) {
        if (cond && !isPressed) { //Rising Edge
            if (!isFallingDetector) {
                func.run();
                isRunning = true;
            }
        } else if (!cond && isPressed) { //Falling edge
            if (isFallingDetector) {
                func.run();
                isRunning = true;
            }
        } else {
           isRunning = false;
        }
            isPressed = cond;
        }

    public void updateOnPress(boolean cond) {
        if(cond) func.run();
    }

    public void reset() {
        isPressed = false;
        isRunning = false;
    }

    @FunctionalInterface
    public interface FallingFunc {
        void run();
    }
}
