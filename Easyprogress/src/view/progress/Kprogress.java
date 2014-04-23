package view.progress;

import com.example.easyprogress.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Provide an drawable in src then simply show and hide.Itself determines
 * whether it is an animation drawable or simple drawable. It will automatically
 * provide rotation animation for simple drawable. And for animation drawable it
 * will automatically hide and show the animation defined in the resource file.
 * 
 * @author KRISHAN
 */
public class Kprogress extends ImageView {

	AnimationDrawable ani;
	Animation rotation;

	private int mode = 0;
	private final int ANIM = 0;
	private final int ROTATE = 1;
	Context cont;

	public Kprogress(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public Kprogress(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub

		init(context);

	}

	private void init(Context context) {
		cont = context;
		if (isInEditMode())
			return;
		// looks for animation drawable first
		try {
			ani = (AnimationDrawable) getDrawable();
			if (ani.getNumberOfFrames() > 1) {
				mode = ANIM;
			} else {
				mode = ROTATE;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mode = ROTATE;
			rotation = AnimationUtils.loadAnimation(context, R.anim.spin);
		}
	}

	public Kprogress(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
		init(context);
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

	/**
	 * Shows easyprogress wheel
	 */
	public void show() {
		setVisibility(View.VISIBLE);
	}

	/**
	 * Hides easyprogress wheel
	 */
	public void hide() {
		setVisibility(View.GONE);
	}

	public void setDrawable(int id) {
		setImageResource(id);
		init(cont);
	}
}
