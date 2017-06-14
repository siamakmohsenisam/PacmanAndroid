package com.example.siamakmohsenisam.project_2;

import android.util.Log;

/**
 * Created by masoud on 2017-05-24.
 */

public class Animation implements Runnable {


    CustomView customView;
    Thread thread =null;

    //Set a reference to target view
    public Animation(CustomView customView) {
        this.customView = customView;
    }


    //Implement run method to run customView.move() on target view and redraw it in a separate thread
    @Override
    public void run() {

        while (thread != null){
            customView.move();

            //redraw the canvas, to clean animated object in old position and redraw it in new position
            customView.postInvalidate();
            try {
                thread.sleep(100);
            } catch (InterruptedException e) {
                Log.d("ANIMATION", e.getMessage());
            }
        }
    }


    public void start(){

        if (thread == null)
        {
            thread = new Thread(this);
            thread.start();
        }

    }

    public void stop(){
        thread = null;
    }

}
