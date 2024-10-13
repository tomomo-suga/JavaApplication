import java.util.ArrayList;
// 仮型引数には大文字一文字を使います。T (Type の意味)を使うことで、様々な型の要素を扱える
// extends　は継承の意味、親クラスArrayListの特性やメソッドを継承

public class ObjectList<T> extends ArrayList<T> {
	
	// 親クラスArrayListから継承された、addメソッドをオーバーライド
	// valueをリストに追加
	public boolean add(T value) {
		return super.add(value);
	}
	
	// ArrayListから継承されたgetメソッドをオーバーライド
	// リスト内に指定されたindex要素を取得して返す
	public T get(int index) {
		return super.get(index);
	}
}
