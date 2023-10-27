package org.firstinspires.ftc.teamcode.modules.output;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.modules.Modulable;

public class Claw implements Modulable {
    public static final double CLOSED_POS = 0;
    private static final double OPENED_POS = 0.1;
    private final String name;
    protected Servo claw;
    private boolean open;

    public Claw(String name) {
        this.name = name;
    }

    public double getPosition() {
        return claw.getPosition();
    }

    public void setPosition(double position) {
        claw.setPosition(position);
    }


    @Override
    public void init(HardwareMap map) {
        claw = map.get(Servo.class, name);
        claw.setDirection(Servo.Direction.REVERSE);
    }

    /**
     * Makes the claw start to move towards the specified position.
     *
     * @param open open or close the claw
     */
    public void setClawOpen(boolean open) {
        this.open = open;
        startMoveClaw();
    }

    /**
     * Start to move the claw opposite to the current state.
     */
    public void toggleClaw() {
        open = !open;
        startMoveClaw();
    }

    private void startMoveClaw() {
        claw.setPosition(open ? OPENED_POS : CLOSED_POS);
    }
}

