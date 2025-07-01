package poly.basic;

public class CastingMain4 {

    public static void main(String[] args) {
        Parent parent1 = new Child(); // 자식을 생성했기에 모든 Parent 인스턴스도 담아져 있음
        Child child1 = (Child) parent1; // 다운캐스팅
        child1.childMethod(); // 문제 없음

        Parent parent2 = new Parent(); // 부모를 생성했기에 Parent 즉 자식 인스턴스는 없는 상태로 생성
        Child child2 = (Child) parent2; // 런타임 오류
        child2.childMethod(); // 실행 불가
    }
}
