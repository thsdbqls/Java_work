package d260209_01;

import java.util.ArrayList;
import java.util.List;

// 컬렉션(수집) 프레임워크(구조)
// 자바에서 데이터를 수집하는 구조
// 데이터는 형이 반드시 필요하다
// 소분자로 된 형은 기본현(int, float, char, ...) -> 한 개의 모음
// 대문자로 된 형은 클래스형(String, Scanner, ...) -> 데이터의 모임
// 컬렉션 프레임워크는 클래스형의 데이터를 저장하기 위한 클래스
public class Main {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		// 위으 코드에서 <> 안에 String은 형, 해당 형은 리스트로 저장한다.
		list.add(new String("APPLE"));
		list.add(new String("ORANGE"));
		list.add(new String("MANGO"));
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.indexOf("MANGO"));
		System.out.println(list.get(list.indexOf("MANGO")));

	}

}
