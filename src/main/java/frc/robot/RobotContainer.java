/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj2.command.button.JoystickButton; 
import frc.robot.commands.HopperControl;
import frc.robot.commands.TeleOp; 
import frc.robot.commands.IntakeControlUp;
import frc.robot.commands.IntakeControlDown; 
import frc.robot.commands.IntakeControlStop;
import frc.robot.commands.ClimberControlDown;
import frc.robot.commands.ClimberControlUp; 
import frc.robot.commands.ClimberControlStop;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hoppy;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Climber; 
 
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Hoppy m_hoppy = new Hoppy(); 
  private final Intake m_intake = new Intake(); 
  private final Climber m_climber = new Climber(); 
  
  public final OI m_oi = new OI(); 

 // private final ExampleCommand m_autoCommand = new ExampleCommand(m_driveTrain);

  private final TeleOp m_teleOp = new TeleOp(m_driveTrain, m_oi);
  private final HopperControl m_hopperControl = new HopperControl(m_hoppy, m_oi); 
  private final IntakeControlStop m_intakeControlStop = new IntakeControlStop(m_intake); 
  private final ClimberControlStop m_climberControlStop = new ClimberControlStop(m_climber); 
  //private final IntakeControlStop m_intakeControlStop = new IntakeControlStop(m_intake); 

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_driveTrain.setDefaultCommand(m_teleOp);
    m_hoppy.setDefaultCommand(m_hopperControl);
    m_intake.setDefaultCommand(m_intakeControlStop);
    m_climber.setDefaultCommand(m_climberControlStop);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Joystick stick2 = new Joystick(1); 
    new JoystickButton(stick2, 1).whileHeld(new IntakeControlUp(m_intake));
    new JoystickButton(stick2, 2).whileHeld(new IntakeControlDown(m_intake)); 
    
    new JoystickButton(stick2, 9).whileHeld(new ClimberControlUp(m_climber)); 
    new JoystickButton(stick2, 11).whileHeld(new ClimberControlDown(m_climber)); 
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_teleOp; 
  } */
}
