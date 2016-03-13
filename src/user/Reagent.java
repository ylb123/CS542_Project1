package user;

public class Reagent {
  
  private String rname;
  private String source;
  private String type;
  private String expireDate;
  private int scoreNum;
  private double avrscore;
  
  public Reagent(String rname, String source, String type, String expireDate, int scoreNum, double avrscore) {
    this.rname = rname;
    this.source = source;
    this.type = type;
    this.expireDate = expireDate;
    this.scoreNum = scoreNum;
    this.avrscore = avrscore;
  }
  
  public String getRname() {
    return rname;
  }
  
  public String getSource() {
    return source;
  }
  
  public String getType() {
    return type;
  }
  
  public String expireDate() {
    return expireDate;
  }
  
  public int getScoreNum() {
    return scoreNum;
  }
  
  public double getAvrscore() {
    return avrscore;
  }

}
