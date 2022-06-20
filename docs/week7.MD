## 회고

이번주는 머리에 남긴 게 별로 없다. 보통 이전에는 아무리 몰라도 코드를 따라 치고 관련 내용 찾아보면 며칠이 지나서 윤곽을 잡을 수 있었다. 그런데 스프링 시큐리티는 어떤 맥락에서 왜 이런 비슷한 단어들이 나오는지 종잡을 수 없었다. 그래서 관련 책을 2권 샀는데 거기서도 과제 관련 내용은 나오지 않았다. ~~내 돈..~~ 
 
그래서 트레이너님께 학습방법을 요청드렸다.

> 스프링 시큐리티를 깊게 아는 것은 추천하지 않습니다만 시큐리티의 설계를 아는 것은 도움이 크게 될 것으로 보입니다!

> [https://docs.spring.io/spring-security/reference/servlet/architecture.html](https://docs.spring.io/spring-security/reference/servlet/architecture.html)

> 요 페이지 하나만 보셔도 스프링 시큐리티를 어떻게 사용할 수 있겠구나! 라는 감이 잡히실 거라고 생각해요!

허허 그러나 감은 잡히지 않았다. 미시적으로 접근하지 말고 나무보다 숲을 먼저 보게 하려고 트레이너님께서 아키텍처를 보라고 하신 것 같다. 방법을 알려줬는데 그래도 못 따라고 있다. 영어가 부족한가, CS가 부족한가, 자바 지식이 부족한가? 다시 종이에 써가면서 읽어보고 한글로 된 블로글들도 읽어봤다. 그래도 잘 모르겠다. 

일단 책으로 해결하려고 한 게 잘못이었나 싶다. 지난 코드리뷰 중에 2번 가량 내가 찾아 봐야 할 내용이 [자바 ORM 표준 JPA 프로그래밍](http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9788960777330)에서 나왔다. 그래서 이 책을 샀더니 1번 더 써먹을 기회가 있었다. 발췌독으로 필요할 때 써먹은 것이다. 

ORM 책은 개념 설명 위주로 내가 필요할 때 찾아볼 용도에 알맞은 책이었다. 그러나 이번에 산 책은 하나는 프로젝트 기반([스프링 인 액션](http://www.yes24.com/Product/Goods/90180239) )이었고 다른 하나는 개념 위주( [스프링 시큐리티 3](http://www.yes24.com/Product/Goods/4425736))인데 내가 찾아야 할 Filter나 아키텍처 관련 내용이 없었다.

또한 너무 모두 알려고 한 것 같다. 여러 개의 벽을 만났는데 여러 개 모두 알려고 욕심을 부린 모양이다. 한 개라도 문제를 풀었어야 다음 문제를 풀 동력을 얻었을까 싶다. 계속 실패(?)하면 아예 자포자기로 방향이 기우는 것 같다. 그러고 나서 다시 트레이너님의 코멘트를 보니 스프링 시큐리티를 깊게 아는 것은 추천하지 않는다는 내용이 있다. 왜 추천하지 않으시는지 이유는 모르겠지만 이것을 또 놓쳤구나..

그리고 코드숨 할당 시간을 너무 적게 써왔다. 코드숨 과정 처음에 Effective Java 스터디를 시작한다고 해서 이 책을 읽어왔다. 또 코드숨 다른 팀은 Modern Java in Action을 읽고 있어서 이 책도 읽어왔다. 그런데 Java Puzzler도 추천이 있어서 이 책도 읽어왔다. 알고리즘 문제풀이도 감을 잃지 않으려면 지속해야 하니 이것도 하고 CS 책들도 읽어왔다. 코드숨에 과제에 쓸 시간이 점점 적어졌다.

그럼 다른 취준생분들은 이런 과목들을 공부 안 할까? 아니다 다들 책도 읽고 문제도 풀고 과제도 할 것이다. 아무튼 벽을 계속 만나니 내가 택한 방법은 거리두기, 시간두기였다. 다음에 복습할 테니깐 그때 차근차근 살펴보자는 계획이었다.

이렇게 써보니깐 알겠다. 책으로 해결, 욕심, 부족한 시간 할당은 모두 핑계인 것 같다. 방법의 문제가 아니라 태도의 문제가 아니었을까? 정복이 어렵다 싶으면 눈길을 돌리는 습관이 뇌에 남아 있어서 끝까지 바짓가랑이를 붙잡지 않아서 벽앞에서 다른 길로 간 것 같다. 태도를 점검하자.

## 코드리뷰 코멘트

**다른 수강생분들이 받으신 코멘트도 포함했습니다.**

> [e0b8be8](https://github.com/CodeSoom/spring-week7-assignment-1/commit/e0b8be892608605e37887bdb83cb015897f5dae7) 커밋 메시지가 좋습니다. 커밋 메시지 본문도 훌륭합니다. 좀 더 심플하면 더 좋았겠지만 지금 상태로도 좋습니다.  
[![image](https://user-images.githubusercontent.com/1855714/110794380-0a66c500-82b9-11eb-8961-605e8867aebf.png)](https://user-images.githubusercontent.com/1855714/110794380-0a66c500-82b9-11eb-8961-605e8867aebf.png)

---

> 저는 class 만큼 인터페이스를 자주 쓰는 편이라 연관이 없다고도 하기도 애매하고, 있다고 하기도 애매하네요. 그냥 필요한 상황이면 사용해요.

> 예를 들어 다음과 같은 인터페이스를 하나 만들었다고 합시다. 이메일과 패스워드의 getter를 동시에 필요로하는 로직이 여러 군데에 있다면 이 인터페이스는 꽤 여러 곳에 달아줄 수 있습니다.
```java
public interface UserIdentifier {
  String getEmail();
  String getPassword();
}
```

> 그런데 굳이 구현체를 만들기 귀찮다면 저는 그냥 이렇게 정적 팩토리를 인터페이스에 넣어주기도 합니다.

```java

public interface UserIdentifier {
  String getEmail();
  String getPassword();

  static UserIdentifier of(String email, String password) {
    return new UserIdentifier() {
      @Override
      public String getEmail() {
        return email;
      }

      @Override
      public String getPassword() {
        return password;
      }
    };
  }
}
```
활용은 자신의 상상력과 경험에 달려 있습니다.

---
- [Git Commit Good Practice](https://wiki.openstack.org/wiki/GitCommitMessages#Example_1_4)


## Sources    
    
- [코드숨 스프링](https://www.codesoom.com/courses/spring)    
- [코드숨 트레이너 기계인간님 John Grib](https://johngrib.github.io/)    
- [코드숨 트레이너 남영환님](https://github.com/ssisksl77)
