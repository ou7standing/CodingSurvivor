package org.example.Challenge6;

class MarketingSpecialist implements Worker {
    private double budget = 5000.00;

    public MarketingSpecialist() {
        Shop.getShop ().addWorker (this);
    }

    public void spendMoney(double marketingCampaignCost) throws Exception {
        if (marketingCampaignCost > budget) {
            throw new Exception ("Cost cannot exceed budget");
        }
        budget -= marketingCampaignCost;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public double getCurrentBalance() {
        return budget;
    }
}