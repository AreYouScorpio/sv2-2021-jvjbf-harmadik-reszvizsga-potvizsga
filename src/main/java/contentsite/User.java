package contentsite;

public class User {

    String UserName;
    int password;
    boolean isPremium;
    boolean isOnline;

    public User(String userName, String password) {
        UserName = userName;
        this.password = (userName+password).hashCode();
    }

    public void upgradeForPremium(){
        this.isPremium = true;
    }

    public void setLogIn(boolean value){
        this.isOnline = value;
    }

    public String getUserName() {
        return UserName;
    }

    public int getPassword() {
        return password;
    }

    public boolean isPremiumMember() {
        return isPremium;
    }

    public boolean isLogIn() {
        return isOnline;
    }
}
