import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class Lambda {
	// streamとは、コレクション操作を効率的に行う。情報を作る・消費する　0から
	// streamの取得
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

	public static void main(String[] args) {
		// 中間操作
		// 1 から 10000 までの範囲
		IntStream stream = IntStream.range(1, 10000);

		// sreamの終端操作であるforEachを利用して、stream内の全ての要素を出力する
		// メソッド参照を使わないランダム式にて記述　i ->
		// iはforループやストリームAPIでよく使われる変数名
		// ミリ単位の
		stream.forEach(i -> System.out.println(currentTime() + " " + i));
	}

	private static String currentTime() {
		// (LocalDateTime.now())は現在の日時を取得
		// 上記をformatに変換し文字列で返す
		return FORMATTER.format(LocalDateTime.now());
	}
}
