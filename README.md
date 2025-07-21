# springFw

## 📅 목차

- [2025-07-21](#2025-07-21)

<br><br><br>

# 2025-07-21

## 📘 Java - XML 기반 의존성 주입 (Dependency Injection)

---

### ✅ 의존성 주입(Dependency Injection, DI)이란?

* 객체 간의 의존 관계를 코드 내에서 직접 생성하지 않고 외부에서 주입하는 설계 패턴
* 객체 간 결합도를 낮추고, 유연성과 테스트 용이성을 높임
* 주로 스프링 프레임워크에서 사용되며, XML 파일을 통해 설정 가능

---

### ✅ XML 기반 의존성 주입 방식

* XML 파일에 빈(bean) 설정과 의존 관계를 명시
* 스프링 컨테이너가 해당 XML을 읽어 객체 생성 및 의존성 주입 수행
* 주입 방식: 생성자 주입(Constructor Injection), 세터 주입(Setter Injection) 두 가지가 대표적

---

### ✅ XML 예시: 간단한 빈과 의존성 주입

```xml
<!-- applicationContext.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
         http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 의존 객체 -->
    <bean id="engine" class="com.example.Engine" />

    <!-- 주입 받는 객체 -->
    <bean id="car" class="com.example.Car">
        <!-- 생성자 주입 -->
        <constructor-arg ref="engine" />
    </bean>

</beans>
```

---

### ✅ 생성자 주입(Constructor Injection)

* 생성자 인자를 통해 의존 객체를 주입
* 불변(Immutable) 객체 생성에 적합

```xml
<bean id="car" class="com.example.Car">
    <constructor-arg ref="engine" />
</bean>
```

---

### ✅ 세터 주입(Setter Injection)

* 빈 프로퍼티의 setter 메서드를 통해 의존 객체를 주입
* 선택적 의존성 주입에 적합

```xml
<bean id="car" class="com.example.Car">
    <property name="engine" ref="engine" />
</bean>
```

---

### ✅ Java 클래스 예시

```java
// 의존 객체
public class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

// 의존 주입 받는 클래스
public class Car {
    private Engine engine;

    // 생성자 주입
    public Car(Engine engine) {
        this.engine = engine;
    }

    // 세터 주입용 메서드
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving.");
    }
}
```

---

### ✅ XML 기반 DI 요약

| 구분     | 특징                          | XML 설정 태그           |
| ------ | --------------------------- | ------------------- |
| 생성자 주입 | 생성자를 통해 의존성 주입, 필수 의존성에 적합  | `<constructor-arg>` |
| 세터 주입  | setter 메서드로 주입, 선택적 의존성에 적합 | `<property>`        |

---

### ✅ DI 적용 후 객체 사용 예

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        Car car = (Car) context.getBean("car");
        car.drive();
    }
}
```

## 📘 Java - 어노테이션 기반 의존성 주입 (Annotation-based DI)

---

### ✅ 어노테이션 기반 의존성 주입이란?

* XML 설정 대신 자바 코드 내에 어노테이션을 사용해 의존성 주입을 선언하는 방법
* 코드가 간결해지고, 설정 분산 없이 컴포넌트 바로 위에 주입 정보를 작성 가능
* 주로 스프링 프레임워크에서 많이 사용됨

---

### ✅ 주요 어노테이션

| 어노테이션               | 설명                             |
| ------------------- | ------------------------------ |
| `@Component`        | 일반적인 빈(Bean) 클래스임을 표시          |
| `@Service`          | 서비스 계층 컴포넌트를 표시 (비즈니스 로직)      |
| `@Repository`       | DAO 계층 컴포넌트를 표시 (데이터 접근 계층)    |
| `@Controller`       | 웹 MVC 컨트롤러 컴포넌트를 표시            |
| `@Autowired`        | 의존성 자동 주입, 타입에 맞는 빈을 찾아 주입     |
| `@Qualifier`        | 같은 타입 빈이 여러 개일 때 특정 빈 이름 지정    |
| `@Inject` (JSR-330) | `@Autowired`와 비슷한 기능 (Java 표준) |
| `@Resource`         | 이름(name) 기반 의존성 주입             |

---

### ✅ 어노테이션 기반 의존성 주입 예시

```java
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

@Component
public class Car {

    private Engine engine;

    // 생성자 주입
    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }

    // 또는 세터 주입
    // @Autowired
    // public void setEngine(Engine engine) {
    //     this.engine = engine;
    // }

    public void drive() {
        engine.start();
        System.out.println("Car is driving.");
    }
}
```

---

### ✅ 스프링 설정 클래스 예시 (Java Config)

```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    // XML 대신 이 클래스가 빈 설정 역할을 함
}
```

---

### ✅ 어노테이션 DI 특징

* **자동 빈 등록** : `@ComponentScan`으로 특정 패키지를 스캔해 빈을 자동 등록
* **타입 기반 자동 주입** : `@Autowired`가 타입으로 빈을 찾아 주입
* **명확하고 간결한 코드** : XML 설정 없이도 클래스 내에서 의존성 선언 가능
* **유연한 주입 방식** : 생성자, 세터, 필드 주입 모두 가능 (필드 주입은 테스트 어려움으로 권장 안 함)

---

### ✅ 필드 주입 예시 (권장하지 않음)

```java
@Component
public class Car {

    @Autowired
    private Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is driving.");
    }
}
```

---

### ✅ 실행 예 (Main 클래스)

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

        Car car = context.getBean(Car.class);
        car.drive();
    }
}
```

---

📅[목차로 돌아가기](#-목차)

