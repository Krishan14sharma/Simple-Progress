package com.example;

import view.progress.LoadingProgress;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity
{
	LoadingProgress progress,progress1;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        progress=(LoadingProgress)findViewById(R.id.loading);
        progress1=(LoadingProgress)findViewById(R.id.loading1);
        
        progress.show();
        progress1.show();
    }

}
