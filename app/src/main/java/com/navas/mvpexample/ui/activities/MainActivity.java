package com.navas.mvpexample.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.navas.mvpexample.R;
import com.navas.mvpexample.domain.BroadcastExecutor;
import com.navas.mvpexample.ui.mvp.model.MainModel;
import com.navas.mvpexample.ui.mvp.presenter.MainPresenter;
import com.navas.mvpexample.ui.mvp.view.MainView;
import com.navas.mvpexample.util.BusProvider;

public class MainActivity extends AppCompatActivity {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
    }

    private void initPresenter() {
        presenter = new MainPresenter(new MainModel(new BroadcastExecutor(this)), new MainView(this, BusProvider.getInstance()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.register(presenter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.unregister(presenter);
    }
}
