package com.android.customkeyboard.customKeyboard;

import android.content.Context;
import android.support.annotation.IdRes;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.android.customkeyboard.R;

import es.dmoral.toasty.Toasty;


/**
 * Created by decimal on 2017-11-07.
 */

public class KeyboardViewDemo extends FrameLayout implements View.OnClickListener {

    private PinEntryEditText mPasswordField;


    public KeyboardViewDemo(Context context) {
        super(context);
        init();
    }

    public KeyboardViewDemo(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KeyboardViewDemo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.one_time_pwd, this);
        initViews();
    }

    private void initViews() {
        mPasswordField = $(R.id.password_field);
        $(R.id.t9_key_0).setOnClickListener(this);
        $(R.id.t9_key_1).setOnClickListener(this);
        $(R.id.t9_key_2).setOnClickListener(this);
        $(R.id.t9_key_3).setOnClickListener(this);
        $(R.id.t9_key_4).setOnClickListener(this);
        $(R.id.t9_key_5).setOnClickListener(this);
        $(R.id.t9_key_6).setOnClickListener(this);
        $(R.id.t9_key_7).setOnClickListener(this);
        $(R.id.t9_key_8).setOnClickListener(this);
        $(R.id.t9_key_9).setOnClickListener(this);
        $(R.id.t9_key_clear).setOnClickListener(this);
        $(R.id.t9_key_backspace).setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        // handle number button click
        if ("number_button".equals(v.getTag())) {
            mPasswordField.append(((TextView) v).getText());
            getInputText(v);
            return;
        }
        switch (v.getId()) {
            case R.id.t9_key_clear: { // handle clear button
                mPasswordField.setText(null);
            }
            break;
            case R.id.t9_key_backspace: { // handle backspace button
                // delete one character
                Editable editable = mPasswordField.getText();
                int charCount = editable.length();
                if (charCount > 0) {
                    editable.delete(charCount - 1, charCount);
                }
            }
            break;
        }

    }

    public String getInputText(View view) {

        if (mPasswordField.length() == 6 && mPasswordField.length() < 7) {
            Log.e("otp", mPasswordField.getText().toString() + "");
            Toasty.success(getContext(), "OTP IS : " + mPasswordField.getText().toString(), Toast.LENGTH_SHORT, true).show();

            //perform any action like server hit which link to otp ..you can do here...

        }
        return mPasswordField.getText().toString();

    }


    protected <T extends View> T $(@IdRes int id) {
        return (T) super.findViewById(id);
    }
}