package com.example.easyprogress;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class LoadingProgress extends LinearLayout {

	LayoutInflater li;
	Kprogress kprogress;
	TextView textview;
	String text;
	private boolean isVisible=false;

	public LoadingProgress(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(context,attrs);
	}

	public LoadingProgress(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init(context,attrs);
	}

	private void init(Context context,AttributeSet attrs) {
		if(attrs!=null)
		{
			TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.LoadingProgress, 0, 0);
		try {
			text = a.getString(R.styleable.LoadingProgress_text);
		} finally {
			a.recycle();
		}}
		if (isInEditMode())
			return;
		li = (LayoutInflater) getContext().getSystemService(
				Service.LAYOUT_INFLATER_SERVICE);
		View view = li.inflate(R.layout.loadingprogress, this, false);
		addView(view);
		kprogress = (Kprogress) view.findViewById(R.id.progress);
		textview = (TextView) view.findViewById(R.id.textView1);
		if(text!=null)
		{
			textview.setText(text);
		}
		hide(); // in the beginning hide it;
	}

	public LoadingProgress(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context,null);
	}

	@Override
	protected void onVisibilityChanged(View changedView, int visibility) {
		// TODO Auto-generated method stub
		super.onVisibilityChanged(changedView, visibility);
		if (visibility == VISIBLE) {
			kprogress.show();
		} else {
			kprogress.hide();
		}

	}

	/**
	 * Shows our loading progress
	 */
	public void show() {
		setVisibility(View.VISIBLE);
		setVisible(true);
	}

	/**
	 * Hides our loading progress
	 */
	public void hide() {
		setVisibility(View.GONE);
		setVisible(false);
	}

	/**Shows loading progress with text
	 * @param text
	 */
	public void show(String text) {
		textview.setText(text);
		show();
	}
	
	/**Show loading progress with text and text color
	 * @param text
	 * @param color textcolor
	 */
	public void show(String text,String color) {
		textview.setText(text);
		textview.setTextColor(Color.parseColor(color));
		show();
}

	/**
	 * @return the isVisible
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/**
	 * @param isVisible the isVisible to set
	 */
	private void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	}
