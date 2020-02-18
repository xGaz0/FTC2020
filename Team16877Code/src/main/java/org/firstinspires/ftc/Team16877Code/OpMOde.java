package org.firstinspires.ftc.Team16877Code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "WASD", group = "Linear Opmode")
public class OpMOde extends LinearOpMode {

    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;

    DcMotorSimple parkingMotor;
    DcMotorSimple handMotor;

    Servo getServo;
    Servo foundation1;
    Servo foundation2;
    Servo handServo;

    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        leftFront = hardwareMap.get(DcMotor.class, "MotorFrontLeft");
        rightFront = hardwareMap.get(DcMotor.class, "MotorFrontRight");
        leftBack = hardwareMap.get(DcMotor.class, "MotorBackLeft");
        rightBack = hardwareMap.get(DcMotor.class, "MotorBackRight");

        parkingMotor = hardwareMap.get(DcMotorSimple.class, "motor5");
        handMotor = hardwareMap.get(DcMotorSimple.class, "handMotor");

        handServo = hardwareMap.get(Servo.class, "handServo");
        getServo = hardwareMap.get(Servo.class, "getServo");
        foundation1 = hardwareMap.get(Servo.class, "servoFoundation1");
        foundation2 = hardwareMap.get(Servo.class, "servoFoundation2");


        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            if ((gamepad1.right_stick_y != 0) || (gamepad1.left_stick_y != 0)) {
                leftFront.setPower(-gamepad1.left_stick_y);
                leftBack.setPower(-gamepad1.left_stick_y );
                rightFront.setPower(gamepad1.right_stick_y);
                rightBack.setPower(gamepad1.right_stick_y);
            } else if (gamepad1.dpad_up && !gamepad1.dpad_down && !gamepad1.dpad_right && !gamepad1.dpad_left) {
                leftFront.setPower(0.5);
                leftBack.setPower(0.5);
                rightFront.setPower(-0.5);
                rightBack.setPower(-0.5);
            } else if (!gamepad1.dpad_up && gamepad1.dpad_down && !gamepad1.dpad_right && !gamepad1.dpad_left) {
                leftFront.setPower(-0.5);
                leftBack.setPower(-0.5);
                rightFront.setPower(0.5);
                rightBack.setPower(0.5);
            } else if (!gamepad1.dpad_up && !gamepad1.dpad_down && gamepad1.dpad_right && !gamepad1.dpad_left) {
                leftFront.setPower(0.5);
                leftBack.setPower(-0.5);
                rightFront.setPower(0.5);
                rightBack.setPower(-0.5);
            } else if (!gamepad1.dpad_up && !gamepad1.dpad_down && !gamepad1.dpad_right && gamepad1.dpad_left) {
                leftFront.setPower(-0.5);
                leftBack.setPower(0.5);
                rightFront.setPower(-0.5);
                rightBack.setPower(0.5);
            } else if (gamepad1.dpad_up && !gamepad1.dpad_down && gamepad1.dpad_right && !gamepad1.dpad_left) {
                leftFront.setPower(0.5);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(-0.5);
            } else if (gamepad1.dpad_up && !gamepad1.dpad_down && !gamepad1.dpad_right && gamepad1.dpad_left) {
                leftFront.setPower(0);
                leftBack.setPower(0.5);
                rightFront.setPower(-0.5);
                rightBack.setPower(0);
            } else if (!gamepad1.dpad_up && gamepad1.dpad_down && !gamepad1.dpad_right && gamepad1.dpad_left) {
                leftFront.setPower(-0.5);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0.5);
            } else if (!gamepad1.dpad_up && gamepad1.dpad_down && gamepad1.dpad_right && !gamepad1.dpad_left) {
                leftFront.setPower(0);
                leftBack.setPower(-0.5);
                rightFront.setPower(0.5);
                rightBack.setPower(0);
            } else {
                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);
            }

            if (gamepad1.right_bumper) {
                getServo.setPosition(0.7);
            } else {
                getServo.setPosition(0);
            }
            if (gamepad1.left_bumper) {
                foundation1.setPosition(0.2);
                foundation2.setPosition(0.8);
            } else {
                foundation1.setPosition(1);
                foundation2.setPosition(0);
            }

            if (gamepad1.right_trigger > 0) {
                parkingMotor.setPower(-gamepad1.right_trigger);
            } else if (gamepad1.left_trigger > 0) {
                parkingMotor.setPower(gamepad1.left_trigger);
            } else {
                parkingMotor.setPower(0);
            }
            if (gamepad2.right_stick_button) {
                handServo.setPosition(0.6);
            } else{
                handServo.setPosition(0);
            }
            handMotor.setPower(gamepad2.right_stick_y);
        }
    }
}
