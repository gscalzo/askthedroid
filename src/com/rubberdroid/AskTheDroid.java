package com.rubberdroid;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Toast;

public class AskTheDroid extends Activity implements OnClickListener,
		AnimationListener {
	private Random rand = new Random();
	private String msgs[] = { "Are you kidding?", "As I see it, yes.",
			"Ask again later.", "Better not tell you now.",
			"Cannot predict now.", "Concentrate and ask again.",
			"Definitely not.", "Don't bet on it.", "Don't count on it.",
			"Forget about it. ", "Go for it!", "I have my doubts.",
			"It is certain.", "It is decidedly so.", "Looking good!",
			"Looks good to me!", "Most likely.", "My reply is no.",
			"My sources say no.", "Outlook good.", "Outlook not so good.",
			"Outlook so so.", "Probably.", "Reply hazy, try again.",
			"Signs point to yes.", "Very doubtful.", "Who knows?",
			"Without a doubt.", "Yes.", "Yes - definitely.",
			"Yes, in due time.", "You may rely on it.",
			"You will have to wait.", };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		View button = findViewById(R.id.ask);
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		animateAndroid();
	}

	private void animateAndroid() {
		View android = findViewById(R.id.android);
		Animation animation = AnimationUtils
				.loadAnimation(this, R.anim.shake_x);
		animation.setAnimationListener(this);
		android.startAnimation(animation);

	}

	private String randomMsg() {
		int idx = rand.nextInt(msgs.length);
		String msg = msgs[idx];
		return msg;
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		showTheAnswer();
	}

	private void showTheAnswer() {
		String msg = randomMsg();
		Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
	}

	@Override
	public void onAnimationStart(Animation animation) {
	}
}
