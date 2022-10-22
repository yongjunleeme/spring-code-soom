## 회고   
- [1주차 - 웹 개발 시작하기](docs/week1.MD)  
- [2주차 - Spring Web](docs/week2.MD)  
- [3주차 - Test](docs/week3.MD)  
- [4주차 - Domain](docs/week4.MD)  
- [5주차 - 유효성 검사](docs/week5.MD)  
- [6주차 - 로그인](docs/week6.MD)  
- [7주차 - 보안](docs/week7.MD)  
- [8주차 - 더 나아가기](docs/week8.MD)

## [추가 학습, 오류 해결](docs/troubleShooting.MD)

## 참고 링크

### java
- [Mockito 한글 번역](https://github.com/mockito/mockito/wiki/Mockito-features-in-Korean)

### http
- [http의 기본 포트가 80, https의 기본 포트가 443인 이유는 무엇일까?](https://johngrib.github.io/wiki/why-http-80-https-443/)
- [상태코드별 Reason-Phrase]([https://datatracker.ietf.org/doc/html/rfc7231#section-6.1](https://datatracker.ietf.org/doc/html/rfc7231#section-6.1))
- [RFC 5424](https://datatracker.ietf.org/doc/html/rfc5424): logger를 정의했는데 읽어보라고 하심

### git
- [파일 마지막에 자동으로 1개의 개행 문자 추가하기](https://johngrib.github.io/wiki/intellij/#%ED%8C%8C%EC%9D%BC-%EB%A7%88%EC%A7%80%EB%A7%89%EC%97%90-%EC%9E%90%EB%8F%99%EC%9C%BC%EB%A1%9C-1%EA%B0%9C%EC%9D%98-%EA%B0%9C%ED%96%89-%EB%AC%B8%EC%9E%90-%EC%B6%94%EA%B0%80%ED%95%98%EA%B8%B0)
- [Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
- [Udacity Git Commit Message Style Guide](https://udacity.github.io/git-styleguide/)
- [Git Commit Good Practice](https://wiki.openstack.org/wiki/GitCommitMessages#Example_1_4)

### etc 
- [테스트 디렉토리 설정](https://es2sun.tistory.com/m/216)
  

## 조언  
### 책 처음 받아볼 때 끝까지 훑어보기  
> - 그런데 책을 사서 책이 도착한 날 있잖아요? 그날은 30분 정도 시간을 들여서 처음부터 끝까지 훑어보면 좋습니다. 그러면 나중에 책 안의 내용이 필요한 순간이 왔을 때 아 그거 그 책에 있었던 거 같은데? 하는 경우가 생겨요.  
  
### 공식문서 읽기, 창시자의 글 읽기  
  
- PUT에 200 or 201 무엇으로 응답?  
  - 표준을 먼저 보고 [rfc7231](https://datatracker.ietf.org/doc/html/rfc7231#section-4.3.4)  
  - 번역본을 살펴본다 [MDN](https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/PUT)  
> 처음엔 영어가 어렵고 용어를 잘 모르겠어도 공식 문서, RFC, JLS(Java Language Spec) 등을 읽는 습관을 기르셔야 해요.  
  문제가 생길 때마다 읽기만 해도 됩니다.  
  한달동안 30번 문제가 생겨서 30번 공식 문서를 읽는다고 합시다.  
  10년 후엔 내공이 어떨까요?  
  10년차 개발자가 됐는데 공식 문서 몇 번 안 읽어봤고 그러면 스스로 자신감이 어떨까요?  
  
### 책은 중요한 책부터 확실하게 읽기  
  
> 꼭 읽으세요. 그래서 책을 많이 읽어야지 하면 답이 없어요.  
중요한 것부터 하나라도 확실히 읽으며 가면 됩니다.  
  
  
### 가능하면 new를 최소화 > 가능한 한 new를 최소화하는 것이 스프링의 장점을 최대화하는 것이라고 생각하고 코드 디자인을 하는 것이 중요해요  
  
### 주석을 잘 다는 법  
  
> String.java 부터 시작해 보세요.  
Java 언어를 만든 사람들이 주석을 어떻게 남겼는지 공부하면 많이 배울 수 있을 겁니다.  
  
### 테스트 코드 작성방법, fixture  
  
> 테스트 하나를 연극이나 드라마라고 생각해 보세요. 그리고 fixture를 배우라고 생각해보세요. 처음에는 fixture를 여러개를 만들어서 연극마다 다 다르게 해보시면 됩니다. 그러다 보면 점점 캐릭터가 겹치는 배우가 눈에 보일 거에요. 겹치는 배우를 공용 fixture로 선언해 주면 됩니다.  
  
### 어떻게 공부할 것인가  
> 책, 강의를 반복해서 보는 것을 추천하지는 않습니다. 왜냐하면 효율적이지 못하기 때문이에요. 어떻게 공부할 것인가 라는 책에서 좀 더 자세히 나오기는 하지만, 반복적인 읽기는 효율적이지 않은 것으로 드러났습니다.  
> 책을 읽으면서 `이 책을 읽으면 나는 무엇을 할 수 있게 될까?` 라는 질문을 계속 던져보세요.  
> 책을 읽을 때 저는 문제집을 만들면서 읽습니다. 저 문제에 답할 수 없으면 이 챕터를 넘어가지 않아요  

### 공부방법

>“늘 검색해서 보는 것 보다 이렇게 내가 만든 무언가를 직접 확인하는 것이 빠르게 몸으로 와닿는 경험을 했다.” 직접 체험하신 건 기억도 오래 지속될 거예요. 종종 “내가 뭘 했더라?”란 생각만 해도 장기기억으로 금방 넘어갈 겁니다. 학습 과정을 단순 공부가 아니라 실험이 되도록 설계해 보세요. 제가 자주 하는 말이 “엄청나게 많이 실험해 보세요”인데, 실험을 했냐 안 했냐 차이는 엄청납니다. 엄청 작은 프로그램을 자주 만들어 보세요. [https://github.com/ahastudio/CodingLife](https://github.com/ahastudio/CodingLife "https://github.com/ahastudio/CodingLife")


### 선택의 이유를 설명하는 습관  
  
> 잘 하셨습니다. 여기에서 잘 하셨다고 말씀드린 것은 이름을 잘 선택했다는 뜻이 아닙니다. (여기에서 Changer가 나은지 Updater가 나은지보다 더 중요한 이야기입니다) 결정의 의미를 설명하신 것이 잘 하신 거에요. 앞으로도 선택의 이유를 설명하는 습관을 계속 키워가 보세요. 자신의 코드를 습관적으로 설명하다 보면 코딩할 때에도 코드의 이유를 계속 생각하시면서 작업하시게 될 겁니다.  
  
> 혼자 있을 때에도 자신의 코드를 남에게 설명하는 것처럼 이야기해보는 시간을 가져 보세요.  
  
### PR 작성법  
> PR 본문은 이렇게 작성해 보세요. `what` - `why` - `how` 를 떠올리며 작성하는 것입니다.  
  

### vim으로 인텔리제이와 비슷한 환경을 어떻게 구성 할 수 있나요?

> 인텔리제이가 뭘 어떻게 했는지를 열심히 생각하면서 해야겠죠?
인텔리제이가 하늘에서 뚝 떨어진 게 아니잖아용. 누군가 열심히 이거저거 긁어모아서 만들었겠죠.
컴퓨터를 통해 우리가 하는 많은 일이 프랙탈 구조를 갖고 있죠. 이게 개발 환경 구성하는 일에서도 비슷하다고 생각해요.
코드숨 스프링 과정을 들어보면 초기에 /tasks/123 같은 걸 파싱하는 서브 과제가 주어지는데요
이게 별 거 아닌 일 같지만 문자열 파싱이라는 아주 큼지막한 주제로 진입해 생각할 수 있는 좋은 과제이기도 합니다.
이와 비슷하게 개발환경을 IDE 없이 구성해보는 건 (남들에게 권하기는 곤란한 주제이긴 하지만)
이걸 하면서 결국엔 개인에게 최적화된 사용 경험과 일반 다수의 설정 편의를 어느 정도로 트레이드 오프 하느냐의 문제이기도 했어요.
그래서 IDE 없이 Vim으로 뭘 구성해보는 건 썩 괜찮고 쓸만하지만 매니악한 소프트웨어 하나를 만드는 일과 비슷한 경험이라고도 할 수 있을 거 같습니다.
정반대로 IntelliJ 처럼 많은 사람들이 어려움 없이 편리하게 사용하는 애플리케이션에 대해서도 많이 생각하게 됐고요.   


### ETC  
  
> 커밋 메세지를 먼저 적고 작업해보세요.  

---

> List 혹은 Collection을 사용해야하는 목적과 다른 사람이 추론하기 쉽게하기 위함이군요.
> 코드는 한 번 쓰고 여러번 읽으니까요.

---

> [포스텔의 법칙](https://johngrib.github.io/wiki/Postel-s-law/)
> 그런데 한편 이 관대함을 끝까지 밀어놓고 보면 또 다른 것이 보입니다. shell script 의 매력.    
> 셸 스크립트는 문자열 리스트를 받아서 문자열 리스트를 리턴하죠.
> 셸 명령 하나하나는 문자열 하나만 받아서 스스로를 방어하고, 스스로 파싱하고, 스스로 검증하고, 문자열 하나를 내놓는 셈입니다.
> 셸 명령들에 재미가 붙으면 타입이 하나 있는 언어의 매력이 이런 것인가! 하는 느낌도 받게 됩니다.
   
---

> AST 구현 연습하기 제일 적절한 난이도의 과제는 역시 JSON 일 거에요. JSON 으로 한번 해보세요.
연산자 우선순위같은 귀찮은 서브 과제도 없죠.
처음부터 JSON의 모든 타입을 지원하는 게 아니라 처음엔 객체와 스트링만 지원하는 JSON 파서를 만드는 겁니다.
그러면 콤마, 쌍따옴표, 중괄호를 인식하게 만들고 재귀하게 만들면 그만이죠.
그리고 정수 추가하고, 실수 추가하고, 배열 추가하고...

---

## Sources  
  
- [코드숨 스프링](https://www.codesoom.com/courses/spring)  
- [코드숨 트레이너 John Grib님](https://johngrib.github.io/)  
- [코드숨 트레이너 아샬님](https://www.youtube.com/channel/UCLLncfeIYljE0o_yUw7MkcA)  
- [코드숨 트레이너 한윤석님](https://hannut91.github.io/)
 
