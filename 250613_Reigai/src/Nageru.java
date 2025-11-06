public class Nageru{
	public static void main(String[] args) {
		try {
			System.out.println("スロー");
			System.out.println("メソッド呼び出し");
			System.out.println(zikkou());
			System.out.println("メソッド呼び出し終わり");
			// わざとシステムエラーにしてみる
			int a = 1/0;
			System.out.println("aは" + a);
		}catch (ArithmeticException ae) {
			// ArithmeticExceptionは0で割った際の例外のみを取り扱う
			System.out.println("ゼロ除算エラー");
		}catch (NumberFormatException nfe) {
			System.out.println("数値型変換エラー");
		}catch (Exception e) {
			System.out.println("原因不明のエラー");
		}finally {
			// finally: ファイナル(最終)処理
			//   try-catchを終える際に実行する共通処理
			System.out.println("try-catch終了");
		}
		System.out.println("糸冬");
	}
	
	private static String zikkou() throws NumberFormatException {
		String ret = "返す";
		//システムエラーを起こす
		System.out.println(1 + Integer.parseInt(""));
		
		return ret;
	}
	
}