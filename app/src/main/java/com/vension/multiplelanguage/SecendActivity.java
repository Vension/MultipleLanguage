package com.vension.multiplelanguage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RadioGroup;

/**
 * @author ：Created by Administrator on 2018/5/7 10:45.
 * @email：kevin-vension@foxmail.com
 * @desc character determines attitude, attitude determines destiny
 */
public class SecendActivity extends BaseActivity {

	private RadioGroup mRadioGroup;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		mRadioGroup = findViewById(R.id.rg_language);
		int i = PreferenceUtil.getInt("language", 0);
		if (i == 2){
			mRadioGroup.check(R.id.rb_zh_rhk);
		}else if(i == 3){
			mRadioGroup.check(R.id.rb_english);
		}else{
			mRadioGroup.check(R.id.rb_zh_rcn);
		}
		mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup radioGroup, int id) {
				switch (id){
					case R.id.rb_zh_rcn:
						//中文简体
						switchLanguage(1);
						break;
					case R.id.rb_zh_rhk:
						//中文繁体
						switchLanguage(2);
						break;
					case R.id.rb_english:
						//英文
						switchLanguage(3);
						break;
						default:break;
				}
				freshView();
			}
		});
	}

}
