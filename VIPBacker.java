public class VIPBacker extends User {

    public VIPBacker(String name, String email, double wallet) {
        super(name, email, "Backer", wallet);
    }

    public double getVIPBonus() {
        return 1.05; // 5% extra pledge
    }
}
