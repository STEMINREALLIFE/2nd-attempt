package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.AutoLog;

public interface intakeIo {
    @AutoLog
    public static class IntakeInputs {
        public double intakeVelocityRotPerSecond;
    }

    public default void setMotorVoltage(double voltage) {

    }

    public default void setMotorPercentage(double percent) {

    }

    public default void updateInputs(IntakeInputs inputs) {

    }


}
