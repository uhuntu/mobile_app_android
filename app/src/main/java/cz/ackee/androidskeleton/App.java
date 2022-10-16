package cz.ackee.androidskeleton;

import android.app.Application;

import de.greenrobot.event.EventBus;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

/**
 * Application class for this application
 * Created by david.bilik@ackee.cz on 26. 6. 2014.
 */
public class App extends Application {

    public static final String PACKAGE_NAME = BuildConfig.APPLICATION_ID;

    private static App sInstance;
    private EventBus mEventBus;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mEventBus = new EventBus();
        initCalligraphy();
    }

    private void initCalligraphy() {
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("font/Roboto-Regular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
        //....
    }

    public static App getInstance() {
        return sInstance;
    }


    public EventBus getEventBus() {
        return mEventBus;
    }
}
