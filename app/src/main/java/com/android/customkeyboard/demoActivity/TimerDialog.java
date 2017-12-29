package com.android.customkeyboard.demoActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.customkeyboard.R;


public class TimerDialog extends Dialog {
    // Button okButton;
    Context mContext;
    TextView mTitle = null, textViewCount;
    TextView mMessage = null;
    View v = null;
    ProgressBar progressBar;
    CountDownTimer countDownTimer;
    long timeInMillis;
    private TimerDialog mTimerDialog;


    public TimerDialog(Context context) {
        super(context);
        mContext = context;

        setContentView(R.layout.timer);
        mTitle = findViewById(R.id.dialogTitle);
        mMessage = findViewById(R.id.dialogMessage);
        progressBar = findViewById(R.id.progressBar);
        textViewCount = findViewById(R.id.textViewCount);

        start();

    }

    public TimerDialog(Context context, int theme_black_noTitleBar_fullscreen) {
        super(context);
        mContext = context;
    }


    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        mTitle.setText(title);
    }

    @Override
    public void setTitle(int titleId) {
        super.setTitle(titleId);
        mTitle.setText(mContext.getResources().getString(titleId));
    }

    public void setMessage(CharSequence message) {
        mMessage.setText(message);
        mMessage.setMovementMethod(ScrollingMovementMethod.getInstance());
        mMessage.setScrollContainer(true);
    }

    public void setMessage(int messageId) {
        mMessage.setText(mContext.getResources().getString(messageId));
        mMessage.setMovementMethod(ScrollingMovementMethod.getInstance());
        mMessage.setScrollContainer(true);
    }

    private void start() {
        long timeInput = Long.parseLong("30") * 1000;
        timeInMillis = timeInput;
        progressBar.setMax((int) timeInMillis / 1000);
        countDownTimer = new CountDownTimer(timeInMillis, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewCount.setText("" + String.valueOf(Math.round(millisUntilFinished * 0.001f)));
                progressBar.setProgress(Math.round(millisUntilFinished * 0.001f));
            }

            @Override
            public void onFinish() {
                stop();
            }
        }.start();
        countDownTimer.start();

    }

    private void stop() {
        countDownTimer.cancel();

    }
}