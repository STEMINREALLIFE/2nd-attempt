package frc.robot.subsystems;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    VictorSP intakeMotor1 = new VictorSP(1);
    VictorSP intakeMotor2 = new VictorSP(2);
    TalonFX bird = new TalonFX(51);// bird
    CANSparkMax sparky = new CANSparkMax(57, MotorType.kBrushless);
    StatusSignal<Double> birdStatus = bird.getRotorPosition();// status signal
    // Double birdMotorPos = birdStatus.getValue();

    DigitalInput beambreak = new DigitalInput(9);



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

    public void setBirdPower(double power) {
        bird.set(power); // bird
    }

    public void setSparkPower(double power) {
        sparky.set(power); // spark
    }

    public void birdGo() {
        setBirdPower(0.7);// bird
    }

    public void sparkGo() {
        setSparkPower(0.7);// spark

    }

    public void intake() {
        setPower(-0.7);

    }

    public void outake() {
        setPower(0.7);
    }

    public void stop() {
        setPower(0); // I know I could have made one stop function but I made 3 deal with it.
    }

    public void stop2() {
        setBirdPower(0);// bird
    }

    public void stop3() {
        setSparkPower(0);// spark
    }

    public void bridValue() {
        birdStatus.refresh();
        birdStatus.getValueAsDouble(); // WORK ON THIS!!!!
    }


    public Command intakeCommand() {

        return Commands.runEnd(() -> intake(), () -> stop(), this).until(() -> beambreak.get());
    }

    public Command outakeCommand() {
        return Commands.runEnd(() -> outake(), () -> stop(), this);
    }

    public Command birdy() {
        return Commands.runEnd(() -> birdGo(), () -> stop2(), this);// bird
    }

    public Command sparky() {
        return Commands.runEnd(() -> sparkGo(), () -> stop3(), this);// spark
    }

    public Command print() {
        return Commands.print("asbqeb");
    }

    public Command returnBirdyValue() {
        return Commands.run(() -> bridValue(), this);// WORK ON THIS!!!!
    }

    @Override
    public void periodic() {
        birdStatus.refresh();
        SmartDashboard.putBoolean("beamBreak", beambreak.get());
        SmartDashboard.putNumber("birdMotorPos", birdStatus.getValueAsDouble());// working

    }

}
