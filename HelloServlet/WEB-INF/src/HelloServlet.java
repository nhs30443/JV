import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("//hello")
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		// TODO: やることリスト
		// TODO 25/**/** ここは後でやる
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		
		
		String name = "加藤壯昇"; 

		
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body { font-family: 'Segoe UI', sans-serif; background: #f4f4f4; padding: 30px; }");
		out.println("h1 { color: #2c3e50; }");
		out.println("div, p, label { margin: 10px 0; }");
		out.println("input, select, textarea, button { margin: 5px; padding: 8px; border-radius: 5px; border: 1px solid #ccc; }");
		out.println("button { background-color: #007bff; color: white; border: none; cursor: pointer; }");
		out.println("button:hover { background-color: #0056b3; }");
		out.println("fieldset { border: 1px solid #ccc; padding: 10px; margin-bottom: 20px; }");
		out.println("input[type='color'] { width: 50px; height: 50px; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h1>Hello Servlet UI Test</h1>");

		// 表示用テキスト
		out.println("<p>Hello</p>");
		out.println("<p><b>日本語</b>で<i>Hello</i>は<u>こんにちは</u>。</p>");

		out.println("<p>私の名前は"+ name +"です</p>");

		// テキストボックス
		out.println("<label>名前: <input type='text' placeholder='名前を入力'></label><br>");

		// パスワード
		out.println("<label>パスワード: <input type='password'></label><br>");

		// テキストエリア
		out.println("<label>自己紹介:<br><textarea rows='3' cols='30'>ここに入力</textarea></label><br>");

		// チェックボックス
		out.println("<label><input type='checkbox'> 利用規約に同意する</label><br>");

		// ラジオボタン
		out.println("性別:<br>");
		out.println("<label><input type='radio' name='gender'> 男性</label>");
		out.println("<label><input type='radio' name='gender'> 女性</label><br>");

		// セレクトボックス
		out.println("<label>国籍:");
		out.println("<select>");
		out.println("<option>日本</option>");
		out.println("<option>アメリカ</option>");
		out.println("<option>ドイツ</option>");
		out.println("</select></label><br>");

		// ボタン
		out.println("<button>送信</button>");
		out.println("<button>キャンセル</button>");

		// フィールドセット（囲い）
		out.println("<fieldset>");
		out.println("<legend>お問い合わせ</legend>");
		out.println("メール: <input type='email'><br>");
		out.println("内容: <textarea rows='2' cols='30'></textarea><br>");
		out.println("</fieldset>");

		// テーブル
		out.println("<table border='1' cellpadding='5'>");
		out.println("<tr><th>ID</th><th>名前</th><th>年齢</th></tr>");
		out.println("<tr><td>1</td><td>太郎</td><td>20</td></tr>");
		out.println("<tr><td>2</td><td>花子</td><td>22</td></tr>");
		out.println("</table><br>");

		// 進捗バー
		out.println("<label>進捗状況:</label><progress value='70' max='100'></progress><br>");

		// rangeスライダー
		out.println("<label>音量:<input type='range' min='0' max='100' value='50'></label><br>");

		// 色選択
		out.println("<label>色選択:<input type='color' value='#ff0000'></label><br>");

		// 日付
		out.println("<label>日付:<input type='date'></label><br>");

		// 時間
		out.println("<label>時間:<input type='time'></label><br>");

		// 数値入力
		out.println("<label>数量:<input type='number' value='1' min='1' max='10'></label><br>");

		out.println("<style>");
		out.println("footer { margin-top: 40px; padding: 10px; text-align: center; color: #777; font-size: 14px; border-top: 1px solid #ccc; }");
		out.println("</style>");
		out.println("<footer>");
		out.println("copyright &copy; <script>var hiduke=new Date();document.write(hiduke.getFullYear());</script> ChatGPT-4-turbo. All rights reserved.");
		out.println("</footer>");
		
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
	// 1行コメント
	/* 複数行コメント */
}