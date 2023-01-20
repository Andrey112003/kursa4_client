package ru.eltech.client.panels;

import ru.eltech.client.api.CarRouter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CarsPanel extends JPanel {

    public CarsPanel(CarRouter router) throws IOException {
        setLayout(new BorderLayout());

        JPanel commandPanel = new JPanel();;

        commandPanel.setLayout(new GridLayout(3,1));

        CarTablePanel carTablePanel = new CarTablePanel(router);

        commandPanel.add(new CarCreatePanel(router, carTablePanel));
        commandPanel.add(new CarUpdatePanel(router, carTablePanel));
        commandPanel.add(new CarDeletePanel(router, carTablePanel));

        add(carTablePanel, BorderLayout.CENTER);
        add(commandPanel, BorderLayout.LINE_END);
    }
}
