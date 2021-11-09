/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI; 
import frc.robot.subsystems.Hoppy;

/**
 * An example command that uses an example subsystem.
 */
public class HopperControl extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Hoppy m_hoppy;
  private OI m_oi; 

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public HopperControl(Hoppy hoppy, OI oi) {
    m_hoppy = hoppy;
    m_oi = oi;
    m_hoppy = hoppy;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_hoppy);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean hopperUp = m_oi.isHopperUp(); 
    boolean hopperDown = m_oi.isHopperDown(); 
    if (!(hopperUp && hopperDown)){
      if (hopperUp){ 
        m_hoppy.flipUp();
      }
      if (hopperDown){
        m_hoppy.flipDown(); 
      }
    } 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
