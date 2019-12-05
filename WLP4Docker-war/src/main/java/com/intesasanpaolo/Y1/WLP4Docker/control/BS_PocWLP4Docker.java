package com.intesasanpaolo.Y1.WLP4Docker.control;


import javax.annotation.PostConstruct;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.*;
import org.apache.log4j.Logger;

import com.intesasanpaolo.Y1.WLP4Docker.model.Output;
import com.intesasanpaolo.Y1.WLP4Docker.model.TABSOA;
import com.intesasanpaolo.Y1.WLP4Docker.view.iBS_PocWLP4Docker;


@Stateless(name = "BS_PocWLP4Docker_bean")
public class BS_PocWLP4Docker implements iBS_PocWLP4Docker {

	private Logger pLog;
	private CL_dao pCL_dao;

	private EntityManager pEM;
	protected static final String ACRONIMO = "Y1XXX";
	private static final String OPERATION = "QODB262";
	private static final String Persistence_Unit_Name = "PocWLP4Docker";

	public BS_PocWLP4Docker() {

	}

	@PostConstruct
	public void init() {
		pLog = Logger.getLogger(getClass().getPackage().getName());

		EntityManagerFactory _emf = Persistence.createEntityManagerFactory(
				Persistence_Unit_Name);
		pEM = _emf.createEntityManager();

		pCL_dao = new CL_dao();

		pCL_dao.setEntityManager(pEM);

	}

	public Output queryQODB262(String aCodiceABI, String aCOD_TABELLA, String aCHIAVE_TABELLA) {
		// EntityManager _em = null;
		// try {
		// _em = pJ2DB.getEntityManager(aCodiceABI, ACRONIMO, OPERATION,
		// Persistence_Unit_Name);
		// } catch (Y1Exception e) {
		// pLog.fatal(e.getMessage());
		// _o.setRETCODE("99");
		// _o.setMESSAGGIO("errore grave " + e.getMessage());
		// return _o;
		// }
		//
		Output _o = new Output();

		pCL_dao.setEntityManager(pEM);

		TABSOA _tabsoa = pCL_dao.queryQODB262(aCOD_TABELLA, aCHIAVE_TABELLA);

		if (_tabsoa == null) {
			_o.setRETCODE("20");
			_o.setMESSAGGIO("in input è stato impostato un codice Entità inesistente");
		} else {
			_o.setRETCODE("00");
			_o.setMESSAGGIO(_tabsoa.getAreaDati());
		}

		return _o;

	}

	@Override
	@Asynchronous
	public void loadCacheAsynch(String aCodiceABI, String aCod_Tabella) {
		pLog.info("Inizio processo LOAD Asynch");
		Output _o = new Output();
//		EntityManager _em = null;
//		try {
//			_em = pJ2DB.getEntityManager(aCodiceABI, ACRONIMO, OPERATION, Persistence_Unit_Name);
//		} catch (Y1Exception e) {
//			pLog.fatal(e.getMessage());
//			_o.setRETCODE("99");
//			_o.setMESSAGGIO("errore grave " + e.getMessage());
//		}
//
//		pCL_dao.setEntityManager(_em);

		Integer _count = pCL_dao.loadCache(aCod_Tabella);

		if (_count == null) {
			_o.setRETCODE("20");
			_o.setMESSAGGIO("in input è stato impostato un codice Entità inesistente");
		} else {
			_o.setRETCODE("00");
			_o.setMESSAGGIO(_count.toString());
		}
		pLog.info("Fine   processo LOAD Asynch");
	}

	@Override
	public Output loadCache(String aCodiceABI, String aCod_Tabella) {
//		EntityManager _em = null;
		Output _o = new Output();
//		try {
//			String _JNDIname = pJ2DB.getJNDIname("01025","Y1WS0","READ");
//			pEM.setProperty("javax.persistence.jtaDataSource", _JNDIname);
//
//		} catch (Y1Exception e) {
//			pLog.fatal(e.getMessage());
//			_o.setRETCODE("99");
//			_o.setMESSAGGIO("errore grave " + e.getMessage());
//		}
//		try {
//			_em = pJ2DB.getEntityManager(aCodiceABI, ACRONIMO, OPERATION, Persistence_Unit_Name);
//		} catch (Y1Exception e) {
//			pLog.fatal(e.getMessage());
//			_o.setRETCODE("99");
//			_o.setMESSAGGIO("errore grave " + e.getMessage());
//			return _o;
//		}
//
//		pCL_dao.setEntityManager(pEM);

		Integer _count = pCL_dao.loadCache(aCod_Tabella);

		if (_count == null) {
			_o.setRETCODE("20");
			_o.setMESSAGGIO("in input è stato impostato un codice Entità inesistente");
		} else {
			_o.setRETCODE("00");
			_o.setMESSAGGIO(_count.toString());
		}
		return _o;
	}

	@Override
	public Output clearCache(String aCodiceABI) {
		Output _o = new Output();
//		EntityManager _em = null;
//		try {
//			_em = pJ2DB.getEntityManager(aCodiceABI, ACRONIMO, OPERATION, Persistence_Unit_Name);
//		} catch (Y1Exception e) {
//			pLog.fatal(e.getMessage());
//			_o.setRETCODE("99");
//			_o.setMESSAGGIO("errore grave " + e.getMessage());
//		}
//
//		pCL_dao.setEntityManager(_em);

		pCL_dao.clearCache();

		_o.setRETCODE("00");
		_o.setMESSAGGIO("cache Cleared");

		return _o;

	}

}
