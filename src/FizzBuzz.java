
public class FizzBuzz {
	public static void main(String[] args) {
		// コマンド引数がない場合
		if (args.length == 0) {
			// プログラム強制終了
			return;
		}
		// コマンドライン第一引数を整数値として取得
		int max = Integer.parseInt(args[0]);
		// 1からmaxまで繰り返す
		for (int i = 1; i <= max; i++) {
			//			System.out.println(i);
			if (i % 15 == 0) {
				System.out.println("FizzBuzz");
			}
			// iが3で割り切れるならば
			else if (i % 3 == 0) {
				System.out.println("Fizz");
			}
			// iが5で割り切れるならば
			else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}

	}
}
