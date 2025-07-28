# springFw

## 📅 목차

- [2025-07-21](#2025-07-21)
- [2025-07-22](#2025-07-22)
- [2025-07-23](#2025-07-23)
- [2025-07-24](#2025-07-24)
- [2025-07-25](#2025-07-25)
- [2025-07-28](#2025-07-28)

<br><br><br>

# 2025-07-21
---

## 1. XML 기반 의존성 주입 (Dependency Injection)

* **무엇인가?**
  객체 간의 의존 관계를 XML 파일에 설정해두고, 스프링 컨테이너가 이를 읽어 필요한 객체를 생성하고 연결해 주는 방식.

* **특징**

  * 모든 의존 관계를 XML 설정 파일에서 선언적으로 관리
  * 객체 생성과 주입 방식을 모두 설정 파일에서 제어
  * 생성자 주입과 세터 주입을 명확히 구분해서 설정 가능
  * 설정과 코드가 분리되어 있어 설정 변경 시 코드 수정 없이 의존성 변경 가능
  * 다만 설정이 길어지면 XML이 복잡해지고 관리가 어려울 수 있음

* **장점**

  * 설정이 한 곳에 집중되어 있어 의존성 흐름 파악이 용이
  * 환경별, 배포별 설정 변경이 쉬움
  * XML 파일만 바꾸면 의존성 변경 가능 → 유연성 높음

* **단점**

  * XML 작성과 관리에 번거로움
  * 코드와 설정이 분리돼 있어 개발 중 이해가 어려울 수 있음
  * 자바 코드와 설정이 따로 존재해 중복과 불일치 발생 가능

---

## 2. 어노테이션 기반 의존성 주입

* **무엇인가?**
  자바 코드 내에 `@Autowired`, `@Component` 같은 어노테이션을 붙여 직접 의존성을 선언하는 방식으로, 스프링이 자동으로 빈을 탐색하고 주입함.

* **특징**

  * 설정(XML)이 거의 필요 없고, 자바 클래스 위에 어노테이션으로 표시
  * 컴포넌트 스캔을 통해 자동으로 빈을 찾고 생성
  * 타입 기반 주입으로 명시적인 의존성 연결을 줄임
  * 생성자, 세터, 필드 등 다양한 방법으로 주입 가능
  * 코드와 설정이 통합돼 있어 관리가 쉽고 직관적임

* **장점**

  * 설정 작업과 XML 관리가 크게 줄어 개발 생산성 향상
  * 의존성 관계가 코드 바로 위에 있어 이해와 유지보수가 쉬움
  * 자동 주입으로 개발 편의성 극대화

* **단점**

  * 대규모 프로젝트에서 의존성 흐름이 코드에 분산될 수 있어 전체 구조 파악이 어려울 수 있음
  * 자동 주입으로 인해 어떤 빈이 주입되는지 애매해질 수 있음 (특히 동일 타입 빈 여러 개 존재 시)
  * 컴파일 타임이 아닌 런타임 시에 문제 발견 가능 (빈 누락 등)

---

## 간단 비교표

| 구분        | XML 기반 DI       | 어노테이션 기반 DI                |
| --------- | --------------- | -------------------------- |
| 의존성 설정 위치 | 외부 XML 파일       | 자바 코드 내부 어노테이션             |
| 주입 방식     | 명시적 생성자/세터 주입   | 자동 타입 주입 (생성자/세터/필드)       |
| 관리 편의성    | 설정 집중, 변경 용이    | 코드와 설정 통합, 직관적             |
| 복잡성       | XML 복잡해질 수 있음   | 코드 분산으로 대규모 시 복잡해질 수 있음    |
| 유연성       | 환경별 설정 변경 쉽고 명확 | 자동 주입으로 간결하지만 변경시 코드 수정 필요 |

---

📅[목차로 돌아가기](#-목차)

---

# 2025-07-22

---

## 1. 어노테이션 기반 의존성 주입 (Dependency Injection)

* **무엇인가?**
  자바 클래스에 어노테이션을 붙여 스프링이 자동으로 빈을 등록하고 의존성을 주입하는 방식.

* **특징**

  * XML 설정을 거의 사용하지 않고, 코드 안에 어노테이션으로 빈과 의존 관계 선언
  * `@Component`, `@Controller`, `@Service`, `@Repository` 등으로 빈 등록
  * `@Autowired`로 타입에 맞는 빈을 자동 주입
  * `@Qualifier`를 사용해 동일 타입 빈 중 특정 빈 지정 가능
  * `@Configuration`, `@ComponentScan`, `@ImportResource`, `@Bean` 등 자바 기반 설정 지원
  * 빈 스코프 지정 가능 (`singleton` 기본, `prototype` 등)

* **장점**

  * 설정과 코드가 통합되어 관리와 이해가 쉬움
  * 컴포넌트 스캔을 통해 자동으로 빈을 찾아서 등록하므로 편리함
  * 코드 작성량과 설정 작업이 크게 줄어 개발 생산성 향상

* **단점**

  * 대규모 프로젝트에서는 의존성 흐름이 코드에 분산되어 파악 어려울 수 있음
  * 자동 주입으로 어떤 빈이 주입되는지 모호해질 가능성 (특히 동일 타입 빈 여러 개일 때)
  * 런타임 시점에 의존성 문제 발생할 수 있음

---

## 2. Spring AOP (Aspect-Oriented Programming)

* **무엇인가?**
  핵심 비즈니스 로직과 공통 관심사를 분리하여 코드 중복을 줄이고 모듈화하는 프로그래밍 패러다임.

* **특징**

  * 공통 관심사(로깅, 트랜잭션 등)를 모듈화하여 핵심 관심사에서 분리
  * 핵심 로직(Target Object)에 Proxy를 씌워 부가 기능 수행
  * Aspect, Advice, Pointcut 등 여러 개념으로 동작 방식 명확히 정의
  * 런타임에 필요한 시점(JoinPoint)에 공통 기능을 삽입(Weaving)

* **주요 용어**

  | 용어            | 설명                                          |
  | ------------- | ------------------------------------------- |
  | Target Object | 부가기능이 적용될 실제 객체                             |
  | JoinPoint     | 부가기능을 적용할 수 있는 시점(메서드 실행 등)                 |
  | Pointcut      | JoinPoint 중 Advice가 적용될 위치 지정               |
  | Aspect        | 공통 관심사를 모듈화한 단위 (Advice + Pointcut)         |
  | Advice        | 공통 기능이 실제 동작하는 코드 (Before, After, Around 등) |
  | Weaving       | Aspect를 핵심 로직에 연결하는 과정                      |

* **장점**

  * 코드 중복 최소화 및 유지보수성 향상
  * 공통 기능 변경이 쉽고 핵심 로직에 영향 최소화
  * 선언적 트랜잭션 처리 등 다양한 기능 편리하게 구현 가능

* **단점**

  * AOP 동작 원리와 구조 이해에 시간 필요
  * 복잡한 설정이나 디버깅이 어려울 수 있음

---

📅[목차로 돌아가기](#-목차)

---

# 2025-07-23

---

## 1. 어노테이션 기반 AOP (Aspect-Oriented Programming)

* **무엇인가?**
  XML 설정 없이 자바 어노테이션만으로 AOP 기능을 구현하는 방식으로, 핵심 로직에 부가기능을 선언적으로 적용할 수 있음.

* **특징**

  * `@Aspect`로 공통 기능 클래스를 정의
  * `@Before`, `@After`, `@Around` 등의 어드바이스(Advice) 어노테이션을 사용
  * `@Pointcut`으로 공통 기능이 적용될 위치(JoinPoint)를 명시
  * 설정 클래스에 `@EnableAspectJAutoProxy` 추가하여 AOP 활성화
  * 자바 코드 내에서 AOP 설정이 모두 가능해 관리가 간편

* **장점**

  * XML 없이 자바 코드로 모든 설정 가능
  * 가독성과 유지보수성이 높아짐
  * 스프링과 잘 통합되어 자동 주입 및 스캔과 연동 용이

* **단점**

  * AOP 동작 방식과 표현식을 정확히 이해하지 않으면 오작동 위험
  * Pointcut 표현식이 복잡할 수 있음

---

## 2. 포인트컷(Pointcut) 표현식

* **무엇인가?**
  Advice가 적용될 JoinPoint를 지정하기 위한 표현식 (메서드 기준으로 사용)

* **주요 형식 예시**

  ```
  execution(접근제어자 리턴타입 패키지명.클래스명.메서드명(파라미터))
  ```

* **예시 설명**

  ```java
  execution(* com.example.service.*.*(..))
  ```

  → `com.example.service` 패키지 내의 모든 클래스의 모든 메서드에 적용

* **표현식 패턴**

  | 패턴            | 의미                       |
  | ------------- | ------------------------ |
  | `*`           | 모든 값 (리턴타입, 메서드명 등에서 사용) |
  | `..`          | 0개 이상의 하위 패키지 또는 파라미터    |
  | `(..)`, `(*)` | 모든 파라미터, 또는 하나의 파라미터     |
  | 정확한 메서드명 지정   | 특정 메서드에만 적용              |

---

## 3. DB(Database, 데이터베이스)

* **무엇인가?**
  데이터를 효율적으로 저장, 관리, 검색할 수 있도록 구조화된 저장소

* **종류**

  * 관계형 DBMS: MySQL, Oracle, PostgreSQL 등
  * 비관계형(NoSQL): MongoDB, Redis 등

* **용도**

  * 사용자 정보, 게시글, 상품 정보 등 앱/웹 서비스의 핵심 데이터 저장
  * 데이터를 구조화하고 중복 없이 관리

---

## 4. JDBC (Java Database Connectivity)

* **무엇인가?**
  자바에서 DB와 연결해 SQL을 실행할 수 있도록 도와주는 API

* **동작 순서**

  1. 드라이버 로드 (`Class.forName(...)`)
  2. DB 연결 (`DriverManager.getConnection(...)`)
  3. SQL 실행 (`Statement` 또는 `PreparedStatement`)
  4. 결과 처리 (`ResultSet`)
  5. 연결 종료 (`close()`)

* **단점**

  * 반복 코드 많고, 예외 처리 복잡
  * 유지보수가 어려움
  * 그래서 Spring JDBC, JPA 등이 등장함

---

## 5. CRUD (Create, Read, Update, Delete)

* **무엇인가?**
  데이터베이스의 기본적인 4가지 작업 방식

| 작업     | 설명     | SQL 예시                     |
| ------ | ------ | -------------------------- |
| Create | 데이터 생성 | `INSERT INTO`              |
| Read   | 데이터 조회 | `SELECT`                   |
| Update | 데이터 수정 | `UPDATE ... SET ... WHERE` |
| Delete | 데이터 삭제 | `DELETE FROM ... WHERE`    |

---

📅[목차로 돌아가기](#-목차)

---

# 2025-07-24

---

## 1. DB 테이블 정보를 기반으로 VO(Value Object) 클래스 작성

* **무엇인가?**
  DB 테이블의 컬럼 구조와 1:1로 매핑되는 자바 클래스. 데이터를 담는 용도이며, 계층 간 데이터 전달에 사용됨.

* **특징**

  * 테이블의 각 컬럼은 VO 클래스의 필드로 매핑됨
  * 기본적으로 getter/setter, toString(), 생성자 등을 포함
  * DB → 자바 객체 변환 (역시 자바 → DB 삽입 시도 가능)

* **예시**

  ```java
  public class EmpVO {
      private int empno;
      private String ename;
      private String job;
      private int sal;
      // getter, setter, toString 등
  }
  ```

---

## 2. 기능 설계를 위한 인터페이스 `IEmpRepository` 작성

* **무엇인가?**
  DB 연산을 추상화한 인터페이스로, CRUD 메서드들을 정의해 구현 클래스로 위임하기 위한 설계 단계.

* **역할**

  * EmpRepository가 반드시 구현해야 하는 메서드 목록 정의
  * 예: `insertEmp(EmpVO vo)`, `findAll()`, `findByEmpno(int empno)` 등

---

## 3. 구현 클래스 `EmpRepository` 작성

* **무엇인가?**
  `IEmpRepository`를 구현하는 클래스. 실제 SQL 문을 작성하고 JDBC를 이용하여 DB 연동을 처리함.

* **주요 내용**

  * DB 연결, SQL 실행, 결과 처리까지 담당
  * 반복되는 JDBC 코드들을 메서드로 분리 가능
  * CRUD 중심으로 SQL 작성

* **예시**

  ```java
  public class EmpRepository implements IEmpRepository {
      public List<EmpVO> findAll() {
          // JDBC로 SELECT * FROM emp 실행
      }
  }
  ```

---

## 4. 클래스 간 관계 및 계층 구조

```
[EmpMain]
   │
   ▼
[IEmpService] ←구현― [EmpService]
   │
   ▼
[IEmpRepository] ←구현― [EmpRepository]
   │
   ▼
 [EmpVO]  ← 데이터를 담고 전달함
```

### 각 클래스 설명

| 클래스명               | 역할 설명                                          |
| ------------------ | ---------------------------------------------- |
| **EmpMain**        | 프로그램 실행 시작점, 사용자의 요청을 처리하고 서비스 호출              |
| **EmpVO**          | DB의 데이터를 담는 VO 객체 (Value Object)               |
| **IEmpRepository** | DAO 계층의 인터페이스. 데이터베이스와 연동하는 기능을 정의             |
| **EmpRepository**  | 실제 JDBC 코드를 작성해 DB와 통신하는 구현 클래스                |
| **IEmpService**    | 서비스 계층의 인터페이스. 비즈니스 로직의 추상화된 기능 정의             |
| **EmpService**     | 비즈니스 로직 처리 클래스. Repository를 이용해 데이터 처리 및 로직 수행 |

---

## 전체 구조 요약 (MVC + Repository 구조 일부 반영)

* **EmpMain** → 사용자와 인터랙션 / 흐름 제어
* **Service 계층** → 비즈니스 로직 처리
* **Repository 계층** → DB 접근 및 SQL 실행
* **VO 객체** → 데이터 전달용

---

📅[목차로 돌아가기](#-목차)

---

# 2025-07-25

---

## 1. SQL을 이용한 사원 관련 주요 기능

| 기능 구분         | 설명                            | 예시 SQL 구문                                   |
| ------------- | ----------------------------- | ------------------------------------------- |
| 특정 부서 사원 수 조회 | 부서번호를 기준으로 해당 부서에 소속된 사원 수 조회 | `SELECT COUNT(*) FROM emp WHERE deptno = ?` |
| 사원번호로 사원 조회   | 사원번호(empno)를 통해 개별 사원 정보 조회   | `SELECT * FROM emp WHERE empno = ?`         |
| 전체 사원 조회      | 모든 사원 정보를 테이블에서 조회            | `SELECT * FROM emp`                         |
| 새로운 사원 등록     | 새 사원의 정보를 DB에 INSERT          | `INSERT INTO emp (...) VALUES (...)`        |
| 급여 업데이트       | 특정 사원의 급여(sal) 정보 수정          | `UPDATE emp SET sal = ? WHERE empno = ?`    |
| 사원 삭제         | 특정 사원의 정보를 테이블에서 제거           | `DELETE FROM emp WHERE empno = ?`           |

---

## 2. DB 제약조건 (Constraints)

* **무엇인가?**
  테이블에 저장되는 데이터의 정확성과 일관성을 보장하기 위한 조건

| 제약조건            | 설명                                           |
| --------------- | -------------------------------------------- |
| **PRIMARY KEY** | 기본 키, 각 행(row)을 유일하게 식별, `NOT NULL + UNIQUE` |
| **FOREIGN KEY** | 다른 테이블의 기본키를 참조, 테이블 간 관계 설정                 |
| **UNIQUE**      | 특정 컬럼 값이 테이블 내에서 중복되지 않도록 제한                 |
| **CHECK**       | 컬럼에 들어가는 값의 범위나 조건을 제한 (`CHECK (sal > 0)` 등) |

---

## 3. 트랜잭션(Transaction) 처리

* **무엇인가?**
  데이터베이스의 논리적 작업 단위로, 하나의 작업 단위 내의 모든 연산이 완전히 수행되거나 전혀 수행되지 않아야 함.

* **트랜잭션의 성질 (ACID + 순차성)**

| 성질                        | 설명                                    |
| ------------------------- | ------------------------------------- |
| **원자성 (Atomicity)**       | 모두 성공하거나 모두 실패해야 함 (All or Nothing)   |
| **일관성 (Consistency)**     | 트랜잭션 전후에 데이터의 무결성이 유지됨                |
| **격리성 (Isolation)**       | 동시에 수행되는 트랜잭션은 서로 간섭하지 않음             |
| **영속성 (Durability)**      | 커밋된 데이터는 시스템 장애가 발생해도 보존됨             |
| **순차성 (Serializability)** | 동시에 수행된 트랜잭션의 결과는 순차적으로 실행한 것과 동일해야 함 |

* **관련 SQL 명령어**

  * `BEGIN` 또는 `START TRANSACTION`
  * `COMMIT` : 성공 시 저장
  * `ROLLBACK` : 실패 시 되돌림

---

## 4. MVC 패턴 (Model - View - Controller)

* **무엇인가?**
  애플리케이션을 세 가지 책임으로 분리하여 유연성과 유지보수성을 높이는 소프트웨어 아키텍처 패턴

| 구성 요소          | 역할 설명                                |
| -------------- | ------------------------------------ |
| **Model**      | 데이터와 관련된 로직 처리 (DB 접근, 비즈니스 로직 등)    |
| **View**       | 사용자에게 보여지는 화면 (콘솔, HTML, JSP 등)      |
| **Controller** | 사용자 입력을 받고, 그에 따라 Model 호출 및 View 반환 |

* **흐름 예시 (콘솔 기준)**

  ```
  사용자 입력 → Controller → Service → Repository → DB
                                     ↓
                             결과를 VO로 받아 View 출력
  ```

* **장점**

  * 역할 분리로 유지보수 용이
  * 테스트 및 확장성 뛰어남
  * 로직과 화면 처리 분리로 협업 효율적

---

📅[목차로 돌아가기](#-목차)

---

# 2025-07-28

---

## 1. 패키지 분리 구조

**MVC 원칙에 따라 패키지를 역할별로 분리**

```
📦 project-root
 ┣ 📂 controller       → 사용자 요청 처리
 ┃ ┗ 📄 EmpController.java
 ┣ 📂 dao              → DB 처리 (Repository)
 ┃ ┣ 📄 EmpRepository.java
 ┃ ┗ 📄 IEmpRepository.java
 ┣ 📂 model            → 데이터 모델 (VO 클래스)
 ┃ ┗ 📄 EmpVO.java
 ┣ 📂 service          → 비즈니스 로직 처리
 ┃ ┣ 📄 EmpService.java
 ┃ ┗ 📄 IEmpService.java
```

* 역할이 명확하게 나뉘어 유지보수 및 협업에 용이
* Spring의 DI(의존성 주입) 및 AOP 적용 시 구조화에 효과적

---

## 2. Controller 계층에 요청 처리 메서드 추가

### ✅ 사원 수 조회 컨트롤러

```java
@RequestMapping(value = "/hr/count")
public String empCount(@RequestParam(value = "deptid", required = false, defaultValue = "0") int deptId,
                       Model model) {

    if (deptId == 0) {
        model.addAttribute("count", empService.getEmpCount()); // 전체 사원 수
    } else {
        model.addAttribute("count", empService.getEmpCount(deptId)); // 부서별 사원 수
    }

    return "hr/count"; // → /WEB-INF/views/hr/count.jsp
}
```

### ✅ 전체 사원 목록 조회

```java
@RequestMapping(value = "/hr/list")
public String empAllList(Model model) {
    List<EmpVO> empList = empService.getEmpList();
    model.addAttribute("empList", empList);

    return "hr/list";
}
```

### ✅ 사원 상세 정보 조회

```java
@RequestMapping(value = "/hr/{employeeId}")
public String getEmpInfo(@PathVariable int employeeId, Model model) {
    EmpVO emp = empService.getEmpInfo(employeeId);
    model.addAttribute("emp", emp);

    return "hr/view";
}
```

---

## 3. JSP 뷰에서 모델 데이터 출력

### 📄 `count.jsp` 예시

```jsp
<h1>사원 수: ${count}</h1>
```

* Spring에서 `Model` 객체에 저장한 `"count"`를 JSP에서 EL(Expression Language)로 출력
* 요청 URL: `/hr/count` (기본 전체), `/hr/count?deptid=10` (10번 부서)

---

## 4. 전체 흐름 요약 (요청 → 처리 → 응답)

```
[브라우저 요청: /hr/count?deptid=10]
        ↓
[EmpController]
  ↓    - 요청 파라미터 분석
  ↓    - empService 호출
[EmpService]
  ↓    - 비즈니스 로직 수행
  ↓    - empRepository 통해 DB에서 데이터 조회
[EmpRepository]
  ↓    - JDBC or MyBatis 이용 SQL 실행
[DB 조회 완료 → VO 반환]
        ↓
[EmpService → Controller → Model에 저장]
        ↓
[View: JSP로 forward → ${count} 출력]
```

---

## 5. 보충 개념: @RequestParam vs @PathVariable

| 어노테이션           | 설명                       | 예시                    |
| --------------- | ------------------------ | --------------------- |
| `@RequestParam` | 쿼리스트링 (?key=value) 값을 받음 | `/hr/count?deptid=10` |
| `@PathVariable` | URL 경로 내 값을 바인딩          | `/hr/1001`            |

---

📅[목차로 돌아가기](#-목차)

---

