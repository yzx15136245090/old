package com.old.model;

import java.util.Date;

import javax.persistence.Column;

public class User {
	 private String userid;

    private String username;

    private String userschool;

    private String password;

    private String telphone;

    private String email;

    private String credit;

    private String invitecode;

    private String power;

    private String photo;

    private Integer money;
    private Ident ident;

    public Ident getIdent() {
		return ident;
	}

	public void setIdent(Ident ident) {
		this.ident = ident;
	}

	public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserschool() {
        return userschool;
    }

    public void setUserschool(String userschool) {
        this.userschool = userschool == null ? null : userschool.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit == null ? null : credit.trim();
    }

    public String getInvitecode() {
        return invitecode;
    }

    public void setInvitecode(String invitecode) {
        this.invitecode = invitecode == null ? null : invitecode.trim();
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", userschool=" + userschool + ", password=" + password
				+ ", telphone=" + telphone + ", email=" + email + ", credit="
				+ credit + ", invitecode=" + invitecode + ", power=" + power
				+ ", photo=" + photo + ", money=" + money + "]";
	}
	
	
	private String validatacode;
	private Date outdate;
	@Column(name = "validatacode", length = 50)
	public String getValidatacode() {
	    return validatacode;
	}
	 
	public void setValidatacode(String validatacode) {
	    this.validatacode = validatacode;
	}
	@Column(name = "outdate", length = 50)
	public Date getOutdate() {
	    return outdate;
	}
	 
	public void setOutdate(Date outdate) {
	    this.outdate = outdate;
	}
	
    
}