package club.banyuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "club.banyuan")
@MapperScan("club.banyuan.**.dao")
@EnableTransactionManagement
public class MallMgtApplication {

  public static void main(String[] args) {
    SpringApplication.run(MallMgtApplication.class);
  }
}
