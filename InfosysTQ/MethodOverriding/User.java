package InfosysTQ.MethodOverriding;

public class User {
    private int id;
    private String userName;
    private String emailId;
    private double walletBal;

    public User(int id, String userName, String emailId, double walletBal) {
        this.id = id;
        this.userName = userName;
        this.emailId = emailId;
        this.walletBal = walletBal;
    }

    public static void main(String[] args) {
        User u = new User(1,"Majahr","majahr@123",1200);
        System.out.println(u.getId()+" "+u.getUserName()+" "+u.getEmailId()+" "+u.getWalletBal());
        u.makePayment(1000);
    }
    private boolean makePayment(double billAmount){
        double res = this.getWalletBal()-billAmount;
        if (billAmount > this.getWalletBal()){
            System.out.println("You don't have enough balance :(");
            return false;
        }
        if (res<0){
            System.out.println("Insufficient balance in wallet! :(");
            return false;
        }else {
            System.out.println("Transaction Successful :)");
            return true;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getWalletBal() {
        return walletBal;
    }

    public void setWalletBal(double walletBal) {
        this.walletBal = walletBal;
    }
}
class PremiumUser extends User{
    private int rewardPoint;

    public PremiumUser(int id, String userName, String emailId, double walletBal,int rewardPoint) {
        super(id, userName, emailId, walletBal);
        this.rewardPoint = rewardPoint;
    }

//    public boolean makePayment(double billAmount){
//
////        if(){
////
////        }
//    }
    public int getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(int rewardPoint) {
        this.rewardPoint = rewardPoint;
    }
}