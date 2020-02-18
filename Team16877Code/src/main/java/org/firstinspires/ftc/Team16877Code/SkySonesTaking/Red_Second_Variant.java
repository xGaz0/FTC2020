package org.firstinspires.ftc.Team16877Code.SkySonesTaking;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.Team16877Code.AutonautsAPI;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

import static java.lang.Math.abs;

//import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name="RXYX")
public class Red_Second_Variant extends AutonautsAPI {
    @Override
    public void runOpMode() {

        boolean i = true;
        INIT();
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        while (opModeIsActive()) {
            if (i) {
                gettingServo(false);
                runLeft(0.67, 0.5);
                runForward(0.9, 0.5);
                gettingServo(true);
                sleep(200);
                runBack(0.8, 0.5);
                runRight(1.17, 0.5);
                gettingServo(false);
                sleep(200);
                runBack(0.10, 0.5);
                runLeft(0.3, 0.5);
                i = !i;
            }
        }
    }
}
