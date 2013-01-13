package com.elhaso.tutinterruptvideostream;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class HelloInterruptVideoStream extends Activity
{
	private String path = "http://dl.dropbox.com/u/145894/t/rabbits.3gp";
	private VideoView video_view_;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		video_view_ = (VideoView)findViewById(R.id.surface_view);

		getWindow().clearFlags(WindowManager
			.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);

		video_view_.setVideoURI(Uri.parse(path));
		video_view_.setMediaController(new MediaController(this));
		video_view_.requestFocus();
		video_view_.start();
	}
}
