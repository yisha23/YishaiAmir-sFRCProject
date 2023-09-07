package frc.trigon.robot.subsystems.turret;

import com.ctre.phoenixpro.configs.TalonFXConfiguration;
import com.ctre.phoenixpro.hardware.TalonFX;
import com.ctre.phoenixpro.signals.InvertedValue;
import com.ctre.phoenixpro.signals.NeutralModeValue;
import edu.wpi.first.math.controller.PIDController;

public class TurretConstants {
    private static final int MOTOR_ID = 0;
    private static final InvertedValue INVERTED_VALUE = InvertedValue.CounterClockwise_Positive;
    private static final NeutralModeValue NEUTRAL_MODE_VALUE = NeutralModeValue.Coast;
    static final TalonFX MOTOR = new TalonFX(MOTOR_ID);
    private static final double
            P = 0,
            I = 0,
            D = 0;
    static final PIDController PID_CONTROLLER = new PIDController(P, I, D);

    static {
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration();

        talonFXConfiguration.Audio.BeepOnBoot = false;
        talonFXConfiguration.MotorOutput.Inverted = INVERTED_VALUE;
        talonFXConfiguration.MotorOutput.NeutralMode = NEUTRAL_MODE_VALUE;

        MOTOR.getConfigurator().apply(talonFXConfiguration);

        PID_CONTROLLER.setSetpoint(0);
    }
}
