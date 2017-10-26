package br.com.urbanape.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the RECHARGEINFOSTAFFS database table.
 * 
 */
@Entity
@Table(name="RECHARGEINFOSTAFFS")
@NamedQuery(name="Rechargeinfostaff.findAll", query="SELECT r FROM Rechargeinfostaff r")
public class Rechargeinfostaff implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RechargeinfostaffPK id;

	@Column(name="DT_ID")
	private BigDecimal dtId;

	@Column(name="DT_ID2")
	private BigDecimal dtId2;

	@Column(name="FG_ID")
	private BigDecimal fgId;

	@Column(name="PRV_ID")
	private BigDecimal prvId;

	@Column(name="PRVGRP_SEQNBR")
	private BigDecimal prvgrpSeqnbr;

	@Column(name="RISTF_ADDCOMP")
	private String ristfAddcomp;

	@Column(name="RISTF_ADDNBR")
	private String ristfAddnbr;

	@Column(name="RISTF_ADDRESS")
	private String ristfAddress;

	@Temporal(TemporalType.DATE)
	@Column(name="RISTF_BIRTHDATE")
	private Date ristfBirthdate;

	@Column(name="RISTF_CITY")
	private String ristfCity;

	@Column(name="RISTF_DISTRICT")
	private String ristfDistrict;

	@Column(name="RISTF_DOCNBR")
	private String ristfDocnbr;

	@Column(name="RISTF_DOCNBR2")
	private String ristfDocnbr2;

	@Column(name="RISTF_EMAIL")
	private String ristfEmail;

	@Column(name="RISTF_GENDER")
	private String ristfGender;

	@Column(name="RISTF_HRID")
	private String ristfHrid;

	@Column(name="RISTF_NAME")
	private String ristfName;

	@Column(name="RISTF_NAMEMOTHER")
	private String ristfNamemother;

	@Column(name="RISTF_QTDPERDAY")
	private BigDecimal ristfQtdperday;

	@Temporal(TemporalType.DATE)
	@Column(name="RISTF_REGDATE")
	private Date ristfRegdate;

	@Column(name="RISTF_REGUSER")
	private String ristfReguser;

	@Column(name="RISTF_ST_CODE")
	private String ristfStCode;

	@Column(name="RISTF_STATUS")
	private String ristfStatus;

	@Column(name="RISTF_STATUSGENERATIONCARD")
	private String ristfStatusgenerationcard;

	@Column(name="RISTF_TEL_AREACODE")
	private String ristfTelAreacode;

	@Column(name="RISTF_TEL_NUMBER")
	private String ristfTelNumber;

	@Column(name="RISTF_ZIP")
	private String ristfZip;

	@Column(name="SC_ID")
	private BigDecimal scId;

	//bi-directional many-to-one association to Rechargeinfo
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="RI_ID",  insertable=false, updatable=false)
	private Rechargeinfo rechargeinfo;

	public Rechargeinfostaff() {
	}

	public RechargeinfostaffPK getId() {
		return this.id;
	}

	public void setId(RechargeinfostaffPK id) {
		this.id = id;
	}

	public BigDecimal getDtId() {
		return this.dtId;
	}

	public void setDtId(BigDecimal dtId) {
		this.dtId = dtId;
	}

	public BigDecimal getDtId2() {
		return this.dtId2;
	}

	public void setDtId2(BigDecimal dtId2) {
		this.dtId2 = dtId2;
	}

	public BigDecimal getFgId() {
		return this.fgId;
	}

	public void setFgId(BigDecimal fgId) {
		this.fgId = fgId;
	}

	public BigDecimal getPrvId() {
		return this.prvId;
	}

	public void setPrvId(BigDecimal prvId) {
		this.prvId = prvId;
	}

	public BigDecimal getPrvgrpSeqnbr() {
		return this.prvgrpSeqnbr;
	}

	public void setPrvgrpSeqnbr(BigDecimal prvgrpSeqnbr) {
		this.prvgrpSeqnbr = prvgrpSeqnbr;
	}

	public String getRistfAddcomp() {
		return this.ristfAddcomp;
	}

	public void setRistfAddcomp(String ristfAddcomp) {
		this.ristfAddcomp = ristfAddcomp;
	}

	public String getRistfAddnbr() {
		return this.ristfAddnbr;
	}

	public void setRistfAddnbr(String ristfAddnbr) {
		this.ristfAddnbr = ristfAddnbr;
	}

	public String getRistfAddress() {
		return this.ristfAddress;
	}

	public void setRistfAddress(String ristfAddress) {
		this.ristfAddress = ristfAddress;
	}

	public Date getRistfBirthdate() {
		return this.ristfBirthdate;
	}

	public void setRistfBirthdate(Date ristfBirthdate) {
		this.ristfBirthdate = ristfBirthdate;
	}

	public String getRistfCity() {
		return this.ristfCity;
	}

	public void setRistfCity(String ristfCity) {
		this.ristfCity = ristfCity;
	}

	public String getRistfDistrict() {
		return this.ristfDistrict;
	}

	public void setRistfDistrict(String ristfDistrict) {
		this.ristfDistrict = ristfDistrict;
	}

	public String getRistfDocnbr() {
		return this.ristfDocnbr;
	}

	public void setRistfDocnbr(String ristfDocnbr) {
		this.ristfDocnbr = ristfDocnbr;
	}

	public String getRistfDocnbr2() {
		return this.ristfDocnbr2;
	}

	public void setRistfDocnbr2(String ristfDocnbr2) {
		this.ristfDocnbr2 = ristfDocnbr2;
	}

	public String getRistfEmail() {
		return this.ristfEmail;
	}

	public void setRistfEmail(String ristfEmail) {
		this.ristfEmail = ristfEmail;
	}

	public String getRistfGender() {
		return this.ristfGender;
	}

	public void setRistfGender(String ristfGender) {
		this.ristfGender = ristfGender;
	}

	public String getRistfHrid() {
		return this.ristfHrid;
	}

	public void setRistfHrid(String ristfHrid) {
		this.ristfHrid = ristfHrid;
	}

	public String getRistfName() {
		return this.ristfName;
	}

	public void setRistfName(String ristfName) {
		this.ristfName = ristfName;
	}

	public String getRistfNamemother() {
		return this.ristfNamemother;
	}

	public void setRistfNamemother(String ristfNamemother) {
		this.ristfNamemother = ristfNamemother;
	}

	public BigDecimal getRistfQtdperday() {
		return this.ristfQtdperday;
	}

	public void setRistfQtdperday(BigDecimal ristfQtdperday) {
		this.ristfQtdperday = ristfQtdperday;
	}

	public Date getRistfRegdate() {
		return this.ristfRegdate;
	}

	public void setRistfRegdate(Date ristfRegdate) {
		this.ristfRegdate = ristfRegdate;
	}

	public String getRistfReguser() {
		return this.ristfReguser;
	}

	public void setRistfReguser(String ristfReguser) {
		this.ristfReguser = ristfReguser;
	}

	public String getRistfStCode() {
		return this.ristfStCode;
	}

	public void setRistfStCode(String ristfStCode) {
		this.ristfStCode = ristfStCode;
	}

	public String getRistfStatus() {
		return this.ristfStatus;
	}

	public void setRistfStatus(String ristfStatus) {
		this.ristfStatus = ristfStatus;
	}

	public String getRistfStatusgenerationcard() {
		return this.ristfStatusgenerationcard;
	}

	public void setRistfStatusgenerationcard(String ristfStatusgenerationcard) {
		this.ristfStatusgenerationcard = ristfStatusgenerationcard;
	}

	public String getRistfTelAreacode() {
		return this.ristfTelAreacode;
	}

	public void setRistfTelAreacode(String ristfTelAreacode) {
		this.ristfTelAreacode = ristfTelAreacode;
	}

	public String getRistfTelNumber() {
		return this.ristfTelNumber;
	}

	public void setRistfTelNumber(String ristfTelNumber) {
		this.ristfTelNumber = ristfTelNumber;
	}

	public String getRistfZip() {
		return this.ristfZip;
	}

	public void setRistfZip(String ristfZip) {
		this.ristfZip = ristfZip;
	}

	public BigDecimal getScId() {
		return this.scId;
	}

	public void setScId(BigDecimal scId) {
		this.scId = scId;
	}

	public Rechargeinfo getRechargeinfo() {
		return this.rechargeinfo;
	}

	public void setRechargeinfo(Rechargeinfo rechargeinfo) {
		this.rechargeinfo = rechargeinfo;
	}

	@Override
	public String toString() {
		return "Rechargeinfostaff [id=" + id + ", dtId=" + dtId + ", dtId2=" + dtId2 + ", fgId=" + fgId + ", prvId="
				+ prvId + ", prvgrpSeqnbr=" + prvgrpSeqnbr + ", ristfAddcomp=" + ristfAddcomp + ", ristfAddnbr="
				+ ristfAddnbr + ", ristfAddress=" + ristfAddress + ", ristfBirthdate=" + ristfBirthdate + ", ristfCity="
				+ ristfCity + ", ristfDistrict=" + ristfDistrict + ", ristfDocnbr=" + ristfDocnbr + ", ristfDocnbr2="
				+ ristfDocnbr2 + ", ristfEmail=" + ristfEmail + ", ristfGender=" + ristfGender + ", ristfHrid="
				+ ristfHrid + ", ristfName=" + ristfName + ", ristfNamemother=" + ristfNamemother + ", ristfQtdperday="
				+ ristfQtdperday + ", ristfRegdate=" + ristfRegdate + ", ristfReguser=" + ristfReguser
				+ ", ristfStCode=" + ristfStCode + ", ristfStatus=" + ristfStatus + ", ristfStatusgenerationcard="
				+ ristfStatusgenerationcard + ", ristfTelAreacode=" + ristfTelAreacode + ", ristfTelNumber="
				+ ristfTelNumber + ", ristfZip=" + ristfZip + ", scId=" + scId + ", rechargeinfo=" + rechargeinfo + "]";
	}
	
	

}