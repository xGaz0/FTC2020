package org.firstinspires.ftc.Team16877Code.SkySonesTaking;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.Team16877Code.AutonautsAPI;

import static java.lang.Math.abs;

//import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name="RYXX")
public class Red_First_Variant extends AutonautsAPI {

    @Override
    public void runOpMode() {

        INIT();
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        while (!opModeIsActive());

        liftServo(false);
        runRight(0.55,0.5);
        runForward(0.75,0.5);
        liftServo(true);
        sleep(200);
        runBack(0.2,0.5);
        runLeft(1.2,0.5);
        liftServo(false);
        sleep(200);
        runBack(0.05,0.5);
        runRight(1.8,0.5);
        runForward(0.05,0.5);
        runForward(0.2, 0.5);
        liftServo(true);
        sleep(200);
        runBack(0.2,0.5);
        runLeft(1.8,0.5);
        liftServo(false);
        sleep(200);
        runBack(0.05,0.5);
        runRight(2.2,0.5);
        runForward(0.25,0.5);
        liftServo(true);
        sleep(200);
        runBack(0.2,0.5);
        runLeft(2.2,0.5);
        liftServo(false);
        sleep(200);
        runRight(0.3,0.5);
    }
}
