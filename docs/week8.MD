## 회고

Spring Rest Docs를 사용했는데 나는 기존에 스웨거에 익숙해서 그런지 낯설고 불편했다. 그런데 자료를 찾다보니 대부분 스웨거보다 Spring Rest Docs가 낫다는 평이 지배적인 것 같다. 이유는 스웨거의 용도는 API 테스트이고 사용하려면 어노테이션으로 떡칠(안 해봐서 모름)을 해야하기 때문이라고 들었다. 당연한 이야기인데 놓친 것은 내가 보기 편하다고 남들도 편한 건 아니라는 사실이다. 또한 결과(문서)만 판단의 요소가 아니라 결과까지 이르는 여정의 하나하나가 판단의 요소인 것 같다.

도커는 시도를 못해봤다. ~~강의 영상 버퍼링이 심해서..~~  예전에 몇 번 해봤는데 자주 안 쓰니 매번 잊어먹는다. 비단 도커만이 아니라 다른 공부도 마찬가지다. 인위적으로 자주 접해서 망각을 늦추는 방법으로 내가 쓴 글 랜덤 읽기를 조언하신 게 기억이 난다. 그런데 배움과 다시 읽기의 텀이 조금만 길어져도 내가 쓴 글조차 이해가 안 되었다. 자주 써야 할 것 같은 기술은 기록할 때 최대한 자세하게 쓰는 게 좋을 것 같다. 아, 그런데 책에 자세히 써 있는 것은 따로 기록을 안 하는 게 나은 것도 같다.

코드숨

자바, 스프링보다 학습방법, 접근방법 조언


-   내가 하고 싶은 사이드 프로젝트를 통해 찾는 내가 좋아하는 기술
-   많은 면접을 통해 발견하는 내가 좋아하는 기술에 관심을 보이는 회사
-   스프링의 우선순위는 Spring Core, Spring MVC, Spring Data, Test
-   개발자도 회사원이다. 함께 일하고 싶은 회사원이 어떤 모습일까.

## 코드리뷰 코멘트

**다른 수강생분들이 받으신 코멘트도 포함했습니다.**

