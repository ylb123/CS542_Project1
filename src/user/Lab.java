package user;

public class Lab {
      String lid;
      String name;
      String affiliation;
      int bbpoint;
      
	  public Lab(String lid, String name, String affiliation, int bbpoint) {
	
		this.lid = lid;
		this.name = name;
		this.affiliation = affiliation;
		this.bbpoint = bbpoint;
	 }

	public String getLid() {
		return lid;
	}

	public String getName() {
		return name;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public int getBbpoint() {
		return bbpoint;
	}
	  
      
}
