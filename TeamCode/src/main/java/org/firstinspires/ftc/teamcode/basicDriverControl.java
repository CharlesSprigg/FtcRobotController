package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class basicDriverControl extends OpMode {
    //declaring the basic drive motors
    DcMotor mRF, mLF, mRB, mLB;
    //declaring auxiliary motors
    DcMotor spinner;


    public void init() {
        //assigning the basic drive motors
        mRF = hardwareMap.dcMotor.get("mRF");
        mLF = hardwareMap.dcMotor.get("mLF");
        mRB = hardwareMap.dcMotor.get("mRB");
        mLB = hardwareMap.dcMotor.get("mLB");

        //assigning the auxiliary motors
        spinner = hardwareMap.dcMotor.get("spinner");


    }// end of init

    public void loop(){
        //gets the values of the controller buttons
        double rightY = gamepad1.right_stick_y; //forward and backward
        double rightX = gamepad1.right_stick_x; //strafe left and right
        double leftX = gamepad1.left_stick_x;   //rotate left and right

        //linear drive system (not curved i need to learn how to do that)

        if (Math.abs(rightY) > 0.1 || Math.abs(rightX) > 0.1 || Math.abs(leftX) > 0.1) {
            mLF.setPower(rightY + rightX + leftX);
            mLB.setPower(rightY - rightX + leftX);
            mRF.setPower(rightY - rightX - leftX);
            mRB.setPower(rightY + rightX - leftX);
        }
        else{
            mLF.setPower(0);
            mLB.setPower(0);
            mRF.setPower(0);
            mRB.setPower(0);
        }

        if (gamepad1.a || gamepad2.a){
            spinner.setPower(0.4);
        }
        else{
            spinner.setPower(0.0);
        }
        

    }// end of loop

    double driveRate(double input, double rate){ //adds a rate curve to the motors from the controller input.
        return Math.pow(Math.abs(input),rate)*((input > 0) ? 1: -1);//fancy if statement.
        //     ^ in math - |input|^rate ^       ^ if more than 0 pos, if less than 0 neg
    }//end of driveRate

}// end of OpMode