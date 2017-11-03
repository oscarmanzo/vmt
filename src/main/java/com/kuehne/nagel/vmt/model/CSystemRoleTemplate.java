package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the c_system_role_template database table.
 * 
 */
@Entity
@Table(name="c_system_role_template")
@NamedQuery(name="CSystemRoleTemplate.findAll", query="SELECT c FROM CSystemRoleTemplate c")
public class CSystemRoleTemplate implements Serializable {
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

	//bi-directional many-to-one association to RtRoleTemplatePermission
	@OneToMany(mappedBy="CSystemRoleTemplate")
	private List<RtRoleTemplatePermission> rtRoleTemplatePermissions;

	//bi-directional many-to-one association to RtUserSystemRoleTemplate
	@OneToMany(mappedBy="CSystemRoleTemplate")
	private List<RtUserSystemRoleTemplate> rtUserSystemRoleTemplates;

	public CSystemRoleTemplate() {
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

	public List<RtRoleTemplatePermission> getRtRoleTemplatePermissions() {
		return this.rtRoleTemplatePermissions;
	}

	public void setRtRoleTemplatePermissions(List<RtRoleTemplatePermission> rtRoleTemplatePermissions) {
		this.rtRoleTemplatePermissions = rtRoleTemplatePermissions;
	}

	public RtRoleTemplatePermission addRtRoleTemplatePermission(RtRoleTemplatePermission rtRoleTemplatePermission) {
		getRtRoleTemplatePermissions().add(rtRoleTemplatePermission);
		rtRoleTemplatePermission.setCSystemRoleTemplate(this);

		return rtRoleTemplatePermission;
	}

	public RtRoleTemplatePermission removeRtRoleTemplatePermission(RtRoleTemplatePermission rtRoleTemplatePermission) {
		getRtRoleTemplatePermissions().remove(rtRoleTemplatePermission);
		rtRoleTemplatePermission.setCSystemRoleTemplate(null);

		return rtRoleTemplatePermission;
	}

	public List<RtUserSystemRoleTemplate> getRtUserSystemRoleTemplates() {
		return this.rtUserSystemRoleTemplates;
	}

	public void setRtUserSystemRoleTemplates(List<RtUserSystemRoleTemplate> rtUserSystemRoleTemplates) {
		this.rtUserSystemRoleTemplates = rtUserSystemRoleTemplates;
	}

	public RtUserSystemRoleTemplate addRtUserSystemRoleTemplate(RtUserSystemRoleTemplate rtUserSystemRoleTemplate) {
		getRtUserSystemRoleTemplates().add(rtUserSystemRoleTemplate);
		rtUserSystemRoleTemplate.setCSystemRoleTemplate(this);

		return rtUserSystemRoleTemplate;
	}

	public RtUserSystemRoleTemplate removeRtUserSystemRoleTemplate(RtUserSystemRoleTemplate rtUserSystemRoleTemplate) {
		getRtUserSystemRoleTemplates().remove(rtUserSystemRoleTemplate);
		rtUserSystemRoleTemplate.setCSystemRoleTemplate(null);

		return rtUserSystemRoleTemplate;
	}

}