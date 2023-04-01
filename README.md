<h3 align="center">JPA를 활용한 예제</h3>

#### 1. jpa 환경설정 셋팅(maven)
 * 라이브러리 추가(pom.xml)
 * jpa 설정(persistence.xml)

#### 2. jpa 로직 구현
 * persistence.xml에 구현한 persistence 유닛을 Persistence.createEntityManagerFactory로 생성 
 * EntityManager 생성
 * EntityTransaction 생성 후 begin(), commit()을 사용하여 트랜젝션 구현
 
#### 3. Member 객체를 활용한 CRUD 구현
  * find() 함수를 사용한 리스트 db 조회
  * remove() 함수를 사용한 영속성 컨텍스트 제거
  * 영속성 컨텍스트 값 수정을 통한 update 적용
  * persist() 함수를 사용한 create 적용
  * flush() 함수를 사용하여 쿼리 생성 확인
    * em.flush() 직접 호출 
    * commit() 자동 호출
    * jpql 쿼리 실행 시 자동 호출