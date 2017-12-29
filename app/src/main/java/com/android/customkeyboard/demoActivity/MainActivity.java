package com.android.customkeyboard.demoActivity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.android.customkeyboard.R;

public class MainActivity extends AppCompatActivity {

    public static void showMainDialog(String title, String message, final TimerDialog mTimerDialog, final Context context) {
        try {
            mTimerDialog.setTitle(title);
            mTimerDialog.setCanceledOnTouchOutside(true);
            mTimerDialog.setMessage(message);
            mTimerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            mTimerDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mTimerDialog.dismiss();
                }
            }, 30000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimerDialog timerDialog = new TimerDialog(MainActivity.this);
        showMainDialog("", "Please Wait...", timerDialog, MainActivity.this);

    }

}
