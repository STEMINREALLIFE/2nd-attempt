package frc.robot.subsystems.drive;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Drivetrain subsystem.
 */

public class Drivetrain extends SubsystemBase {
    VictorSP driveTrainMotor1 = new VictorSP(7); // back left motor
    VictorSP driveTrainMotor2 = new VictorSP(6); // front left motor
    VictorSP driveTrainMotor3 = new VictorSP(5); // front right motor
    VictorSP driveTrainMotor4 = new VictorSP(4); // back right motor

    public Drivetrain() {
        driveTrainMotor1.addFollower(driveTrainMotor2);
        driveTrainMotor2.setInverted(true);
        driveTrainMotor3.addFollower(driveTrainMotor4);
    }

    public void setPowerLeft(double power) {
        driveTrainMotor1.set(power);
    }

    public void setPowerRight(double power) {
        driveTrainMotor3.set(power);
    }

    public void drive(double leftspeed, double rightspeed) {
        setPowerLeft(-leftspeed);
        setPowerRight(-rightspeed);
    }

    public Command drivecommand(DoubleSupplier left, DoubleSupplier right) {
        return Commands.run(() -> drive(left.getAsDouble(), right.getAsDouble()), this);

    }

}

