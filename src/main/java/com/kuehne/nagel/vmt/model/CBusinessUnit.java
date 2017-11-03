package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the c_business_unit database table.
 * 
 */
@Entity
@Table(name="c_business_unit")
@NamedQuery(name="CBusinessUnit.findAll", query="SELECT c FROM CBusinessUnit c")
public class CBusinessUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean active;

	@Column(name="create_user")
	private String createUser;

	private Timestamp created;

	private String description;

	private String mission;

	private Timestamp modified;

	private String name;

	@Column(name="short_identifier")
	private String shortIdentifier;

	private Long trace;

	@Column(name="update_user")
	private String updateUser;

	private String vision;

	//bi-directional many-to-one association to CBusinessType
	@ManyToOne
	@JoinColumn(name="c_business_type_id")
	private CBusinessType CBusinessType;

	//bi-directional many-to-one association to CSubproduct
	@OneToMany(mappedBy="CBusinessUnit")
	private List<CSubproduct> CSubproducts;

	public CBusinessUnit() {
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

	public String getMission() {
		return this.mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
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

	public String getVision() {
		return this.vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public CBusinessType getCBusinessType() {
		return this.CBusinessType;
	}

	public void setCBusinessType(CBusinessType CBusinessType) {
		this.CBusinessType = CBusinessType;
	}

	public List<CSubproduct> getCSubproducts() {
		return this.CSubproducts;
	}

	public void setCSubproducts(List<CSubproduct> CSubproducts) {
		this.CSubproducts = CSubproducts;
	}

	public CSubproduct addCSubproduct(CSubproduct CSubproduct) {
		getCSubproducts().add(CSubproduct);
		CSubproduct.setCBusinessUnit(this);

		return CSubproduct;
	}

	public CSubproduct removeCSubproduct(CSubproduct CSubproduct) {
		getCSubproducts().remove(CSubproduct);
		CSubproduct.setCBusinessUnit(null);

		return CSubproduct;
	}

}