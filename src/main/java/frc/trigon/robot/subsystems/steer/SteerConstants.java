package frc.trigon.robot.subsystems.steer;

import com.ctre.phoenixpro.configs.TalonFXConfiguration;
import com.ctre.phoenixpro.hardware.TalonFX;
import com.ctre.phoenixpro.signals.InvertedValue;
import com.ctre.phoenixpro.signals.NeutralModeValue;

public class SteerConstants {
    private static final int MOTOR_ID = 0;
    private static final InvertedValue INVERTED_VALUE = InvertedValue.CounterClockwise_Positive;
    private static final NeutralModeValue NEUTRAL_MODE_VALUE = NeutralModeValue.Coast;
    static final TalonFX MOTOR = new TalonFX(MOTOR_ID);
    private static final double
            P = 8.4,
            I = 0,
            D = 0;

    public static final double GEAR_RATIO = 12.8;

    static {
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration();

        talonFXConfiguration.Audio.BeepOnBoot = false;
        talonFXConfiguration.MotorOutput.Inverted = INVERTED_VALUE;
        talonFXConfiguration.MotorOutput.NeutralMode = NEUTRAL_MODE_VALUE;
        talonFXConfiguration.Slot0.kP = P;
        talonFXConfiguration.Slot0.kI = I;
        talonFXConfiguration.Slot0.kD = D;

        MOTOR.getConfigurator().apply(talonFXConfiguration);
    }
}
