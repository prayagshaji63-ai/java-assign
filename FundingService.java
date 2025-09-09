import java.util.*;

public class FundingService {
    private List<Campaign> campaigns;

    public FundingService() {
        this.campaigns = new ArrayList<>();
    }

    public void registerCampaign(Campaign campaign) {
        campaigns.add(campaign);
    }

    // Method Overloading
    public boolean addPledge(Campaign campaign, User backer, double amount) {
        return addPledge(campaign, backer, amount, "Standard");
    }

    public boolean addPledge(Campaign campaign, User backer, double amount, String rewardTier) {
        if (backer instanceof VIPBacker) {
            amount *= ((VIPBacker) backer).getVIPBonus();
        }

        if (backer.deduct(amount)) {
            Pledge pledge = new Pledge(backer, amount, rewardTier);
            campaign.addPledge(pledge);
            return true;
        }
        return false;
    }

    public void settleCampaign(Campaign campaign) {
        campaign.settle();
    }

    public void showTopCampaigns() {
        campaigns.stream()
                .sorted((a, b) -> Double.compare(b.getTotalPledged(), a.getTotalPledged()))
                .limit(3)
                .forEach(c -> System.out.println(c.getTitle() + " raised " + c.getTotalPledged()));
    }

    public void showBackerReport(User backer) {
        System.out.println("Contributions by: " + backer.getName());
        for (Campaign c : campaigns) {
            for (Pledge p : c.getPledges()) {
                if (p.getBacker().equals(backer)) {
                    System.out.println("- " + c.getTitle() + ": " + p.getAmount());
                }
            }
        }
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }
}
