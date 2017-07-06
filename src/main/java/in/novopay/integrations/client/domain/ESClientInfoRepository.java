package in.novopay.integrations.client.domain;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESClientInfoRepository extends ElasticsearchRepository<ESClientInfo, String> {

	@Query("{\"query_string\":{\"query\":\"*?0*\",\"fields\":[\"_all\"]}}")
	List<ESClientInfo> findClientInfo(String pattern);
}
