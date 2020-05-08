package cn.james.crm_int;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.james.crm_int.dao")
public class MytoolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytoolsApplication.class, args);
    }

}
