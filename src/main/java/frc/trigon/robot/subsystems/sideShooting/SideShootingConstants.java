package frc.trigon.robot.subsystems.sideShooting;

import com.ctre.phoenixpro.configs.TalonFXConfiguration;
import com.ctre.phoenixpro.hardware.TalonFX;
import com.ctre.phoenixpro.signals.InvertedValue;
import com.ctre.phoenixpro.signals.NeutralModeValue;

public class SideShootingConstants {
    private static final int
            ANGLE_MOTOR_ID = 0,
            SHOOTING_MOTOR_ID = 0;
    private static final InvertedValue INVERTED_VALUE = InvertedValue.CounterClockwise_Positive;
    private static final NeutralModeValue NEUTRAL_MODE_VALUE = NeutralModeValue.Coast;
    static final TalonFX
            ANGLE_MOTOR = new TalonFX(ANGLE_MOTOR_ID),
            SHOOTING_MOTOR = new TalonFX(SHOOTING_MOTOR_ID);

    private static final int
            ANGLE_P = 0,
            ANGLE_I = 0,
            ANGLE_D = 0;

    private static final double ANGLE_MOTOR_OFFSET = 0;

    static {
        TalonFXConfiguration angleMotorConfiguration = new TalonFXConfiguration();

        angleMotorConfiguration.Audio.BeepOnBoot = true;
        angleMotorConfiguration.MotorOutput.Inverted = INVERTED_VALUE;
        angleMotorConfiguration.MotorOutput.NeutralMode = NEUTRAL_MODE_VALUE;
        angleMotorConfiguration.Slot0.kP = ANGLE_P;
        angleMotorConfiguration.Slot0.kI = ANGLE_I;
        angleMotorConfiguration.Slot0.kD = ANGLE_D;

        angleMotorConfiguration.Feedback.FeedbackRotorOffset = ANGLE_MOTOR_OFFSET;

        ANGLE_MOTOR.getConfigurator().apply(angleMotorConfiguration);

        TalonFXConfiguration shootingMotorConfiguration = new TalonFXConfiguration();

        shootingMotorConfiguration.Audio.BeepOnBoot = true;
        shootingMotorConfiguration.MotorOutput.Inverted = INVERTED_VALUE;
        shootingMotorConfiguration.MotorOutput.NeutralMode = NEUTRAL_MODE_VALUE;

        SHOOTING_MOTOR.getConfigurator().apply(shootingMotorConfiguration);
    }

    public enum SideShooterState {
        COLLECT(0, 0),
        HIGH_CUBE(0, 0),
        MIDDLE_CUBE(0, 0);

        final double voltage, angle;

        SideShooterState(double voltage, double angle) {
            this.voltage = voltage;
            this.angle = angle;
        }
    }
}
