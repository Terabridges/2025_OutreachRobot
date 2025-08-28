package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class DriveSystem implements Subsystem {

    //Hardware
    public DcMotor leftFront;
    public DcMotor leftBack;
    public DcMotor rightFront;
    public DcMotor rightBack;

    //Software
    public boolean useSlowMode = false;

    //Constructor
    public DriveSystem(HardwareMap map) {
        leftBack = map.get(DcMotor.class, "left_back");
        leftFront = map.get(DcMotor.class, "left_front");
        rightBack = map.get(DcMotor.class, "right_back");
        rightFront = map.get(DcMotor.class, "right_front");
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    //Methods

    //Interface Methods
    @Override
    public void toInit(){
    }

    @Override
    public void update(){
    }

}
