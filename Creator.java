public class Creator extends User {

    public Creator(String name, String email, double wallet) {
        super(name, email, "Creator", wallet);
    }

    public Campaign createCampaign(String title, double goalAmount, String deadline, boolean isFlexible) {
        return new Campaign(title, goalAmount, deadline, this, isFlexible);
    }
}
