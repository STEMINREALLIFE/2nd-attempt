package frc.robot.subsystems.Twins;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Voltage;

public class SparkyReal implements SparkyIO {
    SparkMax sparky = new SparkMax(57, MotorType.kBrushless);
    TalonFX bird = new TalonFX(51);
    public final RelativeEncoder sparkyEncoder = sparky.getEncoder();
    private final StatusSignal<Angle> talonPosition;
    private final StatusSignal<AngularVelocity> talonVelocity;
    private final StatusSignal<Voltage> talonVoltage;



    public SparkyReal() {
        talonPosition = bird.getPosition();
        talonVelocity = bird.getVelocity();
        talonVoltage = bird.getSupplyVoltage();



    }

    public void setPower(double powerL) {
        sparky.set(powerL);


    }
}
