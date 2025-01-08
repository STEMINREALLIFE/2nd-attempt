package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private intakeIo io;
    // private intakeIoAutoLogged inputs = new intakeIoAutoLogged();

    public Intake(intakeIo io) {
        this.io = io;

    }

}


