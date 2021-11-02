package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.api.DcMotorX;
import org.firstinspires.ftc.teamcode.api.Drivetrain;

@TeleOp
public class apiDriverControl extends OpMode {

    private Drivetrain drivetrain;

    public void init() {
        DcMotorX mRF = new DcMotorX(hardwareMap.dcMotor.get("mRF")),
                 mLF = new DcMotorX(hardwareMap.dcMotor.get("mLF")),
                 mRB = new DcMotorX(hardwareMap.dcMotor.get("mRB")),
                 mLB = new DcMotorX(hardwareMap.dcMotor.get("mLB"));

        drivetrain = new Drivetrain(mRF,mLF,mRB,mLB);

        DcMotorX spinner;
    }//end of init

    public void loop(){
        //gets the values of the controller buttons
        double rightY = gamepad1.right_stick_y; //forward and backward
        double rightX = gamepad1.right_stick_x; //strafe left and right
        double leftX = gamepad1.left_stick_x;   //rotate left and right

        if (Math.abs(rightY) > 0.1 || Math.abs(rightX) > 0.1 || Math.abs(leftX) > 0.1) {

        }
        else{

        }


    }//end of loop
}//end of OpMode
