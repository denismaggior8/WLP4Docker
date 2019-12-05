package com.intesasanpaolo.Y1.WLP4Docker.control;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.intesasanpaolo.Y1.WLP4Docker.model.TABSOA;



public class CL_dao {
	public Logger pLog;

	protected EntityManager pEntityManager;
//	protected iJ2DB pJ2DB;

	@PostConstruct
	public void init() {
		pLog = Logger.getLogger(getClass().getPackage().getName());
	}

	public CL_dao() {
		init();
	}

	public void setEntityManager(EntityManager aEM) {
		pEntityManager = aEM;
	}

//	public EntityManager getEntityManager(String codAbi, String Acronimo, String Operation, String Persistence) {
//		EntityManager em = null;
//
//		try {
////			em = this.pJ2DB.getEntityManager(codAbi, Acronimo, Operation, Persistence);
//
//		} catch (Y1Exception e) {
//			e.printStackTrace();
//		}
//		return em;
//
//	}

//	public void setJ2DB(iJ2DB pJ2DB) {
//		this.pJ2DB = pJ2DB;
//	}

	public TABSOA queryQODB262(String aCOD_TABELLA, String aCHIAVE_TABELLA) {

		List<TABSOA> _rowList = null;

		try {
			// Query query = _EntityManager.createNativeQuery("SELECT * FROM "
			// + CONTRATTO_CCC_A1 + " where " + "COD_AZIENDA = ?1 and "
			// + "ID_CLIENTE= ?2 ");
			// Query query = pEntityManager
			// .createNativeQuery("select * from ANQO.TABSOA where
			// ANQO.TABSOA.COD_TABELLA='V_SOA_AB_CLASSE' and
			// ANQO.TABSOA.CHIAVE_TABELLA='01KW 01ATRE OC'")
			// ;

			Query query = pEntityManager.createQuery(
					"SELECT t from  TABSOA as t where t.id.codTabella= ?1 AND t.id.chiaveTabella = ?2", TABSOA.class);
			// query.setLockMode(LockModeType.NONE);
			query.setParameter(1, aCOD_TABELLA);
			query.setParameter(2, aCHIAVE_TABELLA);

			_rowList = query.getResultList();

		} catch (Exception e) {
			pLog.fatal(e);
			return null;
		} finally {
		}

		if (_rowList.size() == 0) {
			return null;
		} else {
			return _rowList.get(0);
		}

	}

	public int loadCache(String aCod_Tabella)  {
		List<TABSOA> _rowList = null;

		try {
			// Query query = _EntityManager.createNativeQuery("SELECT * FROM "
			// + CONTRATTO_CCC_A1 + " where " + "COD_AZIENDA = ?1 and "
			// + "ID_CLIENTE= ?2 ");
			// Query query = pEntityManager
			// .createNativeQuery("select * from ANQO.TABSOA where
			// ANQO.TABSOA.COD_TABELLA='V_SOA_AB_CLASSE' and
			// ANQO.TABSOA.CHIAVE_TABELLA='01KW 01ATRE OC'")
			// ;

			Query query = pEntityManager.createQuery("SELECT t from  TABSOA as t where t.id.codTabella= ?1 ",
					TABSOA.class);
			// query.setLockMode(LockModeType.NONE);
			query.setParameter(1, aCod_Tabella);

			_rowList = query.getResultList();

		} catch (Exception e) {
			pLog.fatal(e);
//			throw new Y1Exception(new Y1RetCode(EnumRetCode.Severe, e.getMessage(), null));
		} finally {
		}
		return _rowList.size();

	}

	public void clearCache() {

		EntityManagerFactory _emf = pEntityManager.getEntityManagerFactory();
		Cache _c = _emf.getCache();
		_c.evict(TABSOA.class);
	}
}
