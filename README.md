## Goal
- [자바공화국](https://jojoldu.tistory.com/609) 시민이 되어보자.
- 코딩친구 만들기
  - 나이 먹고 시작해서 그런가, 성격 탓인가. 코딩친구가 없는데(~~사실 친구도 없음~~) 자바지기 박재성님에 따르면 코딩친구가 성장 핵심 중 하나라고 한다.

## 커리큘럼

- [0주차](docs/week0.MD)
- [1주차 - 웹 개발 시작하기](docs/week1.MD)
- [2주차 - Spring Web](docs/week2.MD)
- [3주차 - Test](docs/week3.MD)
- [4주차 - Domain](docs/week4.MD)

## 참고 링크

### java

- [Static 대신 객체 사용하기 #1](https://www.youtube.com/watch?v=qRZL2NkXRdo&ab_channel=%EC%BD%94%EB%94%A9%EC%9D%98%EC%8B%A0%EC%95%84%EC%83%AC)

### http
- [http의 기본 포트가 80, https의 기본 포트가 443인 이유는 무엇일까?](https://johngrib.github.io/wiki/why-http-80-https-443/)
- [상태코드별 Reason-Phrase](https://datatracker.ietf.org/doc/html/rfc7231#section-6.1)

### git
- [파일 마지막에 자동으로 1개의 개행 문자 추가하기](https://johngrib.github.io/wiki/intellij/#%ED%8C%8C%EC%9D%BC-%EB%A7%88%EC%A7%80%EB%A7%89%EC%97%90-%EC%9E%90%EB%8F%99%EC%9C%BC%EB%A1%9C-1%EA%B0%9C%EC%9D%98-%EA%B0%9C%ED%96%89-%EB%AC%B8%EC%9E%90-%EC%B6%94%EA%B0%80%ED%95%98%EA%B8%B0)

### etc
- [Three Fs](https://github.com/ahastudio/til/blob/main/retrospective/three-fs.md)
- [j 언어](https://github.com/ahastudio/til/tree/main/j)

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
  
### ETC  
  
> 커밋 메세지를 먼저 적고 작업해보세요.  

> List 혹은 Collection을 사용해야하는 목적과 다른 사람이 추론하기 쉽게하기 위함이군요.
> 코드는 한 번 쓰고 여러번 읽으니까요.

> [포스텔의 법칙](https://johngrib.github.io/wiki/Postel-s-law/)
> 그런데 한편 이 관대함을 끝까지 밀어놓고 보면 또 다른 것이 보입니다. shell script 의 매력.    
> 셸 스크립트는 문자열 리스트를 받아서 문자열 리스트를 리턴하죠.
> 셸 명령 하나하나는 문자열 하나만 받아서 스스로를 방어하고, 스스로 파싱하고, 스스로 검증하고, 문자열 하나를 내놓는 셈입니다.
> 셸 명령들에 재미가 붙으면 타입이 하나 있는 언어의 매력이 이런 것인가! 하는 느낌도 받게 됩니다.

## Sources  
  
- [코드숨 스프링](https://www.codesoom.com/courses/spring)  
- [코드숨 트레이너 기계인간님 John Grib](https://johngrib.github.io/)  
- [코드숨 트레이너 아샬님](https://www.youtube.com/channel/UCLLncfeIYljE0o_yUw7MkcA)  
- [코드숨 트레이너 한윤석님](https://hannut91.github.io/)
 
