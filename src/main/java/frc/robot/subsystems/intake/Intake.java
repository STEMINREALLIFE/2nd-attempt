package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private IntakeIO io;
    private IntakeIOAutoLogged inputs = new IntakeIOAutoLogged();

    public Intake(IntakeIO io) {
        this.io = io;

    }

}


