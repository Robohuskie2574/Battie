/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hoppy extends SubsystemBase {


  public Hoppy() {

  } 

  Spark spark = new Spark(0);

  public void flipUp(){
    spark.set(0.4); 
  }

  public void flipDown(){
    spark.set(-0.4); 
  }
  
  @Override
  public void periodic() {  
  
  }
}