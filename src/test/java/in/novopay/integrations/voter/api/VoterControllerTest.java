package in.novopay.integrations.voter.api;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.novopay.integrations.BaseResponse;
import in.novopay.integrations.BaseSpringTest;
import in.novopay.integrations.voter.service.VoterDTO;

@AutoConfigureMockMvc
public class VoterControllerTest extends BaseSpringTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void test_voterIdLookup_200() throws Exception {
		String voterId = "ZKT3101706";
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/v1/voter/" + voterId).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println("Response ---> " + content);
		ObjectMapper om = new ObjectMapper();
		VoterDTO voterDTO = om.readValue(content, VoterDTO.class);
		System.out.println(ReflectionToStringBuilder.toString(voterDTO, ToStringStyle.SHORT_PREFIX_STYLE));
	}
	
	@Test
	public void test_voterIdLookup_404() throws Exception {
		String voterId = "blahblahblah";
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/v1/voter/" + voterId).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println("Response ---> " + content);
		ObjectMapper om = new ObjectMapper();
		BaseResponse response = om.readValue(content, BaseResponse.class);
		System.out.println(ReflectionToStringBuilder.toString(response, ToStringStyle.SHORT_PREFIX_STYLE));
	}
}
