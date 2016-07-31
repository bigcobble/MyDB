package sdx.mydb;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by lsx on 2016/7/31.
 */
public class MyAPP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
