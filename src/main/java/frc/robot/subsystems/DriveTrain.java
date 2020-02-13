/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup; 
import edu.wpi.first.wpilibj.drive.DifferentialDrive; 
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; 

public class DriveTrain extends SubsystemBase {
  public DriveTrain() {

    front_left.setInverted(true);
    back_left.setInverted(true); 
    front_right.setInverted(true); 
    back_right.setInverted(true); 
  }

  WPI_TalonSRX front_left = new WPI_TalonSRX(2); 
  WPI_TalonSRX front_right = new WPI_TalonSRX(1); 

  WPI_TalonSRX back_left   = new WPI_TalonSRX(3);
  WPI_TalonSRX back_right  = new WPI_TalonSRX(4);
  SpeedControllerGroup right = new SpeedControllerGroup(front_right, back_right);
  SpeedControllerGroup left = new SpeedControllerGroup(front_left, back_left);      
  // SpeedControllerGroup is a way of grouping together microcontrollers. These groups can be told to run as a group of operations

  DifferentialDrive diffDrive = new DifferentialDrive(left, right);
  // DifferentialDrive is a type of driving option

  public void drive(double x_axis, double y_axis) {
    diffDrive.arcadeDrive(x_axis, y_axis);
  } 

  @Override
  public void periodic() {  
    
  }
}