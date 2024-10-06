import com.example.Child;
import com.example.GrandParent;
import com.example.Parent;

public class HelloWorld {
	public static void main(String[] args) {
		GrandParent gp = new GrandParent();
		System.out.println(gp.getAge());
		Parent p = new Parent();
		System.out.println(p.getAge());
		Child c = new Child();
		System.out.println(c.getAge());
	}
}