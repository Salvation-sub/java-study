Java 기본형 vs 참조형 핵심 개념 정리
1. 값 저장 방식의 차이점
   정답: B - 기본형: 값 직접 저장, 참조형: 주소 저장
   java// 기본형 - 값 직접 저장
   int a = 10;        // 변수 a에 실제 값 10이 저장됨

// 참조형 - 주소 저장
Student s = new Student();  // 변수 s에는 Student 객체의 메모리 주소가 저장됨
2. 변수 대입 시 복사되는 데이터
   정답: B - 기본형은 값 자체가, 참조형은 메모리 주소가 복사된다
   java// 기본형
   int a = 10;
   int b = a;    // a의 값 10이 복사되어 b에 저장

// 참조형
Student s1 = new Student();
Student s2 = s1;  // s1의 주소값이 복사되어 s2에 저장 (같은 객체를 가리킴)
3. 메서드 전달 시 동작 차이
   정답: A - 기본형 변경은 외부 영향X, 참조형 변경은 외부 영향O
   java// 기본형 - 외부에 영향 없음
   static void changePrimitive(int x) {
   x = 20;  // 복사된 값만 변경, 원본은 그대로
   }

// 참조형 - 외부에 영향 있음
static void changeReference(Student student) {
student.name = "변경됨";  // 같은 객체를 가리키므로 원본도 변경됨
}
4. null의 의미와 사용
   정답: B - 참조할 대상이 없음, 참조형 변수
   java// 참조형 변수에만 null 사용 가능
   Student student = null;  // 아무 객체도 가리키지 않음

// 기본형 변수에는 null 사용 불가
int number = null;  // 컴파일 오류!
5. NullPointerException 발생 시점
   정답: C - null 값을 가진 참조 변수로 멤버 접근 시
   javaStudent student = null;
   student.name = "홍길동";     // NullPointerException 발생!
   System.out.println(student.age);  // NullPointerException 발생!

// 해결 방법
if (student != null) {
student.name = "홍길동";  // 안전한 접근
}
핵심 원칙 요약
🔑 대원칙: 자바는 항상 변수의 값을 복사해서 대입한다
구분기본형참조형저장하는 것실제 값객체의 주소대입 시 복사값 자체주소값메서드 전달값 복사 (원본 불변)주소 복사 (객체 공유)null 할당불가능가능연산산술 연산 가능산술 연산 불가
🚨 주의사항

참조형 변수 대입: 객체가 복사되는 것이 아니라 주소만 복사됨
메서드 매개변수: 참조형도 "값에 의한 전달"이지만, 그 값이 주소값임
null 체크: 참조형 변수 사용 전 항상 null 체크 필요
메모리 관리: 아무도 참조하지 않는 객체는 GC가 자동 제거

