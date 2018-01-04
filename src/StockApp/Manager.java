package StockApp;

public class Manager {
    private String loginName;
    private String password;
    private String name;

    public Manager(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    public Manager(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public boolean checkLogin(String loginName, String password) {
        return loginName == this.loginName && password == this.password;
    }

}
