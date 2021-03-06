package org.usfirst.frc.team280.robot.subsystems;

import java.lang.reflect.GenericArrayType;

import org.usfirst.frc.team280.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Wrist extends PIDSubsystem {

	public WPI_TalonSRX Motor = new WPI_TalonSRX(RobotMap.WristTalon);
	public Encoder encoder = new Encoder(RobotMap.wrist_encoder_port_a, RobotMap.wrist_encoder_port_b);
	
	public Wrist() {
		super(-0.1, 0, 0);
		getPIDController().setOutputRange(-0.85, 0.85);
		getPIDController().setSetpoint(encoder.get());
		getPIDController().enable();
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
	
	public void encZero() {
		encoder.reset();
		this.getPIDController().setSetpoint(encoder.get());
	}
}
