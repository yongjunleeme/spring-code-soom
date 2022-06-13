## 회고

1)
타자를 많이 쳤더니 손가락이 아프다. 학습과 관련은 없지만 예방 가능했던 부분이 아닌가 싶다. 손가락 보호(?)를 위해 장비에 투자를 하는 사람들의 이야기를 종종 들었기 때문이다. 내 손가락이 무적이 아니라는 사실을 간접적으로라도 MUST로 인지했다면 훨씬 이르게 보호 대비를 하여 더 오랜 유효기간을 확보할 수 있지 않았을까? 

질문을 할 때 내심 기대와 다른 답변을 받을 때가 있다. 현재의 내가 인지하는 범위 바깥이라 동문서답이라는 오해를 하는 것 같다. 하지만 나중에야 그 답변의 선견지명(?)에 놀랄 때가 종종 있었다. 선입견을 거두고 그 답변을 있는 그대로 받아들였다면 좀더 시간을 아꼈을 것이다.

좀더 수용성을 높여야 한다는 생각이 들었다.

2)
JWT를 몇 번째 접하는데도 개념이 아리송하다. 하지만 당장의 과제에는 불편함이 없으니 또 그냥 넘어갔다. 몇 년 전 JWT도 그랬고 처음 접한 개념은 글로 정리한다. 그러고 나서 이후 다시 그 개념을 만나면 안다는 착각(?)을 하고 작동만 하면 다시 넘어가는 것 같다.

그렇다면 처음에 초장박살을 낸다는 생각으로 깊게 공부해야 하나? 그건 어렵지 않나. 접할 때마다 모를 수 있다는 태도를 가지고 조금씩 더 공부해야 하나? 이게 더 맞는 쪽인 것 같다. 개념과 코딩을 모두 실행을 반복할수록 안다(?)에 근접하는 것 같기 때문이다.

좀더 깊게 알려면 정리를 하자. 그러고 나서 또 만나면 모른다는 태도로 덧붙여서 정리하자. 한 개념과 다른 개념 인터리빙된다고 해야 하나? 그런 지점이 오면 더욱 이해가 되는 것 같기 때문이다.

3)
코드숨 7주차? 학습태도가 해이하다. 중간 딴 짓 비중이 높아지고 목표의식도 흐릿해진 듯 하다. 온라인의 한계를 느낀다. 아니 그게 아니라 온라인으로 공부하는 나의 한계를 본다. 내 학원과 같은 단체학습(?) 습관이 공부할 때 옆 사람이 뭘 얼마나 하는지에 대해 관심이 많았기 때문이었나 싶다.

관계 기반의 학습과 생각의 태도가 이런 습관을 낳은 것 같다. 나만의 길을 우직하게 갈 수 있으면 더 좋을 같구먼.

## Review Comment

> 다른 수강생분들이 받으신 코멘트도 추가했습니다.

