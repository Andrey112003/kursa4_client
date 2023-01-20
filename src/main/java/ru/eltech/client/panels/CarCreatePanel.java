package ru.eltech.client.panels;

import ru.eltech.client.api.CarRouter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CarCreatePanel extends JPanel {
    public CarCreatePanel(CarRouter router, CarTablePanel carTable) {
        JLabel brandLabel = new JLabel("Введите бренд");
        JTextField brandText = new JTextField(30);
        JLabel yearLabel = new JLabel("Введите год выпуска");
        JTextField yearText = new JTextField(30);
        JLabel priceLabel = new JLabel("Введите стоимость");
        JTextField priceText = new JTextField(30);

        JButton send = new JButton("Добавить");
        send.addActionListener(new CarCreateListener(router, carTable, brandText, yearText, priceText));

        setLayout(new GridLayout(7,1));

        add(brandLabel);
        add(brandText);

        add(yearLabel);
        add(yearText);

        add(priceLabel);
        add(priceText);

        add(send);
    }

    private record CarCreateListener(CarRouter router,
                                     CarTablePanel carTable,
                                     JTextField brandText,
                                     JTextField yearText,
                                     JTextField priceText)
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String brand = brandText.getText().trim();

            int year = 0;
            if (yearText.getText().trim().length() > 0) {
                year = Integer.parseInt(yearText.getText().trim());
            }

            int price = 0;
            if (priceText.getText().trim().length() > 0) {
                price = Integer.parseInt(priceText.getText().trim());
            }

            try {
                carTable.getCtModel().addRecord(router.createCar(brand, year, price));
                carTable.update();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            finally {
                brandText.setText("");
                yearText.setText("");
                priceText.setText("");
            }
        }
    }
}
