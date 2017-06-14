package com.example.siamakmohsenisam.project_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by masoud on 2017-05-24.
 */

public class CustomView extends View implements View.OnTouchListener{

    //Declare the object we want to animate
    private Pacman[] pacmans = new Pacman[5];


    Bitmap[] bitmaps= {BitmapFactory.decodeResource(getResources(), R.drawable.p0),
            BitmapFactory.decodeResource(getResources(), R.drawable.p1),
            BitmapFactory.decodeResource(getResources(), R.drawable.p2),
            BitmapFactory.decodeResource(getResources(), R.drawable.p3),
            BitmapFactory.decodeResource(getResources(), R.drawable.p4)};
    Bitmap racket = BitmapFactory.decodeResource(getResources(), R.drawable.racket);
    String[] names={"Pacman0","Pacman1","Pacman2","Pacman3","Pacman4",};
    float raketXPos = 200;

    //------------------------------------- Constructor
    public CustomView(Context context) {
        super(context);
        //initialize square1
        int x=0;
        for (int i=0 ; i < pacmans.length; i++)
        {
            bitmaps[i]= Bitmap.createScaledBitmap(bitmaps[i],100,100,true);
            pacmans[i] =  new Pacman(names[i],x,1, i*30+400,-100,(i+2)*5 ,bitmaps[i]);

            if (x==0) x=1;
            else x *=-1;
        }


        racket = Bitmap.createScaledBitmap(racket,300,50,true);

        setOnTouchListener(this);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float max_Y = canvas.getHeight()-100;
        float max_X = canvas.getWidth()-100;

        canvas.drawBitmap(racket,raketXPos,canvas.getHeight()-50,null);

        for (int i=0 ; i < pacmans.length; i++)
        {
            makeDir(pacmans[i],max_X,max_Y);
            canvas.drawBitmap(pacmans[i].getBitmap(), pacmans[i].getxPos(), pacmans[i].getyPos(),null);
        }


        //Redraw bitmap object1





    }

    private void makeDir(Pacman pacman, float max_x,float max_y) {

        if (pacman.getxPos()>= max_x || pacman.getxPos() <= 5)
            pacman.setxDir(pacman.getxDir()*-1);

        if (pacman.getyPos() <= 5 && pacman.getyDir()< 0)
            pacman.setyDir(pacman.getyDir()*-1);

        if (pacman.getyPos() >= max_y + 100 ) {
            pacman.setyPos(-100);
            Result.numNoCatch++;
        }

        if (pacman.getyPos() >= max_y - 50 && pacman.getyPos() < max_y - 50 + pacman.getSpeed() &&
                pacman.getxPos() >= raketXPos - 100 && pacman.getxPos() < raketXPos + 300 ) {
            pacman.setyDir(pacman.getyDir() * -1);
            Result.numCatch++;
        }
    }


    public void move(){

    //    makeDir(pacmans,0);
     //   if (control_X(pacmans))
        for (int i=0 ; i < pacmans.length; i++)
        {
            pacmans[i].setxPos(pacmans[i].getxPos()+ pacmans[i].getxDir()* pacmans[i].getSpeed());
            pacmans[i].setyPos(pacmans[i].getyPos()+ pacmans[i].getyDir()* pacmans[i].getSpeed());
        }

    }






    @Override
    public boolean onTouch(View v, MotionEvent event) {


        //--------------------------------------- Display position by touching canvas
        if (event.getY()>= v.getHeight()-150)
            raketXPos = event.getX();

        return false;
    }
}
