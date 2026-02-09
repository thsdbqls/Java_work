package d260123;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) throws IOException {
		// 메모리에 있는 데이터를 파일에 저장하는 것은 출력 스트림(output Stream)으로
		// 파일로 부터 메모리로 데이터 가져오기 (input Stream)
		
		// 이클립스에서 파일의 기준점은 프로젝트 명이다
		File file = new File("a.txt");  // 경로가 없는 경우 기준점은 프로젝트 명이다
		FileInputStream in=new FileInputStream(file);
		System.out.println(in.available());
		String s="";
		while(in.available()>0) {
			s+= (char)in.read();
		}
		System.out.println(s);
		
		// 메모리에 본인의 영문 이름을 입력하고,
		// 스트림으로 파일에 메모리의 내용을 기록하세요
		s = "son " + s;
		FileOutputStream ou = new FileOutputStream(file);

		// 문자열을 byte 배열로 변환
		for(byte b:s.getBytes()) {
		ou.write(b);
		}
		ou.flush();
	}

}
