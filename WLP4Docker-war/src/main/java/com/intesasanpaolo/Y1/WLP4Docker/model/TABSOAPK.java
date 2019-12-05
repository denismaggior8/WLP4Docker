package com.intesasanpaolo.Y1.WLP4Docker.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TABSOA database table.
 * 
 */
@Embeddable
public class TABSOAPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_TABELLA")
	private String codTabella;

	@Column(name="CHIAVE_TABELLA")
	private String chiaveTabella;

	public TABSOAPK() {
	}
	public String getCodTabella() {
		return this.codTabella;
	}
	public void setCodTabella(String codTabella) {
		this.codTabella = codTabella;
	}
	public String getChiaveTabella() {
		return this.chiaveTabella;
	}
	public void setChiaveTabella(String chiaveTabella) {
		this.chiaveTabella = chiaveTabella;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TABSOAPK)) {
			return false;
		}
		TABSOAPK castOther = (TABSOAPK)other;
		return 
			this.codTabella.equals(castOther.codTabella)
			&& this.chiaveTabella.equals(castOther.chiaveTabella);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codTabella.hashCode();
		hash = hash * prime + this.chiaveTabella.hashCode();
		
		return hash;
	}
}