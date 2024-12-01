package frc.robot.subsystems.intake;


import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

// direct

public class IntakeReal implements intakeIo {
    private final VictorSP leftIntake = new VictorSP(1);
    private final VictorSP rightIntake = new VictorSP(2);
    // public final RelativeEncoder encoder = leftIntake



    public IntakeReal() {
        leftIntake.setInverted(true);
        leftIntake.addFollower(rightIntake); // motor 2 does what motor 1 does
        // so motor spins other way
        // right == mot
    }

    public void updateInputs() {}

    public void setMotorVoltage(double power) {
        leftIntake.set(power);
    }
}


