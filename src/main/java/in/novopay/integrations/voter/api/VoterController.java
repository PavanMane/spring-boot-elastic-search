package in.novopay.integrations.voter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.novopay.integrations.BaseResponse;
import in.novopay.integrations.ResponseCode;
import in.novopay.integrations.voter.service.IVoterService;
import in.novopay.integrations.voter.service.VoterDTO;

@RestController
@RequestMapping(value = "/v1/voter")
public class VoterController {
	
	@Autowired
	private IVoterService voterService;
	
	@RequestMapping(value = "/{voterId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<? extends Object> voterIdLookup(@PathVariable String voterId) {
		try {
			VoterDTO voterDTO = voterService.getVoter(voterId);
			if (voterDTO == null) {
				return getFailureResponse(ResponseCode.ERROR, "Voter info not found for voterId: " + voterId, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<VoterDTO>(voterDTO, HttpStatus.OK);
		} catch (Exception e) {
			return getFailureResponse(ResponseCode.ERROR, e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	private ResponseEntity<BaseResponse> getFailureResponse(String responseCode, String message, HttpStatus httpStatus) {
		BaseResponse response = new BaseResponse();
		response.setCode(responseCode);
		response.setMessage(message);
		return new ResponseEntity<BaseResponse>(response, httpStatus);
	}
}
