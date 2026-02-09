package d260202_03;

import d260202_01.Phonebook;
import d260202_01.PhonebookDAO;

public class AccountBookManage {

	UpdateDAO udao;
	
	public void update(String category, String indate, AccountBook p) {
		if(p.getAmount().equals("")) {p.setAmount(null);}
		if(p.getCategory().equals("")) {p.setCategory(null);}
		if(p.getIndate().equals("")) {p.setIndate(null);}
		p.setId(0);
		
		udao.SelectUpdate2(p);
	}
}
