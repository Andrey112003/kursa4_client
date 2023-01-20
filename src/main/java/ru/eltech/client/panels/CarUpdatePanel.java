package ru.eltech.client.panels;

import ru.eltech.client.api.CarRouter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CarUpdatePanel extends JPanel {
    public CarUpdatePanel(CarRouter router, CarTablePanel carTable) {
        JLabel idLabel = new JLabel("Введите id");
        JTextField idText = new JTextField(30);
        JLabel brandLabel = new JLabel("Введите бренд");
        JTextField brandText = new JTextField(30);
        JLabel yearLabel = new JLabel("Введите год выпуска");
        JTextField yearText = new JTextField(30);
        JLabel priceLabel = new JLabel("Введите стоимость");
        JTextField priceText = new JTextField(30);

        JButton edit = new JButton("Изменить");
        edit.addActionListener(new CarUpdateListener(router, carTable, idText, brandText, yearText, priceText));

        setLayout(new GridLayout(9,1));

        add(idLabel);
        add(idText);

        add(brandLabel);
        add(brandText);

        add(yearLabel);
        add(yearText);

        add(priceLabel);
        add(priceText);

        add(edit);
    }

    private record CarUpdateListener(   CarRouter router,
                                        CarTablePanel carTable,
                                        JTextField idText,
                                        JTextField brandText,
                                        JTextField yearText,
                                        JTextField priceText)
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int id = 0;
            if (idText.getText().trim().length() > 0) {
                id = Integer.parseInt(idText.getText().trim());
            }

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
                carTable.getCtModel().updateRecord(router.updateCar(id, brand, year, price));
                carTable.update();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException(ex);
            }
            finally {
                idText.setText("");
                brandText.setText("");
                yearText.setText("");
                priceText.setText("");
            }
        }
    }
}
