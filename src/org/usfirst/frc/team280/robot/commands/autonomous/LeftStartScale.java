package org.usfirst.frc.team280.robot.commands.autonomous;

import org.usfirst.frc.team280.robot.Robot;

import org.usfirst.frc.team280.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LeftStartScale extends Command {

	WPI_TalonSRX LMMotor = new WPI_TalonSRX(RobotMap.LMTalon);
	WPI_TalonSRX RMMotor = new WPI_TalonSRX(RobotMap.RMTalon);		
	WPI_TalonSRX LSMotor = new WPI_TalonSRX(RobotMap.LSTalon);
	WPI_TalonSRX RSMotor = new WPI_TalonSRX(RobotMap.RSTalon);
	WPI_TalonSRX LS1Motor = new WPI_TalonSRX(RobotMap.LMTalon);
	WPI_TalonSRX RS1Motor = new WPI_TalonSRX(RobotMap.RMTalon);
	private WPI_TalonSRX timer;

	public LeftStartScale() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time


	protected void initialize() {


		String gameData;
		Command option;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		option = Robot.chooser.getSelected();
		// Character 0: Your Switch | Char. 1: Scale | Char. 2: Opposing Switch
		// (Competition) Valid GameData is as follows: LLL, RRR, LRL, RLR	
		if (gameData.equals("LRL") || gameData.equals("RRR")) {
			DriverStation.reportError("Left Start Scale: Scale is on right.", false);
			if (timer.get() > 2.0) {
				LMMotor.set(0.5);
				RMMotor.set(0.5);
				LSMotor.set(0.5);
				RSMotor.set(0.5);
				LS1Motor.set(0.5);
				RS1Motor.set(0.5);
			} else { 

				if (timer.get() > 2.0) {
					LMMotor.set(0.5);
					RMMotor.set(0.5);
					LSMotor.set(0.5);
					RSMotor.set(0.5);
					LS1Motor.set(0.5);
					RS1Motor.set(0.5);
				}  

				else if (gameData.equals("RLR") || gameData.equals("LLL")) {
					DriverStation.reportError("Left Start Scale: Scale is on right.", false);


					if (timer.get() > 2.0) {
						LMMotor.set(0.5);
						RMMotor.set(0.5);
						LSMotor.set(0.5);
						RSMotor.set(0.5);
						LS1Motor.set(0.5);
						RS1Motor.set(0.5);
					} else { 

						if (timer.get() > 2.0) {
							LMMotor.set(0.5);
							RMMotor.set(0.5);
							LSMotor.set(0.5);
							RSMotor.set(0.5);
							LS1Motor.set(0.5);
							RS1Motor.set(0.5);
						} else { 


						}

					}


				}




				//EXAMPLE
				/*
				 * if (timer.whatever > timing 1) {
				 * 	LMMotor.set(speed);
				 * 	RMMotor.set(speed);
				 * 	LSMotor.set(speed);
				 * 	RSMotor.set(speed);
				 * 	LS1Motor.set(speed);
				 * 	RS1Motor.set(speed);
				 *  }
				 * else if (timer.whatever > timing 2) {
				 * 	etc. }
				 * keep going until you have the full path put down
				 * for the last one just have the ifnal time with a Motors.set(0);
				 */


				else { 
					DriverStation.reportError("Invalid GameData recieved. Data: " + gameData, false);
				}
			} 
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
