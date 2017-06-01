package in.novopay.integrations.voter.domain;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESVoterRepository extends ElasticsearchRepository<ESVoterInfo, String> {
	
    @Query("{\"bool\": {\"must\": [{\"match\": {\"identifier.id\": \"?0\"}}]}}")
     ESVoterInfo findOneByVoterId(String voterId);
}