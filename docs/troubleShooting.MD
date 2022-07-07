## 1주차

## POST로 요청을 할 때 `ConnectionError`
jackson 라이브러리의 ObjectMapper를 사용할 때, 직렬화 또는 역직별화의 대상이 되는 Object를 정의하는데 있어 몇가지 주의할 것을 발견했습니다.

1.  역직렬화(JSON to Object) 시 기본 생성자가 있어야 한다
2.  직렬화(Object to JSON) 시 Getter가 있어야 한다

## try-with-resources

```java
private void send(HttpExchange exchange, HttpResponse httpResponse) throws IOException {
	exchange.sendResponseHeaders(httpResponse.getStatusCode(), httpResponse.getContent().getBytes().length);

	try (OutputStream outputStream = exchange.getResponseBody()) {
		outputStream.write(httpResponse.getContent().getBytes());
		outputStream.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
```
 [이펙티브 자바](http://www.yes24.com/Product/Goods/65551284)의 아이템 9. try-finally보다는 try-with-resources를 사용하라를 참고했습니다.

IO를 할 때 try-finally문을 써서 finally에 close()로 닫는 경우 예외 발생 여지가 있으므로 try-with-resources문을 사용했습니다.

try에서도 예외가 발생하고 finally에서도 예외가 발생하면 close()로 발생한 예외를 프로그래머가 인지하지 못할 가능성이 있다고 이해했습니다.

-   try-with-resources문의 괄호()안에 객체를 생성하는 문장을 넣으면, 이 객체는 따로 close()를 호출하지 않아도 try 블럭을 벗어나면 자동으로 close()를 호출한다.
    -   닫아야 하는 자원은 `AutoCloseable`인터페이스를 구현해서 close()를 호출
    -   try에서 예외 발생, close()에서도 예외가 발생하면 try는 일반 예외 형태로 출력, close() 예외는 Suppresed의 머리말을 달고 출력된다.


## 2주차
 
### ConcurrentHashMap


- hashMap: 동기화를 위한 락을 걸지 않으므로 hashTable보다 빠르지만 멀티쓰레드 환경에서 데이터 무결성을 보장할 수 없음
- hashTable: 데이터 변경 Synhronized로
- synchronizedMap
	- 메소드 전체에 Synhronized, 스레드 안전하지만 비효율
	- Iterator, Spliterator, Stream을 사용할 때는 안전하지 않을 수 있으므로 `Synhronized()`으로 감싸서 사용
- ConcurrentHashMap
	- lock striping을 사용해 부분(기본 16개)적으로 Synhronized, 스레드 안전하고 효율적
 

### layered architecture
- PRESENTATION LAYER --> UI레이어, MVC --> Controller
- APPLICATION LAYER --> 프로그램 기능 --> Service
- DOMAIN LAYER --> 기능들이 어떤 식으로 관계를 맺는가 --> Models
- INFRASTRUCTURE LAYER 


###  `@RestController`

-   해당 클래스가 REST API를 구현한 컨트롤러임을 나타낸다.
-   `@Controller`와는 다르게 RequestBody를 객체로 받기 위해서 메서드에 `@ResponseBody`를 붙여줄 필요가 없다.
- 그 이유는, `@RestController`이 `@Controller` 와 `@RequestBody`의 주요 기능을 묶어 놓았기 때문이에요.  

아래의 Spring Docs를 보시면 정리가 잘 되실거예요.  새로운 인터페이스와 메소드를 공부하실 때마다 Docs를 확인하시는 습관을 들이신다면 정말 많은 도움이 될 거예요.

-   [RestController 에 대해 읽기](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html)

### `@RequestMapping`

-   특정 URL을 클래스나 핸들러 메서드에 매핑해주는 역할을 한다.
-   메서드 레벨에서 path 속성을 통해 각자 매핑할 URL을 설정할 수 있다. (보통 URL에서 공통되는 부분을 클래스 레벨로 빼서 정의한다.)
-   같은 URL에 대해 HTTP 메서드별로 다르게 매핑 하고 싶을 때는 method 속성으로 각각 HTTP 메서드를 설정해 줘야 매핑이 이루어진다. (안 그러면 이미 bean으로 등록돼 있다면서 BeanCreationException 에러가 발생한다.)

### `@GetMapping`, `@PostMapping`, `@PutMapping`, `@PatchMapping` , `@DeleteMapping`

-   같은 URL에 대해 HTTP 메서드별로 다르게 매핑 하고 싶을 때는 method 속성으로 각각 HTTP 메서드를 설정해 줘야 매핑이 이루어진다. (안 그러면 이미 bean으로 등록돼 있다면서 BeanCreationException 에러가 발생한다.)
-   주의) PUT은 데이터 전체를 수정하고, PATCH는 일부 영역만 수정한다.


### 불변 객체 업데이트 빌더 패턴
 
