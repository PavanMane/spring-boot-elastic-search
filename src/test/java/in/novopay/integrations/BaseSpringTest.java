package in.novopay.integrations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseSpringTest {

	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
	
	@Before
	public void init() {
		Assert.assertNotNull(elasticsearchTemplate);
	}
	
	@Test
	public void testing() {
		System.out.println("Testing......");
	}

}
