package frc.trigon.robot.subsystems.steer;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Steer extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    private final static Steer INSTANCE = new Steer();

    public static Steer getInstance() {
        return INSTANCE;
    }

    p

    private Steer() {
    }
}

