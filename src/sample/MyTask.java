package sample;

import javafx.concurrent.Task;
import javafx.scene.image.ImageView;

import java.util.concurrent.TimeUnit;

public class MyTask extends Task {
    ImageView selectedImage;
    boolean direction = true;
    int x = 0;

    public MyTask(ImageView selectedImage) {
        this.selectedImage = selectedImage;
    }

    @Override
    protected Object call() throws Exception {
        boolean b = true;
        while(b) {
            if (direction) {
                for (int i = 0; i < 3; i++) {
                    x+=20;
                    selectedImage.setX(x);
                    TimeUnit.SECONDS.sleep(1);
                }
                direction = !direction;
            } else {
                for (int i = 0; i < 3; i++) {
                    x-=20;
                    selectedImage.setX(x);
                    TimeUnit.SECONDS.sleep(1);
                }
                direction = !direction;
            }
        }
        return null;
    }
}
