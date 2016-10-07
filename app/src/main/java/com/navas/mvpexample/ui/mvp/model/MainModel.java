package com.navas.mvpexample.ui.mvp.model;


import com.navas.mvpexample.domain.BroadcastExecutor;

public class MainModel {

    static final String NAME_DEFAULT = "Diego";
    private BroadcastExecutor broadcastExecutor;

    public MainModel(BroadcastExecutor broadcastExecutor) {
        this.broadcastExecutor = broadcastExecutor;
    }

    public String getName() {
        return NAME_DEFAULT;
    }

    public void sendBroadcast() {
        broadcastExecutor.sendBroadcast();
    }
}
