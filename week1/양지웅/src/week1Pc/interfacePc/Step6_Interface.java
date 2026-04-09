package week1Pc.interfacePc;

public class Step6_Interface {

    public static void main(String[] args) {
        Notifiable email = new EmailNotifier();
        Notifiable sms = new SmsNotifier();

        sms.sendNotification("회원가입을 축하합니다");
        email.sendNotification("구현체 작성");
    }
}
