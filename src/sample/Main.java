package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import static javafx.geometry.Pos.CENTER;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        BorderPane root = new BorderPane();
        primaryStage.setTitle("Hello World");
        GridPane root = new GridPane();

        try {
            MyWorker w = new MyWorker();
            ProgressBar bar = new ProgressBar();
            bar.progressProperty().bind(w.progressProperty());
            new Thread(w).start();
            Label lname = new Label("Login");
            Label lpass = new Label("Password");
            TextField txName = new TextField("Admin");
            PasswordField txPass = new PasswordField();

            Button button = new Button("Login");
            Button buttonCancel = new Button("Cancel");

            HBox hb = new HBox();
            hb.setAlignment(Pos.CENTER_RIGHT);
            hb.getChildren().add(button);
            root.setAlignment(CENTER);
            root.setVgap(10);
            root.setHgap(10);
            root.add(lname, 0, 0);
            root.add(lpass, 0, 1);
            root.add(txName, 1, 0);
            root.add(txPass, 1, 1);
            root.add(hb, 1, 2);
            root.add(bar,0,2);
            root.add(buttonCancel,0,3);

            buttonCancel.setOnAction((event) -> w.cancel());

            button.setOnAction((event) -> {
                if (txName.getText().equals("Admin") && txPass.getText().equals("123")) {
                    System.out.println("Access granted");
                    switchForm();
                } else {
                    System.out.println("Access denied");
                }
            });

            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void switchForm() {
        BorderPane root = new BorderPane();
        Label l = new Label("OK");
        root.setCenter(l);
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
