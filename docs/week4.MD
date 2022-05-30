 ## 회고

4주차의 주제는 도메인인데 강의 수강과 과제 수행 뒤에도 도메인을 잘 모르겠다. 3주차에 이어 테스트 위주로 학습한 것 같다. 아마 클린 아키텍처나 JPA등을 처음 접해서인 것 같다.

이를 배우려면 방대한 시간이 들어갈 것이라 지레 짐작해서 강의만 듣고 머리에서 휘발됐다. 불과 지난 주에 접해서 조금이라도 익숙한 테스트만 살펴봤기 때문에 새로운 내용을 학습할 기회를 잃어버렸나 싶다. 

배워야 할 내용들이 많은데 이전 것을 붙잡고 있다가는 컴포트 존에 빠져 있기 십상이다. 지금은 최대한 많은 것을 접하는 기회이므로 배울 개념들은 최대한 적용을 해보려고 하자.
 
## Review Comment

> 다른 분들의 코멘트를 참고하였습니다!

> JavaDoc은 프로젝트 전체를 빌드하면 모든 JavaDoc 주석을 모아서 웹 사이트로 만들어 주는 도구입니다. 신기하죠? 다음 링크로 한 번 들어가보세요.
> [https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html)
> 위의 웹 사이트는 String.java 에 들어있는 JavaDoc 주석을 사용해서 javadoc 명령어가 만들어준 웹 페이지입니다. 즉, JavaDoc은 내가 만든 소스코드를 많은 사람들에게 설명하기 위한 도구에요. 설명을 꼼꼼하고 바른 어법으로 작성하는 것이 중요합니다.
> 만약 JavaDoc 웹을 빌드해보고 싶다면 터미널에서 다음과 같이 입력해 보세요.

```
./gradlew javadoc
```

> 또는 인텔리제이에서 `gradle - Tasks - documentation - javadoc` 을 더블 클릭해 실행해봐도 됩니다.

