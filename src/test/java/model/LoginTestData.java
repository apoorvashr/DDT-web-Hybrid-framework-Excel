package model;

public class LoginTestData {

    private final String username;
    private final String password;
    private final String pageTitle;

    public LoginTestData(String pageTitle, String username, String password) {
        this.pageTitle = pageTitle;
        this.username = username;
        this.password = password;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}