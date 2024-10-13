// extends　は継承の意味、親クラスAbstractPersonの特性やメソッドを継承している
public class Man extends AbstractPerson {

	// AbstractPersonのメソッドをオーバーライドする
	// protectedはクラスのアクセス制御を行う
	@Override
	protected String getGender() {
		return "man";
	}

}
