package frc.trigon.robot.subsystems.steer;


import com.ctre.phoenixpro.controls.PositionVoltage;
import com.ctre.phoenixpro.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

public class Steer extends SubsystemBase {
    private final static Steer INSTANCE = new Steer();

    public static Steer getInstance() {
        return INSTANCE;
    }

    private final TalonFX motor = SteerConstants.MOTOR;

    private Steer() {
    }

    /**
     * Create a command that sets the target angle from the given supplier.
     * @param angleSupplier supplies the target angle
     * @return the command
     */

    public CommandBase getSetTargetAngleCommand(Supplier<Double> angleSupplier) {
        return new FunctionalCommand(
                () -> {},
                () -> setTargetAngle(angleSupplier.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    /**
     * Create a command that sets the target angle.
     * @param targetAngle target angle
     * @return the command
     */

    public CommandBase getSetTargetAngleCommand(double targetAngle) {
        return startEnd(
                () -> setTargetAngle(targetAngle),
                this::stop
        );
    }

    /**
     * @return a command that turns to angle 90, waits 3 seconds, then turns to angle 180, waits 3 seconds, turns to angle 0
     */

    public CommandBase getAngleSequenceCommand() {
        return new SequentialCommandGroup(
                getSetTargetAngleCommand(90).withTimeout(3),
                getSetTargetAngleCommand(180).withTimeout(3),
                getSetTargetAngleCommand(0)
        );
    }

    private void setTargetAngle(double angleDegrees) {
        double systemRevolutions = angleDegrees / 360;
        double motorRevolutions = systemRevolutions * SteerConstants.GEAR_RATIO;
        PositionVoltage request = new PositionVoltage(motorRevolutions);
        motor.setControl(request);
    }

    private void stop() {
        motor.stopMotor();
    }
}

