package com.rubberdroid;

import java.util.Random;

import android.app.Activity;
import android.media.MediaPlayer;
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
	private MediaPlayer[] mplayers;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		findViewById(R.id.ask).setOnClickListener(this);
		createMplayers();
	}

	private void createMplayers() {
		mplayers = new MediaPlayer[33];
		int i = 0;
		mplayers[i++] = MediaPlayer.create(this, R.raw.a1);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a2);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a3);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a4);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a5);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a6);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a7);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a8);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a9);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a10);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a11);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a12);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a13);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a14);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a15);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a16);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a17);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a18);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a19);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a20);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a21);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a22);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a23);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a24);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a25);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a26);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a27);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a28);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a29);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a30);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a31);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a32);
		mplayers[i++] = MediaPlayer.create(this, R.raw.a33);
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
		playMsngNo(idx);
		String msg = msgs[idx];
		return msg;
	}

	private void playMsngNo(int idx) {
		mplayers[idx].start();
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
