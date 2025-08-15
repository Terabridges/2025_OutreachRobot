package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSystem implements Subsystem {

    //Hardware
    public DcMotor sucker;
    public CRServo beltTransfer;

    //Software
    private double suckerPow = 0.0;
    private double beltPow = 0.0;

    //Constructor
    public IntakeSystem(HardwareMap map){
        sucker = map.get(DcMotor.class, "sucker");
        beltTransfer = map.get(CRServo.class, "belt_transfer");
    }

    //Methods
    public void toggleSucker(){
        suckerPow = (suckerPow == 0.0 ? 1.0 : 0.0);
        beltPow = (beltPow == 0.0 ? 1.0 : 0.0);
    }

    //Interface Methods
    @Override
    public void toInit(){
    }

    @Override
    public void update(){
        sucker.setPower(suckerPow);
        beltTransfer.setPower(beltPow);
    }



}
