package frc.trigon.robot.subsystems.differentialDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

public class DifferentialDrive extends SubsystemBase {
    private final static DifferentialDrive INSTANCE = new DifferentialDrive();
    private final edu.wpi.first.wpilibj.drive.DifferentialDrive differentialDrive = DifferentialDriveConstants.DIFFERENTIAL_DRIVE;

    private DifferentialDrive() {
    }

    /**
     * Creates new tank drive command with the given left and right rates.
     *
     * @param rightSpeedSupplier supplies the rates
     * @param leftSpeedSupplier  supplies the rates
     * @param squareInputs if set, decreases the input sensitivity at low speeds
     * @return the command
     */
    public CommandBase getTankDriveCommand(Supplier<Double> rightSpeedSupplier, Supplier<Double> leftSpeedSupplier, boolean squareInputs) {
        return new FunctionalCommand(
                () -> {
                },
                () -> tankDrive(leftSpeedSupplier.get(), rightSpeedSupplier.get(), squareInputs),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    /**
     * Creates new arcade drive with a given speed and turn rate.
     *
     * @param speedSupplier    the robot's speed along the X axis. Forward is positive
     * @param rotationSupplier the robot's rotation rate around the Y axis
     * @param squareInputs if set, decreases the input sensitivity at low speeds
     * @return the command
     */
    public CommandBase getArcadeDriveCommand(Supplier<Double> speedSupplier, Supplier<Double> rotationSupplier, boolean squareInputs) {
        return new FunctionalCommand(
                () -> {
                },
                () -> arcadeDrive(speedSupplier.get(), rotationSupplier.get(), squareInputs),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    /**
     * Creates a new curvature drive command with a given speed and turn rate, as well as a button for turning in-place.
     *
     * @param speedSupplier    the robot's speed along the X axis. Forward is positive
     * @param rotationSupplier the normalized curvature. Counterclockwise is positive
     * @param allowTurnInPlace if set,the robot allows to turn-in-place
     * @return the command
     */
    public CommandBase getCurvatureDriveCommand(Supplier<Double> speedSupplier, Supplier<Double> rotationSupplier, boolean allowTurnInPlace) {
        return new FunctionalCommand(
                () -> {
                },
                () -> curvatureDrive(speedSupplier.get(), rotationSupplier.get(), allowTurnInPlace),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    private void tankDrive(double lefSpeed, double rightSpeed, boolean squareInputs) {
        differentialDrive.tankDrive(lefSpeed, rightSpeed, squareInputs);
    }

    private void arcadeDrive(double speed, double rotation, boolean squareInputs) {
        differentialDrive.arcadeDrive(speed, rotation, squareInputs);
    }

    private void curvatureDrive(double speed, double rotation, boolean allowTurnInPlace) {
        differentialDrive.curvatureDrive(speed, rotation, allowTurnInPlace);
    }

    private void setTargetAngle(double targetAngle, double currentAngle){
        DifferentialDriveConstants.turnController.setSetpoint(targetAngle);
        DifferentialDriveConstants.turnController.setTolerance(DifferentialDriveConstants.toleranceDegrees);
        double rotationSpeed = DifferentialDriveConstants.turnController.calculate(currentAngle);
        differentialDrive.arcadeDrive(0, rotationSpeed);
    }

    private void stop() {
        differentialDrive.stopMotor();
    }

}

