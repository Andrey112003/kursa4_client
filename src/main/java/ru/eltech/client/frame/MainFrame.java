package ru.eltech.client.frame;

import ru.eltech.client.api.CarRouter;
import ru.eltech.client.panels.CarsPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {

    private final CarRouter carRouter;

    public MainFrame(CarRouter carRouter) throws HeadlessException, IOException {
        super("Patient Record System");
        this.carRouter = carRouter;

        add(new CarsPanel(carRouter), BorderLayout.CENTER);
    }
}
