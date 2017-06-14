package com.example.siamakmohsenisam.project_2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by siamakmohsenisam on 2017-05-25.
 */

public class Pacman  {

    private String name;
    private int xDir;
    private int yDir;
    private float xPos;
    private float yPos;
    private int speed;
    private Bitmap bitmap;

//    public Pacman() {
//        this(0,0,0, BitmapFactory.decodeResource(getResources(),R.drawable.pacman));
//    }


    public Pacman(String name, Bitmap bitmap) {
        this(name,0,0,0,0,0, bitmap);
    }

    public Pacman(String name, int xDir, int yDir, float xPos, float yPos, int speed, Bitmap bitmap) {
        this.name = name;
        this.xDir = xDir;
        this.yDir = yDir;
        this.xPos = xPos;
        this.yPos = yPos;
        this.speed = speed;
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxDir() {
        return xDir;
    }

    public void setxDir(int xDir) {
        this.xDir = xDir;
    }

    public int getyDir() {
        return yDir;
    }

    public void setyDir(int yDir) {
        this.yDir = yDir;
    }

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return name + '\n' +
                "Direction is = (" + xDir +
                "," + yDir +
                ") Position is = (" + xPos +
                "," + yPos +
                ") and speed is = " + speed ;
    }
}