> [JWT에 대해 학습하고 JWT을 도입한다고 가정하고 글을 작성해보았습니다.](https://github.com/CodeSoom/spring-week6-assignment-1/pull/2#issuecomment-791187665)

> `@FunctionalInterface`를 왜 붙이는지에 대해서는 저도 이번 기회에 깊이 있게 생각해 봐야겠어요. 다음은 제가 최근에 정리해 둔 글입니다.  
[https://johngrib.github.io/wiki/java-functional-interface/](https://johngrib.github.io/wiki/java-functional-interface/)

> JavaDoc은 주석이지만 열심히 작성하다 보면 놀라운 깨달음을 얻을 수 있습니다. 그리고 그 깨달음은 객체지향 핵심 원리와 닿아 있고, 팀 플레이어로서의 자신을 성장시키는 데에도 큰 도움이 됩니다.

> Transactional 이 필요한 이유가 무엇인가요?

login 시 트랜잭션의 속성인 [ACID](https://ko.wikipedia.org/wiki/ACID) 을 보장하기 위해서는 `@Tansactional`이 필요한 게 아닌가 합니다.

또한 직접 구현하려면 여러 고려사항을 따져야 하지만 `@Tansactional`을 선언하면 AOP는 프록시를 동적으로 만들어서 스프링 컨테이너에 등록하는 일련의 과정을 수행할 수 있기 때문입니다. 

그런데 트랜잭션 격리수준에 따라 아래의 각 문제가 발생할 여지가 있습니다. 격리수준은 데이터베이스마다 다른데 보통 READ COMMITTED를 기본으로 사용합니다. 과제에서 사용한 [H2의 트랜잭션 격리설정](https://h2database.com/html/advanced.html#transaction_isolation)에서 디폴트 설정이 무엇인지는 잘 모르겠습니다.. ㅠ,ㅠ 

## 트랜잭션 격리수준

- READ UNCOMMITED

커밋하지 않은 데이터를 읽을 수 있다. 예를 들어 트랜잭션1이 데이터를 수정하고 있는데 커밋하지 않아도 트랜잭션 2가 수정 중인 데이터를 조회할 수 있다. 이를 Dirty read라고 한다. 트랜잭션 2가 Dirty read한 데이터를 사용하는데 트랜잭션1을 롤백하면 테이터 정합성에 문제가 발생할 수 있다.

- READ COMMITTED

커밋한 데이터만 읽을 수 있다. 따라서 Dirty READ가 발생하지 않는다. 하지만 Non-Repeatable read는 발생할 수 있다. 예를 들어 트랜잭션 1이 회원 A를 조회 중인데 갑자기 트랜잭션 2가 회원 A를 수정하고 커밋하면 트랜잭션 1이 다시 회원 A를 조회했을 때 수정된 데이터가 조회된다. 이처럼 반복해서 같은 데이터를 읽을 수 있는 상태를 Non-Repeatable read라 한다.

- REPEATABLE READ

한 번 조회한 데이터를 반복해서 조회해도 같은 데이터가 조회된다. 하지만 Phantom read는 발생할 수 있다. 예를 들어 트랜잭션1이 10살 이하의 회원을 조회했는데 트랜잭션 2가 5살 회원을 추가하고 커밋하면 트랜잭션 1이 다시 10살 이하의 회원을 조회했을 때 회원 하나가 추가된 상태로 조회된다. 이처럼 반복 조회 시 결과 집합이 달라지는 것을Phantom read라고 한다.

- SERIALZABLE

가장 엄격한 트랜잭션 격리 수준이다. 하지만 동시성 처리 성능이 급격히 떨어질 수 있다.

## 출처
- [스프링 DB 1편 - 데이터 접근 핵심 원리](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-db-1/dashboard)
- [스프링 DB 2편 - 데이터 접근 활용 기술](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-db-2?inst=260d2a39)
- [자바 ORM 표준 JPA 프로그래밍](http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9788960777330)


### apache commons lang

```java
if (Strings.isBlank(token) {
	// ...
}
```

> nit : 항상 하는 널체크가 귀찮다면 이렇게 하는 것도 좋겠습니다!  
대표적인 문자열 관련 유틸모임은 apache commons lang 을 전통적으로 많이 사용합니다.  
위 예시는 log4j에 구현체가 있길래 보여드린 예시입니다.


- nit가 nitpicking(중요하지 않지만 작은 변화)을 의미하는군요!
- [log4j](https://ko.wikipedia.org/wiki/Log4j) (아파치 로깅 유틸리티)
- [Apache Commons](https://commons.apache.org/proper/commons-lang/)

## Sources    
    
- [코드숨 스프링](https://www.codesoom.com/courses/spring)    
- [코드숨 트레이너 기계인간님 John Grib](https://johngrib.github.io/)    
- [코드숨 수강생 JamieShin0201님](https://github.com/JamieShin0201)
