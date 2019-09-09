package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int toX, toY;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите x: ");
        toX = in.nextInt();
        System.out.print("Введите y: ");
        toY = in.nextInt();

        Robot robot = new Robot();
        Robot.moveRobot(robot, toX, toY);

        System.out.printf("X: %d, Y: %d", robot.getX(), robot.getY());
    }
}
