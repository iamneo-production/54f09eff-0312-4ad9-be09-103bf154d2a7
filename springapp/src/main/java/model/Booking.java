package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking {

	@Id
	private int bid;
	private String bmname;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBmname() {
		return bmname;
	}
	public void setBmname(String bmname) {
		this.bmname = bmname;
	}
	
	
}
