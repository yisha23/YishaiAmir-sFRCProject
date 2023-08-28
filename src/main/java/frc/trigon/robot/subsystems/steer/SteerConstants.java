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

    public static final double GEAR_RATIO =

    static {
        TalonFXConfiguration config = new TalonFXConfiguration();

        config.Audio.BeepOnBoot = false;
        config.MotorOutput.Inverted = INVERTED_VALUE;
        config.MotorOutput.NeutralMode = NEUTRAL_MODE_VALUE;
        config.Slot0.kP = P;
        config.Slot0.kI = I;
        config.Slot0.kD = D;
    }
}
