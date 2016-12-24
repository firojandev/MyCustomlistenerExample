package com.onlineicttutor.mycustomlistenerexample.utility;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.onlineicttutor.mycustomlistenerexample.mylisteners.OnUseremailAvailableListener;

/**
 * Created by alfiroj on 12/24/16.
 */
public class CheckUseremailEditText extends EditText implements View.OnKeyListener {

    OnUseremailAvailableListener onUseremailAvailableListener = null;

    final private static String[] existUsers = new String[] {
            "firoj.andev@gmail.com",
            "eva.firoj@gmail.com",
            "demo@gmail.com",
            "firoj@yahoo.com",
            "kamal@yahoo.com"
    };

    public CheckUseremailEditText(Context context) {
        super(context);
        this.setOnKeyListener(this);
    }

    public CheckUseremailEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setOnKeyListener(this);
    }

    public CheckUseremailEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnKeyListener(this);
    }

    public void setOnUseremailAvailableListener(OnUseremailAvailableListener listener) {
        onUseremailAvailableListener = listener;
    }

    private void OnUserChecked(String useremail, boolean available){
        if(onUseremailAvailableListener!=null) {
            if(!TextUtils.isEmpty(useremail)){
                onUseremailAvailableListener.onAvailableChecked(useremail, available);
            }
        }
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(event.getAction()==KeyEvent.ACTION_DOWN)
            return false;

        boolean available = true;

        String useremail = getText().toString().toLowerCase();

        Log.e("useremail"," useremail here-->"+useremail);

        if(!TextUtils.isEmpty(useremail)){
            for(int i=0; i<existUsers.length; i++) {
                if(existUsers[i].equals(useremail)){
                    available = false;
                    Log.e("check user 1"," 1 here-->"+available);
                    break;
                }
            }
            OnUserChecked(useremail, available);
            return false;
        }
        return false;
    }
}
