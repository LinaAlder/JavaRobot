package com.company;

import com.sun.javafx.scene.traversal.Direction;

import static java.lang.Math.abs;

public class Robot {

    private int X = 0, Y = 0;
    private Direction direction = Direction.UP;

    public Direction getDirection() {
        return direction;
    }
    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void turnLeft() {
        if (direction == Direction.UP)
            direction = Direction.LEFT;
        else {
            if (direction == Direction.RIGHT)
                direction = Direction.UP;
            else {
                if (direction == Direction.DOWN)
                    direction = Direction.RIGHT;
                else {
                    if (direction == Direction.LEFT)
                        direction = Direction.DOWN;
                }
            }
        }
    }

    public void turnRight() {

        if (direction == Direction.UP)
            direction = Direction.RIGHT;
        else {
            if (direction == Direction.RIGHT)
                direction = Direction.DOWN;
            else {
                if (direction == Direction.DOWN)
                    direction = Direction.LEFT;
                else {
                    if (direction == Direction.LEFT)
                        direction = Direction.UP;
                }
            }
        }
    }

    public void stepForward() {
        if (direction == Direction.UP)
            Y++;
        else {
            if (direction == Direction.RIGHT)
                X++;
            else {
                if (direction == Direction.DOWN)
                    Y--;
                else {
                    if (direction == Direction.LEFT)
                    X--;
                }
            }
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {

        int changeX = toX - robot.getX();
        int changeY = toY - robot.getY();

        if (robot.getDirection() == Direction.RIGHT)
            robot.turnLeft();
        else {
            if (robot.getDirection() == Direction.DOWN){
                robot.turnLeft();
                robot.turnLeft();
            }
            else {
                if (robot.getDirection() == Direction.LEFT)
                    robot.turnRight();

            }
        }
        if (changeX > 0) {
            robot.turnRight();
        } else {
            robot.turnLeft();
        }
        for (int i = 0; i < Math.abs(changeX); i++)
            robot.stepForward();

        if (robot.getDirection() == Direction.LEFT) {
            robot.turnRight();
        } else {
            robot.turnLeft();
        }

        if (changeY < 0) {
            robot.turnLeft();
            robot.turnLeft();
        }

        for (int i = 0; i < Math.abs(changeY); i++)
            robot.stepForward();
    }

}
