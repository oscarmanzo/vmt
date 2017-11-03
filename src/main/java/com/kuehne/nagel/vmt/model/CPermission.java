package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the c_permission database table.
 * 
 */
@Entity
@Table(name="c_permission")
@NamedQuery(name="CPermission.findAll", query="SELECT c FROM CPermission c")
public class CPermission implements Serializable {
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

	private Long trace;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to CSystemModule
	@ManyToOne
	@JoinColumn(name="c_system_module_id")
	private CSystemModule CSystemModule;

	//bi-directional many-to-one association to RtRoleTemplatePermission
	@OneToMany(mappedBy="CPermission")
	private List<RtRoleTemplatePermission> rtRoleTemplatePermissions;

	//bi-directional many-to-one association to RtUserSpecialPermission
	@OneToMany(mappedBy="CPermission")
	private List<RtUserSpecialPermission> rtUserSpecialPermissions;

	public CPermission() {
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

	public CSystemModule getCSystemModule() {
		return this.CSystemModule;
	}

	public void setCSystemModule(CSystemModule CSystemModule) {
		this.CSystemModule = CSystemModule;
	}

	public List<RtRoleTemplatePermission> getRtRoleTemplatePermissions() {
		return this.rtRoleTemplatePermissions;
	}

	public void setRtRoleTemplatePermissions(List<RtRoleTemplatePermission> rtRoleTemplatePermissions) {
		this.rtRoleTemplatePermissions = rtRoleTemplatePermissions;
	}

	public RtRoleTemplatePermission addRtRoleTemplatePermission(RtRoleTemplatePermission rtRoleTemplatePermission) {
		getRtRoleTemplatePermissions().add(rtRoleTemplatePermission);
		rtRoleTemplatePermission.setCPermission(this);

		return rtRoleTemplatePermission;
	}

	public RtRoleTemplatePermission removeRtRoleTemplatePermission(RtRoleTemplatePermission rtRoleTemplatePermission) {
		getRtRoleTemplatePermissions().remove(rtRoleTemplatePermission);
		rtRoleTemplatePermission.setCPermission(null);

		return rtRoleTemplatePermission;
	}

	public List<RtUserSpecialPermission> getRtUserSpecialPermissions() {
		return this.rtUserSpecialPermissions;
	}

	public void setRtUserSpecialPermissions(List<RtUserSpecialPermission> rtUserSpecialPermissions) {
		this.rtUserSpecialPermissions = rtUserSpecialPermissions;
	}

	public RtUserSpecialPermission addRtUserSpecialPermission(RtUserSpecialPermission rtUserSpecialPermission) {
		getRtUserSpecialPermissions().add(rtUserSpecialPermission);
		rtUserSpecialPermission.setCPermission(this);

		return rtUserSpecialPermission;
	}

	public RtUserSpecialPermission removeRtUserSpecialPermission(RtUserSpecialPermission rtUserSpecialPermission) {
		getRtUserSpecialPermissions().remove(rtUserSpecialPermission);
		rtUserSpecialPermission.setCPermission(null);

		return rtUserSpecialPermission;
	}

}