package app;
public class LogManager extends Manager{

    private static String message;

    public LogManager(String username, String password) {
        super(username, password);
    }

    public static void setMessage(String message) {LogManager.message = message;
    }

    public static void displayMessage(){JFrameWindow.setText(message);}

    @Override
    void manage() {

    }
}
