 ## 회고

```java
@WebMvcTest(UserControllerTest.class)
@WebMvcTest(UserController.class)
```

과제 테스트를 하면서 위 코드 중 위에 것을 쓰는 바람에 무려 1.5일 가까이 정체되었다. 오류 메시지를 봐도 전체 코드를 살펴 보아도 이것저것 다 해봐도 해결이 안 됐다. 트레이너님께 질문을 드렸고 답변을 코드로 주셨다. 그런데도 나는 코드는 못 보고 코멘트만 보아서 또 정체를 이어갔다. 나중에 해결하고 나서 코멘트를 보니 코드가 보였다. 하하;; 

시간이 없다고 생각하니 더 근시안적인 마음을 먹어서 그런가 어떤 원리를 살펴볼 행동은 취하지 않고 내가 가진 개념 가운데 추론하여 이것 저것 고쳐보고 에러에 관한 구글검색만 했다. 아샬님이 언급했던 멘탈 모델이 떠오른다.. 크게 봐서 지금 내 공부 계획도 근시안적으로 당장의 과제만 보고 흘러가는 것은 아닌가 걱정이 되었다. 해야 할 공부종류가 너무 많아서 당장 이해만 되면 넘어가는 식이다. 

그렇다면 깊은 공부를 해야 할 때는 언제이고 어떻게 해야 하나? 내가 오류를 직접 맞닥뜨리거나 이건 왜?라는 궁금증이 생기면 자연스럽게 인덱스가 생겨 기억에 오래남을 뿐더러 좀더 깊게 살펴보기도 하는 것 같다. 이번 과제 중에서 `updateUser()`에는 `save`가 없는데 어떻게 저장이 되는 것인지 궁금했다. 트레이너님께 질문을 드렸고 `dirty checking`을 알게 되었다. 내가 궁금하니 코드도 뒤져보고 자연스럽게 정리도 하는데 즐거웠다. 

그런데 시간을 많이 썼다. 그나마 토요일 아침에 풀이영상이 갑자기 열리지 않은 덕분에 몇 시간이 확보되어서 알아보는 데 시간을 썼다. 아마 평소 루틴이었으면 계획된 일을 하느라 궁금증 해결 시간을 덜 썼을 것이다. 

종합해보면 실제 내가 코드를 짜야 오류와 궁금증을 둘 다 만나고 거기에 쓰이는 공부는 즐겁고 깊게 할 수 있지 않나 싶다. 그리고 마음과 시간의 여유가 필요할 것 같다. 남보다 잘 하기 위해서 코딩 배우는 게 아니라 내가 전보다 더 잘 만들기 위해서 배우는 것이다. 이 즐거움을 누리는 게 급하게 남들 쫓아가는 것보다 나한테는 더 중요하다.
  
## Review Comment

> 다른 분들이 받은 코멘트도 추가했습니다.

> 1.  `Controller`에서 `@Valid`에 대한 예외 처리가 `MethodArgumentNotValidException.class`로 가능한 걸로 알고 있습니다. 그런데, 저는 이전에 우리가 NOT_FOUND 예외를 `ProductNotFoundException` 으로 처리했던 것처럼 잘못된 요청에 대해서는`ProductBadReqeustException`을 통해서 처리하기를 원합니다. 제가 만든 예외로 커스터마이징해서 인식하게 하려면 어떻게 해야 할까요?

### `@Valid`

