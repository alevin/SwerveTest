package org.usfirst.frc.team5507.robot.subsystems;

import org.usfirst.frc.team5507.robot.commands.HolonomicDriveCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class HolonomicDrivetrain extends Drivetrain {

	private double mAdjustmentAngle = 0;
	private boolean mFieldOriented = true;


	public double getAdjustmentAngle() {
		return mAdjustmentAngle;
	}

	public abstract double getGyroAngle();

	public abstract void holonomicDrive(double forward, double strafe, double rotation);

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new HolonomicDriveCommand(this));
	}

	public boolean isFieldOriented() {
		return mFieldOriented;
	}

	public void setAdjustmentAngle(double adjustmentAngle) {
		mAdjustmentAngle = adjustmentAngle;
	}

	public void setFieldOriented(boolean fieldOriented) {
		mFieldOriented = fieldOriented;
	}

	public abstract void stopDriveMotors();

	public void zeroGyro() {
		setAdjustmentAngle(getGyroAngle() + getAdjustmentAngle());
	}
}
