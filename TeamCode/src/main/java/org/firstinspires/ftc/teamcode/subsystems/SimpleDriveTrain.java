package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SimpleDriveTrain {
    private DcMotor leftFrontDrive;
    private DcMotor leftRearDrive;
    private DcMotor rightFrontDrive;
    private DcMotor rightRearDrive;
    private DcMotor fifthMotor;

    public SimpleDriveTrain(HardwareMap hardwareMap, String leftFrontName, String leftRearName, String rightFrontName, String rightRearName, String fifthMotorName) {
        leftFrontDrive = hardwareMap.get(DcMotor.class, leftFrontName);
        leftRearDrive = hardwareMap.get(DcMotor.class, leftRearName);
        rightFrontDrive = hardwareMap.get(DcMotor.class, rightFrontName);
        rightRearDrive = hardwareMap.get(DcMotor.class, rightRearName);
        fifthMotor = hardwareMap.get(DcMotor.class, fifthMotorName);

        // Motors on the left side should spin in the same direction
        // Motors on the right side should spin in the opposite direction of the left side for forward movement
        // Assuming standard motor orientation, reverse the right side motors.
        // If your robot moves backward when given positive power, un-reverse these.
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftRearDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightRearDrive.setDirection(DcMotor.Direction.REVERSE);
        fifthMotor.setDirection(DcMotor.Direction.FORWARD); // Adjust if needed

        // Set all motors to brake when power is zero
        leftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRearDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRearDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fifthMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
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
     * Controls the fifth motor using L1 and R1 buttons.
     * L1 for forward, R1 for reverse. Stops if both or neither are pressed.
     * @param l1Pressed True if L1 is pressed
     * @param r1Pressed True if R1 is pressed
     */
    public void controlFifthMotor(boolean l1Pressed, boolean r1Pressed) {
        double fifthMotorPower = 0.0;
        if (l1Pressed && !r1Pressed) {
            fifthMotorPower = 1.0;
        } else if (r1Pressed && !l1Pressed) {
            fifthMotorPower = -1.0;
        }
        fifthMotor.setPower(fifthMotorPower);
    }

    /**
     * Stops all drivetrain motors and the fifth motor.
     */
    public void stop() {
        setPower(0, 0);
        fifthMotor.setPower(0);
    }

    // You can add methods for encoders if needed, for example:
    // public void setMode(DcMotor.RunMode mode) {
    //     leftFrontDrive.setMode(mode);
    //     leftRearDrive.setMode(mode);
    //     rightFrontDrive.setMode(mode);
    //     rightRearDrive.setMode(mode);
    //     fifthMotor.setMode(mode);
    // }
}
