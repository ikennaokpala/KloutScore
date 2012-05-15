package com.scribe.kloutscore;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.scribe.service.KloutScoreService;

public class KloutScoreActivity extends Activity implements OnClickListener {
	Button button;
	TextView textView;
	String screenName;
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView)findViewById(R.id.scoreText);
        textView.setVisibility(View.INVISIBLE);
        button = (Button)findViewById(R.id.scoreButton);
    	button.setOnClickListener(this);
    }
    
	@Override
	public void onClick(View v) {
		screenName = ((EditText)findViewById(R.id.screenName)).getText().toString();
		String kscore = KloutScoreService.getScore(screenName).toString();
        textView = (TextView)findViewById(R.id.scoreText);
		textView.setText(kscore);
		textView.setVisibility(v.VISIBLE);
	}
	
}