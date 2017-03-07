package techprosolution.chatdemo;

import android.app.Application;

/**
 * Created by vishalrandive on 07/03/17.
 */

public class ChatApplication extends Application
{
    private static ChatApplication instance;

    public static ChatApplication getInstance()
    {
        return instance;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        DBManager.init(this);
    }
}
