package com.navas.mvpexample.ui.mvp.presenter;


import com.navas.mvpexample.ui.mvp.model.MainModel;
import com.navas.mvpexample.ui.mvp.view.MainView;
import com.navas.mvpexample.ui.mvp.view.MainView.BroadcastButtonPrssedEvent;
import com.navas.mvpexample.ui.mvp.view.MainView.DoneButtonPressedEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainPresenterTest {

    private MainPresenter presenter;
    @Mock
    MainModel model;

    @Mock
    MainView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter(model, view);
    }

    @Test
    public void itShouldDisplayName() {
        when(model.getName()).thenReturn("sarasa");
        presenter.onButtonPressed(new DoneButtonPressedEvent());
        verify(view).displayName(model.getName());
    }

    @Test
    public void itShouldSendBroadcast() {
        presenter.onBroadcastButtonPressed(new BroadcastButtonPrssedEvent());
        verify(model).sendBroadcast();
    }
}
