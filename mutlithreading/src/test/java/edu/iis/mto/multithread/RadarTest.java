package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.concurrent.ExecutorService;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private ExecutorService executorService;

    @Mock
    private PatriotBattery batteryMock;

    @BeforeEach
    void init() {
        doAnswer((Answer<Object>) invocation -> {
            Runnable runnable = invocation.getArgument(0);
            runnable.run();
            return null;
        }).when(executorService).submit(any(Runnable.class));
    }

    @Test
    void launchZeroPatriotWhenNoticesAScudMissile() {
        BetterRadar radar = new BetterRadar(executorService, batteryMock, 0);
        Scud missile = new Scud();
        radar.notice(missile);
        verify(batteryMock, times(0)).launchPatriot(missile);
    }

    @Test
    void launchPatriotOnceWhenNoticesAScudMissile() {
        BetterRadar radar = new BetterRadar(executorService, batteryMock, 1);
        Scud missile = new Scud();
        radar.notice(missile);
        verify(batteryMock, times(1)).launchPatriot(missile);
    }

    @Test
    void launchPatriotTwiceWhenNoticesAScudMissile() {
        BetterRadar radar = new BetterRadar(executorService, batteryMock, 2);
        Scud missile = new Scud();
        radar.notice(missile);
        verify(batteryMock, times(2)).launchPatriot(missile);
    }

    @Test
    void launchPatriotThriceWhenNoticesAScudMissile() {
        BetterRadar radar = new BetterRadar(executorService, batteryMock, 3);
        Scud missile = new Scud();
        radar.notice(missile);
        verify(batteryMock, times(3)).launchPatriot(missile);
    }

    @Test
    void launchPatriotFiveTimesWhenNoticesAScudMissile() {
        BetterRadar radar = new BetterRadar(executorService, batteryMock, 5);
        Scud missile = new Scud();
        radar.notice(missile);
        verify(batteryMock, times(5)).launchPatriot(missile);
    }

}
