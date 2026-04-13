public class SmsNotifier implements Notifiable{
    @Override
    public void sendNotification(String message) {
        System.out.println("[SMS] "+message);
    }
}
