package frc.trigon.robot.subsystems.differentialDrive;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenixpro.hardware.Pigeon2;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import java.util.List;

public class DifferentialDriveConstants {
    private static final int
            RIGHT_FRONT_MOTOR_ID = 0,
            RIGHT_REAR_MOTOR_ID = 1,
            LEFT_FRONT_MOTOR_ID = 2,
            LEFT_REAR_MOTOR_ID = 3;
    private static final boolean INVERTED_VALUE = false;
    private static final NeutralMode NEUTRAL_MODE_VALUE = NeutralMode.Coast;
    private static final WPI_TalonSRX
            RIGHT_FRONT_MOTOR = new WPI_TalonSRX(RIGHT_FRONT_MOTOR_ID),
            RIGHT_REAR_MOTOR = new WPI_TalonSRX(RIGHT_REAR_MOTOR_ID),
            LEFT_FRONT_MOTOR = new WPI_TalonSRX(LEFT_FRONT_MOTOR_ID),
            LEFT_REAR_MOTOR = new WPI_TalonSRX(LEFT_REAR_MOTOR_ID);
    private static final MotorControllerGroup
            RIGHT_MOTORS = new MotorControllerGroup(RIGHT_FRONT_MOTOR, RIGHT_REAR_MOTOR),
            LEFT_MOTORS = new MotorControllerGroup(LEFT_FRONT_MOTOR, LEFT_REAR_MOTOR);
    static final DifferentialDrive DIFFERENTIAL_DRIVE = new DifferentialDrive(RIGHT_MOTORS, LEFT_MOTORS);
    static final Pigeon2 PIGEON = new Pigeon2(0);

    private static final int
            P = 0,
            I = 0,
            D = 0;

    static final PIDController TURN_CONTROLLER_PID = new PIDController(P, I, D);
    static final double TOLERANCE_DEGREES = 0.5;

    static {
        for (WPI_TalonSRX currentMotor : List.of(RIGHT_FRONT_MOTOR, RIGHT_REAR_MOTOR, LEFT_FRONT_MOTOR, LEFT_REAR_MOTOR)) {
            currentMotor.setInverted(INVERTED_VALUE);
            currentMotor.setNeutralMode(NEUTRAL_MODE_VALUE);
        }
        TURN_CONTROLLER_PID.setTolerance(TOLERANCE_DEGREES);
    }
}
