package com.icall.free.activity;

import com.icall.free.R;
import com.icall.free.activity.demo.ThinkAndroidBaseActivity;
import com.icall.free.activity.demo.ThinkAndroidCacheActivtiy;
import com.icall.free.activity.demo.ThinkAndroidDBActivtiy;
import com.icall.free.activity.demo.ThinkAndroidDwonLoadActivtiy;
import com.icall.free.activity.demo.ThinkAndroidHttpActivtiy;
import com.icall.free.activity.demo.ThinkAndroidImageCacheActivtiy;
import com.icall.free.activity.demo.ThinkAndroidMainActivity;
import com.icall.free.activity.demo.ThinkAndroidMultiThreadDwonLoadActivtiy;
import com.icall.free.activity.demo.ThinkAndroidMvcActivtiy;
import com.icall.free.activity.demo.ThinkAndroidOtherActivtiy;
import com.icall.free.activity.demo.ThinkAndroidSimpleDwonLoadActivtiy;
import com.icall.free.activity.demo.ThinkAndroidSimpleTwoDwonLoadActivtiy;
import com.icall.free.command.TestMVCCommand;
import com.icall.free.util.CodeProperties;
import com.ta.TAApplication;
import com.ta.annotation.TAInjectView;
import com.ta.util.cache.TAFileCache;
import com.ta.util.cache.TAFileCache.TACacheParams;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author 白猫
 * @version V1.0
 * @Title: 用户其启动界面
 * @Package com.icall.free.activity
 * @Description: 用户其启动界面时候的一个启动页面完成一些初始化工作
 * @date 2013-5-6
 */
public class SplashActivity extends ThinkAndroidBaseActivity implements View.OnClickListener {
    private static final String SYSTEMCACHE = "thinkandroid";

    @TAInjectView(id = R.id.facebook_register_btn)
    Button facebook_register_btn;
    @TAInjectView(id = R.id.phone_register_btn)
    Button phone_register_btn;

    @Override
    protected void onAfterOnCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onAfterOnCreate(savedInstanceState);
        setContentView(R.layout.splash);
        facebook_register_btn.setOnClickListener(this);
        phone_register_btn.setOnClickListener(this);
//        CodeProperties.generateUrl();
        // TANetworkStateReceiver.registerNetworkStateReceiver(this);
//        final View view = View.inflate(this, R.layout.splash, null);
//        setContentView(view);
//        // 渐变展示启动屏
//        AlphaAnimation aa = new AlphaAnimation(0.5f, 1.0f);
//        aa.setDuration(5000);
//        view.startAnimation(aa);
//        aa.setAnimationListener(new AnimationListener() {
//            @Override
//            public void onAnimationEnd(Animation arg0) {
//                startMain();
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//        });
    }

    @Override
    protected void onPreOnCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onPreOnCreate(savedInstanceState);
        TAApplication application = (TAApplication) getApplication();
        // 配置系统的缓存,可以选择性的配置
        TACacheParams cacheParams = new TACacheParams(this, SYSTEMCACHE);
        TAFileCache fileCache = new TAFileCache(cacheParams);
        application.setFileCache(fileCache);
        // 注册activity
        getTAApplication().registerCommand(R.string.testmvccommand,
                TestMVCCommand.class);
        // 注册activity
        getTAApplication().registerActivity(R.string.thinkandroidmainactivity,
                ThinkAndroidMainActivity.class);
        // 注册activity
        getTAApplication().registerActivity(R.string.thinkandroidcacheactivtiy,
                ThinkAndroidCacheActivtiy.class);
        // 注册activity
        getTAApplication().registerActivity(R.string.thinkandroiddbactivtiy,
                ThinkAndroidDBActivtiy.class);
        // 注册activity
        getTAApplication().registerActivity(
                R.string.thinkandroidimagecacheactivtiy,
                ThinkAndroidImageCacheActivtiy.class);
        // 注册activity
        getTAApplication().registerActivity(R.string.thinkandroidmvcactivtiy,
                ThinkAndroidMvcActivtiy.class);
        // 注册activity
        getTAApplication().registerActivity(R.string.thinkandroidhttpactivtiy,
                ThinkAndroidHttpActivtiy.class);
        // 注册activity
        getTAApplication().registerActivity(
                R.string.thinkandroidsimpledwonloadactivtiy,
                ThinkAndroidSimpleDwonLoadActivtiy.class);
        // 注册activity
        getTAApplication().registerActivity(
                R.string.thinkandroidsimpletwodwonloadactivtiy,
                ThinkAndroidSimpleTwoDwonLoadActivtiy.class);
        // 注册activity
        getTAApplication().registerActivity(R.string.thinkandroiddwonloadactivtiy,
                ThinkAndroidDwonLoadActivtiy.class);
        // 注册activity
        getTAApplication().registerActivity(
                R.string.thinkandroidmultithreaddwonloadactivtiy,
                ThinkAndroidMultiThreadDwonLoadActivtiy.class);

        // 注册activity
        getTAApplication().registerActivity(R.string.thinkandroidotheractivtiy,
                ThinkAndroidOtherActivtiy.class);

        getTAApplication().registerActivity(R.string.faceBookLoginActivity,
                FaceBookLoginActivity.class);
        getTAApplication().registerActivity(R.string.loginActivity,
                LoginActivity.class);
        getTAApplication().registerActivity(R.string.registerActivity,
                RegisterActivity.class);
    }

    private void startMain() {
        // TODO Auto-generated method stu
        doActivity(R.string.loginActivity);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.facebook_register_btn:
                doActivity(R.string.faceBookLoginActivity);
                break;
            case R.id.phone_register_btn:
                doActivity(R.string.thinkandroidhttpactivtiy);
                break;
        }
    }
}