[https://github.com/edalorzo/fundamental-programming#spring-controller-barricade](https://github.com/edalorzo/fundamental-programming#spring-controller-barricade)  
이런 방법이 있습니다. 그런데 실제로 쓰는 건 거의 못 봤어요. 보통 `@Valid`의 처리 결과 던져진 예외는 `@NotBlank` 같은 애노테이션에 인자로 넘겨준 에러 메시지로 응답하도록 작업해 둡니다. 그래서 `@NotBlank(message = "공백이면 안됩니다.")` 보통 이렇게 하는 것으로 충분한 느낌입니다.

현재 작업하신 상태에서 제가 다음과 같이 작업해 봤습니다.

`@NotBlank`
[![image](https://user-images.githubusercontent.com/1855714/108852282-bf964d80-7628-11eb-9465-94ab23e22aa8.png)](https://user-images.githubusercontent.com/1855714/108852282-bf964d80-7628-11eb-9465-94ab23e22aa8.png)
`ErrorAdvice`
[![image](https://user-images.githubusercontent.com/1855714/108852311-ca50e280-7628-11eb-971e-f36aef6c60f4.png)](https://user-images.githubusercontent.com/1855714/108852311-ca50e280-7628-11eb-971e-f36aef6c60f4.png)

그리고 다음과 같이 `curl`을 사용해 HTTP 요청을 보내봤습니다.

```
curl -s -H 'Content-Type: application/json' \
  -D - -X POST \
  --data '{  "name": "123", "maker": "", "price": 1}' 'http://localhost:8080/products'
```

그러니 이런 결과가 돌아갑니다. 이 결과를 더 예쁘게 가공해 쓸 수도 있겠죠.  
[![image](https://user-images.githubusercontent.com/1855714/108852525-11d76e80-7629-11eb-8840-1147c73d142f.png)](https://user-images.githubusercontent.com/1855714/108852525-11d76e80-7629-11eb-8840-1147c73d142f.png)

작업하신 상태에서는 `handleProductBadRequestException`가 이걸 가로채서 다음 결과만 나옵니다.

```
HTTP/1.1 400 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 23 Feb 2021 13:48:14 GMT
Connection: close

{"message":"Product bad request"}
```

> 2.  `Controller`에서 `@Valid`가 처리되는 것으로 보아, `Service`에서는 `@Valid`와 연관이 별로 없는 것으로 생각됩니다. 이게 맞다면, `ServiceTest`에서는 가령 `create`에서 이름이 없다던가, 메이커가 없다든가 등의 잘못된 요청에 대한 예외 작성은 어떤 식으로 해야할까요? `Service` 내에서는 예외를 잡는 부분이 없는 것 같아서 `given`, `verify`에 대한 작성을 못했습니다.

### Service 에서의 예외

다른 평범한 Java 애플리케이션을 작성하는 것과 크게 다를 바 없습니다. 예외를 던져야 한다면 예외를 던지고, 예외를 받는(`catch`) 녀석은 예외를 스스로 해결하던가, 또는 자신의 호출자에게 한 번 더 던질 것인가를 결정해야 합니다. `Service 내에서는 예외를 잡는 부분이 없는 것 같`다면 Service 내 코드에서 예외를 던지고 잡는 코드를 추가하면 됩니다. 예외가 던져지는 곳이 서비스인지 컨트롤러인지는 별로 중요하지 않습니다.

> 3-1. 길어지는 update에서의 `@Display`를 어떻게 작성해야 할지 고민입니다.

```
@DisplayName("만약 저징되어 있는 고양이 장난감의 아이디와 업데이트 될 이름, 메이커, 가격, 이미지가 주어진다면")
```

이것이 명확하게 동작을 드러낸다고 생각했는데 너무 긴 것이 아닌가 생각했습니다.

```
@DisplayName("만약 저장되어 있는 고양이 장난감의 아이디와 업데이트 될 객체가 주어진다면")
```

> 3-2. 업데이트 시, 매개변수는 `id`와 `Product`가 모두 필요한대, id와 상관없이 객체에서 `메이커가 없을 때` 를 검사한다면, id에 대한 부분은 생략해도 될까요?

```
@DisplayName("만약 저징되어 있는 고양이 장난감의 아이디와 메이커가 비어있는 객체가 주어진다면")
```

```
@DisplayName("만약 메이커가 비어있는 객체가 주어진다면")
```

### `@DisplayName`

이건 정답이 없어서 상황에 맞는 더 좋은 메시지를 항상 고민하는 수 밖에 없습니다.  
`만약 저징되어 있는 고양이 장난감의 아이디와 업데이트 될 이름, 메이커, 가격, 이미지가 주어진다면` 같은 메시지는 저도 참 고민스럽네요. 저라면 테스트 메시지를 조금 더 추상화할 것 같아요. 테스트 설명은 너무 추상적이어도 안 되지만 너무 구체적이어도 좋지 않습니다.



> 4.  `@NotNull` , `@NotBlank` 의 어노테이션에 대한 테스트는 어떻게 면밀히 검증할까요?  
    `@NotNull`의 경우 `null`은 불가, `""`와 `" "`는 허용  
    `@NotBlank`의 경우 `null`, `""`, `" "`모두 불가

> `null`, `""`, `" "` 모두 유의미한 차이가 있을까요? 먼저, 입력값이 없으면 `생성` 버튼을 눌렀을 때, null이 넘어가나요, `""`이 넘어가나요? `@NotNull`과 `@NotBlank`라고 구분해서 사용한 것이 유의미한 차이가 있을거라고 생각해서 `@DisplayName`에서 `blank 일 때`, `null일 때` 이런식으로 나눴는데, 크게 상관없을까요?


### `@NotNull`, `@NotBlank`

이 테스트는 제 경우엔 Http Rest 테스트로 처리하곤 합니다. 또는 예외가 던져지는지 정도까지만 확인해요.  
그리고 `blank일 때`, `null일 때`를 나누는 것은 테스트 코드 양이 상당히 늘어나고, 작성하는 사람도 굉장히 피곤하죠. 이런 경우엔 배열이나 `List`를 사용해서 테스트 코드를 회전시키는 방법을 권합니다. (이번주에 리뷰하면서 도와드릴게요).

> 그렇다면 결국 `Service`에서 예외가 처리되니까 `Controller`에서 `try-catch`를 사용하거나 따로 예외처리를 하지 않아도 되지 않나요?

그렇습니다! 제가 기다리던 질문입니다. 예외를 반드시 컨트롤러에서만 처리해야 한다고 믿는 사람들도 있는데요, 사실도 아니고 바람직하지도 않은 믿음입니다. 우리는 여기에서 컨트롤러 레이어, 서비스 레이어로 이루어진 여러 계층의 소프트웨어를 작성하고 있는 셈인데요. 어떤 예외는 레이어를 넘나들고, 어떤 예외는 레이어 내에서 다른 레이어에 공개되지 않도록 조용히 처리해야 합니다. 두 예외를 잘 구분해서 처리해야겠죠. 핵심은 이것입니다. "서비스/컨트롤러 입장에서 외부에 공개해야 하는 예외 상황이란 무엇이며 외부에 알리지 않고 조용히 처리할 예외는 무엇인가?"

여기에서 또다시 취향이 갈리고, 팀 컨벤션이 생기고 하는 영역이 됩니다. 제 취향은 가급적이면 예외를 던지지 않고 예외가 발생한 곳에서 잘 처리하는 것이긴 한데요, 어떤 사람은 제 의견에 크게 반대하기도 할 것입니다.

다음에 대해서도 잘 생각해 봅시다.

-   동영상 파일에 0.1초 정도 손상된 구간이 있다면 동영상 재생 프로그램은 사용자에게 예외를 알리지 않고 0.1초 정도 까만 화면을 보여주고(알아서 예외를 처리하고) 계속 다음 장면을 재생한다.
-   프린터기로 뭔가를 출력할 때 종이가 부족하면 프린터기는 기계에도 빨간 불을 켜고, 프린터 출력 프로그램에도 종이가 없다는 것을 알리고, 모니터에도 종이가 없다는 경고 메시지를 띄운다.


`@Valid는 @Controller에서만 정상적으로 작동하기 떄문에 @Service에서는 사용 할 수 없다.`는 사실이 아닙니다. 서비스에서도 사용할 수 있는데 좀 더 귀찮죠.

`id`를 컨트롤러에서 존재여부 확인이 불가능...하지는 않습니다. 리턴 타입에 주목하면 해결할 수 있는 문제입니다. 이 문제의 가장 널리 알려진 해결책은 `Optional`을 쓰는 거죠.

`checked exception`과 `unchecked exception`에 대해 공식 문서를 읽어 보시기를 권해드립니다.  
[https://docs.oracle.com/javase/specs/jls/se15/html/jls-11.html#jls-11.1.1](https://docs.oracle.com/javase/specs/jls/se15/html/jls-11.html#jls-11.1.1)


`Product`같은 엔티티를 컨트롤러를 통해 HTTP 응답으로 유출하지 않는 것이 좋습니다. 전용의 POJO 객체 사용을 고려해 보시면 어떨까요?

```java
@Getter
@Setter
@Entity
@Builder
```

`@Builder`를 `class` 선언 바로 위에 선언하는 것은 안티패턴입니다. `@Builder`를 올바르게 사용하는 방법에 대해 조사해서 설명해 보세요.


```java
private static final Long EXIST_ID = 1L;
private static final Long NOT_EXIST_ID = 100L;
```
이 두 값에 논리적인 근거가 없습니다.

`NOT_EXIST_ID`를 만드는 논리적인 방법은 두 가지가 있습니다.

1.  `NOT_EXIST_ID`를 사용하기 전에 `NOT_EXIST_ID`로 상품을 찾아 지워버립니다.
2.  `NOT_EXIST_ID`를 사용하기 전에 모든 상품을 지웁니다.

이렇게 하면 확실히 `NOT_EXIST_ID`는 존재하지 않는 아이디가 되겠죠.  
테스트에서 가장 중요한 것은 논리입니다. 그 외의 모든 것은 논리를 돕기 위한 도구입니다.

## `@WebMvcTest()`

-   `@Controller`, `@ControllerAdvice` 등의 빈을 스캔한다. [자동 설정 목록](https://docs.spring.io/spring-boot/docs/current/reference/html/test-auto-configuration.html#appendix.test-auto-configuration)
    -   `@WebMvcTest(UserController.class)`: 괄호 안에 테스트할 클래스 명시할 수도 있음
-   `MockMvc`로 컨트롤러를 자동 설정에 추가한다.
    -   하나의 컨트롤러로 제한하지 않으려면 `@MockBean`으로 등록한다.

@WebMvcTest(UserController.class)  
class UserControllerTest {

@Autowired  
private MockMvc mockMvc;
  
@MockBean  
private UserService userService;
}

### 장점

-   웹 애플리케이션 관련 빈만 등록하므로 빠르다.
-    통합 테스트를 진행하기 어려운 테스트를 진행 가능하다.  
    ex) 결제 모듈 API를 콜하며 안되는 상황에서 Mock을 통해 가짜 객체를 만들어 테스트 가능.

### 단점

-   요청부터 응답까지 모든 테스트를 Mock 기반으로 테스트하기 때문에 실제 환경에서는 제대로 동작하지 않을 수 있다.

### 예제

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

-   given: Mock 객체 생성
-   when: Mock 객체 반환
-   then: 응답 검사

## dirty checking

-   JPA의 상태변화 감지 자동 저장 기능?
-   JPA에서 엔티티 조회 시 스냅샷 생성
-   영속성 컨텍스트 내에서 스냅샷과 다른 상태 변화 감지 시 업데이트 쿼리 호출
-   전체 필드를 업데이트 하는 방식
-   개별 필드를 업데이트하려면 `@DynamicUpdate`를 사용

참고: [https://jojoldu.tistory.com/415](https://jojoldu.tistory.com/415)

공식문서를 참조하고 싶었는데 [jpa 문서](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)에서 dirty checking을 찾을 수 없었습니다. (공식 문서가 아닌가요..??) [Hibernate 문서](https://docs.jboss.org/hibernate/orm/6.0/userguide/html_single/Hibernate_User_Guide.html)에는 dirty checking이 언급되는데 과제 코드에서는 Hibernate를 안 쓴다고 생각했습니다. 이에 검색해서 위 참고 블로그를 보니 내용의 원본은 저번주와 같이 [자바 ORM 표준 JPA 프로그래밍](https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=62681446) 책을 참조했다고 합니다. 모든 길은 이 책으로 통하는 것인지...ㅎㅎ;

과제 코드에서 dirty checking 로직을 어디서 호출하나 찾아보고 싶었습니다. `JpaUserRepository` 인터페이스에서 `CrudRepository`를 상속하여 SpringData에 접근한다고 생각했는데 막상 `CrudRepository`에 들어가보니 인터페이스만 있고 실행 코드는 찾을 수 없었습니다.  
이 [블로그](https://blog.woniper.net/346?category=699184%20%EC%B6%9C%EC%B2%98:%20https://xzio.tistory.com/646%20%5B%EC%BD%94%EB%94%A9%EC%B0%BD%EA%B3%A0:%ED%8B%B0%EC%8A%A4%ED%86%A0%EB%A6%AC) 를 참조하니 CrudRepository가 [SimpleJpaRepository](http://docs.spring.io/autorepo/docs/spring-data-jpa/1.6.2.RELEASE/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository.html) 구현체에 의해 동작한다는데 CrudRepository에서 어떻게 이어져 있는지는 잘 모르겠습니다. 일단 SimpleJpaRepository 코드를 보니 save 비슷한 코드가 있어서 여기서 작동을 하는 것인가 싶었습니다~!

[![simpleJpaRepository](https://user-images.githubusercontent.com/48748376/171967039-0f364cac-d3c2-470a-b161-93cd5e268c70.png)](https://user-images.githubusercontent.com/48748376/171967039-0f364cac-d3c2-470a-b161-93cd5e268c70.png)

-  출처: [sprint boot doc](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.spring-boot-applications.spring-mvc-tests)
-  출처: [갓대희의 작은공간:티스토리](https://goddaehee.tistory.com/212)


## Sources    
    
- [코드숨 스프링](https://www.codesoom.com/courses/spring)    
- [코드숨 트레이너 기계인간님 John Grib](https://johngrib.github.io/)    
- [코드숨 트레이너 남영환님](https://github.com/ssisksl77)
