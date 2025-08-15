package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TransferSystem implements Subsystem {

    //Hardware
    public DcMotor wheelTransfer;

    //Software
    private double wheelPow = 0.0;

    //Constructor
    public TransferSystem(HardwareMap map){
        wheelTransfer = map.get(DcMotor.class, "wheel_transfer");
    }

    //Methods
    public void toggleTransfer(){
        wheelPow = (wheelPow == 0.0 ? 1.0 : 0.0);
    }

    //Interface Methods
    @Override
    public void toInit(){
    }

    @Override
    public void update(){
        wheelTransfer.setPower(wheelPow);
    }



}
