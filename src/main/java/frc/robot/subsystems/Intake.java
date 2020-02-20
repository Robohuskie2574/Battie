/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  public Intake() {

  } 

  Spark innerSpark = new Spark(1);
  Spark outerSpark = new Spark(3); 

  public void intakeUp(){
    innerSpark.set(0.5);
    outerSpark.set(0.6); 
  }

  public void intakeDown(){
    innerSpark.set(-0.5);
    outerSpark.set(-0.6); 
  }

  public void intakeStop(){
    innerSpark.set(0);
    outerSpark.set(0); 
  }
  
  @Override
  public void periodic() {  
    
  }
}