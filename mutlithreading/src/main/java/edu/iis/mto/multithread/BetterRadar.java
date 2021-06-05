package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;

public class BetterRadar {

    private final int MISSILE_COUNT;

    private ExecutorService executorService;
    private PatriotBattery patriotBattery;

    public BetterRadar(ExecutorService executorService, PatriotBattery patriotBattery, int missileCount) {
        this.executorService = executorService;
        this.patriotBattery = patriotBattery;
        this.MISSILE_COUNT = missileCount;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile, MISSILE_COUNT);
    }

    private void launchPatriot(Scud enemyMissile, int missileCount) {
        Runnable launchPatriots = () -> {
            for(int i = 0; i < missileCount; i++) {
                patriotBattery.launchPatriot(enemyMissile);
            }
        };
        executorService.submit(launchPatriots);
    }

}
