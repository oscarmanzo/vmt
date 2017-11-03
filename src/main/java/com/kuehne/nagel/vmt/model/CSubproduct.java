package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the c_subproduct database table.
 * 
 */
@Entity
@Table(name="c_subproduct")
@NamedQuery(name="CSubproduct.findAll", query="SELECT c FROM CSubproduct c")
public class CSubproduct implements Serializable {
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

	//bi-directional many-to-one association to CBusinessUnit
	@ManyToOne
	@JoinColumn(name="c_business_unit_id")
	private CBusinessUnit CBusinessUnit;

	//bi-directional many-to-one association to CSubproductType
	@OneToMany(mappedBy="CSubproduct")
	private List<CSubproductType> CSubproductTypes;

	public CSubproduct() {
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

	public CBusinessUnit getCBusinessUnit() {
		return this.CBusinessUnit;
	}

	public void setCBusinessUnit(CBusinessUnit CBusinessUnit) {
		this.CBusinessUnit = CBusinessUnit;
	}

	public List<CSubproductType> getCSubproductTypes() {
		return this.CSubproductTypes;
	}

	public void setCSubproductTypes(List<CSubproductType> CSubproductTypes) {
		this.CSubproductTypes = CSubproductTypes;
	}

	public CSubproductType addCSubproductType(CSubproductType CSubproductType) {
		getCSubproductTypes().add(CSubproductType);
		CSubproductType.setCSubproduct(this);

		return CSubproductType;
	}

	public CSubproductType removeCSubproductType(CSubproductType CSubproductType) {
		getCSubproductTypes().remove(CSubproductType);
		CSubproductType.setCSubproduct(null);

		return CSubproductType;
	}

}