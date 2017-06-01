package in.novopay.integrations.voter.domain;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import in.novopay.integrations.BaseSpringTest;

public class ESVoterRepositoryTest extends BaseSpringTest {

	@Autowired
	private ESVoterRepository eSVoterRepository;
	
	@Before
	public void init() {
		Assert.assertNotNull(eSVoterRepository);
	}
	
	@Test
	public void test_findOneByVoterId() {
		String voterId = "ZKT3101706";
		ESVoterInfo voterInfo = eSVoterRepository.findOneByVoterId(voterId);
		boolean correctVoterId = false;
		if (voterInfo != null) {
			System.out.println("Base Voter Info ---> " + ReflectionToStringBuilder.toString(voterInfo, ToStringStyle.SHORT_PREFIX_STYLE));
			ESVoterIdentifier voterIdentifier = voterInfo.getIdentifier();
			if (voterIdentifier != null) {
				System.out.println("voterIdentifier Info ---> " + ReflectionToStringBuilder.toString(voterIdentifier, ToStringStyle.SHORT_PREFIX_STYLE));
				correctVoterId = StringUtils.equals(voterId, voterIdentifier.getId());
			}
			ESVoterAddress voterAddress = voterInfo.getAddress();
			if (voterAddress != null) {
				System.out.println("voterAddress Info ---> " + ReflectionToStringBuilder.toString(voterAddress, ToStringStyle.SHORT_PREFIX_STYLE));
			}
			ESVoterParent voterParent = voterInfo.getParent();
			if (voterParent != null) {
				System.out.println("voterParent Info ---> " + ReflectionToStringBuilder.toString(voterParent, ToStringStyle.SHORT_PREFIX_STYLE));
			}
		}
		Assert.assertTrue(correctVoterId);
		
	}
	
	@Test
	public void test_findOneByVoterIdFail() {
		ESVoterInfo voterInfo = eSVoterRepository.findOneByVoterId("blahblahblha");
		Assert.assertNull(voterInfo);
	}
}
