/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Winch extends SubsystemBase {

  public Winch() {

  } 
  Spark winchMotor = new Spark(1);

  public void in(){
    System.out.println("case up");
    winchMotor.set(0.80); 
  }

  public void out(){
    System.out.println("case down"); 
    winchMotor.set(-0.40); 
  }

  public void stop(){
    winchMotor.set(0); 
  }
  
  @Override
  public void periodic() {  
     
  }
}