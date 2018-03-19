package org.usfirst.frc.team280.robot.subsystems;

import org.usfirst.frc.team280.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Wrist extends PIDSubsystem {

	WPI_TalonSRX Motor = new WPI_TalonSRX(RobotMap.WristTalon);
	Encoder encoder = new Encoder(RobotMap.wrist_encoder_port_a, RobotMap.wrist_encoder_port_b);
	
	public Wrist() {
		super(0.01, 0, 0);
	}
	
	@Override
	protected void initDefaultCommand() {
	}

	@Override
	protected double returnPIDInput() {
		return getEncoderValue();
	}

	@Override
	protected void usePIDOutput(double output) {
		Motor.set(output);
	}
	
	public void rotate(double speed) {
		Motor.set(speed);
	}
	
	public double getEncoderValue() {
		return encoder.get();
	}
	
	public void encRotate(double counts) {
		// Run motor up to number of encoder counts supplied
		if (Math.signum(counts) == 1.0) { // Check if counts is positive
			if (encoder.get() < counts) {
				Motor.set(0.85);
			}
		} else if (Math.signum(counts) == -1.0) { // Check if counts is negative
			if (encoder.get() < counts) {
				Motor.set(-0.85);
			}
		} else {
			Motor.set(0);
		}
	}
}