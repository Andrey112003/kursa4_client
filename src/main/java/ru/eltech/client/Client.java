package ru.eltech.client;

import ru.eltech.client.api.CarRouter;
import ru.eltech.client.frame.MainFrame;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.io.IOException;

public class Client {

    private final CarRouter carRouter;

    public Client(CarRouter carRouter) {
        this.carRouter = carRouter;
    }

    public void run() throws IOException {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Error: NimbusLookAndFeel");
        }
        MainFrame frame = new MainFrame(carRouter);
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
