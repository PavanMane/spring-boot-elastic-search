package in.novopay.integrations.client.domain;

public class ESKYCInfo {

	private String id;
	private String kycId;
	private String documentTypeId;
	private String documentTypeName;
	private String documentKey;
	private String expiryDate;
	private String issuedDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKycId() {
		return kycId;
	}
	public void setKycId(String kycId) {
		this.kycId = kycId;
	}
	public String getDocumentTypeId() {
		return documentTypeId;
	}
	public void setDocumentTypeId(String documentTypeId) {
		this.documentTypeId = documentTypeId;
	}
	public String getDocumentTypeName() {
		return documentTypeName;
	}
	public void setDocumentTypeName(String documentTypeName) {
		this.documentTypeName = documentTypeName;
	}
	public String getDocumentKey() {
		return documentKey;
	}
	public void setDocumentKey(String documentKey) {
		this.documentKey = documentKey;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}
	
}
