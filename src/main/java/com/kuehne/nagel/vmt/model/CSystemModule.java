package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the c_system_module database table.
 * 
 */
@Entity
@Table(name="c_system_module")
@NamedQuery(name="CSystemModule.findAll", query="SELECT c FROM CSystemModule c")
public class CSystemModule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="action_url")
	private String actionUrl;

	private Boolean active;

	@Column(name="create_user")
	private String createUser;

	private Timestamp created;

	private String description;

	@Column(name="hover_string")
	private String hoverString;

	@Column(name="icon_name")
	private String iconName;

	private Timestamp modified;

	private String name;

	@Column(name="shown_name")
	private String shownName;

	private Long trace;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to CPermission
	@OneToMany(mappedBy="CSystemModule")
	private List<CPermission> CPermissions;

	//bi-directional many-to-one association to CSystemModule
	@ManyToOne
	@JoinColumn(name="c_system_module_parent_id")
	private CSystemModule CSystemModule;

	//bi-directional many-to-one association to CSystemModule
	@OneToMany(mappedBy="CSystemModule")
	private List<CSystemModule> CSystemModules;

	//bi-directional many-to-one association to CSystemParameter
	@OneToMany(mappedBy="CSystemModule")
	private List<CSystemParameter> CSystemParameters;

	public CSystemModule() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionUrl() {
		return this.actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
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

	public String getHoverString() {
		return this.hoverString;
	}

	public void setHoverString(String hoverString) {
		this.hoverString = hoverString;
	}

	public String getIconName() {
		return this.iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
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

	public String getShownName() {
		return this.shownName;
	}

	public void setShownName(String shownName) {
		this.shownName = shownName;
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

	public List<CPermission> getCPermissions() {
		return this.CPermissions;
	}

	public void setCPermissions(List<CPermission> CPermissions) {
		this.CPermissions = CPermissions;
	}

	public CPermission addCPermission(CPermission CPermission) {
		getCPermissions().add(CPermission);
		CPermission.setCSystemModule(this);

		return CPermission;
	}

	public CPermission removeCPermission(CPermission CPermission) {
		getCPermissions().remove(CPermission);
		CPermission.setCSystemModule(null);

		return CPermission;
	}

	public CSystemModule getCSystemModule() {
		return this.CSystemModule;
	}

	public void setCSystemModule(CSystemModule CSystemModule) {
		this.CSystemModule = CSystemModule;
	}

	public List<CSystemModule> getCSystemModules() {
		return this.CSystemModules;
	}

	public void setCSystemModules(List<CSystemModule> CSystemModules) {
		this.CSystemModules = CSystemModules;
	}

	public CSystemModule addCSystemModule(CSystemModule CSystemModule) {
		getCSystemModules().add(CSystemModule);
		CSystemModule.setCSystemModule(this);

		return CSystemModule;
	}

	public CSystemModule removeCSystemModule(CSystemModule CSystemModule) {
		getCSystemModules().remove(CSystemModule);
		CSystemModule.setCSystemModule(null);

		return CSystemModule;
	}

	public List<CSystemParameter> getCSystemParameters() {
		return this.CSystemParameters;
	}

	public void setCSystemParameters(List<CSystemParameter> CSystemParameters) {
		this.CSystemParameters = CSystemParameters;
	}

	public CSystemParameter addCSystemParameter(CSystemParameter CSystemParameter) {
		getCSystemParameters().add(CSystemParameter);
		CSystemParameter.setCSystemModule(this);

		return CSystemParameter;
	}

	public CSystemParameter removeCSystemParameter(CSystemParameter CSystemParameter) {
		getCSystemParameters().remove(CSystemParameter);
		CSystemParameter.setCSystemModule(null);

		return CSystemParameter;
	}

}