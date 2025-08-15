package org.firstinspires.ftc.teamcode.TeleOp.TeleControl;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Subsystems.ShooterSystem;
import org.firstinspires.ftc.teamcode.Subsystems.TransferSystem;
import org.firstinspires.ftc.teamcode.Utiliy.EdgeDetector;

public class TransferControl implements Control {

    //Software
    TransferSystem transfer;
    Gamepad gp1;
    Gamepad gp2;
    Robot robot;
    EdgeDetector transferRE = new EdgeDetector(() -> transfer.toggleTransfer());

    //Constructor
    public TransferControl(TransferSystem transfer, Gamepad gp1, Gamepad gp2) {
        this.transfer = transfer;
        this.gp1 = gp1;
        this.gp2 = gp2;
    }

    public TransferControl(Robot robot, Gamepad gp1, Gamepad gp2) {
        this(robot.transferSystem, gp1, gp2);
        this.robot = robot;
    }

    //Methods

    //Interface Methods
    @Override
    public void update(){
        transferRE.update(gp1.b);
    }

    @Override
    public void addTelemetry(Telemetry telemetry){
    }

}
