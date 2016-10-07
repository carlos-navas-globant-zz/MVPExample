package com.navas.mvpexample.domain;

import android.content.Intent;


import org.assertj.android.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.navas.mvpexample.domain.BroadcastExecutor.ACTION_NAME;
import static com.navas.mvpexample.domain.BroadcastExecutor.EXTRA_NAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
public class BroadcastExecutorTest {

        @Test
        public void itShouldBroadcastActiveCamera() throws Exception {
            new BroadcastExecutor(RuntimeEnvironment.application).sendBroadcast();
            List<Intent> intents = shadowOf(RuntimeEnvironment.application).getBroadcastIntents();
            assertThat(intents).hasSize(1);
            Intent intent = intents.get(0);
            Assertions.assertThat(intent)
                      .hasAction(ACTION_NAME)
                      .hasExtra(EXTRA_NAME);
        }
}
