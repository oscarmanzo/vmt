package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the c_department database table.
 * 
 */
@Entity
@Table(name="c_department")
@NamedQuery(name="CDepartment.findAll", query="SELECT c FROM CDepartment c")
public class CDepartment implements Serializable {
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

	//bi-directional many-to-one association to CSgiCentre
	@ManyToOne
	@JoinColumn(name="c_sgi_centre_id")
	private CSgiCentre CSgiCentre;

	//bi-directional many-to-one association to CProfitCentre
	@OneToMany(mappedBy="CDepartment")
	private List<CProfitCentre> CProfitCentres;

	public CDepartment() {
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

	public CSgiCentre getCSgiCentre() {
		return this.CSgiCentre;
	}

	public void setCSgiCentre(CSgiCentre CSgiCentre) {
		this.CSgiCentre = CSgiCentre;
	}

	public List<CProfitCentre> getCProfitCentres() {
		return this.CProfitCentres;
	}

	public void setCProfitCentres(List<CProfitCentre> CProfitCentres) {
		this.CProfitCentres = CProfitCentres;
	}

	public CProfitCentre addCProfitCentre(CProfitCentre CProfitCentre) {
		getCProfitCentres().add(CProfitCentre);
		CProfitCentre.setCDepartment(this);

		return CProfitCentre;
	}

	public CProfitCentre removeCProfitCentre(CProfitCentre CProfitCentre) {
		getCProfitCentres().remove(CProfitCentre);
		CProfitCentre.setCDepartment(null);

		return CProfitCentre;
	}

}