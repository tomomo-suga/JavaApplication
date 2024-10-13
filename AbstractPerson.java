// Abstractは、抽象クラスを表す修飾子
// 人を表す抽象クラス（定義だけで処理を持たない）です
public abstract class AbstractPerson {

	// protected はアクセス修飾子。性別を取得するための抽象メソッド getGender を持ちます
	protected abstract String getGender();

	// 性別に応じて、標準出力に指定のメッセージを出力
	// メッセージを出力するインスタンスメソッド（クラスオブジェクトに紐づけられたメソッド）speakを呼び出す
	public void speak() {
		System.out.println("I'am a" + getGender());
	}
}
