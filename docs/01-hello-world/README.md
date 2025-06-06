# Java 입문 - Hello World

## 📋 목차
- [개발 환경 설정](#개발-환경-설정)
- [다운로드 소스 코드 실행 방법](#다운로드-소스-코드-실행-방법)
- [자바 프로그램 실행](#자바-프로그램-실행)
- [주석(comment)](#주석comment)
- [자바란?](#자바란)

## 🛠 개발 환경 설정

### IDE 선택: IntelliJ vs Eclipse
- **IntelliJ IDEA** (권장): 빠른 속도와 편의성으로 최근에 주로 사용
- **Eclipse**: 과거에 많이 사용되었지만 현재는 IntelliJ가 대세

### OS 선택: Windows vs Mac
- 자바로 개발하는 대부분의 메이저 회사들은 **Mac** 사용
- **Windows**를 사용해도 무방함
- 강의는 Mac 기준이지만 Windows 사용자 배려

### IntelliJ IDEA 설치

#### 다운로드 링크
- [IntelliJ IDEA 다운로드](https://www.jetbrains.com/ko-kr/idea/download)
- **Community Edition (무료 버전)** 사용 권장

#### OS별 설치 파일 선택
- **Windows**: `.exe` 파일 선택
- **macOS**:
    - M1, M2, M3: Apple Silicon 선택
    - 나머지: Intel 선택

> **참고**: 자바 언어 학습 단계에서는 무료 버전(Community Edition)으로 충분합니다.

## 🚀 프로젝트 생성 및 실행

### 새 프로젝트 생성
1. **New Project** 선택
2. 프로젝트 설정:
    - **Name**: `java-start`
    - **Location**: 원하는 위치 선택
    - **Create Git repository**: 선택하지 않음
    - **Language**: Java
    - **Build system**: IntelliJ
    - **JDK**: 자바 버전 17 이상
    - **Add sample code**: 선택

### JDK 다운로드
- **Version**: 21 선택
- **Vendor**: Oracle OpenJDK 또는 Eclipse Temurin 21
- **aarch64**: Apple M1/M2/M3 CPU 사용시 선택

> **주의**: Oracle OpenJDK 21이 없다면 Eclipse Temurin 21을 선택하세요.

## 📁 다운로드 소스 코드 실행 방법

### 기존 프로젝트 열기
1. **File** → **New** → **Project from Existing Sources...** 선택
2. 압축을 푼 프로젝트 폴더 선택
3. **Create project from existing sources** 선택
4. 계속 **Next** 선택
5. **openjdk-21** 선택 (없다면 + 버튼으로 다운로드)
6. **Create** 버튼 선택

## 💻 자바 프로그램 실행

### HelloJava 예제
```java
public class HelloJava {
    public static void main(String[] args) {
        System.out.println("hello java");
    }
}
```

**실행 결과:**
```
hello java
```

### 코드 분석

#### `public class HelloJava`
- **HelloJava**를 클래스라 함
- 파일명과 클래스 이름이 같아야 함
- `{}` 블록으로 클래스의 시작과 끝을 나타냄

#### `public static void main(String[] args)`
- **main 메서드**: 프로그램의 시작점
- 자바는 `main(String[] args)` 메서드를 찾아서 프로그램 시작
- `{}` 블록으로 메서드의 시작과 끝을 나타냄

#### `System.out.println("hello java");`
- **System.out.println()**: 값을 콘솔에 출력하는 기능
- **"hello java"**: 문자열은 `"` (쌍따옴표)로 감쌈
- **`;`**: 자바는 세미콜론으로 문장을 구분 (필수)

### 실행 과정
1. HelloJava 프로그램을 실행
2. 자바는 시작점인 `main()` 메서드를 실행
3. `System.out.println("hello java")`를 만나고 문자열 출력
4. `main()` 메서드의 `{}` 블록이 끝나면 프로그램 종료

### 괄호의 종류
- **소괄호** `()`
- **중괄호** `{}`
- **대괄호** `[]`

### 블록(Block) 예시
```java
public class HelloJava { // HelloJava 클래스의 범위 시작
    public static void main(String[] args) { // main() 메서드의 범위 시작
        System.out.println("hello java");
    } // main() 메서드의 범위 끝
} // HelloJava 클래스의 범위 끝
```

> **들여쓰기**: 블록이 중첩될 때마다 스페이스 4번 사용 (IntelliJ에서 Tab 키 자동 적용)

### 추가 예제: HelloJava2
```java
public class HelloJava2 {
    public static void main(String[] args) {
        System.out.println("hello java1");
        System.out.println("hello java2");
        System.out.println("hello java3");
    }
}
```

**실행 결과:**
```
hello java1
hello java2
hello java3
```

> 프로그램은 `main()`을 시작으로 위에서 아래로 한 줄씩 실행됩니다.

## 📝 주석(comment)

주석은 소스 코드에 대한 설명을 적거나 특정 코드의 실행을 임시로 막을 때 사용합니다.

### 주석의 종류

#### 한 줄 주석 (Single Line Comment)
```java
// 이 부분은 주석입니다
System.out.println("hello java1"); // 부분 적용 주석
```

#### 여러 줄 주석 (Multi Line Comment)
```java
/*
여러 줄에 걸친
주석입니다
*/
```

### CommentJava 예제
```java
public class CommentJava {
    /*
    주석을 설명하는 부분입니다.
    */
    public static void main(String[] args) {
        System.out.println("hello java1"); // hello java1을 출력합니다
        // System.out.println("hello java2"); // 이 줄은 실행되지 않음
        
        /* 여러 줄 주석
        System.out.println("hello java3");
        System.out.println("hello java4");
        */
        
        System.out.println("hello java3");
    }
}
```

**실행 결과:**
```
hello java1
hello java3
```

## ☕ 자바란?

### 자바 표준 스펙과 구현

#### 자바 표준 스펙
- 자바는 이렇게 만들어야 한다는 **설계도이며 문서**
- 자바 커뮤니티 프로세스(JCP)를 통해 관리
- 여러 회사에서 이 표준 스펙을 기반으로 실제 작동하는 자바를 개발

#### 다양한 자바 구현체
- **Oracle OpenJDK**
- **Eclipse Temurin (AdoptOpenJDK)**
- **Amazon Corretto** (AWS에 최적화)

> 자바 구현체들은 모두 표준 스펙에 맞도록 개발되어 있어, 대부분 문제없이 호환됩니다.

### 컴파일과 실행 과정

```
Hello.java (소스코드)
    ↓ javac (자바 컴파일러)
Hello.class (바이트코드)
    ↓ java (자바 실행기)
실행 결과
```

#### 컴파일
- **javac Hello.java**: 소스 코드를 바이트코드로 변환
- `.java` → `.class` 파일 생성
- 문법 오류 검출 및 최적화

#### 실행
- **java Hello**: 바이트코드를 실행
- 자바 가상 머신(JVM)이 실행되면서 프로그램 작동

### IDE와 자바

#### IntelliJ의 자바 관리
- 내부에 자바를 편리하게 설치하고 관리
- 컴파일과 실행을 자동으로 처리
- 복잡한 환경 설정 없이 개발 가능

#### 자동 처리 과정
- **컴파일**: IntelliJ가 `javac`를 자동 실행
- **실행**: IntelliJ가 `java`를 자동 실행
- **out 폴더**: 컴파일된 `.class` 파일 확인 가능

### 자바와 운영체제 독립성

#### 일반적인 프로그램
- 특정 OS에서만 실행 가능
- 윈도우 프로그램은 Mac이나 Linux에서 실행 불가

#### 자바 프로그램
- **"Write Once, Run Anywhere"**
- 자바가 설치된 모든 OS에서 실행 가능
- `.class` 파일은 모든 자바 환경에서 동일하게 작동

#### 개발과 운영 환경
- **개발**: Windows, Mac (편의성)
- **서버**: Linux (안정성)
- **AWS**: Amazon Corretto + Linux

```
개발자 PC (Windows/Mac) → Hello.class → 서버 (Linux)
```

## 🎯 핵심 포인트

1. **IntelliJ IDEA Community Edition** 사용 권장
2. **JDK 21** 이상 설치
3. **main 메서드**는 프로그램의 시작점
4. **세미콜론(;)**은 문장의 끝을 표시 (필수)
5. **자바는 대소문자를 구분**
6. **주석**을 활용해 코드 설명 및 임시 비활성화
7. **운영체제 독립성**으로 어디서나 실행 가능

