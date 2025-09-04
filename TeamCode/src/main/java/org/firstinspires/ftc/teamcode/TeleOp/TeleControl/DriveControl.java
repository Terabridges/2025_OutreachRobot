package org.firstinspires.ftc.teamcode.TeleOp.TeleControl;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSystem;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Utiliy.EdgeDetector;

public class DriveControl implements Control {

    //Software
    DriveSystem driveSystem;
    public Robot robot;
    public Gamepad gp1;
    public Gamepad gp2;
    public double FAST_MULT = 1.0;
    public double SLOW_MULT = 0.6;
    public double speed = FAST_MULT;
    EdgeDetector slowModeRE = new EdgeDetector( () -> toggleSlowMode());

    //Constructor
    public DriveControl(DriveSystem d, Gamepad gp1, Gamepad gp2) {
        this.driveSystem = d;
        this.gp1 = gp1;
        this.gp2 = gp2;
    }

    public DriveControl(Robot robot, Gamepad gp1, Gamepad gp2) {
        this(robot.driveSystem, gp1, gp2);
        this.robot = robot;
    }

    //Methods
    public void toggleSlowMode(){
        driveSystem.useSlowMode = !driveSystem.useSlowMode;
    }


    //Interface Methods
    @Override
    public void update(){

        slowModeRE.update(gp1.left_bumper);
        speed = (driveSystem.useSlowMode ? SLOW_MULT : FAST_MULT);

        double max;
        double axial = -gp1.left_stick_y;  // Note: pushing stick forward gives negative value
        double lateral = gp1.left_stick_x;
        double yaw = gp1.right_stick_x;
        double leftFrontPower = axial + lateral + (yaw);
        double rightFrontPower = axial - lateral - (yaw);
        double leftBackPower = axial - lateral + (yaw);
        double rightBackPower = axial + lateral - (yaw);
        max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
        max = Math.max(max, Math.abs(leftBackPower));
        max = Math.max(max, Math.abs(rightBackPower));
        if (max > 1.0) {
            leftFrontPower /= max;
            rightFrontPower /= max;
            leftBackPower /= max;
            rightBackPower /= max;
        }
        leftFrontPower *= speed;
        rightFrontPower *= speed;
        leftBackPower *= speed;
        rightBackPower *= speed;
        driveSystem.leftFront.setPower(leftFrontPower);
        driveSystem.rightFront.setPower(rightFrontPower);
        driveSystem.leftBack.setPower(leftBackPower);
        driveSystem.rightBack.setPower(rightBackPower);
    }

    @Override
    public void addTelemetry(Telemetry telemetry){
        //telemetry.addData("SPEED", (driveSystem.useSlowMode ? "SLOW" : "FAST"));
    }

}
