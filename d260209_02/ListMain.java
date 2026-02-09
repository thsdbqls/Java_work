package d260209_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListMain {

	public static void main(String[] args) {
		// ArrayList, LinkLisk, Vector
		// 중복이 가능하다
		List<String> arraylist = new ArrayList<String>();
		arraylist.add("apple");
		arraylist.add("mango");
		arraylist.add("kiwi");
		System.out.println(arraylist);
		// 수정	
		arraylist.set(0, "mangoapple");
		System.out.println(arraylist.get(0));
		// 전체 출력 -> forEach, for, iterator 로 가능하다
		// 삭제 arraylist.remove(0);
		
		
		List<String> linklist = new LinkedList<String>();
		linklist.add("apple");
		linklist.add("cpple");
		linklist.add("bpple");
		
		System.out.println(linklist);
		// arraylist와 차이점은 arraylist는 순차적으로 입력을 해야하는데
		// linklist는 앞과 뒤에 추가할 수 있다.(Queue stack 처럼 사용할 수 있다)
		linklist.addFirst("zeroApple");
		linklist.addLast("lastapple");
		System.out.println(linklist);
		
		// Vector : 방향이 있다(크기가 있다는 뜻)(크기를 자동으로 조절한다)(최고 핵심이다)
		Vector v = new Vector<String>();
		String[] s = {"계획자","설계자","개발자"};
		//v.add(s);
		v.addElement(0);
		v.addElement(1);
		v.addElement(2);
		
		if(v.contains("개발자")) {
			int i=v.indexOf("개발자");
			System.out.println(v.get(i));
		}
		v.addElement(0);
		v.addElement(1);
		v.addElement(2);  // 11개 입력 -> vector는 10개 기본 사이즈이고
			              // 11개가 입력될 때 사이즈는 20개로 늘어난다.
		System.out.println(v.capacity());  // 저장가능한 크기
	}

}
