package frc.robot.subsystems.Twins;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

public class SparkyReal implements SparkyIO {
    CANSparkMax sparky = new CANSparkMax(57, MotorType.kBrushless);
    TalonFX bird = new TalonFX(51);
    public final RelativeEncoder sparkyEncoder = sparky.getEncoder();
    private final StatusSignal<Double> talonPosition;
    private final StatusSignal<Double> talonVelocity;
    private final StatusSignal<Double> talonVoltage;



    public SparkyReal() {
        talonPosition = bird.getPosition();
        talonVelocity = bird.getVelocity();
        talonVoltage = bird.getSupplyVoltage();



    }
}
