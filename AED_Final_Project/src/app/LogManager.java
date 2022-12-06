package app;


import app.FrameWindow;

public class LogManager extends Manager{

    private static String message;

    public static void setMessage(String message) {LogManager.message = message;
    }

    public static void displayMessage(){FrameWindow.setText(message);}

    @Override
    void manage() {

    }
}
