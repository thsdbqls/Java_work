package d260209_01;

import java.util.HashMap;
import java.util.Map;

public class RefValMain {

	public static void main(String[] args) {
		/*String a = new String("hello");
		String b = new String("inst");
		String c=a;
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(a.hashCode());
		System.out.println(c.hashCode());
		
		Map<String, Phonebook> map = new HashMap<String, Phonebook>();
		Phonebook p = new Phonebook(1, "hongkildong");
		map.put("hong", p);
		System.out.println(map.get("hong").hashCode());
		System.out.println(p.hashCode());
		System.out.println(map.put("hong",p)==p);
		p = new Phonebook(2, "kimkildong");
		System.out.println(p.hashCode());
		map.put("kim", p);
		System.out.println(map.size());*/
		
		String a = new String("hello");
		String b = new String("hello");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		b="insa";
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		String c = new String("welcom");
		String d =c;
		System.out.println(c.hashCode());
		System.err.println(d.hashCode());
		
		// d는 c를 참조하는 변수, 참조하는 변수가 값을 변경하게 되면 연결되어 있는 변수도 같이 변경된다.
		c=c+"!!";
		System.out.println(c.hashCode());
		System.err.println(d.hashCode());
		System.out.println(c);
		System.err.println(d);
	}

}
