package step7;

public class Step7_MiniProject {
    public static void main(String[] args) {
        // 배열 + 상속
        User[] users = {
                new User("김철수", 20),
                new User("박민준", 22),
                new AdminUser("이영희", 28, "SUPER_ADMIN")
        };

        System.out.println("=== 전체 회원 목록 ===");
        for (User u : users) {
            u.printInfo();
        }

        // 캡슐화
        System.out.println("\n=== 나이 수정 ===");
        users[0].setAge(25);
        users[0].printInfo();
        users[1].setAge(-1); // 잘못된 값 → 막힘

        // 인터페이스
        System.out.println("\n=== 알림 발송 ===");
        Notifiable notifier = new EmailNotifier();
        notifier.sendNotification("가입을 환영합니다, " + users[0].getName() + "님!");
    }
    }