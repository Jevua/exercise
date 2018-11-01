package com.example.exercise;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.web.servlet.ServletComponentScan;
//注解扫描路径
@SpringBootApplication(scanBasePackages = "com")
//扫描@weblistener注解
@ServletComponentScan
public class ExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseApplication.class, args);
    }
}
