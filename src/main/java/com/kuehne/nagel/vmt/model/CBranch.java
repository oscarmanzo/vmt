package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the c_branch database table.
 * 
 */
@Entity
@Table(name="c_branch")
@NamedQuery(name="CBranch.findAll", query="SELECT c FROM CBranch c")
public class CBranch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean active;

	@Column(name="create_user")
	private String createUser;

	private Timestamp created;

	private String description;

	private Timestamp modified;

	private String name;

	@Column(name="short_identifier")
	private String shortIdentifier;

	private Long trace;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to CCompany
	@ManyToOne
	@JoinColumn(name="c_company_id")
	private CCompany CCompany;

	//bi-directional many-to-one association to COffice
	@OneToMany(mappedBy="CBranch")
	private List<COffice> COffices;

	public CBranch() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortIdentifier() {
		return this.shortIdentifier;
	}

	public void setShortIdentifier(String shortIdentifier) {
		this.shortIdentifier = shortIdentifier;
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

	public CCompany getCCompany() {
		return this.CCompany;
	}

	public void setCCompany(CCompany CCompany) {
		this.CCompany = CCompany;
	}

	public List<COffice> getCOffices() {
		return this.COffices;
	}

	public void setCOffices(List<COffice> COffices) {
		this.COffices = COffices;
	}

	public COffice addCOffice(COffice COffice) {
		getCOffices().add(COffice);
		COffice.setCBranch(this);

		return COffice;
	}

	public COffice removeCOffice(COffice COffice) {
		getCOffices().remove(COffice);
		COffice.setCBranch(null);

		return COffice;
	}

}