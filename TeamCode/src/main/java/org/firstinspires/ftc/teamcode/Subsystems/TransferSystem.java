package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TransferSystem implements Subsystem {

    //Hardware
    public CRServo beltTransfer;
    public DcMotor wheelTransfer;

    //Software

    //Constructor
    public TransferSystem(HardwareMap map){
        beltTransfer = map.get(CRServo.class, "belt_transfer");
        wheelTransfer = map.get(DcMotor.class, "wheel_transfer");
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
