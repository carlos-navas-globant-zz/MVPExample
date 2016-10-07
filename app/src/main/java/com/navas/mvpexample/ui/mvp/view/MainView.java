package com.navas.mvpexample.ui.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.navas.mvpexample.R;
import com.squareup.otto.Bus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainView extends ActivityView {

    private Bus bus;

    @Bind(R.id.editText)
    EditText txtName;

    public MainView(Activity activity, Bus bus) {
        super(activity);
        this.bus = bus;
        ButterKnife.bind(this, activity);
    }

    @OnClick(R.id.btn_display_name)
    void onButtonDisplayPressed() {
        String name = txtName.getText().toString();
        if (!TextUtils.isEmpty(name)) {
            bus.post(new DisplayButtonPressedEvent(name));
        }
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

    public static final class DisplayButtonPressedEvent {
        private String name;

        public DisplayButtonPressedEvent(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static final class BroadcastButtonPrssedEvent {}
}
