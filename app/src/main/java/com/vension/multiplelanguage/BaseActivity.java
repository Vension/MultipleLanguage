package com.vension.multiplelanguage;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.Locale;

/**
 * @author ：Created by Administrator on 2018/5/7 11:14.
 * @email：kevin-vension@foxmail.com
 * @desc character determines attitude, attitude determines destiny
 */
public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 初始化PreferenceUtil
		PreferenceUtil.init(this);
		// 根据上次的语言设置，重新设置语言
		switchLanguage(PreferenceUtil.getInt("language", 0));
	}



	/**
	 * 切换语言
	 * @param languageType
	 */
	protected void switchLanguage(int languageType){
		Resources resources = getResources();//获得res资源对象
		Configuration config = resources.getConfiguration();//获得设置对象
		DisplayMetrics dm = resources.getDisplayMetrics();//获得屏幕参数：主要是分辨率，像素等。
		switch (languageType) {
			case 0:
				config.locale = Locale.getDefault();       //系统默认语言
				break;
			case 1:
				config.locale = Locale.SIMPLIFIED_CHINESE; //简体中文
				break;
			case 2:
				config.locale = Locale.TAIWAN;             //繁体中文
				break;
			case 3:
				config.locale = Locale.ENGLISH;            //英文
				break;
			default:
				config.locale = Locale.SIMPLIFIED_CHINESE;
				break;
		}
		String language = config.locale.getLanguage();
		Log.i("当前语言————————>",language);
		resources.updateConfiguration(config, dm);
		// 保存设置语言的类型
		PreferenceUtil.commitInt("language", languageType);
	}


	protected void freshView(){
		Intent intent = new Intent(this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		startActivity(intent);
	}

}
