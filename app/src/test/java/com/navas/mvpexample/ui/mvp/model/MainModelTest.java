package com.navas.mvpexample.ui.mvp.model;


import com.navas.mvpexample.domain.BroadcastExecutor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.navas.mvpexample.ui.mvp.model.MainModel.NAME_DEFAULT;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class MainModelTest {

    private MainModel model;

    @Mock
    BroadcastExecutor broadcastExecutor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        model = new MainModel(broadcastExecutor);
    }

    @Test
    public void itShouldReturnName() {
        assertEquals(NAME_DEFAULT, model.getName());
    }

    @Test
    public void itShouldSendBroadcast() {
        model.sendBroadcast();
        verify(broadcastExecutor).sendBroadcast();
    }
}
