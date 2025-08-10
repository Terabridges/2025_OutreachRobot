package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Robot {

    //Objects
    public HardwareMap hardwareMap;
    public Telemetry telemetry;
    public Gamepad gp1;
    public Gamepad gp2;

    //Subsystems
    public DriveSystem driveSystem;
    public ShooterSystem shooterSystem;

    //Other
    public String currentState = "none";

    //Subsystem List
    public List<Subsystem> subsystems;

    //Constructors
    public Robot(HardwareMap map, Telemetry t, Gamepad gp1, Gamepad gp2){
        hardwareMap = map;
        telemetry = t;

        driveSystem = new DriveSystem(hardwareMap);
        shooterSystem = new ShooterSystem(hardwareMap);

        subsystems = new ArrayList<>(Arrays.asList(driveSystem, shooterSystem));

        this.gp1 = gp1;
        this.gp2 = gp2;
    }

    public Robot(HardwareMap map, Telemetry t){this(map, t, null, null);}

    //Methods



    //Interface Methods
    public void update() {
        for (Subsystem s : subsystems) {
            s.update();
        }
    }

    public void toInit() {
        for (Subsystem s : subsystems) {
            s.toInit();
        }
    }

}