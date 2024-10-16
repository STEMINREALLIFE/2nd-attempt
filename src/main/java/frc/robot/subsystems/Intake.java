package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    VictorSP intakeMotor1 = new VictorSP(1);
    VictorSP intakeMotor2 = new VictorSP(2);


    DigitalInput beambreak = new DigitalInput(9);

    // I NEED TO MAKE A LEFT MOTOR????


    public Intake() {
        intakeMotor2.setInverted(true);
        intakeMotor1.setInverted(true);
        intakeMotor1.addFollower(intakeMotor2); // motor 2 does what motor 1 does
        // so motor spins other way
        // right == motor 1
        // left == motor 2

    }

    public void setPower(double power) {
        intakeMotor1.set(power);
    }

    public void intake() {
        setPower(-0.7);

    }

    public void outake() {
        setPower(0.7);
    }

    public void stop() {
        setPower(0);
    }

    public Command intakeCommand() {
        return Commands.runEnd(() -> intake(), () -> stop(), this).until(() -> beambreak.get());
    }

    public Command outakeCommand() {
        return Commands.runEnd(() -> outake(), () -> stop(), this);
    }

    public Command print() {
        return Commands.print("asbqeb");
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("beamBreak", beambreak.get());
    }

}
