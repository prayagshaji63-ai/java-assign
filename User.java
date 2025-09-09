import java.util.UUID;

public class User {
    protected String userId;
    protected String name;
    protected String email;
    protected String role;
    private double wallet;

    public User(String name, String email, String role, double wallet) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.role = role;
        this.wallet = wallet;
    }

    public String getUserId() {
        return userId;
    }

    public double getWallet() {
        return wallet;
    }

    public void deposit(double amount) {
        if (amount > 0) wallet += amount;
    }

    public boolean deduct(double amount) {
        if (wallet >= amount) {
            wallet -= amount;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
