package in.novopay.integrations.client.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "assets_client", type = "details")
public class ESClientInfo {

	@Id
	private String id;
	
	private long clientId;
	private String name;
	private String accountNo;
	private String externalId;
	private String statusEnum;
	private Date dob;
	private String spouseName;
	private String fatherName;
	private String gender;
	private String maritalStatus;
	private String mobileNo;
	private String email;
	private String customerTitle;
	private String imageId;
	private String imageb64;
	private String officeId;
	private String officeName;
	
	@Field(type=FieldType.Nested)
	private List<ESKYCInfo> kycs;
	
	@Field(type=FieldType.Nested)
	private List<ESAddress> addresses;
	
	@Field(type=FieldType.Nested)
	private List<ESLoanAppRef> loanAppRef;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getStatusEnum() {
		return statusEnum;
	}
	public void setStatusEnum(String statusEnum) {
		this.statusEnum = statusEnum;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustomerTitle() {
		return customerTitle;
	}
	public void setCustomerTitle(String customerTitle) {
		this.customerTitle = customerTitle;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getOfficeId() {
		return officeId;
	}
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public List<ESKYCInfo> getKycs() {
		return kycs;
	}
	public void setKycs(List<ESKYCInfo> kycs) {
		this.kycs = kycs;
	}
	public List<ESAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<ESAddress> addresses) {
		this.addresses = addresses;
	}
	public List<ESLoanAppRef> getLoanAppRef() {
		return loanAppRef;
	}
	public void setLoanAppRef(List<ESLoanAppRef> loanAppRef) {
		this.loanAppRef = loanAppRef;
	}
	public String getImageb64() {
		return imageb64;
	}
	public void setImageb64(String imageb64) {
		this.imageb64 = imageb64;
	}
	
}
