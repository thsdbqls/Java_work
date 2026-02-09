package d260123_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main1 {

	public static void main(String[] args) throws IOException {
		/*
		 * 작업 순서
		 * 
		 * 1) phonebook.txt 파일을 내용을 메모리에 로드한다.
		 * 2) 메모리에 로드된 줄단위 내용을 분리한다
		 * 3) 분리된 데이터를 Phonebook객체로 생성한다
		 * 4) 생성된 Phonebook객체는 리스트 형태로 관리한다.
		 * 
		 */
		File file = new File("phonebook.txt");
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		
		String buf="";
		List<Phonebook> list = new ArrayList<Phonebook>();  // 객체를 관리하기 위한 프레임워크
		//List<Phonebook> list2 = new LinkedList<Phonebook>()
		while((buf=br.readLine())!=null) {
			//System.out.println(buf);
			
			String[] datas = buf.split(" ");
			int id=Integer.parseInt(datas[0]);
			String name=datas[1];
			String hp=datas[2];
			String email=datas[3];
			System.out.printf("%d %s %s %s\n",id,name,hp,email);
			
			Phonebook pb= new Phonebook(id,name, hp, email);
			list.add(pb);
		}
		System.out.println(list);
		
		
		// 새로운 phonebook 객체를 생성하고
		// 리스트 객체의 모든 내용을 텍스트 파일 형식으로 쓰기하시오.
		Phonebook pb2 = new Phonebook(6,"김민수", "010-1111-6666", "min@gmail.com");
		list.add(pb2);
		System.out.println(list);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("Phonebook.txt"));
		
		int index=1;
		for(Phonebook p:list) {
			String inputdate=p.getId()+" "+p.getName()+" "+p.getHp()+" "+p.getEmail();
			bw.write(inputdate);
			// 배열은 lenght, 리스트는 size로 길이를 확인할 수 있다.
			if(index!=list.size()) {bw.newLine();}
			index++;
		}
		bw.flush();
		bw.close();
				
		// 문제점 : 마지막줄에 라인이 추가되는 문제점 발생
		// 마지막에 입력되는 줄은 newLine() 함수를 생략한다.
		
		//위의 내용을 참고하여
		// 전화번호부 관리프로그램에 파일 불러오기 함수를 만들고
		// 이를 초기화시 적용시키시오
		// 추가사항) 메뉴에 파일 불러오기, 파일 저장하기를 추가하여 함수를 완성하시오.
		// 파일 저장하기 함수는 프로그램 종료시 자동을 실행되도록 처리
		

	}

}
