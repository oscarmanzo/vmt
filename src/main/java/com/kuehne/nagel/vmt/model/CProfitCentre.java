package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the c_profit_centre database table.
 * 
 */
@Entity
@Table(name="c_profit_centre")
@NamedQuery(name="CProfitCentre.findAll", query="SELECT c FROM CProfitCentre c")
public class CProfitCentre implements Serializable {
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

	@Column(name="profit_cost_flag")
	private Integer profitCostFlag;

	@Column(name="short_identifier")
	private String shortIdentifier;

	private Long trace;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to CDepartment
	@ManyToOne
	@JoinColumn(name="c_department_id")
	private CDepartment CDepartment;

	//bi-directional many-to-one association to CTrafficCode
	@OneToMany(mappedBy="CProfitCentre")
	private List<CTrafficCode> CTrafficCodes;

	//bi-directional many-to-one association to ScBranchCentre
	@OneToMany(mappedBy="CProfitCentre")
	private List<ScBranchCentre> scBranchCentres;

	public CProfitCentre() {
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

	public Integer getProfitCostFlag() {
		return this.profitCostFlag;
	}

	public void setProfitCostFlag(Integer profitCostFlag) {
		this.profitCostFlag = profitCostFlag;
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

	public CDepartment getCDepartment() {
		return this.CDepartment;
	}

	public void setCDepartment(CDepartment CDepartment) {
		this.CDepartment = CDepartment;
	}

	public List<CTrafficCode> getCTrafficCodes() {
		return this.CTrafficCodes;
	}

	public void setCTrafficCodes(List<CTrafficCode> CTrafficCodes) {
		this.CTrafficCodes = CTrafficCodes;
	}

	public CTrafficCode addCTrafficCode(CTrafficCode CTrafficCode) {
		getCTrafficCodes().add(CTrafficCode);
		CTrafficCode.setCProfitCentre(this);

		return CTrafficCode;
	}

	public CTrafficCode removeCTrafficCode(CTrafficCode CTrafficCode) {
		getCTrafficCodes().remove(CTrafficCode);
		CTrafficCode.setCProfitCentre(null);

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
		scBranchCentre.setCProfitCentre(this);

		return scBranchCentre;
	}

	public ScBranchCentre removeScBranchCentre(ScBranchCentre scBranchCentre) {
		getScBranchCentres().remove(scBranchCentre);
		scBranchCentre.setCProfitCentre(null);

		return scBranchCentre;
	}

}