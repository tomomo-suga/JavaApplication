// extends　は継承の意味、親クラスAbstractPersonの特性やメソッドを継承している
public class Woman extends AbstractPerson {

	// AbstractPersonのメソッドをオーバーライドする
	@Override
	protected String getGender() {
		return "woman";
	}

}