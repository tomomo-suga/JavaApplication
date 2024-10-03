
public class ArgsLastPrinter {
	public static void main(String[] args) {
		// 要素数を表示　System.out.println(args.length);
		// 要素数が0個かどうかを確認する
		if (args.length == 0) {
			// 要素数が0個だったらメッセージを表示して終了
			System.out.println("なし");
			// 要素数が1個以上だったら最後の要素を表示する
			// 添字は0から始まる、１番目の要素は0、引数の最後は要素数-1
		} else {
			System.out.println(args[args.length - 1]);
		}
	}
}
