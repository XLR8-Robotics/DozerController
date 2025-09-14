package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.subsystems.SimpleDriveTrain;

@TeleOp(name = "Simple Tank Drive", group = "Drive")
public class SimpleTankDriveTeleOp extends OpMode {

    private SimpleDriveTrain driveTrain;

    // Motor names (ensure these match your robot's configuration and SimpleDriveTrain)
    private static final String LEFT_FRONT_DRIVE_NAME = "leftFrontDrive";
    private static final String LEFT_REAR_DRIVE_NAME = "leftRearDrive";
    private static final String RIGHT_FRONT_DRIVE_NAME = "rightFrontDrive";
    private static final String RIGHT_REAR_DRIVE_NAME = "rightRearDrive";

    @Override
    public void init() {
        driveTrain = new SimpleDriveTrain(
                hardwareMap,
                LEFT_FRONT_DRIVE_NAME,
                LEFT_REAR_DRIVE_NAME,
                RIGHT_FRONT_DRIVE_NAME,
                RIGHT_REAR_DRIVE_NAME
        );
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {
        // Tank drive controls:
        // Left joystick Y controls left motors
        // Right joystick Y controls right motors
        // We negate the joystick values because forward on the joystick (pushing up)
        // typically gives a negative value, and we want positive power for forward movement.
        double leftPower = gamepad1.left_stick_y;
        double rightPower = gamepad1.right_stick_y;

        driveTrain.setPower(leftPower, rightPower);

        telemetry.addData("Left Power", "%.2f", leftPower);
        telemetry.addData("Right Power", "%.2f", rightPower);
        telemetry.addData("Left Stick Y", "%.2f", gamepad1.left_stick_y);
        telemetry.addData("Right Stick Y", "%.2f", gamepad1.right_stick_y);
        telemetry.update();
    }

    @Override
    public void stop() {
        if (driveTrain != null) {
            driveTrain.stop();
        }
        telemetry.addData("Status", "Stopped");
        telemetry.update();
    }
}
