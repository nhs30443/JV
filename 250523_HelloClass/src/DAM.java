// クラス
public class DAM {
	
	public String title;
	public double rawScore;
	public double bonusScore;
	public double totalScore;
	public int pitch;
	public int stability;
	public int expression;
	public int rhythm;
	public int VL;
	public int chart;
	public int intonation;
	public int shakuri;
	public int kobushi;
	public int fall;
	public int longTone;
	public int vibrato;
	public String vibratoType;
	public double vibratoSecons;
	public int vibratoTimes;
	public int rhythmMeter;
	public String range;
	public String vocalRange;
	public int key;
	public boolean DXG;
	public boolean Ai;

	public String bonusType;
	public double extraPoints;

	public int AiSensitivity;
	public int AiSensitivityPlus;
	public int AiSensitivityMinus;
	public int expressionLoss;
	
	
	// メソッド
	//   素点にボーナス点を加算して総合得点算出
	public void total() {
		this.totalScore = rawScore + bonusScore;
	}
	
	//   抑揚値を基に最大表現力値を算出し、そこから表現欠けを算出
	public void loss() {
		this.expressionLoss = (expression - intonation/4) - 75;
	}
	
}
