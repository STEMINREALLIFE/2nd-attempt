package frc.robot.subsystems.Twins;

import org.littletonrobotics.junction.AutoLog;

public interface SparkyIO {
    @AutoLog
    public static class sparkyIOInputs {
        public double intakeVelocityRotPerSecond;
    }

    public default void setPower(double power) {

    }

    public default void updateInputs(sparkyIOInputs inputs) {

    }


}
