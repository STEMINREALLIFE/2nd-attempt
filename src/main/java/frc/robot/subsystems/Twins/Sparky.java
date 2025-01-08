package frc.robot.subsystems.Twins;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sparky extends SubsystemBase {

    private SparkyIO io;
    private sparkyIOInputsAutoLogged inputs = new sparkyIOInputsAutoLogged();

    public Sparky(SparkyIO io) {
        this.io = io;

    }

    @Override
    public void periodic() {
        Logger.processInputs("sparky", inputs);

    }

    public void setPower(double power) {
        Logger.recordOutput("sparky", power);
        io.setPower(power);

    }

    public Command sparkycmd(double power) {
        return startEnd(() -> {
            setPower(power);
        }, () -> {
            setPower(0);
        });// yay


    }



}
