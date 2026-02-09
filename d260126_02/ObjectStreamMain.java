package d260126_02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamMain {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		/*
		ObjectOutputStream out =
				new ObjectOutputStream(new FileOutputStream("object.ser"));
		
		Phonebook pb
		= new Phonebook(1,"홍길동","010-1111-1111","hong@gmail.com");
		
		out.writeObject(pb);*/
		
		// 객체 자체를 스트림으로 저장한는 것
		ObjectInput ois =
				new ObjectInputStream(new FileInputStream("object.ser"));
				

		Phonebook pb
		= new Phonebook(1,"홍길동","010-1111-1111","hong@gmail.com");
		
				//강제로 형 변형
		Phonebook p=(Phonebook)ois.readObject();
		System.out.println(p);
	}

}
