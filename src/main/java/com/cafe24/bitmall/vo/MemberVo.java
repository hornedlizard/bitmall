package com.cafe24.bitmall.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberVo {
	private long no;
	@NotEmpty
	@Length(min=5, max=10)
	private String id;
	@NotEmpty
	@Pattern(regexp="^(?=.*[a-zA-Z]+)(?=.*[!@#$%^*+=-]|.*[0-9]+).{4,16}$")
	private String password;
	@NotEmpty
	@Length(min=2, max=8)
	private String name;
	@Past
	private Calendar birth;
	//private DateTime birth;
	private String tel;
//	@Pattern(regexp="^01(0|1|[6-9])(\\d{3}|\\d{4})\\d{4}$")
	@NotEmpty
	@Length(min=10, max=11)
	private String phone;
	@NotEmpty
	@Length(min=10, max=40)
	private String address;
	@Email
	@NotEmpty
	@Length(min=7, max=40)
	private String email;
	private String regdate;
	private int type;
	
	private Calendar cal = Calendar.getInstance();
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(birth.getTime());
	}
	public void setBirth(@Length(min=8) String birth) {		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			if (!"".equals(birth)||""!=birth) {
				cal.setTime(sdf.parse(birth));				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.birth = cal;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "memberVo [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name 
				+ ", birth=" + getBirth() + ", tel=" + tel + ", phone=" + phone + ", address=" + address 
				+ ", email=" + email + ", regdate=" + regdate + ", type=" + type + "]";
	}
	
}
