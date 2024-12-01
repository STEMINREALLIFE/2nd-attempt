package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.Intake;

public class OutakeCommand extends Command {
    Intake intake;

    public OutakeCommand(Intake intake) {
        this.intake = intake;

    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        intake.outake(); // calls Intake.java to intake the block
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop(); // calls Intake.java to stop the motors
    }

    @Override
    public boolean isFinished() {
        return false;

    }
}