[669d9f6](https://github.com/CodeSoom/spring-week8-assignment-1/commit/669d9f625c92a88ef624b66c75595e0795ec155b) 좋습니다. 그러나 마지막 줄은 없어도 괜찮았을 거에요.
[![image](https://user-images.githubusercontent.com/1855714/111312920-1f6d9a80-86a3-11eb-95d1-57b821d2af7b.png)](https://user-images.githubusercontent.com/1855714/111312920-1f6d9a80-86a3-11eb-95d1-57b821d2af7b.png)

---

> CI,CD는 방법이 아주 많습니다. 회사에서 사용하는 툴을 먼저 익혀보는 것이 어떨까요? 하나를 알면 다른 툴을 사용할 때도 '내가 쓰던기능은 이 툴에선 어떻게 할 수 있지?' 라는 의문으로 시작하면 어떨까요? 젠킨스를 쓰고 있다면 젠킨스를 github action을 쓰고 있다면 github action을! 없다면 새로운 툴을 도입해보는거죠! 아니면 원하는 회사에서 사용하는 툴을 알아보고 익혀보는거에요!

---

> 저는 사실 Java/Spring 공부를 조금하다가 Lisp에 빠져서 Lisp공부만 했습니다. Lisp를 사용하는 회사에 취직하겠다고 취업전선에 뛰어들었습니다. 하지만 관련 회사가 전혀 없다는 것을 알아차리고 Java/Spring을 쓰는 작은 회사에 들어가게 됩니다.

> 여러회사를 옮기다가 컬리까지 오게되고 리뷰어로 계시는 종립님을 만났었죠. 그러다가 그린랩스라는 회사에서 Lisp계열 언어인 Clojure라는 언어를 사용한다는 소식을 듣고 지원하여 합류하게 됩니다. 빈 프로젝트 폴더에서 시작해서 하나의 프로젝트가 런칭될 때, 그 언어가 오로지 Lisp로 만들어졌을 때 저는 희열을 느꼈습니다.

> 세상에는 여러가지 개발자가 있습니다. 꼭 면접을 위해 무엇을 공부해야 하는가? 라기보다는 내가 무엇을 하고싶은가를 생각하면서 하나의 프로젝트를 만들어보는 것은 어떨까 라는 생각이 듭니다.

> 그럼에도 스프링의 어떤 분야를 깊게 파는게 도움이 될지! 라는 생각이 드신다면! Spring framework 코어, Spring MVC, Spring Data, Test 정도가 되겠네요!

> 참고로 저는 기술면접을 위한 공부는 한 적이 없습니다. 항상 현 회사에서 사용하는 기술에만 집중했고, 제가 관심있는 기술만 습득했어요. 이렇게 공부를 하면 기술면접을 볼 때, 서로가 관심있어하는 기술이 전혀 다르다는 것을 느낄 때도 있습니다. 여기서 그 회사에 가기위해 공부하는가, 아니면 나의 길을 가는가 선택을 하면 됩니다! 일단! 면접을 여러번 보면 무엇이 필요한지 느끼실 거에요! 저는 위에 설명했듯이 반골기질이 있어서 제가 관심있는 공부만 했었습니다. 그럼에도 운명처럼 만나는 회사는 있게 마련이더라고요. ㅎㅎ

> 미래에 함께 일하고 싶은 개발자라... 마치 누구에게 인문한적 조언을 하는 것같아서 감히 제가 어떤 조언도 할 수 없을 것 같아요! 하지만 한가지 분명한건 개발자라고 함께 일하고 싶은 사람이 타분야와 다르지는 않을거에요!

-   내가 하고 싶은 사이드 프로젝트를 통해 찾는 내가 좋아하는 기술
-   많은 면접을 통해 발견하는 내가 좋아하는 기술에 관심을 보이는 회사
-   스프링의 우선순위는 Spring Core, Spring MVC, Spring Data, Test
-   개발자도 회사원이다. 함께 일하고 싶은 회사원이 어떤 모습일까.

---

> 이렇게 비밀 정보를 커밋해서 github에 올리면 곤란합니다! 보통은 비밀 정보가 들어간 yml 파일을 include하는 식으로 해결합니다. 비밀 정보가 있는 yml 파일은 .gitignore에 넣어두죠.

--- 

> `여부`를 제가 좋지 않다고 생각하는 이유는 `여부`가 boolean을 의미하는 두 값을 한꺼번에 표현하기 때문이에요.

> 다음과 같은 코드가 가장 심각한 경우입니다.

```
/* 인증 기간이 지나지 않았는지 여부. */
```

> 괜찮은 습관을 갖춘 프로그래머라면 이렇게 작성하지 않겠지만, 오랜 세월을 거친 방대한 코드를 유지보수하다보면 숱하게 만납니다. 이런 주석을 보면 주석만으로 판단을 할 수가 없죠. 몇 줄 아래로 내려가서 구현체를 봐야 합니다.

> 하지만 다음과 같이 작성하면 주석만 보고도 1초 안에 상황 파악이 끝납니다.

```
/* 인증 기간이 지났다면 true, 지나지 않았다면 false를 리턴합니다. */
```

> `여부`는 별 문제 없어 보인다는 점에서, 아주 가끔씩 치명적인 주석을 작성할 위험이 있는 단어입니다.  
> 그래서 저는 이 단어를 쓰는 것이 나쁜 습관이라 생각해요.

--- 

## Snippet Customize 해보기

-   일부 스니펫의 필드를 수정하거나 추가하고 싶다면 REST Doc 기본 템플릿을 커스마이징할 수 있습니다.
-   기본적으로 스니펫은 [mustache 문법](https://www.tsmean.com/articles/mustache/the-ultimate-mustache-tutorial/)을 사용합니다.
-   커스마이징할 스니펫의 기본 템플릿은 [여기](https://github.com/spring-projects/spring-restdocs/tree/master/spring-restdocs-core/src/main/resources/org/springframework/restdocs/templates/asciidoctor)에서 확인할 수 있습니다.

### request-field 스니펫을 수정해보자

-   간단하게 `default-request-fields.snippet` 을 커스터마이징 해보겠습니다
    -   request-field 중 필수 값 여부를 나타내는 필수값 필드를 추가해보았습니다.
    -   mustache 문법 중 {{^param}}{{/param}} 은 param이 비어 있거나 false 일 때 작동한다고 합니다.

#### `request-field.snippet`

```
===== Request Fields
|===
|필드명|타입|필수값|설명

{{#fields}}
|{{#tableCellContent}}`+{{path}}+`{{/tableCellContent}}
|{{#tableCellContent}}`+{{type}}+`{{/tableCellContent}}
|{{#tableCellContent}}{{^optional}}true{{/optional}}{{/tableCellContent}}     //필수값 필드를 추가함
|{{#tableCellContent}}{{description}}{{/tableCellContent}}

{{/fields}}

|===
```

-   이후에 작성된 `request-field.snippet` 파일을 `src/test/resources/org/springframework/restdocs/templates` 경로에 넣어주면
-   이렇게 변경된 것을 볼 수 있습니다 !

[![Screen Shot 2021-03-19 at 4 10 34 PM](https://user-images.githubusercontent.com/18481400/111751105-6cd24d80-88d7-11eb-88b2-53c16e8640f6.png)](https://user-images.githubusercontent.com/18481400/111751105-6cd24d80-88d7-11eb-88b2-53c16e8640f6.png)

참고: [https://woowabros.github.io/experience/2018/12/28/spring-rest-docs.html](https://woowabros.github.io/experience/2018/12/28/spring-rest-docs.html)

## Sources    
    
- [코드숨 스프링](https://www.codesoom.com/courses/spring)    
- [코드숨 트레이너 John Grib님](https://johngrib.github.io/)    
- [코드숨 트레이너 남영환님](https://github.com/ssisksl77)
