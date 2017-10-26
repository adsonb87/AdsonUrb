package br.com.urbanape.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RECHARGEINFOSTAFFS database table.
 * 
 */
@Embeddable
public class RechargeinfostaffPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="RI_ID", insertable=false, updatable=false)
	private long riId;

	@Column(name="RISTF_ID")
	private long ristfId;

	public RechargeinfostaffPK() {
	}
	public long getRiId() {
		return this.riId;
	}
	public void setRiId(long riId) {
		this.riId = riId;
	}
	public long getRistfId() {
		return this.ristfId;
	}
	public void setRistfId(long ristfId) {
		this.ristfId = ristfId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RechargeinfostaffPK)) {
			return false;
		}
		RechargeinfostaffPK castOther = (RechargeinfostaffPK)other;
		return 
			(this.riId == castOther.riId)
			&& (this.ristfId == castOther.ristfId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.riId ^ (this.riId >>> 32)));
		hash = hash * prime + ((int) (this.ristfId ^ (this.ristfId >>> 32)));
		
		return hash;
	}
}