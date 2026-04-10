package week1Pc.interfacePc;

public class EmailNotifier implements Notifiable {
    @Override
    public void sendNotification(String message) {
        System.out.println("[이메일] "+message);
    }
}
