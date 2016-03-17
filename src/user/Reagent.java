package user;

public class Reagent {
	private String name;
	private int lid;
	private String source;
    private String type;
    private String expDate;
    private int scoreNum;
	private double averageScore;
	private int sqty;
	private int askp;
	
	
	
	public Reagent(String name, int lid, String source, String type,String expDate, int scoreNum, double averageScore,int askp) {
		this.name = name;
		this.lid = lid;
		this.source = source;
		this.type = type;
		this.expDate = expDate;
		this.scoreNum = scoreNum;
		this.averageScore = averageScore;
		this.askp=askp;
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
	public int getLid() {
		return lid;
	}
	public int getSqty() {
		return sqty;
	}
	public int getAskp() {
		return askp;
	}
}
