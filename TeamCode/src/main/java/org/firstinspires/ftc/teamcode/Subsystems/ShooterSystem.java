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
    private double shooterPow = 0.0;
    private double hoodPow = 0.0;
    private double turretPow = 0.0;

    //Constructor
    public ShooterSystem(HardwareMap map){
        shooterWheel = map.get(DcMotor.class, "shooter_wheel");
        turret = map.get(CRServo.class, "turret");
        hood = map.get(CRServo.class, "hood");
    }

    //Methods
    public void toggleShooter(){
        shooterPow = (shooterPow == 0.0 ? 1.0 : 0.0);
    }
    public void hoodUp(){
        hoodPow = 0.5;
    }
    public void hoodDown(){
        hoodPow = -0.5;
    }
    public void hoodStop(){
        hoodPow = 0.0;
    }

    public void turretRight(){
        turretPow = 1.0;
    }

    public void turretLeft(){
        turretPow = -1.0;
    }

    public void turretStop(){
        turretPow = 0.0;
    }

    //Interface Methods
    @Override
    public void toInit(){
    }

    @Override
    public void update(){
        shooterWheel.setPower(shooterPow);
        hood.setPower(hoodPow);
        turret.setPower(turretPow);
    }



}
