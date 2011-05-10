package com.elhaso.tutinterruptvideostream;

import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;

public class HelloInterruptVideoStream extends Activity
{
	private String path = "http://dl.dropbox.com/u/145894/t/rabbits.3gp";
	private VideoViewCustom video_view_;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		video_view_ = (VideoViewCustom)findViewById(R.id.surface_view);
		video_view_.setDimensions(200, 200);
		video_view_.getHolder().setFixedSize(200, 200);

		video_view_.setVideoURI(Uri.parse(path));
		video_view_.setMediaController(new MediaController(this));
		video_view_.requestFocus();
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

			video_view_.setDimensions(200, 200);
			video_view_.getHolder().setFixedSize(200, 200);
		} else {
			/*
			getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
				*/

			video_view_.setDimensions(200, 200);
			video_view_.getHolder().setFixedSize(200, 200);
		}
	}
}
