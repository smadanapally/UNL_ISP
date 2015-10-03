package beans;

public class Organization {
	private String organization = "My Organization";
	private String address = "My Address";

	public Organization(String organs, String addr) {
		// TODO Auto-generated constructor stub

		setAddress(addr);
		setOrganization(organs);
	}

	public Organization() {
		// TODO Auto-generated constructor stub
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		if ( !(organization==null || organization.isEmpty())) {
			this.organization = organization;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (!(address==null||address.isEmpty())) {
			this.address = address;
		}
	}

}
