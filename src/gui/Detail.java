package gui;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Detail {
    @FXML private TableView<double[]> detail;
    @FXML private TableColumn<double[], Double> iterasi, learnRate;
    @FXML private TableColumn<double[], Double> d0, d1, d2, d3, d4, d5, d6, d7, d8, d9;
    @FXML private TableColumn<double[], Double> hasil;

    public void showDetail(double[][] dataArray) {
        ObservableList<double[]> data = FXCollections.observableArrayList();
        for (double[] row : dataArray) {
            data.add(row);
        }

        detail.setItems(data);
        iterasi.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper((int)param.getValue()[0])
        );
        learnRate.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper(round(param.getValue()[1],3))
        );
        d0.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper(round(param.getValue()[2],3))
        );
        d1.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper(round(param.getValue()[3],2))
        );
        d2.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper(round(param.getValue()[4],2))
        );
        d3.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper(round(param.getValue()[5],2))
        );
        d4.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper(round(param.getValue()[6],2))
        );
        d5.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper(round(param.getValue()[7],2))
        );
        d6.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper(round(param.getValue()[8],2))
        );
        d7.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper(round(param.getValue()[9],2))
        );
        d8.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper(round(param.getValue()[10],2))
        );
        d9.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper(round(param.getValue()[11],2))
        );
        hasil.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper((int)param.getValue()[12])
        );
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_EVEN);
        return bd.doubleValue();
    }
}
