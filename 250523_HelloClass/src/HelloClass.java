// クラスの書き方
// スコープ class クラス名
// sスコープ: このクラスを公開する範囲
//   ex) public: 公開　private: 非公開　protected: 同系統には公開
// クラス名は先頭大文字の英語表記
// javaファイル名と同じにする
//   ex) HelloClass

public class HelloClass {
	
	// mainメソッド(javaのクラスで最初に呼び出すメソッド)
	// static: 静的
	//  戻り値の型 void: nullに近い、何もない
	public static void main(String[] args) {
		
		// ここにメソッドでやりたい処理を書いていく
		System.out.println("コンソールに文字出力");
		System.out.println("こんにちは");
		System.out.println("Java SE");

		System.out.println(keisan(200, 56));
		System.out.println(keisan(100, -36));
	}
	
	// メソッドの記述
	public static int keisan(int a, int b) {
		int ret = 0;
		ret = a + b;
		
		return ret; 
	}
	
	
	
}
