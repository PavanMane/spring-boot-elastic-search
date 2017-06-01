package in.novopay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

@SpringBootApplication
public class Application {
	
//	 @Autowired
//	 private ElasticsearchOperations es;

	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
