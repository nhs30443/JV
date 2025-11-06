
public class DAMUse {
	private static final boolean True = true;
	private static final boolean False = false;

	public static void main(String[] args) {
		
		// DAMクラスをインスタンス化
		DAM result1 = new DAM();
		
		result1.title = "冬のうた";
		result1.rawScore = 98.097;
		result1.bonusScore = 1.903;
		result1.pitch = 92;
		result1.stability = 99;
		result1.expression = 100;
		result1.rhythm = 99;
		result1.VL = 97;
		result1.chart = 487;
		result1.intonation = 100;
		result1.shakuri = 60;
		result1.kobushi = 36;
		result1.fall = 0;
		result1.longTone = 8;
		result1.vibrato = 10;
		result1.vibratoType = "B-2";
		result1.vibratoSecons = 66.3;
		result1.vibratoTimes = 44;
		result1.rhythmMeter = 0;
		result1.range = "mid1D-mid2D#";
		result1.vocalRange = "mid1D-mid2D#";
		result1.key = -7;
		result1.DXG = False;
		result1.Ai = True;

		result1.AiSensitivity = 82;
		result1.AiSensitivityPlus = 100;
		result1.AiSensitivityMinus = 100;
		

		// 総合得点を計算
		result1.total();
		
		// 表現欠けを計算
		result1.loss();
		
		
		// 出力
		System.out.println("曲名：" + result1.title);
		System.out.println("素点：" + result1.rawScore + "点");
		System.out.println("ボーナス点：" + result1.bonusScore + "点");
		System.out.println("総合得点：" + String.format("%.3f", result1.totalScore) + "点");
		
		System.out.println("");
		
		System.out.println("音程：" + result1.pitch + "%");
		System.out.println("安定性：" + result1.stability + "点");
		System.out.println("表現力：" + result1.expression + "点");
		System.out.println("リズム：" + result1.rhythm + "点");
		System.out.println("VL：" + result1.VL + "点");

		System.out.println("");
		
		System.out.println("チャート合計：" + result1.chart);

		System.out.println("");
		
		System.out.println("抑揚：" + result1.intonation + "点");
		System.out.println("しゃくり：" + result1.shakuri + "回");
		System.out.println("こぶし：" + result1.kobushi + "回");
		System.out.println("フォール：" + result1.fall + "回");
		
		System.out.println("");
		
		System.out.println("ロングトーン評価：" + result1.longTone);

		System.out.println("");
		
		System.out.println("ビブラート評価：" + result1.vibrato);
		System.out.println("ビブラートタイプ：" + result1.vibratoType);
		System.out.println("ビブラート秒数：" + result1.vibratoSecons + "秒");
		System.out.println("ビブラート回数：" + result1.vibratoTimes + "回");

		System.out.println("");
		
		System.out.println("リズムメーター：" + result1.rhythmMeter);
		
		System.out.println("");
		
		System.out.println("音域：" + result1.range);
		System.out.println("声域：" + result1.vocalRange);
		System.out.println("キー：" + result1.key);

		System.out.println("");
		
		System.out.println("AI感性：" + result1.AiSensitivity + "点");
		System.out.println("AI感性+：" + result1.AiSensitivityPlus + "点");
		System.out.println("AI感性-：" + result1.AiSensitivityMinus + "点");

		System.out.println("");
		
		System.out.println("表現欠け：" + result1.expressionLoss);
		
	}

}
