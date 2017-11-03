package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the c_user database table.
 * 
 */
@Entity
@Table(name="c_user")
@NamedQuery(name="CUser.findAll", query="SELECT c FROM CUser c")
public class CUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean active;

	@Column(name="create_user")
	private String createUser;

	private Timestamp created;

	@Column(name="hashed_pwd")
	private String hashedPwd;

	private Timestamp modified;

	private String password;

	private Long trace;

	@Column(name="update_user")
	private String updateUser;

	private String username;

	//bi-directional many-to-one association to ScHeadcount
	@ManyToOne
	@JoinColumn(name="sc_headcount_id")
	private ScHeadcount scHeadcount;

	//bi-directional many-to-one association to RtUserSpecialPermission
	@OneToMany(mappedBy="CUser")
	private List<RtUserSpecialPermission> rtUserSpecialPermissions;

	//bi-directional many-to-one association to RtUserSystemRoleTemplate
	@OneToMany(mappedBy="CUser")
	private List<RtUserSystemRoleTemplate> rtUserSystemRoleTemplates;

	public CUser() {
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

	public String getHashedPwd() {
		return this.hashedPwd;
	}

	public void setHashedPwd(String hashedPwd) {
		this.hashedPwd = hashedPwd;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ScHeadcount getScHeadcount() {
		return this.scHeadcount;
	}

	public void setScHeadcount(ScHeadcount scHeadcount) {
		this.scHeadcount = scHeadcount;
	}

	public List<RtUserSpecialPermission> getRtUserSpecialPermissions() {
		return this.rtUserSpecialPermissions;
	}

	public void setRtUserSpecialPermissions(List<RtUserSpecialPermission> rtUserSpecialPermissions) {
		this.rtUserSpecialPermissions = rtUserSpecialPermissions;
	}

	public RtUserSpecialPermission addRtUserSpecialPermission(RtUserSpecialPermission rtUserSpecialPermission) {
		getRtUserSpecialPermissions().add(rtUserSpecialPermission);
		rtUserSpecialPermission.setCUser(this);

		return rtUserSpecialPermission;
	}

	public RtUserSpecialPermission removeRtUserSpecialPermission(RtUserSpecialPermission rtUserSpecialPermission) {
		getRtUserSpecialPermissions().remove(rtUserSpecialPermission);
		rtUserSpecialPermission.setCUser(null);

		return rtUserSpecialPermission;
	}

	public List<RtUserSystemRoleTemplate> getRtUserSystemRoleTemplates() {
		return this.rtUserSystemRoleTemplates;
	}

	public void setRtUserSystemRoleTemplates(List<RtUserSystemRoleTemplate> rtUserSystemRoleTemplates) {
		this.rtUserSystemRoleTemplates = rtUserSystemRoleTemplates;
	}

	public RtUserSystemRoleTemplate addRtUserSystemRoleTemplate(RtUserSystemRoleTemplate rtUserSystemRoleTemplate) {
		getRtUserSystemRoleTemplates().add(rtUserSystemRoleTemplate);
		rtUserSystemRoleTemplate.setCUser(this);

		return rtUserSystemRoleTemplate;
	}

	public RtUserSystemRoleTemplate removeRtUserSystemRoleTemplate(RtUserSystemRoleTemplate rtUserSystemRoleTemplate) {
		getRtUserSystemRoleTemplates().remove(rtUserSystemRoleTemplate);
		rtUserSystemRoleTemplate.setCUser(null);

		return rtUserSystemRoleTemplate;
	}

}