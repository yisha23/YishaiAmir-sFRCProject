package frc.trigon.robot.subsystems.colector;


import com.ctre.phoenixpro.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Collector extends SubsystemBase {
    private static final Collector INSTANCE = new Collector();
    private final TalonFX motor = CollectorConstants.MOTOR;

    public static Collector getInstance() {
        return INSTANCE;
    }

    private Collector() {
    }

    /**
     *
     * @return a command that collects
     */

    public CommandBase getCollectCommand() {
        return startEnd(
                this::collect,
                this::stop
        );
    }

    /**
     *
     * @return a command that ejects
     */

    public CommandBase getEjectCommand() {
        return startEnd(
                this::eject,
                this::stop
        );
    }

    /**
     *
     * @return a command that collects and the ejects
     */

    public SequentialCommandGroup getCollectThenEjectCommand() {
        return new SequentialCommandGroup(
                getCollectCommand(),
                getEjectCommand()
        );
    }

    private void collect() {
        motor.setVoltage(CollectorConstants.COLLECT_VOLTAGE);
    }

    private void eject() {
        motor.setVoltage(CollectorConstants.EJECT_VOLTAGE);
    }

    private void stop() {
        motor.stopMotor();
    }
}

