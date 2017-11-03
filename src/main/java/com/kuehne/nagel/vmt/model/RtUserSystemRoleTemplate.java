package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rt_user_system_role_template database table.
 * 
 */
@Entity
@Table(name="rt_user_system_role_template")
@NamedQuery(name="RtUserSystemRoleTemplate.findAll", query="SELECT r FROM RtUserSystemRoleTemplate r")
public class RtUserSystemRoleTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean active;

	@Column(name="create_user")
	private String createUser;

	private Timestamp created;

	private Timestamp modified;

	private Long trace;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to CSystemRoleTemplate
	@ManyToOne
	@JoinColumn(name="c_system_role_template_id")
	private CSystemRoleTemplate CSystemRoleTemplate;

	//bi-directional many-to-one association to CUser
	@ManyToOne
	@JoinColumn(name="c_user_id")
	private CUser CUser;

	public RtUserSystemRoleTemplate() {
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

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
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

	public CSystemRoleTemplate getCSystemRoleTemplate() {
		return this.CSystemRoleTemplate;
	}

	public void setCSystemRoleTemplate(CSystemRoleTemplate CSystemRoleTemplate) {
		this.CSystemRoleTemplate = CSystemRoleTemplate;
	}

	public CUser getCUser() {
		return this.CUser;
	}

	public void setCUser(CUser CUser) {
		this.CUser = CUser;
	}

}