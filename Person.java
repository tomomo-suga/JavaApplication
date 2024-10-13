
public class Person {
	// Genderという列挙型を定義。MANとWOMANの値を設定
	public enum Gender {
		MAN, WOMAN
	};
	// Genderというインスタンス変数
	// コンストラクタはGender型の引数を受取り、その値をGenderに設定する
	private Gender gender;
	// 
	public Person(Gender gender) {
		this.gender = gender;
	}
	// speakメソッド　genderの値に応じて出力する
	public void speak() {
		// swich文を使って値をチェックし、caseごとに指定された値を出力する
		switch (gender) {
		case MAN:
			System.out.println("I'am a man");
			break;
		case WOMAN:
			System.out.println("I'am a woman");
			break;
		default:
		}
	}
	// mainメソッドで、Personクラスのインスタンスを2つ作成
	// それぞれのインスタンスに対してspeakメソッドを呼び出し、メッセージを出力
	public static void main(String[] args) {
		Person man = new Person(Gender.MAN);
		man.speak();

		Person woman = new Person(Gender.WOMAN);
		woman.speak();
	}
}
