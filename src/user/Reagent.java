package user;

public class Reagent {
	private String name;
	private String lid;
	private String source;
    private String type;
    private String expDate;
    private int scoreNum;
	private double averageScore;
	private int sqty;
	private double askp;
	private String image;
	
	
	
	public Reagent(String name, String lid, String source, String type,String expDate, int scoreNum, double averageScore,double askp,String image) {
		this.name = name;
		this.lid = lid;
		this.source = source;
		this.type = type;
		this.expDate = expDate;
		this.scoreNum = scoreNum;
		this.averageScore = averageScore;
		this.askp=askp;
		this.image=image;
	}
	public String getName() {
		return name;
	}
	public String getSource() {
		return source;
	}
	public String getType() {
		return type;
	}
	public String getExpdate() {
		return expDate;
	}
	public int getScorenum() {
		return scoreNum;
	}
	public double getAveragescore() {
		return averageScore;
	}
	public String getLid() {
		return lid;
	}
	public int getSqty() {
		return sqty;
	}
	public double getAskp() {
		return askp;
	}
	public String getImage() {
		return image;
	}
	
}
