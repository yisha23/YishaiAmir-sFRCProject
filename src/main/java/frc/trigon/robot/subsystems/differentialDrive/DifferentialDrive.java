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
     * Creates new tank drive command with a given left and right rates.
     * @param rightStickYSupplier supplies the rates of the right stick
     * @param lefStickYSupplier supplies the rates of the left stick
     * @return the command
     */
    public CommandBase getTankDriveCommand(Supplier<Double> rightStickYSupplier, Supplier<Double> lefStickYSupplier) {
        return new FunctionalCommand(
                () -> {
                },
                () -> arcadeDrive(rightStickYSupplier.get(), lefStickYSupplier.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    /**
     * Creates new arcade drive with a given forward and turn rate.
     * @param driveStickXSupplier The robot's speed along the X axis. Forward is positive
     * @param driveStickYSupplier The robot's rotation rate around the Y axis
     * @return the command
     */
    public CommandBase getArcadeDriveCommand(Supplier<Double> driveStickXSupplier, Supplier<Double> driveStickYSupplier) {
        return new FunctionalCommand(
                () -> {
                },
                () -> tankDrive(driveStickXSupplier.get(), driveStickYSupplier.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    /**
     * Creates a new curvature drive command with a given forward and turn rate, as well as a button for turning in-place.
     * @param driveStickXSupplier The robot's speed along the X axis. Forward is positive
     * @param driveStickYSupplier The normalized curvature. Counterclockwise is positive
     * @param allowTurnInPlaceSupplier  If set,the robot allows to turn-in-place
     * @return the command
     */
    public CommandBase getCurvatureDriveCommand(Supplier<Double> driveStickXSupplier, Supplier<Double> driveStickYSupplier, Supplier<Boolean> allowTurnInPlaceSupplier) {
        return new FunctionalCommand(
                () -> {
                },
                () -> CurvatureDrive(driveStickXSupplier.get(), driveStickYSupplier.get(), allowTurnInPlaceSupplier.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    private void tankDrive(double rightStickY, double lefStickY) {
        differentialDrive.tankDrive(rightStickY, lefStickY);
    }

    private void arcadeDrive(double driveStickX, double driveStickY) {
        differentialDrive.arcadeDrive(driveStickX, driveStickY);
    }

    private void CurvatureDrive(double driveStickX, double driveStickY, boolean allowTurnInPlace){
        differentialDrive.curvatureDrive(driveStickX, driveStickY ,allowTurnInPlace);
    }

    private void stop() {
        differentialDrive.stopMotor();
    }

}

