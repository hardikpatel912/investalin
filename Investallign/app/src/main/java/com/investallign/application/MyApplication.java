package com.investallign.application;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.investallign.R;
import com.investallign.managers.investallign.InvestallignManager;
import com.investallign.utils.UtilityManager;


public class MyApplication extends Application {
    private static Context context;
    static String tag = "MyApplication";
    private static ProgressDialog pd;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
        loadManagers();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }

    public void loadManagers() {
        // Load Managers

        InvestallignManager investallignManager = InvestallignManager.getInstance();
        investallignManager.init();

        UtilityManager utilityManager = UtilityManager.getInstance();
        utilityManager.init(getApplicationContext());
    }

    // Show Toast For Whole Application
    public static void showMsg(String msg, Context context) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void showProgressDialog(Context context1) {
        pd = ProgressDialog.show(context1, null, "", true);
        pd.setContentView(R.layout.dialog_progress);
        Window window = pd.getWindow();
        pd.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    public static void dismissProgressDialog() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }
}
