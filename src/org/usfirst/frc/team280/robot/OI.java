/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team280.robot;

import org.usfirst.frc.team280.robot.commands.*;
import org.usfirst.frc.team280.robot.subsystems.Wrist;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
	// Button button = new JoystickButton(stick, buttonNumber);

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
	
	public Joystick winchJoystick = new Joystick(3);
	public Joystick armJoystick = new Joystick(2);
	public Joystick rightStick = new Joystick(1);
	public Joystick leftStick = new Joystick(0);
	
	public Button WristUp =  new JoystickButton(armJoystick,8);
	public Button WristDown = new JoystickButton(armJoystick,9);
	
	//switched buttons 7 & 4
	public Button GripOpen = new JoystickButton(armJoystick,7);
	public Button GripClose = new JoystickButton(armJoystick,4);
	public Button GripIn = new JoystickButton(armJoystick,5);
	public Button GripOut = new JoystickButton(armJoystick,6);

	//climber buttons 
	public Button ClimberDown = new JoystickButton(winchJoystick,1);
	public Button ClimberUp = new JoystickButton(winchJoystick,2);
	
	
	public OI() {
		WristUp.whileHeld(new RotateWristUp());
		WristDown.whileHeld(new RotateWristDown());
		
		GripOpen.whileHeld(new GripOpen());
		GripClose.whileHeld(new GripClose());
		GripIn.whileHeld(new GripWheelIn());
		GripOut.whileHeld(new GripWheelOut());
		
		encoderZero.whenPressed(new ZeroWristEncoder());
		encoderRotate.whenPressed(new RotateWristEncoder(-30));
	}
}