- 빌더패턴 참고 [Make an Immutable Object - in Java](https://dev.to/monknomo/make-an-immutable-object---in-java-480n)

## 5주차

### Mockito에서 given이 무엇인지 몰라 24시간 삽질

Mockito란

Spring은 **DI(_Dependency Injection_)**를 지원해주는데, 이는 객체 간의 의존성을 Spring이 관리해주는 것이다. 그 덕분에 개발자는 의존성 주입을 신경 쓰지 않고 **객체 간의 의존 관계만 잘 고민해서 객체를 설계**하면 된다.

그런데 이런 의존성은 **테스트를 하는 시점**에서 문제를 발생시킨다. 단위 테스트를 작성할 경우 해당 객체에 대한 기능만을 테스트하고 싶은데 **의존성을 가지는 다른 객체에 의해 테스트 결과가 영향을 받을 수 있다는 것**이다.

이렇게 의존을 가지는 객체를 우리가 원하는 동작만 하도록 만든 것이 **Mock 객체**이다.


### `@WebMvcTest()`
 
- `@Controller`, `@ControllerAdvice` 등의 빈을 스캔한다. [자동 설정 목록](https://docs.spring.io/spring-boot/docs/current/reference/html/test-auto-configuration.html#appendix.test-auto-configuration)  
	- `@WebMvcTest(UserController.class)`: 괄호 안에 테스트할 클래스 명시할 수도 있음
- `MockMvc`로 컨트롤러를 자동 설정에 추가한다.
	- 하나의 컨트롤러로 제한하지 않으려면 `@MockBean`으로 등록한다. 

```java

@WebMvcTest(UserController.class)  
class UserControllerTest {

@Autowired  
private MockMvc mockMvc;
  
@MockBean  
private UserService userService;
}
```
 
#### 장점
- 웹 애플리케이션 관련 빈만 등록하므로 빠르다.
-  통합 테스트를 진행하기 어려운 테스트를 진행 가능하다.
ex) 결제 모듈 API를 콜하며 안되는 상황에서 Mock을 통해 가짜 객체를 만들어 테스트 가능.

#### 단점
 - 요청부터 응답까지 모든 테스트를 Mock 기반으로 테스트하기 때문에 실제 환경에서는 제대로 동작하지 않을 수 있다.

#### 예제

```java
@Test  
@DisplayName("찾은 사용자와 상태코드 200을 응답한다")  
void it_responds_found_user_and_status_code_200() throws Exception {  
    //given  
    given(userService.getUser(EXISTING_ID)).willReturn(user);  
    //when  
    mockMvc.perform(get("/users/{id}", EXISTING_ID)  
                    .accept(MediaType.APPLICATION_JSON)  
                    .contentType(MediaType.APPLICATION_JSON))  
              
            // then  
            .andExpect(jsonPath("$.id").exists())  
            .andExpect(jsonPath("name").exists())  
            .andExpect(jsonPath("email").exists())  
            .andExpect(status().isOk());  
}
```

- given: Mock 객체 생성
- when: Mock 객체 반환
- then: 응답 검사

## 출처
- [sprint boot doc](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.spring-boot-applications.spring-mvc-tests)
- [갓대희의 작은공간:티스토리](https://goddaehee.tistory.com/212)


## dirty checking
- JPA의 상태변화 감지 자동 저장 기능
- JPA에서 엔티티 조회 시 스냅샷 생성
- 영속성 컨텍스트 내에서 스냅샷과 다른 상태 변화 감지 시 업데이트 쿼리 호출
- 전체 필드를 업데이트 하는 방식
- 개별 필드를 업데이트하려면 `@DynamicUpdate`를 사용

참고: https://jojoldu.tistory.com/415

공식문서를 참조하고 싶었는데 [jpa 문서](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)에서 dirty checking을 찾을 수 없었습니다. (공식 문서가 아닌가요..??) [Hibernate 문서](https://docs.jboss.org/hibernate/orm/6.0/userguide/html_single/Hibernate_User_Guide.html)에는 dirty checking이 언급되는데 과제 코드에서는 Hibernate를 안 쓴다고 생각했습니다. 이에 검색해서 참고할 블로그를 보니 블로그 내용의 원본은 저번주와 같이 [자바 ORM 표준 JPA 프로그래밍](https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=62681446) 책을 참조했다고 합니다. 

과제 코드에서 dirty checking 로직을 어디서 호출하나 찾아보고 싶었습니다. `JpaUserRepository` 인터페이스에서 `CrudRepository`를 상속하여 SpringData에 접근한다고 생각했는데 막상 `CrudRepository`에 들어가보니 인터페이스만 있고 실행 코드는 찾을 수 없었습니다.

이 [블로그](https://blog.woniper.net/346?category=699184%20%EC%B6%9C%EC%B2%98:%20https://xzio.tistory.com/646%20[%EC%BD%94%EB%94%A9%EC%B0%BD%EA%B3%A0:%ED%8B%B0%EC%8A%A4%ED%86%A0%EB%A6%AC) 를 참조하니 CrudRepository가 [SimpleJpaRepository](http://docs.spring.io/autorepo/docs/spring-data-jpa/1.6.2.RELEASE/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository.html) 구현체에 의해 동작한다는데 CrudRepository에서 어떻게 이어져 있는지는 잘 모르겠습니다. 일단 SimpleJpaRepository 코드를 보니 save 비슷한 코드가 있어서 여기서 작동을 하는 것인가 싶었습니다~!


## 6주차

### Transactional 이 필요한 이유가 무엇인가요?

login 시 트랜잭션의 속성인 [ACID](https://ko.wikipedia.org/wiki/ACID) 을 보장하기 위해서는 `@Tansactional`이 필요한 게 아닌가 합니다.

또한 직접 구현하려면 여러 고려사항을 따져야 하지만 `@Tansactional`을 선언하면 AOP는 프록시를 동적으로 만들어서 스프링 컨테이너에 등록하는 일련의 과정을 수행할 수 있기 때문입니다. 

그런데 트랜잭션 격리수준에 따라 아래의 각 문제가 발생할 여지가 있습니다. 격리수준은 데이터베이스마다 다른데 보통 READ COMMITTED를 기본으로 사용합니다. 과제에서 사용한 [H2의 트랜잭션 격리설정](https://h2database.com/html/advanced.html#transaction_isolation)에서 디폴트 설정이 무엇인지는 잘 모르겠습니다.. ㅠ,ㅠ 

### 트랜잭션 격리수준

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



## 7주차

https://spring.io/guides/topicals/spring-security-architecture




## BasicAuthenticationFilter

Authorization 요청을 처리할 책임이 있다. HTTP 요청의 BASIC Authorization 헤더의 인증 결과가 성공이면 SecurityContextHolder에 둔다. 실패하면 AuthenticationEntryPoint 구현을 호출한다.

## AuthenticationManager

유저의 요청을 AuthenticationFilter에서 Authentication 객체로 변환해 AuthenticationManager에게 넘겨주고, AuthenticationProvider가 실제 인증을 한 이후에 인증이 완료되면 Authentication객체를 반환해준다.

Spring Security는 ProviderManager라는 AuthenticationManager 인터페이스의 유일한 구현체를 제공한다. ProviderManager는 하나 또는 여러 개의 AuthenticationProvider 구현체를 사용할 수 있다.

## Authentication

사용자 ID, 패스워드와 인증 요청 컨텍스트에 대한 정보를 가지고 있다. 인증 이후의 사용자 상세정보와 같은 UserDetails 타입 오브젝트를 포함할 수도 있다

## 출처

-   [BasicAuthenticationFilter](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/web/authentication/www/BasicAuthenticationFilter.html)
-   [Spring boot - Spring Security(스프링 시큐리티) 란? 완전 해결!](https://coding-start.tistory.com/153)
-   [스프링 시큐리티 구조 이해](https://javacan.tistory.com/entry/To-Understand-Spring-Security-Archi)


# 8주

## asciidoctor

블록 매크로 명령어를 사용할 수 있도록 해준다. `*.adoc` 파일에서 `snippets`를 사용하면 `build/generated-snippets.`를 가리킬 수 있도록 자동으로 설정한다.

## testImplementation

테스트 구현 설정에 `spring-restdocs-mockmvc` 의존성을 추가한다. MVC 테스트를 하려면 `MockMvc`를 사용한다.  
테스트 구동 작업으로 요청과 응답에 관한 문서를 만들 수 있다.

출처:

-   [https://docs.spring.io/spring-restdocs/docs/current/reference/html5/](https://docs.spring.io/spring-restdocs/docs/current/reference/html5/)
-  [https://www.baeldung.com/spring-rest-docs](https://www.baeldung.com/spring-rest-docs)


-   MockMvc: 단위테스트에 사용. 실제 서버 환경과 동일한 `@SpringBootTest`가 필요없어 `@WebMvcTest`로 Presentation Layer 빈들만 불러서 테스트한다.
-   RestAssured : 웹 서비스를 검증하기 위해 end-to-end 테스트에 사용. `@SpringBootTest`로 실제 요청을 보내 테스트하며 실제 요청에 필요한 다양한 메서드를 제공
-   WebTestClient: 스프링5에 도입된 리액티브(non-blocking) 테스트 방법

테스트 용도에 따라 다른 프로젝트를 사용하기 위해서 고정이 아닌 선택사항으로 둔 게 아닌가 싶습니다!

## 출처

-   [https://docs.spring.io/spring-restdocs/docs/current/reference/html5/](https://docs.spring.io/spring-restdocs/docs/current/reference/html5/)
-   [https://tecoble.techcourse.co.kr/post/2020-08-19-rest-assured-vs-mock-mvc/](https://tecoble.techcourse.co.kr/post/2020-08-19-rest-assured-vs-mock-mvc/)
