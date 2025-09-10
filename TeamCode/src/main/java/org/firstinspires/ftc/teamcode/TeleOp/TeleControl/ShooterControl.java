package org.firstinspires.ftc.teamcode.TeleOp.TeleControl;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Subsystems.ShooterSystem;
import org.firstinspires.ftc.teamcode.Utiliy.EdgeDetector;

public class ShooterControl implements Control {

    //Software
    ShooterSystem shooter;
    Gamepad gp1;
    Gamepad gp2;
    Robot robot;
    EdgeDetector shooterRE = new EdgeDetector(() -> shooter.toggleShooter());
    EdgeDetector hoodUpRE = new EdgeDetector(() -> shooter.hoodUp());
    EdgeDetector hoodDownRE = new EdgeDetector(() -> shooter.hoodDown());
    EdgeDetector hoodUpFE = new EdgeDetector(() -> shooter.hoodStop(), true);
    EdgeDetector hoodDownFE = new EdgeDetector(() -> shooter.hoodStop(), true);
    EdgeDetector turretRightRE = new EdgeDetector(() -> shooter.turretRight());
    EdgeDetector turretLeftRE = new EdgeDetector(() -> shooter.turretLeft());
    EdgeDetector turretRightFE = new EdgeDetector(() -> shooter.turretStop(), true);
    EdgeDetector turretLeftFE = new EdgeDetector(() -> shooter.turretStop(), true);


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
        shooterRE.update(gp1.y);
        turretLeftRE.update(gp1.dpad_left);
        turretLeftFE.update(gp1.dpad_left);
        turretRightRE.update(gp1.dpad_right);
        turretRightFE.update(gp1.dpad_right);
        hoodDownRE.update(gp1.dpad_down);
        hoodDownFE.update(gp1.dpad_down);
        hoodUpRE.update(gp1.dpad_up);
        hoodUpFE.update(gp1.dpad_up);
    }

    @Override
    public void addTelemetry(Telemetry telemetry){
        telemetry.addData("Turret Pos", shooter.getTurretPos());
        telemetry.addData("Current Turret Pos", shooter.currentTurretPos);
        telemetry.addData("Turret Pow", shooter.getTurretPow());
        telemetry.addData("Prev Pos", shooter.previousTurretPos);
        telemetry.addData("Rotation Counter", shooter.rotationCounter);
        telemetry.addData("Hood Pos", shooter.hood.getPosition());
    }

}
