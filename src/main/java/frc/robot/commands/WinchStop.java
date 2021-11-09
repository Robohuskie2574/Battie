package frc.robot.commands; 

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Winch;

public class WinchStop extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private Winch m_winch;
  
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public WinchStop(Winch winch) {
      m_winch = winch;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(m_winch);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      m_winch.stop(); 
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