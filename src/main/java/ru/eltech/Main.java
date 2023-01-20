package ru.eltech;

import ru.eltech.client.Client;
import ru.eltech.client.api.CarRouter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CarRouter carRouter =new CarRouter();

        Client client = new Client(carRouter);
        client.run();
    }
}