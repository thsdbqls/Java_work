package d260126_01;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("kim");
		list.add("park");
		list.add("ryu");
		System.out.println(list);
		
		list.add("kim");
		
		System.out.println(list);
		//get이 끄집어 내는 것이다
		System.out.println(list.get(0));
		list.remove(0);  // 0번째 삭제
		System.out.println(list);
	}
}
