# **전문가를 위한 스프링 5 (006987)** 

![전문가를 위한 스프링 5 Cover](./document/images/cover_front.png)

## 전문가를 위한 스프링 5 :: 

<전문가를 위한 스프링 5> 의 소스 코드를 이클립스에서 빌드하는 방법과 실행 방법을 소개합니다.

###  예제 버전
- Spring Framework 5.1.18
- Spring Boot 2.1.6
- JDK 8
- 개발환경 : 이클립스(Eclipse IDE 2019-06 R Packages의 Eclipse IDE for Enterprise Java Developers)

### 소스 코드 다운로드하여 프로젝트 환경 구성하기 

깃헙 리포지토리 우측 상단의 'Clone or download' 녹색 버튼을 클릭하고 'Download Zip'으로 압축 파일을 받아서 원하는 곳에 압축을 풉니다.

다음 순서에 따라 이클립스에서 프로젝트를 임포트합니다.

1. 이클립스 실행
2. File > Import 선택
3. Select an import wizard 에서 'gradle'으로 검색
4. 'Existing Gradle Project' 선택 (Next 버튼)
5. github에서 받은 예제 프로젝트 디렉터리를 선택
6. Finish 버튼 클릭해서 프로젝트를 임포트
7. 이클립스의 Gradle Tasks 에서 빌드 실행 (필요시)

예제 파일은 파일 우클릭 > Run As > Java Application을 선택하여 실행합니다. 

예) 'hello-world' 프로젝트의 'HelloWorldSpringDI.java' 파일 우클릭 > Run As > Java Application 실행

```
 --> HelloWorldMessageProvider: 생성자가 호출됨
 --> StandardOutMessageRenderer: 생성자가 호출됨
 --> StandardOutMessageRenderer: messageProvider 설정
Hello World!

``` 

### Git Clone 으로 프로젝트 환경 구성하기  

깃헙 리포지토리 우측 상단의 'Clone or download' 녹색 버튼을 클릭하고 'Clone with HTTPS'의 리포지토리 주소를 복사합니다. (우측에 있는 아이콘 클릭)

다음 순서에 따라 이클립스에서 깃 프로젝트를 임포트합니다.

1. 이클립스 실행
2. Window > Show View > Git Repositories 선택
3. 'Clone a Git Repository' 선택 (Next 버튼 > Next 버튼 > Finish 버튼)
4. File > Import 선택
5. Select an import wizard > 'Existing Maven Projects' 선택 (Next 버튼)
6. github에서 받은 예제 프로젝트 디렉터리를 선택
7. Finish 버튼 클릭해서 프로젝트를 임포트

예제 파일은 파일 우클릭 > Run As > Java Application을 선택하여 실행합니다. 

예) 'hello-world' 프로젝트의 'HelloWorldSpringDI.java' 파일 우클릭 > Run As > Java Application 실행

```
 --> HelloWorldMessageProvider: 생성자가 호출됨
 --> StandardOutMessageRenderer: 생성자가 호출됨
 --> StandardOutMessageRenderer: messageProvider 설정
Hello World!

``` 

### 참고 문서 및 링크
 - [**Spring** 공식 사이트](https://spring.io/)
 - [**Spring Framework** 깃허브 사이트](https://github.com/spring-projects/spring-framework)
 - [**Eclipse** 다운로드 사이트](https://www.eclipse.org/downloads/)

 
### 정오표

| 페이지 수 | 변경 전 | 변경 후 |
|:-------|-------:|:------:|
|        |        |        |

(ver 20190903 )
<br>
<br>
