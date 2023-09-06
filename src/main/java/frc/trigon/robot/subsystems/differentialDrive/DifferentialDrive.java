package frc.trigon.robot.subsystems.differentialDrive;


import com.ctre.phoenixpro.controls.PositionVoltage;
import com.ctre.phoenixpro.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

public class DifferentialDrive extends SubsystemBase {

    private final static DifferentialDrive INSTANCE = new DifferentialDrive();

    private final TalonFX rightFrontMotor = DifferentialDriveConstants.RIGHT_FRONT_MOTOR;
    private final TalonFX rightRearMotor = DifferentialDriveConstants.RIGHT_REAR_MOTOR;
    private final TalonFX leftFrontMotor = DifferentialDriveConstants.LEFT_FRONT_MOTOR;
    private final TalonFX leftRearMotor = DifferentialDriveConstants.LEFT_REAR_MOTOR;

    public static DifferentialDrive getInstance() {
        return INSTANCE;
    }

    private DifferentialDrive() {
    }

    public CommandBase getTankDriveCommand(Supplier <Double> rightStickYSupplier, Supplier <Double> lefStickYSupplier){
        return new FunctionalCommand(
                () ->{},
                () -> tankDrive(rightStickYSupplier.get(), lefStickYSupplier.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    private void tankDrive(double rightStickY, double lefStickY){
        PositionVoltage rightRequest = new PositionVoltage(rightStickY);
        rightFrontMotor.setControl(rightRequest);
        rightRearMotor.setControl(rightRequest);
        PositionVoltage leftRequest = new PositionVoltage(lefStickY);
        leftFrontMotor.setControl(leftRequest);
        leftRearMotor.setControl(leftRequest);
    }

    private void stop(){
        rightFrontMotor.stopMotor();
        rightRearMotor.stopMotor();
        leftFrontMotor.stopMotor();
        leftRearMotor.stopMotor();
    }

}

