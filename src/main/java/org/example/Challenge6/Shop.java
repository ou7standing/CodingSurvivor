package org.example.Challenge6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Shop {
    private static Shop shop;

    private List<Worker> workers = new ArrayList<> ();

    public static Shop getShop() {
        if (Objects.isNull (shop)) {
            shop = new Shop ();
        }
        return shop;
    }

    public void addWorker(Worker worker) {
        workers.add (worker);
    }

    public double getTurnover() {
        return workers.stream ()
                .mapToDouble (Worker::getCurrentBalance)
                .sum ();
    }
}