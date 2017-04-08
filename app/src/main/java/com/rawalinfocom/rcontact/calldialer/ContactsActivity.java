package com.rawalinfocom.rcontact.calldialer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;

import com.rawalinfocom.rcontact.R;
import com.rawalinfocom.rcontact.calldialer.transition.ScaleTransition;

/**
 * Created by kevingrant on 3/26/15.
 */
public class ContactsActivity extends Activity {

	View mOpenDialerBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);

		mOpenDialerBtn = findViewById(R.id.num_pad_btn);
		mOpenDialerBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ContactsActivity.this, DialerActivity.class);
				ActivityOptions options = null;
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					options = ActivityOptions.makeSceneTransitionAnimation(ContactsActivity.this);
				}
				startActivity(intent, options.toBundle());
			}
		});

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			// First time in this activity
			getWindow().setEnterTransition(makeExitTransition(false));
			// Leaving this activity
			getWindow().setExitTransition(makeExitTransition(false));
			// Resuming from another activity
			getWindow().setReenterTransition(makeExitTransition(true));
			// This activity is preparing to close
			getWindow().setReturnTransition(makeExitTransition(false));
		}


	}

	@SuppressLint("NewApi")
	private Transition makeExitTransition(boolean reentering) {
		TransitionSet transition = new TransitionSet();

		if (reentering) {
			getWindow().setAllowReturnTransitionOverlap(false);
		} else {
			getWindow().setAllowReturnTransitionOverlap(true);
		}

		Transition scaleTransition = new ScaleTransition();
		scaleTransition.addTarget(mOpenDialerBtn);
		transition.addTransition(scaleTransition);

		return transition;
	}
}
