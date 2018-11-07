package sample;

import javafx.concurrent.Task;

public class MyWorker extends Task<Void> {
    @Override
    protected Void call() throws Exception {
        final int max = Integer.MAX_VALUE;
        for (int i = 0; i < max; i++) {
            if (isCancelled()) {
                break;
            }
            updateProgress(i, max / 10);
        }
        return null;
    }
}
