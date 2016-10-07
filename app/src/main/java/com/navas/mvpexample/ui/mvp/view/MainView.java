package com.navas.mvpexample.ui.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import android.widget.Toast;

import com.navas.mvpexample.R;
import com.squareup.otto.Bus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainView extends ActivityView {

    private Bus bus;

    @Bind(R.id.button)
    Button doneButton;

    public MainView(Activity activity, Bus bus) {
        super(activity);
        this.bus = bus;
        ButterKnife.bind(this, activity);
    }

    @OnClick(R.id.button)
    void onClick() {
        bus.post(new DoneButtonPressedEvent());
    }

    @OnClick(R.id.btn_send_broadcast)
    void onBroadcastButtonPressed() {
        bus.post(new BroadcastButtonPrssedEvent());
    }

    public void displayName(String name) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Toast.makeText(context, "Your name is " + name, Toast.LENGTH_LONG).show();
    }

    public static final class DoneButtonPressedEvent {}

    public static final class BroadcastButtonPrssedEvent {}
}
