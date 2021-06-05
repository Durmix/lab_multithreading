package edu.iis.mto.multithread;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @Test
    void launchPatriotOnceWhenNoticesAScudMissile() {
        Radar radar = new Radar(batteryMock);
        Scud enemyMissile = new Scud();
        radar.notice(enemyMissile);
        verify(batteryMock).launchPatriot(enemyMissile);
    }

}
