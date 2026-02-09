package d260209_02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMain {

	public static void main(String[] args) {
		// 순서가 없고 중복안됨
		Set<String> set = new HashSet<String>();
		set.add("apple");
		set.add("mango");
		set.add("banana");
		set.add("kiwi");
		System.out.println(set);
		
		// 입력 방법, 출력 방법, 수정, 삭제, 전체 삭제
		// 입력 : add
		// 출력 : forEach 이용하여 출력하는 방법
		System.out.println(set);
		set.forEach(s->{
			System.out.println(s);
		});
		// 찾기 / 포함되어 있는지 확인하는 방법
		System.out.println(set.contains("apple"));
		// 이터레이터 이용하여 출력하는 방법
		Iterator<String>iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		//for문을 이용하여 출력하는 방법
		for(String s:set) {
			System.out.println(s);
		}
		// 수정은 해당 객체를 찾은 후 삭제한 다음 add한다
		// 별도의 수정이 존재하지 않음
		
		// 삭제
		//set.remove();
		//set.removeAll();
		
		
	}

}
