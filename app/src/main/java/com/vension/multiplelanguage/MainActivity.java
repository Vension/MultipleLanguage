package com.vension.multiplelanguage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity{

	private TextView textShow;
	private Button btnSetting;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textShow = findViewById(R.id.text);
		btnSetting = findViewById(R.id.btn_setting);
		textShow.setText(getString(R.string.showtext));
		btnSetting.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent it = new Intent(MainActivity.this, SecendActivity.class);
				startActivity(it);
			}
		});

	}


}
