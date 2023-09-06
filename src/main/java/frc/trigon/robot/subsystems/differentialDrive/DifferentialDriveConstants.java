package frc.trigon.robot.subsystems.differentialDrive;

import com.ctre.phoenixpro.configs.TalonFXConfiguration;
import com.ctre.phoenixpro.hardware.TalonFX;
import com.ctre.phoenixpro.signals.InvertedValue;
import com.ctre.phoenixpro.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DifferentialDriveConstants {
    private static final int RIGHT_FRONT_MOTOR_ID = 0;
    private static final int RIGHT_REAR_MOTOR_ID = 1;
    private static final int LEFT_FRONT_MOTOR_ID = 2;
    private static final int LEFT_REAR_MOTOR_ID = 3;
    private static final InvertedValue INVERTED_VALUE = InvertedValue.CounterClockwise_Positive;
    private static final NeutralModeValue NEUTRAL_MODE_VALUE = NeutralModeValue.Coast;
    static final TalonFX RIGHT_FRONT_MOTOR = new TalonFX(RIGHT_FRONT_MOTOR_ID);
    static final TalonFX RIGHT_REAR_MOTOR = new TalonFX(RIGHT_REAR_MOTOR_ID);
    static final TalonFX LEFT_FRONT_MOTOR = new TalonFX(LEFT_FRONT_MOTOR_ID);
    static final TalonFX LEFT_REAR_MOTOR = new TalonFX(LEFT_REAR_MOTOR_ID);
    static final MotorControllerGroup RIGHT_MOTORS = new MotorControllerGroup(RIGHT_FRONT_MOTOR, RIGHT_REAR_MOTOR);
    static final MotorControllerGroup LEFT_MOTORS = new MotorControllerGroup(LEFT_FRONT_MOTOR, LEFT_REAR_MOTOR);
    static final DifferentialDrive DIFFERENTIAL_DRIVE = new DifferentialDrive(RIGHT_MOTORS, LEFT_MOTORS);
    private static final double
            P = 0,
            I = 0,
            D = 0;

    static {
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration();

        talonFXConfiguration.Audio.BeepOnBoot = false;
        talonFXConfiguration.MotorOutput.Inverted = INVERTED_VALUE;
        talonFXConfiguration.MotorOutput.NeutralMode = NEUTRAL_MODE_VALUE;

        RIGHT_FRONT_MOTOR.getConfigurator().apply(talonFXConfiguration);
        RIGHT_REAR_MOTOR.getConfigurator().apply(talonFXConfiguration);
        LEFT_FRONT_MOTOR.getConfigurator().apply(talonFXConfiguration);
        LEFT_REAR_MOTOR.getConfigurator().apply(talonFXConfiguration);
    }
}
