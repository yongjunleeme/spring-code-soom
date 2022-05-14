
## 체크 리스트

- 영상강의 학습에 인출을 사용하고 있는가
- 책을 읽을 때 다양한 인출방법을 시도해보고 있는가
- 1시간 단위로 의도적인 몰입을 격리해 상태 점검을 하고 있는가
- 이펙티브 자바의 추상적 개념을 학습하고 다양한 상황에 적용하고 있는가
- 프린트만 찍는 디버깅 스킬이 이외에 다른 방법을 축적하고 있는가


## 회고

코드숨에 쓰는 시간이 점점 줄어든다. CS, 영어 공부도 병행하기 때문이다. 그러면서 두 가지 궁금함이 생겼다.

첫째는 CS 공부방법이다. 나는 네트워크, 운영체제는 전공책을 처음부터 읽고 있다. 나중에 기억이 안 날 것 같은데 그래도 지금이 아니면 읽을 시간이 없을 것 같아서 읽는데 매우 느리다. 프로그래밍 처럼 내가 실수(삽질)를 하거나 무엇이든 만들면 기억에 비교적 오래 남는데 CS는 어떻게 해야 할지 잘 모르겠다. 일단 목적이 인터뷰 때 답변이라고 하지만 이보다는 정말 필요할 때 가져다 쓸 수 있는 CS 지식의 스키마(?)를 남기고 싶은데 어떻게 해야 할 지 모르겠다.

두 번째는 시간배분이다. 1시간 단위로 영어, 독서, CS, 코드숨 등을 나눠서 학습하는데 이게 효율적일지 그냥 지금은 코드숨에 올인을 하고 나중에 다른 것들도 올인하는 형태로 공부하는 게 나을지 잘 모르겠다.  

## Review Comment

> 다른 분들 과제 리뷰 코멘트도 참고하여 포함했습니다..

### CORS
> 1. 데이터 흐름을 다음과 같이 보는건 어떠신가요? 클라이언트(브라우저) <-> 서버(API 서버)
> 2. 모든 클라이언트가 교차출처 검증 책임이 있지 않습니다. 브라우저와 달리 포스트맨은 교차출처 검증을 안합니다. 그래서 CORS 처리를 안해도 포스트맨을 통해서 서버에 요청을 하면 CORS 이슈가 발생하지 않습니다~
> 3. Origin은 Scheme, Host, Port가 같아야 같은 origin으로 인식합니다. 예를 들어, 서버의 origin이 [http://localhost/:8080이고](http://localhost/:8080%EC%9D%B4%EA%B3%A0 "http://localhost/:8080이고") 클라이언트의 origin이 [http://localhost/:3000이면](http://localhost/:3000%EC%9D%B4%EB%A9%B4 "http://localhost/:3000이면") 포트 번호가 달라서 서로 다른 origin으로 인식합니다. 참고로 scheme은 http를 가리킵니다
 
### 상태불변 객체
> `final` 로 바꾸는 것을 시도해보면 좋겠어요!
> 상태가 없는 객체를 만들어보는 경험을 해보면 좋을거라고 생각합니다!
> 불변한 객체는 어느 상황에서도 바뀌지 않기 때문에 안전합니다.
> 우리는 아직 ORM을 쓰고 있지 않기 때문에 상태변경이 필수인 상황은 아니에요! (물론 이것도 주요 비즈니스로직에는 불변으로 다룰 수 있기도 하기 때문에 반만 맞는 거죠)
> 그렇기 때문에 객체 안에 있는 필드들을 모두 `final` 로 바꿔서 불변성한 객체를 만들어보면서 장단점을 느껴보면 좋겠어요!

### 인터페이스 분리 원칙

> 이제 한 발 더 앞으로 나아가봐요! 객체지향프로그래밍에는 `SOLID` 원칙이라고 불리는 것들이 있어요!  
> 그중에서 `I`에 해당하는 `ISP` 를 찾아보고 리팩토링해보면 좋은 경험이 되실거에요!

### concurrentHashMap

> synchronizedMap 과 concurrentHashMap의 차이를 알아보면 재밌을 것 같아요!


### DELETE

> 왜 데이터가 없을 때 204상태로 응답해야하는지 다음 문서를 읽어 봅시다
> [RFC 2616 - 9.7 Delete](https://tools.ietf.org/html/rfc2616#section-9.7)

### 방어적 복사

```java
public List<Task> getTasks() {
	return tasks;
}
```

> 한번 이팩티브자바의 방어적 복사본을 만들어보세요! (Item 50: Make defensive copies when needed)
> 또한 저는 `List.copyOf` 도 고려해볼 것 같아요!

### Controller Pattern

> id로 task를 조회하고, task가 비어있는 경우, response 객체로 404 응답을 가져오고, 빈 문자열을 리턴해주고 있어요.

> 컨트롤러에선 직접 일을 수행하지 않고, 서비스 혹은 비즈니스 로직에 작업을 위임하도록 합니다.  
> 컨트롤러는 왜 이렇게 계층을 나눠서 작업해야 하는 걸까요?  
> 이에 대해 자세히 정리하고 싶다면, 아래의 종립님의 블로그를 참조하시면 도움이 될 거예요.

> 우선은, `Task` 객체가 하는 일을 TaskController 에서 분리를 시도해보세요.

> - [컨트롤러 패턴 (Controller Pattern)](https://johngrib.github.io/wiki/pattern/controller/)


### 조회한 값으로 수정한다면 하나의 트랜잭션으로

```java
public Task save(Task source) {

Task newTask = new Task(sequence.get(), source.getTitle());

Task newTask = new Task(sequence.getAndIncrement(), source.getTitle());
```

> 너무 좋아요! 기억하세요! 조회한 값으로 수정을 한다면 조회와 수정이 하나의 트랜잭션으로 일어나야 합니다!

### ETC

> 기본생성자를 제거해보는 시도를 해보면 좋은 경험이 될 거에요!

## Sources  
  
- [코드숨 스프링](https://www.codesoom.com/courses/spring)  
- [코드숨 6기 MJbae님](https://github.com/MJbae)
- [코드숨 트레이너 남영환님](https://github.com/ssisksl77)
- [코드숨 트레이너 bloomspes님](https://github.com/bloomspes)
- [코드숨 트레이너 기계인간님 John Grib](https://johngrib.github.io/)  

