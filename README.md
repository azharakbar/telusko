#### Annotations in Java

Annotations are those extra information that is provided to increase the functionality of the written code 

In Java, the scope of annotations is large, and, to be in particular about such a usage, we have to mention Spring framework in java that is highly built around these annotation

Frameworks like Spring, expose most of their functionalities as annotations that can be used by developers to make their life easy and make them concentrate only on business logic

Before, we used to depend on XML files to provide extra information to Java regarding the classes. But now, it is outdated, and annotations are the replacement

Not to forget, the boilerplate killer Lombok package also exposes all of their functionalities using annotations

We have built in annotations that come out-of-the-box with the JDK, and Java also provides a way to create our own custom annotations based on our requirements

Annotations are built using interfaces that are differentiated with an "@" symbol
For example, if we want to create an annotation named "Telusko", we have to begin by
```java
@interface Telusko
{
    .
    .
    .
}
```

Annotations are target-specific, meaning, all annotations cannot be used everywhere
Some annotations are applicable on methods, some on classes, some on data fields inside classes and other places too like Constructors etc.

The applicability of an annotation is called as "Target" of the annotation, which we have to specify when we create an annotation
For example, if we wont the annotation "Telusko" to be applicable only to classes, then we have to mention as follows
```java
@Target(ElementType.TYPE)
@interface Telusko
{
    .
    .
    .
}
```

If we had to apply this only on a methods, then it would have been `@Target(ElementType.METHOD)`

Another information that we have to provide during creation of annotation is that, we need to tell the compiler till what level this extra information provided by the annotation has to be retained
This is called as the retention policy of the annotation
Various retention policies are: CLASS(Compile time), RUNTIME(Compile time and runtime), SOURCE(Like a comment)

Now, if we want our "Telusko" interface to be retained till the Runtime, that is to make it reach till the JVM, then
```java
@Target(ElementType.TYPE)
@RetentionPolicy(RetentionPolicy.RUNTIME)
@interface Telusko
{
    .
    .
    .
}
```

Ofcourse, target and retention policies can be provided multivalue using the below syntax
```java
@Target({ElementType.TYPE, ElementType.METHOD})
@RetentionPolicy({RetentionPolicy.RUNTIME, RetentionPolicy.SOURCE})
```

Now, since we have completed knowing on how to define an annotation in java, lets see how to add data members into it
Suppose we want to add courseName, coursePrice as members into the "Telusko" annotation, then it will be as per the below syntax

```java
@Target(ElementType.TYPE)
@RetentionPolicy(RetentionPolicy.RUNTIME)
@interface Telusko
{
    String courseName;
    int coursePrice default 100;
}
```

Here, default says that, if no coursePrice is provided during the usage, the default value of 100 will be used

Example usages:
@Telusko(courseName="Spring Boot", coursePrice=200)
@Telusko(courseName="Spring Boot")


Lets see how the annotation can be applied to a Class, and retrieve its values

```java
@Telusko(courseName="Spring Boot", coursePrice=200)
@Data // from lombok
class Studies {

    int timeTaken;

    String degreeName;
}

class Main {
    public static void main(String[] args) {

        Studies study = new Studies();
        study.setTimeTaken(3);
        study.setDegreeName("BTech");

        Class studyClass = study.getClass();
        Annotation annotation = studyClass.getAnnotation(Studies.class);
        Telusko teluskoAnnotation = (Telusko) annotation;

        System.out.println("courseName: " + teluskoAnnotation.courseName())
        System.out.println("coursePrice: " + teluskoAnnotation.coursePrice())
    }
}

```


During the JAVA Challenge of Telusko, we have come across many annotations 
Lets see some of them

1. `@Override`
This is a built in annotation of Java
Target: Method
Retention: SOURCE

This is used to indicate to the developer that, the method overrides the parent's method


2. `@FunctionalInterface`
This is a built in annotation of Java
Target: TYPE (Class, Interface)
Retention: RUNTIME

This is used to indicate that the interface should have only one abstract method, and is being used as a lambda expression
Hence, no more specifications should be added to the interface


3. `@Getter`, `@Setter`
These are provided by Lombok library
Target: TYPE, FIELD
Retention: SOURCE

These are used to create the boilerplate setters and getters for all data members of a class, or on a specific data memeber of the class

4. `@Component`
This is provided by Spring framework

Target: TYPE
Retention: RUNTIME

Spring app scans all the classes annotated with @Component, and instantiates them, so that we can autowire these into other places  


5. `@Service`
This is provided by Spring framework. Its an alias for @Component

Target: TYPE
Retention: RUNTIME

It is used to denote classes that carry the business logic

6. `@RestController`
This is provided by Spring framework

Target: TYPE
Retention: RUNTIME

Used to create REST endpoints using Spring MVC framework

7. `@Repository`
This is provided by Spring framework

Target: TYPE
Retention: RUNTIME

Used to denote that the class is used for data operations directly with data sources like Database

8. `@Bean`
This is provided by Spring framework

Target: METHOD
Retention: RUNTIME

This is used when a method needs to return a bean that needs to be managed by the Spring context

