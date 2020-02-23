/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber)


  public OI(){
  
  }

  Joystick stick1 = new Joystick(0); // creates a Joystick with the ID of 0 
  Joystick stick2 = new Joystick(1); 
  
  double buffer = 0.2, speed = 0.8; // buffer is minimum threshold to return information, speed is the multiplier
  public double get_y(){
      if (Math.abs(stick1.getY()) > buffer){
        return stick1.getY() * speed; // negates the x-setting, for orientation
      } else {
        return 0;
      }
  }

  public double get_twist(){
    if (Math.abs(stick1.getTwist()) > buffer){
      if (stick1.getTwist() < 0){
        return (stick1.getTwist() * stick1.getTwist()); 
      }
      else {
        return -(stick1.getTwist() * stick1.getTwist()); 
      } 
    } else {
        return 0; 
    }
  }

  JoystickButton hopperDownButton = new JoystickButton(stick2, 3); 
  public boolean isHopperDown(){
    return hopperDownButton.get(); 
  }

  JoystickButton hopperUpButton = new JoystickButton(stick2, 5); 
  public boolean isHopperUp(){
    return hopperUpButton.get(); 
  }

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
