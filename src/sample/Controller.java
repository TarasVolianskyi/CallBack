package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class Controller {


    public TextField txtFldURL;

    public Label lbRes;

    private interface CallBack {
        public void call();
    }

    CallBack callBack = new CallBack() {
        @Override
        public void call() {
            showAlert("finished!");
        }
    };

    public void getStart(ActionEvent actionEvent) {
        //  lbRes.setText(txtFldURL.getText());
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String comUrl = "wget http://62.138.0.84/downloads/Th3-Gr32t-G2tsby-2013-720p-hdp0pc0rns.mp4?st=s8AvxRCX-hOXMA_4MD8zYw&e=1506256110";
                // String secCommand = new RunTimeManager(comUrl).executeComand();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                callBack.call();
            }
        });
        myThread.start();
        String command = new RunTimeManager("pwd").executeComand();
        lbRes.setText("you download file into " + command + "path");

    }

    public void getAlert(ActionEvent actionEvent) {
        showAlert("adsawd");
    }

    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }
}
