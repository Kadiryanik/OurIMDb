public class Organization {
	private String orgName;
	private String orgCountry;
	private int organizationId;
	
	@Override
	public String toString(){
		return "" + this.orgName + " | " + this.orgCountry + " | " + this.organizationId;
	}
	Organization(){
		
	}
	
	Organization(String orgName, String orgCountry, int organizationId){
		this.setorgName(orgName);
		this.setorgCountry(orgCountry);
		this.setorganizationId(organizationId);
	}

	public String getorgName() {
		return orgName;
	}

	public void setorgName(String orgName) {
		this.orgName = orgName;
	}

	public String getorgCountry() {
		return orgCountry;
	}

	public void setorgCountry(String orgCountry) {
		this.orgCountry = orgCountry;
	}

	public int getorganizationId() {
		return organizationId;
	}

	public void setorganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
}
