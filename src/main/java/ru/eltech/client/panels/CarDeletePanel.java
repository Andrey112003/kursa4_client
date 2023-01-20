package ru.eltech.client.panels;

import ru.eltech.client.api.CarRouter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CarDeletePanel extends JPanel {
    public CarDeletePanel(CarRouter router, CarTablePanel carTable) {
        JLabel idLabel = new JLabel("Введите id");
        JTextField idText = new JTextField(30);

        JButton delete = new JButton("Удалить");

        delete.addActionListener(new CarDeleteListener(router, carTable, idText));

        setLayout(new GridLayout(3,1));

        add(idLabel);
        add(idText);

        add(delete);
    }

    private record CarDeleteListener(CarRouter router,
                                        CarTablePanel carTable,
                                        JTextField idText)
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int id = 0;
            if (idText.getText().trim().length() > 0) {
                id = Integer.parseInt(idText.getText().trim());
            }

            try {
                router.deleteCar(id);
                carTable.getCtModel().deleteRecord(id);
                carTable.update();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            finally {
                idText.setText("");
            }
        }
    }
}
