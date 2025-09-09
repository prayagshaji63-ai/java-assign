public class CrowdfundAppMain {
    public static void main(String[] args) {
        FundingService fundingService = new FundingService();

        // Register Users
        Creator alice = new Creator("Alice", "alice@example.com", 0);
        VIPBacker bob = new VIPBacker("Bob", "bob@example.com", 1000);
        User charlie = new User("Charlie", "charlie@example.com", "Backer", 500);

        // Create Campaign
        Campaign techGadget = alice.createCampaign("TechGadget", 1000, "2025-12-31", false);
        fundingService.registerCampaign(techGadget);

        // Pledges
        fundingService.addPledge(techGadget, bob, 200, "Gold");
        fundingService.addPledge(techGadget, charlie, 800); // Overloaded method

        // Show Progress
        System.out.println("Campaign progress: " + techGadget.getProgressPercentage() + "%");

        // Settle campaign
        fundingService.settleCampaign(techGadget);
        System.out.println("Campaign status: " + techGadget.getStatus());

        // Reports
        fundingService.showTopCampaigns();
        fundingService.showBackerReport(bob);
    }
}
