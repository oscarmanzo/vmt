package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the sc_headcount database table.
 * 
 */
@Entity
@Table(name="sc_headcount")
@NamedQuery(name="ScHeadcount.findAll", query="SELECT s FROM ScHeadcount s")
public class ScHeadcount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean active;

	private Boolean blocked;

	@Column(name="create_user")
	private String createUser;

	private Timestamp created;

	@Column(name="employee_id")
	private Integer employeeId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	private Timestamp modified;

	@Column(name="mothers_last_name")
	private String mothersLastName;

	private Long trace;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to CUser
	@OneToMany(mappedBy="scHeadcount")
	private List<CUser> CUsers;

	//bi-directional many-to-one association to RtHeadcountCompanyRole
	@OneToMany(mappedBy="scHeadcount")
	private List<RtHeadcountCompanyRole> rtHeadcountCompanyRoles;

	//bi-directional many-to-one association to CJobPosition
	@ManyToOne
	@JoinColumn(name="c_job_position_id")
	private CJobPosition CJobPosition;

	//bi-directional many-to-one association to CKnCode
	@ManyToOne
	@JoinColumn(name="c_kn_code_id")
	private CKnCode CKnCode;

	//bi-directional many-to-one association to ScBranchCentre
	@ManyToOne
	@JoinColumn(name="sc_branch_centre_id")
	private ScBranchCentre scBranchCentre;

	//bi-directional many-to-one association to ScHeadcount
	@ManyToOne
	@JoinColumn(name="boss_id")
	private ScHeadcount scHeadcount;

	//bi-directional many-to-one association to ScHeadcount
	@OneToMany(mappedBy="scHeadcount")
	private List<ScHeadcount> scHeadcounts;

	public ScHeadcount() {
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

	public Boolean getBlocked() {
		return this.blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
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

	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public String getMothersLastName() {
		return this.mothersLastName;
	}

	public void setMothersLastName(String mothersLastName) {
		this.mothersLastName = mothersLastName;
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

	public List<CUser> getCUsers() {
		return this.CUsers;
	}

	public void setCUsers(List<CUser> CUsers) {
		this.CUsers = CUsers;
	}

	public CUser addCUser(CUser CUser) {
		getCUsers().add(CUser);
		CUser.setScHeadcount(this);

		return CUser;
	}

	public CUser removeCUser(CUser CUser) {
		getCUsers().remove(CUser);
		CUser.setScHeadcount(null);

		return CUser;
	}

	public List<RtHeadcountCompanyRole> getRtHeadcountCompanyRoles() {
		return this.rtHeadcountCompanyRoles;
	}

	public void setRtHeadcountCompanyRoles(List<RtHeadcountCompanyRole> rtHeadcountCompanyRoles) {
		this.rtHeadcountCompanyRoles = rtHeadcountCompanyRoles;
	}

	public RtHeadcountCompanyRole addRtHeadcountCompanyRole(RtHeadcountCompanyRole rtHeadcountCompanyRole) {
		getRtHeadcountCompanyRoles().add(rtHeadcountCompanyRole);
		rtHeadcountCompanyRole.setScHeadcount(this);

		return rtHeadcountCompanyRole;
	}

	public RtHeadcountCompanyRole removeRtHeadcountCompanyRole(RtHeadcountCompanyRole rtHeadcountCompanyRole) {
		getRtHeadcountCompanyRoles().remove(rtHeadcountCompanyRole);
		rtHeadcountCompanyRole.setScHeadcount(null);

		return rtHeadcountCompanyRole;
	}

	public CJobPosition getCJobPosition() {
		return this.CJobPosition;
	}

	public void setCJobPosition(CJobPosition CJobPosition) {
		this.CJobPosition = CJobPosition;
	}

	public CKnCode getCKnCode() {
		return this.CKnCode;
	}

	public void setCKnCode(CKnCode CKnCode) {
		this.CKnCode = CKnCode;
	}

	public ScBranchCentre getScBranchCentre() {
		return this.scBranchCentre;
	}

	public void setScBranchCentre(ScBranchCentre scBranchCentre) {
		this.scBranchCentre = scBranchCentre;
	}

	public ScHeadcount getScHeadcount() {
		return this.scHeadcount;
	}

	public void setScHeadcount(ScHeadcount scHeadcount) {
		this.scHeadcount = scHeadcount;
	}

	public List<ScHeadcount> getScHeadcounts() {
		return this.scHeadcounts;
	}

	public void setScHeadcounts(List<ScHeadcount> scHeadcounts) {
		this.scHeadcounts = scHeadcounts;
	}

	public ScHeadcount addScHeadcount(ScHeadcount scHeadcount) {
		getScHeadcounts().add(scHeadcount);
		scHeadcount.setScHeadcount(this);

		return scHeadcount;
	}

	public ScHeadcount removeScHeadcount(ScHeadcount scHeadcount) {
		getScHeadcounts().remove(scHeadcount);
		scHeadcount.setScHeadcount(null);

		return scHeadcount;
	}

}