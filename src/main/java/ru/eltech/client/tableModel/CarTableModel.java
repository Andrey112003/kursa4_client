package ru.eltech.client.tableModel;

import ru.eltech.client.api.CarRouter;
import ru.eltech.client.model.Car;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CarTableModel extends AbstractTableModel {
    private final int columnCount = 4;
    private List<String[]> carRecords = new ArrayList<>();
    private final CarRouter router;

    public CarTableModel(CarRouter router){
        this.router = router;
    }

    @Override
    public int getRowCount() {
        return carRecords.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return carRecords.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 -> {return "id";}
            case 1 -> {return "brand";}
            case 2 -> {return "year";}
            case 3 -> {return "price";}
        }

        return "";
    }

    public void addRecord(Car car) {
        carRecords.add(car.toString().split(","));
    }

    public void clearData() {
        carRecords.clear();
    }

    public void setCarsRecords(List<String[]> data) {
        carRecords = new ArrayList<>(data);
    }

    public void updateRecord(Car car) {
        var record = carRecords.stream()
                .filter(item -> String.valueOf(car.getId()).equals(item[0]))
                .findFirst()
                .orElseThrow(RuntimeException::new);

        record[1] = car.getBrand();
        record[2] = String.valueOf(car.getYear());
        record[3] = String.valueOf(car.getPrice());
    }

    public void deleteRecord(int id) {
        var record = carRecords.stream()
                .filter(item -> String.valueOf(id).equals(item[0]))
                .findFirst()
                .orElseThrow();

        carRecords.remove(record);
    }
}
