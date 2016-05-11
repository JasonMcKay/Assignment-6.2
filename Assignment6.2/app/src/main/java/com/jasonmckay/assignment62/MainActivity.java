package com.jasonmckay.assignment62;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jasonmckay.assignment62.services.ManufacturingService;
import com.jasonmckay.assignment62.services.ManufacturingService.*;

public class MainActivity extends AppCompatActivity {

    ManufacturingService myCountService;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ManufacturingService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection myConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            MyLocalBinder binder = (MyLocalBinder) service;
            myCountService = binder.getService();
            isBound = true;
            System.out.println("Service started: " + isBound);
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            isBound = false;
            System.out.println("Service finished: " + isBound);
        }
    };

    public void clickButton(View view) {
        int vehicleAmount = myCountService.getVehicleAmount();
        System.out.println("***************" + vehicleAmount + "********************");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isBound)
        {
            unbindService(myConnection);
            isBound = false;
            System.out.println("Service finished: " + isBound);
        }
    }
}
