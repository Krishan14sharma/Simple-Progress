package com.example.easyprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 *  Provide an animation drawable in src then simply show and hide.
 *  For animation drawable use anim mode and for rotation use rotate mode.
 * @author KRISHAN 
 */
public class Kprogress extends ImageView {
	AnimationDrawable ani;
	Animation rotation;
	private static int mode = 0;
	private static final int ANIM = 0;
	private static final int ROTATE = 1;

	public Kprogress(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub

	}

	public Kprogress(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
				R.styleable.Kprogress, 0, 0);
		try {
			mode = a.getInteger(R.styleable.Kprogress_mode, 0);
		} finally {
			a.recycle();
		}
		if (mode == ANIM) {
			if (getDrawable() != null) {
				ani = (AnimationDrawable) getDrawable();
			}
		} else {
			rotation = AnimationUtils.loadAnimation(context, R.anim.spin);
		}

	}

	public Kprogress(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onVisibilityChanged(View changedView, int visibility) {
		// TODO Auto-generated method stub
		super.onVisibilityChanged(changedView, visibility);
		if (mode == ANIM) {
			toggle_anim_visibility(visibility);
		} else {
			if (visibility == VISIBLE) {
				startAnimation(rotation);
			} else {
				clearAnimation();
			}
		}
	}

	/**
	 * @param visibility
	 */
	private void toggle_anim_visibility(int visibility) {
		if (ani != null) {
			if (visibility == VISIBLE) {
				ani.start();
			} else {
				ani.stop();
			}
		}
	}

}
