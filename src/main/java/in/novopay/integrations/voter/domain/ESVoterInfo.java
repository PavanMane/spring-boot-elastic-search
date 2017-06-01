package in.novopay.integrations.voter.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * This is a data model for Voter information in Khoslalab Elasticsearch data set  
 * @author pavanmane
 *
 */
@Document(indexName = "ceo", type = "ceo_type")
public class ESVoterInfo {
	
	@Id
	private String id;
	
	@Field(type=FieldType.Object)
	private ESVoterIdentifier identifier;
	
	private String name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ESVoterIdentifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(ESVoterIdentifier identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ESVoterParent getParent() {
		return parent;
	}

	public void setParent(ESVoterParent parent) {
		this.parent = parent;
	}

	public Map<String, Object> getAll_attributes() {
		return all_attributes;
	}

	public void setAll_attributes(Map<String, Object> all_attributes) {
		this.all_attributes = all_attributes;
	}

	public ESVoterAddress getAddress() {
		return address;
	}

	public void setAddress(ESVoterAddress address) {
		this.address = address;
	}

	@Field(type=FieldType.Object)
	private ESVoterParent parent;
	
	private Map<String, Object> all_attributes; 
	
	@Field(type=FieldType.Object)
	private ESVoterAddress address;
	
	
}
