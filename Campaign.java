import java.util.*;

public class Campaign {
    private String campaignId;
    private String title;
    private double goalAmount;
    private String deadline;
    private String status; // Active, Funded, Failed
    private boolean isFlexible;
    private List<Pledge> pledges;
    private Creator creator;

    public Campaign(String title, double goalAmount, String deadline, Creator creator, boolean isFlexible) {
        this.campaignId = UUID.randomUUID().toString();
        this.title = title;
        this.goalAmount = goalAmount;
        this.deadline = deadline;
        this.status = "Active";
        this.pledges = new ArrayList<>();
        this.creator = creator;
        this.isFlexible = isFlexible;
    }

    public void addPledge(Pledge pledge) {
        pledges.add(pledge);
    }

    public double getTotalPledged() {
        return pledges.stream().mapToDouble(Pledge::getAmount).sum();
    }

    public double getProgressPercentage() {
        return (getTotalPledged() / goalAmount) * 100;
    }

    public void settle() {
        if (getTotalPledged() >= goalAmount || isFlexible) {
            status = "Funded";
            creator.deposit(getTotalPledged());
        } else {
            status = "Failed";
            for (Pledge p : pledges) {
                p.getBacker().deposit(p.getAmount());
            }
        }
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public List<Pledge> getPledges() {
        return pledges;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public Creator getCreator() {
        return creator;
    }

    public double getGoalAmount() {
        return goalAmount;
    }

    public boolean isFlexible() {
        return isFlexible;
    }
}
