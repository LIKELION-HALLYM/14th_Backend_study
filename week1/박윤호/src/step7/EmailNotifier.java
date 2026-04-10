package step7;

public class EmailNotifier implements Notifiable {
    public void sendNotification(String message) {
        System.out.println("[이메일] " + message);
    }
}