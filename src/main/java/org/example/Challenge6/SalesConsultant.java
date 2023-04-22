package org.example.Challenge6;

class SalesConsultant implements Worker {

    private double earnings;

    public SalesConsultant() {
        Shop.getShop ().addWorker (this);
    }

    public void sellProduct(double price) {
        earnings += price;
    }

    public double getMoney() {
        return this.earnings;
    }

    @Override
    public double getCurrentBalance() {
        return earnings;
    }
}