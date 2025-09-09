import java.util.Date;
import java.util.UUID;

public class Pledge {
    private String pledgeId;
    private User backer;
    private double amount;
    private String rewardTier;
    private Date date;

    public Pledge(User backer, double amount, String rewardTier) {
        this.pledgeId = UUID.randomUUID().toString();
        this.backer = backer;
        this.amount = amount;
        this.rewardTier = rewardTier;
        this.date = new Date();
    }

    public double getAmount() {
        return amount;
    }

    public User getBacker() {
        return backer;
    }

    public String getRewardTier() {
        return rewardTier;
    }

    public Date getDate() {
        return date;
    }
}
