package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class basicDrive extends OpMode {
    //declaring the basic drive motors
    DcMotor mRF, mLF, mRB, mLB;
    //declaring auxilary motors
    DcMotor spinner;

    public void init(){
        //assigning the basic drive motors
        mRF = hardwareMap.dcMotor.get("mRF");
        mLF = hardwareMap.dcMotor.get("mLF");
        mRB = hardwareMap.dcMotor.get("mRB");
        mLB = hardwareMap.dcMotor.get("mLB");

        //assigning the auxilary motors
        spinner = hardwareMap.dcMotor.get("spinner");


    }// end of init

    public void loop(){
        //gets the values of the controller buttons
        double rightY = gamepad1.right_stick_y; //forward and backward
        double rightX = gamepad1.right_stick_x; //straife left and right
        double leftX = gamepad1.left_stick_x;   //rotate left and right
        boolean a = gamepad1.a;

        mLF.setPower(rightY + rightX + leftX);
        mLB.setPower(rightY - rightX + leftX);
        mRF.setPower(rightY - rightX - leftX);
        mRB.setPower(rightY + rightX - leftX);

        if (gamepad1.a || gamepad2.a){
            spinner.setPower(0.4);
        }
        

    }// end of loop

}// end of OpMode