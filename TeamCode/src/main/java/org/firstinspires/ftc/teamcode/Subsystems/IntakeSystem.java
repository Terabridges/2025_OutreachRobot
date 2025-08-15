package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSystem implements Subsystem {

    //Hardware
    public DcMotor sucker;

    //Software

    //Constructor
    public IntakeSystem(HardwareMap map){
        sucker = map.get(DcMotor.class, "sucker");
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
