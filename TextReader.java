import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class TextReader {
	private String path;
	// TextReader クラス専用のロガーを作成し、クラス内で利用
	private static Logger logger = Logger.getLogger(TextReader.class.getName());

	// 列挙型 enum のMarkを宣言
	public enum Mark {
		START, END
	};

	// pathは引数、this.pathはインスタンス変数（それぞれのインスタンスに属する変数)
	// 値はインスタンス（値をいれたデータ）毎に異なる
	private TextReader(String path) {
		this.path = path;
	}

	private void execute() {
		// Integer型のリストを作成
		// ArrayListを継承したObjectListクラスのインスタンスを作成
		// ObjectListクラスは、ジェネリッククラスであり、Int型を指定
		List<Integer> valueList = new ObjectList<Integer>();

		// リソース付きtry文を作成、自動的に指定リソース（BufferedReader）を閉じる
		// FileReaderはファイルを読み取り、BufferedReaderは読み込みを効率化する
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			// lineを宣言、初期値にnullを設定。後で、ファイルから読み込んだ1行分のデータを保持するのに使用。
			String line = null;
			// whileループは、BufferedReaderオブジェクトbrから１行ずつデータを読み込みます
			// 読み込んだ行がnullでない限り（ファイル終了に達成ていない限り）、ループが繰り返される
			while ((line = br.readLine()) != null) {
				valueList.add(Integer.parseInt(line));
			}
			// IOException型の例外が発生した場合、catchが実行
		} catch (IOException e) {
			// eスタックトレース（プログラムがエラーを起こした瞬間の履歴）をエラーストリームに出力
			e.printStackTrace();
		}

		// 拡張forループを使って、valueListの各要素を順番にvalueという変数に代入しながらループを実行
		// valueLisstから取り出されたint型の要素が、自動的にInteger形に変換
		for (Integer value : valueList) {
			System.out.println(value);
		}
	}

	// String[] args 可変長引数（ゼロ個以上の引数を渡すことができ、自動的に配列に変換）
	public static void main(String[] args) {
		// ロガーを使って、プログラムの開始を示す情報ログを記録
		// enum型MaekのSTARTの値を取得
		logger.info(Mark.START.name());
		// args[0]で指定されたファイルパスを使用、TextReaderクラスのコンストラクタが呼び出されて
		// executeメソッドが実行される
		new TextReader(args[0]).execute();
		// ロガーを使って、プログラム終了を示す情報ログを記録
		logger.info(Mark.END.name());
	}
}
