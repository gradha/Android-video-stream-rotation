package com.elhaso.tutinterruptvideostream;

import android.app.Activity;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.MediaController;

public class HelloInterruptVideoStream extends Activity
	implements OnPreparedListener, OnVideoSizeChangedListener
{
	// You might need to put here another URL for the example to work.
	private String path = "http://dl.dropbox.com/u/145894/t/rabbits.3gp";

	private final String TAG = "HelloInterruptVideoStream";
	private VideoViewCustom video_view;
	private int screen_width, screen_height;
	private int media_width, media_height;
	private boolean landscape;

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

		// Get the size of the device, will be our maximum.
		Display display = getWindowManager().getDefaultDisplay();
		screen_width = display.getWidth();
		screen_height = display.getHeight();

		video_view = (VideoViewCustom)findViewById(R.id.surface_view);
		video_view.setOnPreparedListener(this);
		resize();

		video_view.setVideoURI(Uri.parse(path));
		video_view.setMediaController(new MediaController(this));
		video_view.requestFocus();
	}

	/** The user rotated the screen.
	 * Since we specified in the AndroidManifest.xml that we want to handle our
	 * own orientation changes, we resize the screen in function of being
	 * portrait or landscape.
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);

		landscape =
			(Configuration.ORIENTATION_LANDSCAPE == newConfig.orientation);
		resize();
	}

	/** Resizes the surfaces to fill the screen.
	 * If the media_width and media_height variables are zero, that means we
	 * don't know yet the size of the video, so we just resize to fill the
	 * whole screen. Otherwise we scale maintaining the aspect ratio to fill
	 * it. The gravity of the layout leaves us centered.
	 */
	public void resize()
	{
		int w = landscape ? screen_height : screen_width;
		int h = landscape ? screen_width : screen_height;

		// If we have the media, calculate best scaling inside bounds.
		if (media_width > 0 && media_height > 0) {
			final float max_w = w;
			final float max_h = h;
			float temp_w = media_width;
			float temp_h = media_height;
			float factor = max_w / temp_w;
			temp_w *= factor;
			temp_h *= factor;

			// If we went above the height limit, scale down.
			if (temp_h > max_h) {
				factor = max_h / temp_h;
				temp_w *= factor;
				temp_h *= factor;
			}

			w = (int)temp_w;
			h = (int)temp_h;
		}
		video_view.setDimensions(w, h);
		video_view.getHolder().setFixedSize(w, h);
	}

	/** The media player is prepared.
	 * Sometimes the media player doesn't have yet the sizes of the video. If
	 * that is the case, register a video size change listener, otherwise
	 * resize ourselves and start the video.
	 */
	public void onPrepared(MediaPlayer mp)
	{
		media_width = mp.getVideoWidth();
		media_height = mp.getVideoHeight();
		Log.i(TAG, "onPrepared " + media_width + "x" + media_height);

		if (media_width > 0 && media_height > 0) {
			// We got a size, resize and start the video.
			resize();
			video_view.start();
		} else {
			// Yuck, no sizes yet? Register a callback.
			mp.setOnVideoSizeChangedListener(this);
		}
	}

	/** Called when the media player knows the video size.
	 * We use this to store the size of the media and start the video, then
	 * remove the listener since the media won't change size.
	 */
	@Override
	public void onVideoSizeChanged(MediaPlayer mp, int width, int height)
	{
		media_width = width;
		media_height = height;
		Log.i(TAG, "onVideoSizeChanged " + media_width + "x" + media_height);

		if (media_width > 0 && media_height > 0) {
			resize();
			video_view.start();
			mp.setOnVideoSizeChangedListener(null);
		}
	}
}
