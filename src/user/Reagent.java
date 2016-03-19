package user;

public class Reagent {
	private String name;
<<<<<<< HEAD
	private String lid;
=======
	private int lid;
>>>>>>> origin/master
	private String source;
    private String type;
    private String expDate;
    private int scoreNum;
	private double averageScore;
	private int sqty;
<<<<<<< HEAD
	private double askp;
	private String image;
	
	
	
	public Reagent(String name, String lid, String source, String type,String expDate, int scoreNum, double averageScore,double askp,String image) {
=======
	private int askp;
	
	
	
	public Reagent(String name, int lid, String source, String type,String expDate, int scoreNum, double averageScore,int askp) {
>>>>>>> origin/master
		this.name = name;
		this.lid = lid;
		this.source = source;
		this.type = type;
		this.expDate = expDate;
		this.scoreNum = scoreNum;
		this.averageScore = averageScore;
		this.askp=askp;
<<<<<<< HEAD
		this.image=image;
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
	public String getLid() {
=======
	public int getLid() {
>>>>>>> origin/master
		return lid;
	}
	public int getSqty() {
		return sqty;
	}
<<<<<<< HEAD
	public double getAskp() {
		return askp;
	}
	public String getImage() {
		return image;
	}
	
=======
	public int getAskp() {
		return askp;
	}
>>>>>>> origin/master
}
