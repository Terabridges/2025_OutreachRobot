package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.TeleOp.TeleControl.Control;
import org.firstinspires.ftc.teamcode.TeleOp.TeleControl.DriveControl;
import org.firstinspires.ftc.teamcode.TeleOp.TeleControl.IntakeControl;
import org.firstinspires.ftc.teamcode.TeleOp.TeleControl.ShooterControl;
import org.firstinspires.ftc.teamcode.TeleOp.TeleControl.TransferControl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@TeleOp(name="MainTeleOp", group="TeleOp")
public class MainTeleOp extends LinearOpMode {

    public HashMap<String, String> gamepadMap = null;
    private ElapsedTime runtime = new ElapsedTime();

    public DriveControl driveControl;
    public ShooterControl shooterControl;
    public IntakeControl intakeControl;
    public TransferControl transferControl;
    public List<Control> controls;

    public Gamepad currentGamepad1;
    public Gamepad previousGamepad1;
    public Gamepad currentGamepad2;
    public Gamepad previousGamepad2;

    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(hardwareMap, telemetry, gamepad1, gamepad2);

        driveControl = new DriveControl(robot, gamepad1, gamepad2);
        shooterControl = new ShooterControl(robot, gamepad1, gamepad2);
        intakeControl = new IntakeControl(robot, gamepad1, gamepad2);
        transferControl = new TransferControl(robot, gamepad1, gamepad2);

        controls = new ArrayList<>(Arrays.asList(driveControl, shooterControl, intakeControl, transferControl));

        currentGamepad1 = new Gamepad();
        previousGamepad1 = new Gamepad();
        currentGamepad2 = new Gamepad();
        previousGamepad2 = new Gamepad();

        //Press Start
        waitForStart();
        robot.toInit();
        runtime.reset();

        //Main Loop
        while (opModeIsActive()) {
            gamepadUpdate();
            robot.update();
            controlsUpdate();
        }
    }

    //Other Methods
    public void controlsUpdate() {
        for (Control c : controls) {
            c.update();
            c.addTelemetry(telemetry);
        }
    }

    public void gamepadUpdate(){
        previousGamepad1.copy(currentGamepad1);
        currentGamepad1.copy(gamepad1);

        previousGamepad2.copy(currentGamepad2);
        currentGamepad2.copy(gamepad2);
    }

}
