package app;

public abstract class Manager {
    private String username;
    private String password;
    abstract void manage();

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean checkUsername(String username){
        return this.username.equals(username);
    }
}
