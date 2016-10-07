package com.navas.mvpexample.ui.mvp.presenter;

import com.navas.mvpexample.ui.mvp.model.MainModel;
import com.navas.mvpexample.ui.mvp.view.MainView;
import com.navas.mvpexample.ui.mvp.view.MainView.BroadcastButtonPrssedEvent;
import com.navas.mvpexample.ui.mvp.view.MainView.DisplayButtonPressedEvent;
import com.squareup.otto.Subscribe;

public class MainPresenter {

    private MainModel model;
    private MainView view;

    public MainPresenter(MainModel model, MainView view) {
        this.model = model;
        this.view = view;
    }

    @Subscribe
    public void onButtonPressed(DisplayButtonPressedEvent event) {
        view.displayName(event.getName());
    }

    @Subscribe
    public void onBroadcastButtonPressed(BroadcastButtonPrssedEvent event) {
        model.sendBroadcast();
    }
}
