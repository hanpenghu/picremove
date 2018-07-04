package linzhanpicsynchironized.picremove;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableScheduling
@MapperScan("linzhanpicsynchironized.picremove.dao")
public class PicremoveApplication {

	public static void main(String[] args) {


		SpringApplication.run(PicremoveApplication.class, args);
	}
}
