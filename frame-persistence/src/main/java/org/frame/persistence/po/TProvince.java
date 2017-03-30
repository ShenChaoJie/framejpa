package org.frame.persistence.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="t_province")
public class TProvince implements java.io.Serializable {

	private static final long serialVersionUID = 7277321030261568800L;
	
	private Integer id;
	private Integer pid;
	private String name;
	private String pname;
	private Date ctime;

	public TProvince() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TProvince(Integer id, Integer pid, String name, String pname,
			Date ctime) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.pname = pname;
		this.ctime = ctime;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "pid")
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "name" ,length =50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pname" ,length =50)
	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	@Temporal(value = TemporalType.TIMESTAMP) 
	@Column(name="ctime")  
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

}
