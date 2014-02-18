package com.example.easyprogress;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class LoadingProgress extends LinearLayout{

	LayoutInflater li;
	public LoadingProgress(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	public LoadingProgress(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init();
	
	}

	private void init() {
		if(isInEditMode())
			return;
		li = (LayoutInflater)getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
	    View view=li.inflate(R.layout.loadingprogress, this, false);
	    addView(view);
	}

	
	public LoadingProgress(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	
	
}
