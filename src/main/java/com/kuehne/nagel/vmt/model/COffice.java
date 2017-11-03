package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the c_office database table.
 * 
 */
@Entity
@Table(name="c_office")
@NamedQuery(name="COffice.findAll", query="SELECT c FROM COffice c")
public class COffice implements Serializable {
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

	@Column(name="office_id")
	private Integer officeId;

	@Column(name="short_identifier")
	private String shortIdentifier;

	private Long trace;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to CBranch
	@ManyToOne
	@JoinColumn(name="c_branch_id")
	private CBranch CBranch;

	//bi-directional many-to-one association to CTrafficCode
	@OneToMany(mappedBy="COffice")
	private List<CTrafficCode> CTrafficCodes;

	//bi-directional many-to-one association to ScBranchCentre
	@OneToMany(mappedBy="COffice")
	private List<ScBranchCentre> scBranchCentres;

	public COffice() {
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

	public Integer getOfficeId() {
		return this.officeId;
	}

	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
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

	public CBranch getCBranch() {
		return this.CBranch;
	}

	public void setCBranch(CBranch CBranch) {
		this.CBranch = CBranch;
	}

	public List<CTrafficCode> getCTrafficCodes() {
		return this.CTrafficCodes;
	}

	public void setCTrafficCodes(List<CTrafficCode> CTrafficCodes) {
		this.CTrafficCodes = CTrafficCodes;
	}

	public CTrafficCode addCTrafficCode(CTrafficCode CTrafficCode) {
		getCTrafficCodes().add(CTrafficCode);
		CTrafficCode.setCOffice(this);

		return CTrafficCode;
	}

	public CTrafficCode removeCTrafficCode(CTrafficCode CTrafficCode) {
		getCTrafficCodes().remove(CTrafficCode);
		CTrafficCode.setCOffice(null);

		return CTrafficCode;
	}

	public List<ScBranchCentre> getScBranchCentres() {
		return this.scBranchCentres;
	}

	public void setScBranchCentres(List<ScBranchCentre> scBranchCentres) {
		this.scBranchCentres = scBranchCentres;
	}

	public ScBranchCentre addScBranchCentre(ScBranchCentre scBranchCentre) {
		getScBranchCentres().add(scBranchCentre);
		scBranchCentre.setCOffice(this);

		return scBranchCentre;
	}

	public ScBranchCentre removeScBranchCentre(ScBranchCentre scBranchCentre) {
		getScBranchCentres().remove(scBranchCentre);
		scBranchCentre.setCOffice(null);

		return scBranchCentre;
	}

}