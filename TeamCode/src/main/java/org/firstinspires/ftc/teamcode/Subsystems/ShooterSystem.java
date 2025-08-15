package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ShooterSystem implements Subsystem {

    //Hardware
    public DcMotor shooterWheel;
    public CRServo turret;
    public CRServo hood;

    //Software

    //Constructor
    public ShooterSystem(HardwareMap map){
        shooterWheel = map.get(DcMotor.class, "shooter_wheel");
        turret = map.get(CRServo.class, "turret");
        hood = map.get(CRServo.class, "hood");
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
