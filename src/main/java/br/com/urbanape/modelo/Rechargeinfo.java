package br.com.urbanape.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the RECHARGEINFO database table.
 * 
 */
@Entity
@NamedQuery(name="Rechargeinfo.findAll", query="SELECT r FROM Rechargeinfo r")
public class Rechargeinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RI_ID")
	private long riId;

	@Column(name="CD_ID")
	private BigDecimal cdId;

	@Column(name="CTE_ID")
	private BigDecimal cteId;

	@Column(name="PRV_ID")
	private BigDecimal prvId;

	@Column(name="PRV_ID_POSTDELIVERY")
	private BigDecimal prvIdPostdelivery;

	@Column(name="RDT_ID")
	private BigDecimal rdtId;

	@Column(name="RI_CARDTYPE")
	private BigDecimal riCardtype;

	@Column(name="RI_EXTERNALCRDINTSNR")
	private BigDecimal riExternalcrdintsnr;

	@Column(name="RI_EXTERNALPRODUCTID")
	private BigDecimal riExternalproductid;

	@Column(name="RI_EXTERNALUSRID")
	private BigDecimal riExternalusrid;

	@Column(name="RI_QTYPERDAY")
	private BigDecimal riQtyperday;

	@Temporal(TemporalType.DATE)
	@Column(name="RI_REGDATE")
	private Date riRegdate;

	@Column(name="RI_REGUSER")
	private String riReguser;

	@Column(name="RI_STATUS")
	private String riStatus;

	@Column(name="RI_TEMP")
	private BigDecimal riTemp;

	@Column(name="USR_ID")
	private BigDecimal usrId;

	@Column(name="USRUT_SEQNBR")
	private BigDecimal usrutSeqnbr;

	@Column(name="UT_ID")
	private BigDecimal utId;

	//bi-directional many-to-one association to Rechargeinfostaff
	@OneToMany(mappedBy="rechargeinfo", fetch=FetchType.EAGER)
	private List<Rechargeinfostaff> rechargeinfostaffs;

	public Rechargeinfo() {
	}

	public long getRiId() {
		return this.riId;
	}

	public void setRiId(long riId) {
		this.riId = riId;
	}

	public BigDecimal getCdId() {
		return this.cdId;
	}

	public void setCdId(BigDecimal cdId) {
		this.cdId = cdId;
	}

	public BigDecimal getCteId() {
		return this.cteId;
	}

	public void setCteId(BigDecimal cteId) {
		this.cteId = cteId;
	}

	public BigDecimal getPrvId() {
		return this.prvId;
	}

	public void setPrvId(BigDecimal prvId) {
		this.prvId = prvId;
	}

	public BigDecimal getPrvIdPostdelivery() {
		return this.prvIdPostdelivery;
	}

	public void setPrvIdPostdelivery(BigDecimal prvIdPostdelivery) {
		this.prvIdPostdelivery = prvIdPostdelivery;
	}

	public BigDecimal getRdtId() {
		return this.rdtId;
	}

	public void setRdtId(BigDecimal rdtId) {
		this.rdtId = rdtId;
	}

	public BigDecimal getRiCardtype() {
		return this.riCardtype;
	}

	public void setRiCardtype(BigDecimal riCardtype) {
		this.riCardtype = riCardtype;
	}

	public BigDecimal getRiExternalcrdintsnr() {
		return this.riExternalcrdintsnr;
	}

	public void setRiExternalcrdintsnr(BigDecimal riExternalcrdintsnr) {
		this.riExternalcrdintsnr = riExternalcrdintsnr;
	}

	public BigDecimal getRiExternalproductid() {
		return this.riExternalproductid;
	}

	public void setRiExternalproductid(BigDecimal riExternalproductid) {
		this.riExternalproductid = riExternalproductid;
	}

	public BigDecimal getRiExternalusrid() {
		return this.riExternalusrid;
	}

	public void setRiExternalusrid(BigDecimal riExternalusrid) {
		this.riExternalusrid = riExternalusrid;
	}

	public BigDecimal getRiQtyperday() {
		return this.riQtyperday;
	}

	public void setRiQtyperday(BigDecimal riQtyperday) {
		this.riQtyperday = riQtyperday;
	}

	public Date getRiRegdate() {
		return this.riRegdate;
	}

	public void setRiRegdate(Date riRegdate) {
		this.riRegdate = riRegdate;
	}

	public String getRiReguser() {
		return this.riReguser;
	}

	public void setRiReguser(String riReguser) {
		this.riReguser = riReguser;
	}

	public String getRiStatus() {
		return this.riStatus;
	}

	public void setRiStatus(String riStatus) {
		this.riStatus = riStatus;
	}

	public BigDecimal getRiTemp() {
		return this.riTemp;
	}

	public void setRiTemp(BigDecimal riTemp) {
		this.riTemp = riTemp;
	}

	public BigDecimal getUsrId() {
		return this.usrId;
	}

	public void setUsrId(BigDecimal usrId) {
		this.usrId = usrId;
	}

	public BigDecimal getUsrutSeqnbr() {
		return this.usrutSeqnbr;
	}

	public void setUsrutSeqnbr(BigDecimal usrutSeqnbr) {
		this.usrutSeqnbr = usrutSeqnbr;
	}

	public BigDecimal getUtId() {
		return this.utId;
	}

	public void setUtId(BigDecimal utId) {
		this.utId = utId;
	}

	public List<Rechargeinfostaff> getRechargeinfostaffs() {
		return this.rechargeinfostaffs;
	}

	public void setRechargeinfostaffs(List<Rechargeinfostaff> rechargeinfostaffs) {
		this.rechargeinfostaffs = rechargeinfostaffs;
	}

	public Rechargeinfostaff addRechargeinfostaff(Rechargeinfostaff rechargeinfostaff) {
		getRechargeinfostaffs().add(rechargeinfostaff);
		rechargeinfostaff.setRechargeinfo(this);

		return rechargeinfostaff;
	}

	public Rechargeinfostaff removeRechargeinfostaff(Rechargeinfostaff rechargeinfostaff) {
		getRechargeinfostaffs().remove(rechargeinfostaff);
		rechargeinfostaff.setRechargeinfo(null);

		return rechargeinfostaff;
	}

}