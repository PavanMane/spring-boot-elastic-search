package in.novopay.integrations.voter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.novopay.integrations.voter.domain.ESVoterInfo;
import in.novopay.integrations.voter.domain.ESVoterRepository;

@Service
public class VoterServiceImpl implements IVoterService {
	
	@Autowired
	private ESVoterRepository eSVoterRepository; 

	@Override
	public VoterDTO getVoter(String voterId) {
		return copyFrom(eSVoterRepository.findOneByVoterId(voterId));
	}
	
	public VoterDTO copyFrom(ESVoterInfo esVoterInfo) {
		VoterDTO voterDTO = null;
		if(esVoterInfo != null) {
			voterDTO = new VoterDTO();
			if(esVoterInfo.getAddress() != null) {
				voterDTO.setAddress1(esVoterInfo.getAddress().getAddressLocality());
				voterDTO.setSub_district(esVoterInfo.getAddress().getAddressRegion());
			}
			voterDTO.setFirst_name(esVoterInfo.getName());
			if(esVoterInfo.getParent() != null) {
				voterDTO.setParent_first_name(esVoterInfo.getParent().getName());
			}
			if(esVoterInfo.getAll_attributes() != null && esVoterInfo.getAll_attributes().size() > 0) {
				voterDTO.setAge_on_issue_date((String)esVoterInfo.getAll_attributes().get("age"));
				voterDTO.setDistrict((String)esVoterInfo.getAll_attributes().get("district"));
			}
		}
		
		return voterDTO;
	}

}
