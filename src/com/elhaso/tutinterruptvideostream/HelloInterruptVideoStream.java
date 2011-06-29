package com.elhaso.tutinterruptvideostream;

import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.MediaController;

public class HelloInterruptVideoStream extends Activity
{
	private String path = "http://dl.dropbox.com/u/145894/t/rabbits.3gp";
	private VideoViewCustom video_view_;
	private int screen_width, screen_height;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		getWindow().clearFlags(WindowManager
			.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);

		Display display = getWindowManager().getDefaultDisplay();
		screen_width = display.getWidth();
		screen_height = display.getHeight();
		//screen_width = screen_height = 200;

		video_view_ = (VideoViewCustom)findViewById(R.id.surface_view);
		video_view_.setDimensions(screen_width, screen_height);
		video_view_.getHolder().setFixedSize(screen_width, screen_height);

		video_view_.setVideoURI(Uri.parse(path));
		video_view_.setMediaController(new MediaController(this));
		video_view_.requestFocus();
		video_view_.start();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);

		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			/*
			getWindow().clearFlags(WindowManager
				.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
				*/

			//Log.i("", "Setting dimension to " + screen_height + "x" + screen_width);
			video_view_.setDimensions(screen_height, screen_width);
			video_view_.getHolder().setFixedSize(screen_height, screen_width);
		} else {
			/*
			getWindow().clearFlags(WindowManager
				.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
				*/

			//Log.i("", "Setting dimension to " + screen_width + "x" + screen_height);
			video_view_.setDimensions(screen_width, screen_height);
			video_view_.getHolder().setFixedSize(screen_width, screen_height);
		}
	}
}
