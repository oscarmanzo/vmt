package com.kuehne.nagel.vmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the c_traffic_codes database table.
 * 
 */
@Entity
@Table(name="c_traffic_codes")
@NamedQuery(name="CTrafficCode.findAll", query="SELECT c FROM CTrafficCode c")
public class CTrafficCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean active;

	@Column(name="create_user")
	private String createUser;

	private Timestamp created;

	private Timestamp modified;

	@Column(name="short_identifier")
	private String shortIdentifier;

	private Long trace;

	@Column(name="traffic_code")
	private Integer trafficCode;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to COffice
	@ManyToOne
	@JoinColumn(name="c_office_id")
	private COffice COffice;

	//bi-directional many-to-one association to CProfitCentre
	@ManyToOne
	@JoinColumn(name="c_profit_centre_id")
	private CProfitCentre CProfitCentre;

	public CTrafficCode() {
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

	public Integer getTrafficCode() {
		return this.trafficCode;
	}

	public void setTrafficCode(Integer trafficCode) {
		this.trafficCode = trafficCode;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public COffice getCOffice() {
		return this.COffice;
	}

	public void setCOffice(COffice COffice) {
		this.COffice = COffice;
	}

	public CProfitCentre getCProfitCentre() {
		return this.CProfitCentre;
	}

	public void setCProfitCentre(CProfitCentre CProfitCentre) {
		this.CProfitCentre = CProfitCentre;
	}

}