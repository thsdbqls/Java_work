package d260127;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFuc implements ActionListener {
	PhonebookFrame f;
	private java.util.List<Phonebook> datas;

	public ButtonFuc(PhonebookFrame phonebookFrame) {
		
		
	}

	public ButtonFuc(PhonebookFrame phonebookFrame, java.util.List<Phonebook> list) {
		this.datas = list;
		this.f = phonebookFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		f.setVisible();
		
		f.getListBox().removeAll();  // 가져온 리스트를 다 지우고
		
		String header=new String("아이디 이름 전화번호                         ");
		f.getListBox().add(header);
		
		for(Phonebook p:datas) {
			f.getListBox().add(p.getId()+ " "+ p.getName() + " " + p.getHp());
			
		}
		
		
		f.getListBox().setVisible(true);
		f.revalidate();
		f.repaint();
	}

}
