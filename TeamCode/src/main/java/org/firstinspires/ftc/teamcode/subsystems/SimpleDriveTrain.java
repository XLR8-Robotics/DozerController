package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SimpleDriveTrain {
    private DcMotor leftFrontDrive;
    private DcMotor leftRearDrive;
    private DcMotor rightFrontDrive;
    private DcMotor rightRearDrive;

    public SimpleDriveTrain(HardwareMap hardwareMap, String leftFrontName, String leftRearName, String rightFrontName, String rightRearName) {
        leftFrontDrive = hardwareMap.get(DcMotor.class, leftFrontName);
        leftRearDrive = hardwareMap.get(DcMotor.class, leftRearName);
        rightFrontDrive = hardwareMap.get(DcMotor.class, rightFrontName);
        rightRearDrive = hardwareMap.get(DcMotor.class, rightRearName);

        // Motors on the left side should spin in the same direction
        // Motors on the right side should spin in the opposite direction of the left side for forward movement
        // Assuming standard motor orientation, reverse the right side motors.
        // If your robot moves backward when given positive power, un-reverse these.
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftRearDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightRearDrive.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to brake when power is zero
        leftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRearDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRearDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    /**
     * Sets power to the drivetrain motors.
     * @param leftPower Power for the left side motors (range: -1.0 to 1.0)
     * @param rightPower Power for the right side motors (range: -1.0 to 1.0)
     */
    public void setPower(double leftPower, double rightPower) {
        leftFrontDrive.setPower(leftPower);
        leftRearDrive.setPower(leftPower);
        rightFrontDrive.setPower(rightPower);
        rightRearDrive.setPower(rightPower);
    }

    /**
     * Stops all drivetrain motors.
     */
    public void stop() {
        setPower(0, 0);
    }

    // You can add methods for encoders if needed, for example:
    // public void setMode(DcMotor.RunMode mode) {
    //     leftFrontDrive.setMode(mode);
    //     leftRearDrive.setMode(mode);
    //     rightFrontDrive.setMode(mode);
    //     rightRearDrive.setMode(mode);
    // }
}
