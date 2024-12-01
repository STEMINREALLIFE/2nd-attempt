package frc.robot.subsystems.Twins;

import org.littletonrobotics.junction.AutoLog;

public interface SparkyIO {
    @AutoLog
    public static class SparkyInputs {
        public double intakeVelocityRotPerSecond;
    }

    public default void setMotorVoltage(double voltage) {

    }

    public default void setMotorPercentage(double percent) {

    }

    public default void updateInputs(SparkyInputs inputs) {

    }


}
