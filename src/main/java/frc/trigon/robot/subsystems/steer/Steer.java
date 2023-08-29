package frc.trigon.robot.subsystems.steer;


import com.ctre.phoenixpro.controls.PositionVoltage;
import com.ctre.phoenixpro.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.*;

import java.util.function.Supplier;

public class Steer extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    private final static Steer INSTANCE = new Steer();

    public static Steer getInstance() {
        return INSTANCE;
    }

    private final TalonFX motor = SteerConstants.MOTOR;

    private Steer() {
    }

    public CommandBase getSetTargetAngle(Supplier <Double> angleSupplier){
        return new FunctionalCommand(
                () ->{},
                () -> setTargetAngle(angleSupplier.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    public CommandBase getSetTargetAngleCommand(double targetAngle){
        return startEnd(
                () -> setTargetAngle(targetAngle),
                this::stop
        );
    }

    public CommandBase getAngleSequenceCommand(){
        return new SequentialCommandGroup(
                getSetTargetAngleCommand(90).withTimeout(3),
                getSetTargetAngleCommand(180).withTimeout(3),
                getSetTargetAngleCommand(0)
        );
    }

    private void setTargetAngle(double angleDegrees){
        double systemRevolutions = angleDegrees / 360;
        double motorRevolutions = systemRevolutions * SteerConstants.GEAR_RATIO;
        PositionVoltage request = new PositionVoltage(motorRevolutions);
        motor.setControl(request);
    }

    private void stop(){
        motor.stopMotor();
    }
}

