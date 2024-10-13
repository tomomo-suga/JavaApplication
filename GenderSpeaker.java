// mainメソッドを持つ、処理を実行させるためのクラス
// Manクラス、Womanクラスのインスタンスを生成し、doSpeakメソッドに渡す
public class GenderSpeaker {
	public static void main(String[] args) {
		doSpeak(new Man());

		doSpeak(new Woman());
	}

	private static void doSpeak(AbstractPerson person) {
		person.speak();
	}
}
