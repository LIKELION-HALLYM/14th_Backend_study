# 📚 Week 1 과제 — 인터페이스 & 미니 프로젝트

> 세션에서 배운 내용을 직접 코드로 작성해보는 과제입니다.
> 어렵게 생각하지 말고, 세션 자료 보면서 천천히 따라해보세요!

---

##  전체 흐름

```
Pull → 브랜치 생성 → 과제 작성 → Push → PR 제출
```


---

##  브랜치 생성

과제 작업은 반드시 새 브랜치에서 진행합니다.

```bash
git checkout -b feat/week1-본인이름
```

예시

```bash
git checkout -b feat/week1-이평강
```

---

## 과제 작성

### 📁 파일 위치

본인 폴더의 `src/` 안에 파일을 만들어서 작성하세요.

```
week1/
└── 본인이름/
    └── src/
        └── 여기에 파일 생성
```

예시

```
week1/이평강/src/Homework1_Interface.java
week1/이평강/src/Homework2_MiniProject.java
```

> ⚠️ 다른 사람 폴더는 절대 수정하지 마세요!

---

##  과제 1 — 인터페이스

**파일명:** `Homework1_Interface.java`

### 무엇을 만드나요?

세션에서 배운 인터페이스를 직접 작성해봅니다.
알림 기능 대신 **결제 수단**을 주제로 만들어볼게요.

### 요구사항

**1. `Payable` 인터페이스 만들기**
- `pay(int amount)` 메서드를 선언하세요.
- 구현 코드 없이 선언만 합니다.

**2. `KakaoPay` 클래스 만들기**
- `Payable`을 `implements` 하세요.
- `pay()` 메서드에서 `"[카카오페이] 000원 결제 완료"` 형태로 출력하세요.

**3. `CreditCard` 클래스 만들기**
- `Payable`을 `implements` 하세요.
- `pay()` 메서드에서 `"[신용카드] 000원 결제 완료"` 형태로 출력하세요.

**4. `main`에서 실행하기**
- 두 구현체를 각각 **`Payable` 타입**으로 선언하고 호출하세요.
- `KakaoPay`로 10000원, `CreditCard`로 25000원 결제 출력

### 예상 출력 결과

```
[카카오페이] 10000원 결제 완료
[신용카드] 25000원 결제 완료
```

### 💡 힌트

세션에서 만든 `Notifiable` 코드 구조와 똑같아요.
`Notifiable` → `Payable`, `EmailNotifier` → `KakaoPay` 로 바꾸면 됩니다!

```java
// 세션 코드 참고
interface Notifiable {
    void sendNotification(String message);
}

class EmailNotifier implements Notifiable {
    public void sendNotification(String message) {
        System.out.println("[이메일] " + message);
    }
}

// main에서
Notifiable notifier = new EmailNotifier(); // ← Payable 타입으로 선언하는 게 핵심!
notifier.sendNotification("안녕");
```

---

##  과제 2 — 미니 프로젝트

**파일명:** `Homework2_MiniProject.java`

### 무엇을 만드나요?

세션에서 배운 **클래스, 캡슐화, 상속, 인터페이스**를 전부 합쳐서
간단한 **도서관 시스템**을 만들어봅니다.

### 요구사항

**1. `Book` 클래스 만들기**
- 필드: `title` (책 제목), `author` (저자), `price` (가격)
- 생성자: 세 값을 받아서 초기화
- `price` 필드는 `private`으로 선언하고 `getPrice()` getter 추가
- `setPrice(int price)` setter 추가 — 가격이 0 이하면 `"올바르지 않은 가격입니다."` 출력 후 return
- `printInfo()` 메서드 — `"제목: 000 | 저자: 000 | 가격: 000원"` 형태로 출력

**2. `EBook` 클래스 만들기 (`Book` 상속)**
- `Book`을 `extends` 하세요.
- 추가 필드: `fileSize` (파일 크기, 단위: MB)
- `printInfo()` 오버라이드 — `"[전자책] 제목: 000 | 저자: 000 | 용량: 00MB"` 형태로 출력

