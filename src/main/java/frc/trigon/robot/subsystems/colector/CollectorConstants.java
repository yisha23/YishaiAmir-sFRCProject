package frc.trigon.robot.subsystems.colector;

import com.ctre.phoenixpro.configs.TalonFXConfiguration;
import com.ctre.phoenixpro.hardware.TalonFX;
import com.ctre.phoenixpro.signals.InvertedValue;
import com.ctre.phoenixpro.signals.NeutralModeValue;

public class CollectorConstants {
    private static final int MOTOR_ID = 0;
    private static final InvertedValue INVERTED_VALUE = InvertedValue.CounterClockwise_Positive;
    private static final NeutralModeValue NEUTRAL_MODE_VALUE = NeutralModeValue.Coast;
    static final TalonFX MOTOR = new TalonFX(MOTOR_ID);

    static final double
            COLLECT_VOLTAGE = 6,
            EJECT_VOLTAGE = -6;

    static {
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration();

        talonFXConfiguration.Audio.BeepOnBoot = false;
        talonFXConfiguration.MotorOutput.Inverted = INVERTED_VALUE;
        talonFXConfiguration.MotorOutput.NeutralMode = NEUTRAL_MODE_VALUE;

        MOTOR.getConfigurator().apply(talonFXConfiguration);
    }
}
