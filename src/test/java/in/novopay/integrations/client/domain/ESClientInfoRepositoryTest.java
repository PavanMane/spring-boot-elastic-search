package in.novopay.integrations.client.domain;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@TestPropertySource(locations="classpath:application-assets-embedded.properties")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ESClientInfoRepositoryTest {

	@Autowired
	private ESClientInfoRepository eSClientInfoRepository;
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	
	@Before
	public void init() {
		Assert.assertNotNull(elasticsearchTemplate);
		Assert.assertNotNull(eSClientInfoRepository);
		elasticsearchTemplate.deleteIndex(ESClientInfo.class);
		elasticsearchTemplate.createIndex(ESClientInfo.class);
		elasticsearchTemplate.putMapping(ESClientInfo.class);
		elasticsearchTemplate.refresh(ESClientInfo.class);
	}
	
	@Test
	public void test_podamNIndexItemCreationAndDeletion() {
		PodamFactory factory = new PodamFactoryImpl();
		ESClientInfo esClientInfo = factory.manufacturePojo(ESClientInfo.class);
		System.out.println("ESClientInfo ---> " + ReflectionToStringBuilder.toString(esClientInfo, ToStringStyle.SHORT_PREFIX_STYLE));
		esClientInfo.getAddresses().forEach(address -> System.out.println("ESClientInfo.addresses ---> " + ReflectionToStringBuilder.toString(address, ToStringStyle.SHORT_PREFIX_STYLE)));
		esClientInfo.getLoanAppRef().forEach(loanAppRef -> System.out.println("ESClientInfo.loanAppRef ---> " + ReflectionToStringBuilder.toString(loanAppRef, ToStringStyle.SHORT_PREFIX_STYLE)));
		esClientInfo.getKycs().forEach(kycs -> System.out.println("ESClientInfo.kycs ---> " + ReflectionToStringBuilder.toString(kycs, ToStringStyle.SHORT_PREFIX_STYLE)));
		System.out.println("Success....");
		long initialCount = eSClientInfoRepository.count();
		eSClientInfoRepository.save(esClientInfo);
		Assert.assertTrue(eSClientInfoRepository.count() == (initialCount + 1));
		eSClientInfoRepository.delete(esClientInfo);
		Assert.assertTrue(eSClientInfoRepository.count() == initialCount);
		
	}
	
	@Test
	public void test_search() {
		PodamFactory factory = new PodamFactoryImpl();
		
		// Item 1
		ESClientInfo esClientInfo1 = factory.manufacturePojo(ESClientInfo.class);
		esClientInfo1.setName("Priya Mani");
		// Item 2
		ESClientInfo esClientInfo2 = factory.manufacturePojo(ESClientInfo.class);
		esClientInfo2.setName("Priyanka Gupta");
		// Item 3
		ESClientInfo esClientInfo3 = factory.manufacturePojo(ESClientInfo.class);
		esClientInfo3.setName("BlahName");
		esClientInfo3.setEmail("Supriya@blah.com");
		// Item 4
		ESClientInfo esClientInfo4 = factory.manufacturePojo(ESClientInfo.class);
		esClientInfo4.setName("Whocares");
		esClientInfo4.getAddresses().get(0).setHamletName("Sarjapur Road");;
		
		long initialCount = eSClientInfoRepository.count();
		
		// save items
		eSClientInfoRepository.save(esClientInfo1);
		eSClientInfoRepository.save(esClientInfo2);
		eSClientInfoRepository.save(esClientInfo3);
		eSClientInfoRepository.save(esClientInfo4);
		Assert.assertTrue(eSClientInfoRepository.count() == (initialCount + 4));
		try {
			System.out.println("=== Pri ===");
			List<ESClientInfo> findClientInfo = eSClientInfoRepository.findClientInfo("Pri");
			Assert.assertTrue(findClientInfo.size() >= 3);
			findClientInfo.forEach(item -> System.out.println(ReflectionToStringBuilder.toString(item, ToStringStyle.SHORT_PREFIX_STYLE)));
			System.out.println("=== gupta ===");
			findClientInfo = eSClientInfoRepository.findClientInfo("gupta");
			Assert.assertTrue(findClientInfo.size() >= 1);
			findClientInfo.forEach(item -> System.out.println(ReflectionToStringBuilder.toString(item, ToStringStyle.SHORT_PREFIX_STYLE)));
			System.out.println("=== arjapu ===");
			findClientInfo = eSClientInfoRepository.findClientInfo("arjapu");
			Assert.assertTrue(findClientInfo.size() >= 1);
			findClientInfo.forEach(item -> System.out.println(ReflectionToStringBuilder.toString(item, ToStringStyle.SHORT_PREFIX_STYLE)));
		} finally {
			// delete items
			eSClientInfoRepository.delete(esClientInfo1);
			eSClientInfoRepository.delete(esClientInfo2);
			eSClientInfoRepository.delete(esClientInfo3);
			eSClientInfoRepository.delete(esClientInfo4);
			Assert.assertTrue(eSClientInfoRepository.count() == initialCount);
		}
		
		
	}
}
