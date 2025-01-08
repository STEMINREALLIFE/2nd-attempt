package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Robot.RobotRunType;
import frc.robot.subsystems.LEDs;
import frc.robot.subsystems.Twins.Sparky;
import frc.robot.subsystems.Twins.SparkyIO;
import frc.robot.subsystems.Twins.SparkyReal;
import frc.robot.subsystems.drive.Drivetrain;
import frc.robot.subsystems.intake.Intake;
// import frc.robot.subsystems.intake.IntakeVictorSP;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    private final CommandXboxController driver = new CommandXboxController(Constants.driverID);


    // Initialize AutoChooser Sendable
    private final SendableChooser<String> autoChooser = new SendableChooser<>();

    /* Subsystems */
    private Intake intake;
    LEDs leds = new LEDs(9, 60);
    Drivetrain drive = new Drivetrain();
    private Sparky sparky;



    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer(RobotRunType runtimeType) {
        switch (runtimeType) {
            case kReal:
                sparky = new Sparky(new SparkyReal());
                // intake = new Intake(new IntakeVictorSP() {});
                break;
            default:
                sparky = new Sparky(new SparkyIO() {});
                // intake = new Intake(new IntakeIo() {});
                break;
        }

        leds.setDefaultCommand(leds.setAllianceColor().ignoringDisable(true));
        drive.setDefaultCommand(
            drive.drivecommand(() -> driver.getLeftY(), () -> driver.getRightY()));
        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        // driver.x().whileTrue(Intake.IntakeCommand().alongWith(leds.setIntakeColor()));
        // driver.b().whileTrue(Intake.outakeCommand());
        driver.y().whileTrue(sparky.sparkycmd(1));


    }


    /**
     * Gets the user's selected autonomous command.
     *
     * @return Returns autonomous command selected.
     */
    public Command getAutonomousCommand() {
        Command autocommand;
        String stuff = autoChooser.getSelected();
        switch (stuff) {
            case "wait":
                autocommand = new WaitCommand(1.0);
                break;
            default:
                autocommand = new InstantCommand();
        }
        return autocommand;
    }
}
