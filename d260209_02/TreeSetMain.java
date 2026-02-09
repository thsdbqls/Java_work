package d260209_02;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		set.add(5);
		set.add(1);
		set.add(3);
		set.add(4);
		set.add(2);
		set.add(6);
		System.out.println(set);

		Set<String> set2 = new TreeSet<String>();
		set2.add("e");
		set2.add("a");
		set2.add("s");
		set2.add("d");
		set2.add("b");
		set2.add("f");
		set2.add("g");
		System.out.println(set2);
		System.out.println(set2.size());
	}

}
