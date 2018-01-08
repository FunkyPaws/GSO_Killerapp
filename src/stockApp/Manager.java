package stockApp;

public class Manager {
    private String loginName;
    private String password;
    private String name;

    public Manager(String loginName, String password, String name) {
        this.loginName = loginName;
        this.password = password;
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
        return loginName.equals(this.loginName) && password.equals(this.password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (getLoginName() != null ? !getLoginName().equals(manager.getLoginName()) : manager.getLoginName() != null)
            return false;
        return getPassword() != null ? getPassword().equals(manager.getPassword()) : manager.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = getLoginName() != null ? getLoginName().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }
}
