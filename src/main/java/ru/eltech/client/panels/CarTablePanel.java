package ru.eltech.client.panels;

import ru.eltech.client.api.CarRouter;
import ru.eltech.client.model.Car;
import ru.eltech.client.tableModel.CarTableModel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class CarTablePanel extends JPanel{
    private final CarRouter router;
    private final CarTableModel ctModel;
    private final JScrollPane scrollPane;
    private final JTable carTable;

    public CarTablePanel(CarRouter router) throws IOException {
        this.router = router;

        ctModel = new CarTableModel(router);
        carTable = new JTable(ctModel);
        scrollPane = new JScrollPane(carTable);

        setLayout(new BorderLayout());

        add(scrollPane, BorderLayout.CENTER);

        update();
    }

    public CarTableModel getCtModel() {
        return ctModel;
    }

    public void update() throws IOException {
        try {
            List<Car> cars =  router.getAllCars();

            if (cars.isEmpty()) {
                return;
            }

            List<String[]> data = cars.stream()
                    .map(Car::toString)
                    .map(record -> record.split(",")).toList();

            ctModel.clearData();
            ctModel.fireTableDataChanged();

            ctModel.setCarsRecords(data);
            ctModel.fireTableDataChanged();
        } catch (IOException ex) {
            System.out.println("get cars error");
        }
    }
}
