package org.firstinspires.ftc.teamcode.TeleOp.TeleControl;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSystem;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Subsystems.ShooterSystem;
import org.firstinspires.ftc.teamcode.Utiliy.EdgeDetector;

public class IntakeControl implements Control {

    //Software
    IntakeSystem intake;
    Gamepad gp1;
    Gamepad gp2;
    Robot robot;
    EdgeDetector suckerRE = new EdgeDetector(() -> intake.toggleSucker());

    //Constructor
    public IntakeControl(IntakeSystem intake, Gamepad gp1, Gamepad gp2) {
        this.intake = intake;
        this.gp1 = gp1;
        this.gp2 = gp2;
    }

    public IntakeControl(Robot robot, Gamepad gp1, Gamepad gp2) {
        this(robot.intakeSystem, gp1, gp2);
        this.robot = robot;
    }

    //Methods

    //Interface Methods
    @Override
    public void update(){
        suckerRE.update(gp1.a);
    }

    @Override
    public void addTelemetry(Telemetry telemetry){
    }

}
