package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rt_headcount_company_role database table.
 * 
 */
@Entity
@Table(name="rt_headcount_company_role")
@NamedQuery(name="RtHeadcountCompanyRole.findAll", query="SELECT r FROM RtHeadcountCompanyRole r")
public class RtHeadcountCompanyRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean active;

	@Column(name="create_user")
	private String createUser;

	private Timestamp created;

	private Timestamp modified;

	private Long trace;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to CCompanyRole
	@ManyToOne
	@JoinColumn(name="c_company_role_id")
	private CCompanyRole CCompanyRole;

	//bi-directional many-to-one association to ScHeadcount
	@ManyToOne
	@JoinColumn(name="sc_headcount_id")
	private ScHeadcount scHeadcount;

	public RtHeadcountCompanyRole() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public Long getTrace() {
		return this.trace;
	}

	public void setTrace(Long trace) {
		this.trace = trace;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public CCompanyRole getCCompanyRole() {
		return this.CCompanyRole;
	}

	public void setCCompanyRole(CCompanyRole CCompanyRole) {
		this.CCompanyRole = CCompanyRole;
	}

	public ScHeadcount getScHeadcount() {
		return this.scHeadcount;
	}

	public void setScHeadcount(ScHeadcount scHeadcount) {
		this.scHeadcount = scHeadcount;
	}

}