package com.beck.paintdemo;

import java.lang.reflect.Field;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class MainActivity extends Activity {
     float x;
     float y;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * HACK:  Show the overflow dots on devices
         * that have a menu button
         */
           try {
               ViewConfiguration config = ViewConfiguration.get(this);
               Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
               if(menuKeyField != null) {
                   menuKeyField.setAccessible(true);
                   menuKeyField.setBoolean(config, false);
               }
           } catch (Exception ex) {
               // Ignore
           }
           
           /*
            * END OVERFLOW HACK
            *
            */
    }
    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
      
        x = e.getX();
        y = e.getY();
        
             return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
