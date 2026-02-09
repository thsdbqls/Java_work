package d260128;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Main7 {

	public static void main(String[] args) {
		MenubarFrame f = new MenubarFrame();
		f.openitem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("openitem선택!!!");
				FileDialog filedialog = new FileDialog(f,"Open File", FileDialog.LOAD);
				filedialog.setVisible(true);
				
				// 파일의 경로, 파일명을 추출
				System.out.println(filedialog.getDirectory());
				System.out.println(filedialog.getFile());
			}
		});
	}

}

class MenubarFrame extends Frame implements MenuListener{
	MenuBar menubar;
	
	Menu filemenu;
	MenuItem newitem;
	MenuItem openitem;
	
	Menu editmenu;
	MenuItem copyitem;
	
	public MenubarFrame() {
		setTitle("메뉴바 만들기");
		setBounds(0, 0, 1000, 1000);
		setVisible(true);
		
		menubar = new MenuBar();
		filemenu = new Menu("file");
		newitem = new MenuItem("New");
		openitem = new MenuItem("Open");
		
		editmenu = new Menu("Edit");
		copyitem = new MenuItem("Copy");
		
		// 메뉴바는 역조립
		// 메뉴 아이템을 추가한 것이다
		filemenu.add(newitem);
		filemenu.add(openitem);
		
		editmenu.add(copyitem);
		
		//메뉴바에 메뉴를 추가해야 한다
		menubar.add(filemenu);
		menubar.add(editmenu);
		
		// 프레임에 메뉴바를 추가
		setMenuBar(menubar);
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
}
