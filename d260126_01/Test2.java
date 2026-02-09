package d260126_01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("kim");
		list.add("park");
		list.add("ryu");
		for(String s: list) {
			System.out.println(list);
			
		}
		System.out.println(list.get(2));
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s=it.next();
			System.out.println("it:"+s);
			if(s.equals("park")) {
				it.remove();
			}
		}
		System.out.println(list);
	}

}
