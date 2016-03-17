package user;

public class Lab {
      private int lid;
      private String lname;
      private String affiliation;
      private String address;
      private String researchArea;
      private double bbpointBalance;
      
	  public Lab(int lid, String lname, String affiliation, String address, String researchArea, double bbpointBalance) {
	
		this.lid = lid;
		this.lname = lname;
		this.affiliation = affiliation;
		this.address = address;
		this.researchArea = researchArea;
		this.bbpointBalace = bbpointBalance;
	 }

	public int getLid() {
		return lid;
	}

	public String getLname() {
		return lname;
	}

	public String getAffiliation() {
		return affiliation;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getRearchArea() {
		return researchArea;
	}

	public int getBbpointBalance() {
		return bbpointBalance;
	}
	  
      
}
