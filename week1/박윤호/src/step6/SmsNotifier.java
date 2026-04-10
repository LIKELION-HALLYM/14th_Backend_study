package step6;

public class SmsNotifier implements Notifiable{
    public void sendNotification(String message) {
        System.out.println("[SMS] " + message);
    }
}
