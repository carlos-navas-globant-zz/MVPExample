package com.navas.mvpexample.domain;

import android.content.Context;
import android.content.Intent;

public class BroadcastExecutor {

    static final String EXTRA_NAME = "com.navas.mvpexample.extra_name";
    static final String ACTION_NAME = "com.navas.mvpexample.action.ACTION_NAME";
    private Context context;

    public BroadcastExecutor(Context context) {
        this.context = context;
    }

    public void sendBroadcast() {
        context.sendBroadcast(new Intent().setAction(ACTION_NAME).putExtra(EXTRA_NAME, "Android"));
    }
}