**3. `Discountable` 인터페이스 만들기**
- `discount(int percent)` 메서드 선언 — 할인율을 받아서 할인된 가격 출력

**4. `SaleBook` 클래스 만들기 (`Book` 상속 + `Discountable` 구현)**
- `Book`을 `extends`하고 `Discountable`을 `implements` 하세요.
- `discount()` 메서드에서 `"할인 적용: 000원 → 000원"` 형태로 출력

**5. `main`에서 실행하기**
- `Book` 2개, `EBook` 1개, `SaleBook` 1개를 `Book[]` 배열에 담기
- for-each로 전체 목록 `printInfo()` 출력
- `SaleBook`의 가격을 `setPrice()`로 변경 후 출력
- 잘못된 가격(-1)도 한 번 시도해보기
- `SaleBook`에 20% 할인 적용해서 출력

### 예상 출력 결과

```
=== 전체 도서 목록 ===
제목: 자바의 정석 | 저자: 남궁성 | 가격: 35000원
제목: Clean Code | 저자: Robert Martin | 가격: 28000원
[전자책] 제목: 토비의 스프링 | 저자: 이일민 | 용량: 15MB
제목: 스프링 입문 | 저자: 김영한 | 가격: 20000원

=== 가격 수정 ===
제목: 스프링 입문 | 저자: 김영한 | 가격: 22000원
올바르지 않은 가격입니다.

=== 할인 적용 ===
할인 적용: 22000원 → 17600원
```

### 💡 힌트

```java
// SaleBook은 이렇게 선언해요
class SaleBook extends Book implements Discountable { ... }

// 할인 계산은 이렇게 해보세요
int discountedPrice = getPrice() - (getPrice() * percent / 100);

// Book[] 배열에 EBook, SaleBook도 담을 수 있어요 (다형성!)
Book[] books = {
    new Book(...),
    new EBook(...),
    new SaleBook(...)
};
```

---

##  Commit & Push

작성 완료 후 아래 순서로 올려주세요.

```bash
git add .
git commit -m "feat: week1 과제 제출 - 본인이름"
git push origin feat/week1-본인이름
```

예시

```bash
git add .
git commit -m "feat: week1 과제 제출 - 이평강"
git push origin feat/week1-이평강
```

---

##  PR 제출

### 브랜치 설정 확인

> ⚠️ 이 설정이 틀리면 제출이 인정되지 않습니다!

| 항목 | 값 |
|------|-----|
| base repository | 원본 레포 (멋사 GitHub) |
| base branch | `submission` ← **main 아님!** |
| compare | 내 Fork 레포 |
| compare branch | `feat/week1-본인이름` |

### PR 제목

```
[week1] 이름 과제 제출
```

### PR 본문 템플릿

```markdown
## 과제 이름
- 

## 어려웠던 점 / 느낀 점
- 

## 실행 화면
<!-- 실행 결과 스크린샷을 첨부해주세요 -->

## 체크리스트
- [ ] 정상 실행 확인
- [ ] 요구사항 구현 완료
```

> PR 생성 시점에 제출이 인정됩니다. Merge 여부와는 무관합니다. 

---

##  제출 기준

| 항목 | 기준 |
|------|------|
| 파일 위치 | `week1/본인이름/src/` 안에 있을 것 |
| 파일명 | `Homework1_Interface.java`, `Homework2_MiniProject.java` |
| 실행 | 에러 없이 실행될 것 |
| 출력 | 예상 출력 결과와 비슷하게 나올 것 |
| PR 브랜치 | base branch가 `submission`일 것 |
| 커밋 메시지 | `feat: week1 과제 제출 - 본인이름` 형태 |

> 완벽하게 구현하지 못해도 괜찮아요!
> 일부만 구현했거나 막히는 부분이 있으면 주석으로 어디서 막혔는지 적어주세요.

---
