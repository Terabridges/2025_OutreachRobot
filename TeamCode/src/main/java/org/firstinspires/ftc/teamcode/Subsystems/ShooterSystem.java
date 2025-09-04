package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.bylazar.configurables.annotations.Configurable;
import org.firstinspires.ftc.teamcode.Utiliy.AbsoluteAnalogEncoder;

@Configurable
public class ShooterSystem implements Subsystem {

    //Hardware
    public DcMotor shooterWheel;
    public CRServo turret;
    public CRServo hood;

    //Software
    private double shooterPow = 0.0;
    private double hoodPow = 0.0;
    private double turretPow = 0.0;
    public AnalogInput turretAnalog;
    public AbsoluteAnalogEncoder turretEnc;

    public static double turretOffset = -50.0;
    public static double turretGearRatio = 1;

    public static double turretPosLimit = 100;
    public static  double turretNegLimit = 10;

    //Constructor
    public ShooterSystem(HardwareMap map){
        shooterWheel = map.get(DcMotor.class, "shooter_wheel");
        turret = map.get(CRServo.class, "turret");
        hood = map.get(CRServo.class, "hood");
        turretAnalog = map.get(AnalogInput.class, "turret_analog");
        turretEnc = new AbsoluteAnalogEncoder(turretAnalog, 3.3, turretOffset, turretGearRatio);
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

    public double getTurretPos(){
        return turretEnc.getCurrentPosition();
    }

    public double getTurretPow(){
        return turretPow;
    }

    //Interface Methods
    @Override
    public void toInit(){
    }

    @Override
    public void update(){
        shooterWheel.setPower(shooterPow);
        hood.setPower(hoodPow);

//        if(turretPow >= 0 && !(turretEnc.getCurrentPosition() >= turretPosLimit)){
//            turret.setPower(turretPow);
//        } else if(turretPow <= 0 && !(turretEnc.getCurrentPosition() <= turretNegLimit)){
//            turret.setPower(turretPow);
//        }
        turret.setPower(turretPow);
    }

    //Negative Limit: 15, -1 full rotation
    //Positive Limit: 345, +1 full rotation



}
