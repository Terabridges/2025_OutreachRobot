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
    public Servo hood;

    //Software
    private double shooterPow = 0.0;
    private double hoodPow = 0.0;
    private double turretPow = 0.0;
    public AnalogInput turretAnalog;
    public AbsoluteAnalogEncoder turretEnc;

    public static double turretOffset = -50.0;
    public static double turretGearRatio = 1;

    public static double turretPosLimit = 350;
    public static  double turretNegLimit = 10;

    public boolean turningRight = false;
    public boolean turningLeft = false;

    public double previousTurretPos = 0;
    public double currentTurretPos;
    public int rotationCounter = 0;

    //Constructor
    public ShooterSystem(HardwareMap map){
        shooterWheel = map.get(DcMotor.class, "shooter_wheel");
        turret = map.get(CRServo.class, "turret");
        hood = map.get(Servo.class, "hood");
        turretAnalog = map.get(AnalogInput.class, "turret_analog");
        turretEnc = new AbsoluteAnalogEncoder(turretAnalog, 3.3, turretOffset, turretGearRatio);
    }

    //Methods
    public void toggleShooter(){
        shooterPow = (shooterPow == 0.0 ? 1.0 : 0.0);
    }
    public void hoodUp(){
        hoodPow = 0.01;
    }
    public void hoodDown(){
        hoodPow = -0.01;
    }
    public void hoodStop(){
        hoodPow = 0.0;
    }

    public void turretRight(){
        turningRight = true;
    }

    public void turretLeft(){
        turningLeft = true;
    }

    public void turretStop(){
        turningRight = false;
        turningLeft = false;
    }

    public double getTurretPos(){
        return turretEnc.getCurrentPosition();
    }

    public double getTurretPow(){
        return turretPow;
    }

    public void updateEdgeDetection(){
        currentTurretPos = turretEnc.getCurrentPosition();
        if ((currentTurretPos > 340) && (previousTurretPos < 20) && rotationCounter==0){ //Goes past neg limit, counterclockwise
            rotationCounter = -1;
        } else if ((currentTurretPos < 20) && (previousTurretPos > 340) && rotationCounter==0){ //Goes past pos limit, clockwise
            rotationCounter = 1;
        } else if ((currentTurretPos > 340) && (previousTurretPos < 20) && rotationCounter==1){ //Goes past neg limit, counterclockwise
            rotationCounter = 0;
        } else if ((currentTurretPos < 20) && (previousTurretPos > 340) && rotationCounter==-1){ //Goes past pos limit, clockwise
            rotationCounter = 0;
        }
        previousTurretPos = currentTurretPos;
    }

    //Interface Methods
    @Override
    public void toInit(){

    }

    @Override
    public void update(){
        shooterWheel.setPower(shooterPow);
        hood.setPosition(hood.getPosition()+hoodPow);

        updateEdgeDetection();
        if (turningRight && rotationCounter == 1){
            turretPow = ((turretPosLimit - turretEnc.getCurrentPosition()) / 245);
        } else if (turningLeft && rotationCounter == 1){
            turretPow = -1;
        } else if (turningLeft && rotationCounter == -1){
            turretPow = ((turretNegLimit - turretEnc.getCurrentPosition()) / 115);
        } else if (turningRight && rotationCounter == -1){
            turretPow = 1;
        } else if (rotationCounter == 0){
            if(turningRight){
                turretPow = 1;
            } else if (turningLeft){
                turretPow = -1;
            } else {
                turretPow = 0;
            }
        } else {
            turretPow = 0;
        }

//        if(turretPow >= 0 && !(turretEnc.getCurrentPosition() >= turretPosLimit)){ //turning right
//            turret.setPower(turretPow);
//        } else if(turretPow <= 0 && !(turretEnc.getCurrentPosition() <= turretNegLimit)){ //turning left
//            turret.setPower(turretPow);
//        }
        turret.setPower(turretPow);


    }

    //Negative Limit: 15, -1 full rotation
    //Positive Limit: 345, +1 full rotation



}
