package step6;

public class Step6_Interface {
    static void main() {
        Notifiable email = new EmailNotifier();
        Notifiable sms = new SmsNotifier();

        email.sendNotification("회원가입을 축하합니다.");
        sms.sendNotification("주문이 접수되었습니다.");
    }

}
