package org.firstinspires.ftc.teamcode.TeleOp.TeleControl;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Subsystems.ShooterSystem;

public class ShooterControl implements Control {

    //Software
    ShooterSystem shooter;
    Gamepad gp1;
    Gamepad gp2;
    Robot robot;

    //Constructor
    public ShooterControl(ShooterSystem shooter, Gamepad gp1, Gamepad gp2) {
        this.shooter = shooter;
        this.gp1 = gp1;
        this.gp2 = gp2;
    }

    public ShooterControl(Robot robot, Gamepad gp1, Gamepad gp2) {
        this(robot.shooterSystem, gp1, gp2);
        this.robot = robot;
    }

    //Methods

    //Interface Methods
    @Override
    public void update(){
    }

    @Override
    public void addTelemetry(Telemetry telemetry){
    }

}