> [![image](https://user-images.githubusercontent.com/1855714/108363456-4669b580-7238-11eb-9c02-6432973af76f.png)](https://user-images.githubusercontent.com/1855714/108363456-4669b580-7238-11eb-9c02-6432973af76f.png)

> 그러면 `spring-week4-assignment-1/app/build/docs/javadoc` 폴더에 `index.html` 파일이 생성될 거에요.  
> 그리고 그 파일을 열어보면 내가 작성한 JavaDoc 주석들이 모두 들어 있습니다.

>   추후에 api가 복잡해져서 HTTP 요청별 반환되는 파라미터들이 다르다면 요청별 각각 다른 Dto 클래스를 만들어서 해결하면 될까요? 아니면 혹시 다른 방법으로 해결해야 하나요?

> 네. 요청별로 다른 응답용 클래스를 만들어 사용하시면 됩니다. 각 요청이 목적과 관심사가 다르기 때문에 같은 클래스를 돌려 쓰다보면 골치아픈 순간이 오게 됩니다. 다만 작업을 할 때 데코레이터를 적용해보는 연습을 해볼 수 있겠군요.

> `extends`를 사용하지 말고, 데코레이터 패턴을 얄팍하게 응용만 해 봅시다. `Product`를 받아서 private 멤버로 갖고만 있고(has a), 각종 `getter` 메소드가 `product.get...`을 래핑하기만 하는 거죠. 해볼 수 있으시겠어요?

> 좋습니다. 한편 아래와 같이 `getter`를 심심하게 사용하는 것보다 `product`의 레퍼런스를 보관한 다음 데코레이터 패턴을 적용해 보는 것도 좋은 공부가 될 수 있을 것 같습니다.

> 생각해보니 데코레이터는 좀 적절하지 않을 것 같고요, `product`의 레퍼런스를 갖고 각 getter가 `product`의 getter를 래핑하는 형태로 구현해보는 것이 더 좋을 것 같습니다.

>데코레이터에 대해 학습이 필요할 것 같습니다. 확인해보겠습니다. 감사합니다

> 제가 작성해둔 글이 있습니다. 도움이 될 지도 모르겠군요. 데코레이터 이야기를 한 것은 간단한 has-a 관계를 염두에 둔 것입니다 :-)  
> [https://johngrib.github.io/wiki/decorator-pattern/](https://johngrib.github.io/wiki/decorator-pattern/)


> 
> 1.  DTO를 컨트롤러 레이어까지만 사용해야할지? 아니면 서비스 레이어에서도 사용할지?
> 2.  컨트롤러 레이어에서 단순히 dto로 변환하여 return하는 경우는 서비스 레이어에서 dto를 반환하는것은 어떤지?

> 엔티티가 dto에 대해 알고 있는 것은 좀 이상하게 느껴지죠? 깨달음을 얻으셨군요. 흔해 빠진 예이지만 dto를 택배 상자라 생각해 봅시다. 택배 상자는 현관문까지만 상품을 운반해 주면 됩니다. 그 이상 들어가면 집안이 오염되겠죠. 그런데 만약 방마다 주인이 따로따로 있다면 어떤 사람은 자기 방으로 택배 상자를 들고 들어가서 열어보는 걸 선호하기도 할 거에요. 방이 좀 더러워지더라도 그 방이 자기방이니까 편하게 느끼기 때문이겠죠. 즉 dto를 취급하는 영역을 칼같이 나누는 것은 어렵습니다. 오염과 책임에 대해 생각해보시는 것도 좋을 것 같습니다.

> 추가로 제 경우를 이야기하자면 dto는 컨트롤러 레이어까지만 사용하고, 그 이상 안쪽으로 보내는 것을 최대한 막으려 하는 습관을 갖고 있긴 해요. 다만 여기에 interface를 사용하는 방법도 생각할 수 있습니다. 만약 dto 의 몇몇 메소드를 정의하고 있는 interface가 있고, 서비스가 받는 타입이 해당 interface라면 DTO를 그대로 서비스에 넘겨주지만 DTO의 타입은 서비스에 넘겨주지 않는 셈이 될 수 있겠죠. 제가 좋아하는 방법입니다

> 주신 피드백을 이후 이펙티브 자바(item 74)에서 비검사예외는 메서드 시그니처에 추가하지 말라는 글을 발견하였는데 추가하지 않는게 맞지 않을까요?  
> 추가적으로 최근 예외처리에 대해 정리를 하면서 비검사예외 검사예외에 대해 정리를 하지 않았던것 정리해보겠습니다.

> 오 이펙티브 자바를 찾아보셨다니 너무 잘하신 것 같아요. 제가 말한 의도는 메소드 사용자에게 알려주는 것이 좋겠다는 정도였는데, 말씀해주신 덕분에 저도 이펙티브 자바를 다시 읽어봤어요. `ProductNotFoundException`은 `RuntimeException`의 서브 클래스이므로 비검사예외가 맞고, 그러니 메소드 시그니처에 추가하지 않아도 괜찮겠네요. 덕분에 저도 좋은 공부가 되었습니다

> DTO 생성자 파라미터에 엔티티를 넣어 사용하는 방법이 있었군요! 감사합니다.  
> 혹시 이런식으로 사용하는 방법이 문제는 없을까 하고 구글링 하다가 조심해야할 점이 있다는 것을 발견하였습니다. 제 경우는 엔티티를 먼저 조회하고 dto로 변환하는 경우라 문제는 없어보이는군요

```
DTO 생성자 파라미터에 엔티티를 그대로 넣은 방식은 설계상 문제는 없습니다.

다만! 엔티티를 먼저 조회해서 이후에 DTO로 변환하는 경우에는 이렇게 해도 됩니다. 왜냐하면 DTO는 엔티티를 의존해도 설계상 아무런 문제가 없기 때문이지요.

그런데! 엔티티를 먼저 조회하지 않고, 바로 DTO로 조회하는 경우에는 이렇게 하는 것이 좋지 않습니다.

여기에는 2가지 이유가 있습니다.

1. DTO로 직접 조회하는 이유는 엔티티를 무시하고, 조회용 모델을 바로 만드는 것이 목표입니다. 따라서 중간에 번거롭게 엔티티를 만들 이유가 없습니다.

2. 이것은 설계상에 큰 문제는 없지만, 성능에서 차이가 납니다.

위에서 첫번째는 SQL select 쿼리가 username, age 두 필드만 조회합니다. 반면에 두번째는 SQL 쿼리가 member의 모든 필드를 다 조회합니다.

결국 리포지토리 계층에서 DTO를 바로 조회할 때는 엔티티를 거치지 않는 것이 더 나은 방법입니다.

다만 리포지토리 계층에서 엔티티를 조회하고, 그 엔티티를 어디선가 DTO로 변환할 때는 이미 엔티티를 조회한 상황이기 때문에 이때는 DTO의 생성자 파라미터를 활용하시는 방법도 괜찮습니다.

출처 : https://www.inflearn.com/questions/50741
```

> `@Autowired`의 기능에 대해 조사해보시면 좋은 공부가 될 것입니다. `@Autowired`와 관련된 질문은 실제 회사 면접에서도 많이 나오는 질문이니 꼭 공부해두세요. `Spring이 자동으로 new를 해주는 것` 이상으로 설명할 수 있어야 합니다.


> 컨트롤러, 서비스 같은 중요한 책임을 가진 클래스에는 JavaDoc 주석을 달아 주시면 어떨까요? 함께 일하는 동료들도 기뻐할 것입니다.

> 서비스와 차이가 있습니다. 서비스는 비즈니스 로직을 담당하고, 컨트롤러는 HTTP 요청/응답을 담당하죠! 서비스가 물류 센터 관리자라면, 컨트롤러는 배송 기사인 셈입니다.


> 추상 메소드는 이것을 보고 공부하세요.
> [https://docs.oracle.com/javase/specs/jls/se11/html/jls-8.html#jls-8.4.3.1](https://docs.oracle.com/javase/specs/jls/se11/html/jls-8.html#jls-8.4.3.1)

> `TaskService`는 `TaskController`의 존재를 모르고 있다는 점을 고려해 주세요.

> 맞아요! 멋진 책과 블로그가 우리에게 많은 도움을 주죠. 그리고 정리된 내용들을 읽으면 우리에게 무언가를 이해할 때 빠르게 해결 할 수 있어요!
여기서 저는 블로그나 책을 보지말고 도큐먼트만 보세요! 라고 말할 수는 없어요!
> 하지만 당연히 아시겠지만, 모든 기능은 시간이 지남에 따라 개선되고 변경되고 진화하지만 블로그와 책은 발간된 시간에서 멈춰있다는 것을요 ㅠㅜㅠㅜ
> 아마 연차가 쌓이면서 자연스럽게 도큐먼트를 옮겨간다는 것은 연차가 쌓여서 '이제 도큐먼트를 읽을 만큼의 실력이 쌓였어!' 가 아니라 '결국 도큐먼트, 공식문서가 가장 유효한 글이구나...' 라는 경험이 쌓이면서 도큐먼트를 읽게되는 것 같아요 ㅠㅜㅠㅜ
> 빠르게 더 먼저 빠르게 읽어보는 것이 좋습니다. 하지만 도큐먼트가 별로인 프로젝트도 있어요. 그런 곳은 오히려 블로그가 도움이 되기도합니다.

> 읽어보신 도큐먼트를 잠깐보자면 readOnly 정보에 아래와 같은 글이 있습니다.
> This just serves as a hint for the actual transaction subsystem; it will not necessarily cause failure of write access attempts. A transaction manager which cannot interpret the read-only hint will not throw an exception when asked for a read-only transaction but rather silently ignore the hint.

> 여기서 우리가 알아야할 점은 그저 힌트만 준다는 것입니다.
쓰기를 수행할 때 실패할 수도 있다. (실제로 Mysql은 예외를 던집니다. 그것을 테스트에 추가할 수도 있죠) H2 구현체는 이 힌트를 무시하고 있습니다.

```java
/**
* According to the JDBC specs, this setting is only a hint to the database
* to enable optimizations - it does not cause writes to be prohibited.
*
* @param readOnly ignored
* @throws SQLException if the connection is closed
*/
@Override
public void setReadOnly(boolean readOnly) throws SQLException {
  try {
  if (isDebugEnabled()) {
      debugCode("setReadOnly(" + readOnly + ");");
  }
  checkClosed();
  } catch (Exception e) {
  throw logAndConvert(e);
  }
}
```

> H2 구현체 주석에도 나오듯이
JDBC 스펙에 따르면, readOnly는 그저 최적화를 위한 힌트일 뿐이다. 또한 readOnly는 쓰기가 금지되는 것되는 것도 아니다.

> 주석아래 @param readOnly ignored 를 보면 readOnly는 무시된다는 것을 알 수 있습니다.


## Sources  
  
- [코드숨 스프링](https://www.codesoom.com/courses/spring)  
- [코드숨 트레이너 기계인간님 John Grib](https://johngrib.github.io/)  
- [코드숨 트레이너 남영환님](https://github.com/ssisksl77)
