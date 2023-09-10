package frc.trigon.robot.subsystems.turret;


import com.ctre.phoenixpro.controls.PositionVoltage;
import com.ctre.phoenixpro.hardware.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

public class Turret extends SubsystemBase {
    private final static Turret INSTANCE = new Turret();
    private final TalonFX motor = TurretConstants.MOTOR;
    private final PIDController pidController = TurretConstants.PID_CONTROLLER;

    public static Turret getInstance() {
        return INSTANCE;
    }

    private Turret() {
    }

    /**
     * Creates a new command that aligns the turret to the reflector.
     *
     * @param reflectorPosition supplies the pixels of the reflector on the screen
     * @param hasTarget         supplies if the limelight sees the reflector
     * @return the command
     */
    public CommandBase getAlignToReflectorCommand(Supplier<Double> reflectorPosition, Supplier<Boolean> hasTarget) {
        return new FunctionalCommand(
                () -> {
                },
                () -> alignToReflector(hasTarget.get(), reflectorPosition.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    private void alignToReflector(boolean hasTarget, double reflectorPosition) {
        if (!hasTarget) {
            PositionVoltage request = new PositionVoltage(5);
            motor.setControl(request);
            return;
        }
        double output = pidController.calculate(reflectorPosition);
        PositionVoltage request = new PositionVoltage(output);
        motor.setControl(request);
    }

    private void stop() {
        motor.stopMotor();
    }
}

