package gui;

import code.DigitRecognition;
import code.ImageHelper;
import code.LVQ;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp extends Application {

    private Stage primaryStage;
    boolean prosesClicked = false;
    File selectedFile;
    double[][] detail;

    @FXML TextField imagePath, learningRate;
    @FXML ImageView imageView;
    @FXML Label hasil;
    @FXML Slider epoch;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        primaryStage.setTitle("Digit Recognition Using LVQ");
        showMain();
    }

    private void showMain() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("MainApp.fxml"));
            AnchorPane rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void handleBrowse(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("test"));
        selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null){
            imagePath.setText(selectedFile.getName());
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
        }
    }

    @FXML private void handleProses(){
        if (selectedFile!=null){
            DigitRecognition main = null;
            try {
                main = new DigitRecognition(selectedFile.getAbsolutePath());
            }catch (IOException ex){
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }

            //proses utama
            LVQ lvq = new LVQ(main.angkaDataUji);
            lvq.setData(main.dataUji, main.dataLatih);
            lvq.setLearningRate(Double.parseDouble(learningRate.getText()));
            lvq.setEpoch((int)epoch.getValue());

            lvq.setBobot();
            detail = new double[lvq.epoch+1][13];
            for (int i = 0; i <= lvq.epoch; i++) {
                System.out.print("Epoch ke-" + i);
                lvq.menghitungJarak();
                lvq.terdekat();
                lvq.updateBobot();
                lvq.learningRate = 0.96 * lvq.learningRate;

                detail[i][0] = i;
                detail[i][1] = lvq.learningRate;
                detail[i][2] = lvq.jarak[0];
                detail[i][3] = lvq.jarak[1];
                detail[i][4] = lvq.jarak[2];
                detail[i][5] = lvq.jarak[3];
                detail[i][6] = lvq.jarak[4];
                detail[i][7] = lvq.jarak[5];
                detail[i][8] = lvq.jarak[6];
                detail[i][9] = lvq.jarak[7];
                detail[i][10] = lvq.jarak[8];
                detail[i][11] = lvq.jarak[9];
                detail[i][12] = lvq.hasil;
            }

            hasil.setText(Integer.toString(lvq.hasil));
            prosesClicked = true;
        } else {
            errorMessage(true);
        }
    }

    @FXML private void handleDetail() {
        if (prosesClicked == true) {
            showDetail(detail);
        } else {
            errorMessage(false);
        }
    }

    public void showDetail(double[][] dataDetail) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Detail.fxml"));
            AnchorPane page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Detail");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            Detail controller = loader.getController();
            controller.showDetail(dataDetail);

            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void errorMessage(boolean isProses){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        if (isProses){
            alert.setTitle("Pilih file dahulu");
            alert.setContentText("Pilih file gambar terlebih dahulu");
        } else {
            alert.setTitle("Klik proses dahulu");
            alert.setContentText("Jalankan proses terlebih dahulu");
        }
        alert.showAndWait();
    }
}
