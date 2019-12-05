package com.intesasanpaolo.Y1.WLP4Docker.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TABSOA database table.
 * 
 */
@Entity
@Table(name="TABSOA",schema="ANQO")
public class TABSOA implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TABSOAPK id;

	@Column(name="AREA_DATI")
	private String areaDati;

	public TABSOA() {
	}

	public TABSOAPK getId() {
		return this.id;
	}

	public void setId(TABSOAPK id) {
		this.id = id;
	}

	public String getAreaDati() {
		return this.areaDati;
	}

	public void setAreaDati(String areaDati) {
		this.areaDati = areaDati;
	}

}