package com.intesasanpaolo.Y1.WLP4Docker.web;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.xml.ws.Holder;

import com.intesasanpaolo.Y1.WLP4Docker.model.Output;
import com.intesasanpaolo.Y1.WLP4Docker.view.iBS_PocWLP4Docker;
import com.intesasanpaolo.Y1.WLP4Docker.view.iPocWLP4DockerWS;
import com.intesasanpaolo.Y1.chrono.Y1Chrono;
 
//@WebService(endpointInterface = "com.intesasanpaolo.Y1.view.iPocTABSOAws", serviceName = "PocTABSOAws")
@WebService(serviceName = "PocWLP4Dockerws")
public class PocWLP4DockerWS implements iPocWLP4DockerWS {

	@EJB
	private iBS_PocWLP4Docker pBS_PocWLP4Docker;

	@Override
	public String HW() {
		// TODO Auto-generated method stub
		return "Hello from EG";
	}

	public void queryQODB262(String aCodiceABI, String aCod_Tabella, String aChiave_Name, Holder<Output> aOutput) {
		Y1Chrono _y1chrono = new Y1Chrono();
		_y1chrono.Start();
		if (aCodiceABI == null || aCodiceABI.isEmpty()) {
			aOutput.value.setRETCODE("08");
			aOutput.value.setMESSAGGIO("in input è stato impostato un codice Azienda non valido");
			return;
		}

		if (aCod_Tabella == null || aCod_Tabella.isEmpty()) {
			aOutput.value.setRETCODE("11");
			aOutput.value.setMESSAGGIO("in input è stato impostato un codice Tabella non valido");
			return;
		}

		if (aChiave_Name == null || aChiave_Name.isEmpty()) {
			aOutput.value.setRETCODE("12");
			aOutput.value.setMESSAGGIO("in input è stato impostato un codice Chiave non valido");
			return;
		}

		aOutput.value = pBS_PocWLP4Docker.queryQODB262(aCodiceABI, aCod_Tabella, aChiave_Name);
		_y1chrono.Stop();
		aOutput.value.setY1Chrono(_y1chrono);
	}

	@Override
	public void loadCache(String aCodiceABI, String aCod_Tabella, Holder<Output> aOutput) {
		Y1Chrono _y1chrono = new Y1Chrono();
		_y1chrono.Start();
		if (aCodiceABI == null || aCodiceABI.isEmpty()) {
			aOutput.value.setRETCODE("08");
			aOutput.value.setMESSAGGIO("in input è stato impostato un codice Azienda non valido");
			return;
		}

		if (aCod_Tabella == null || aCod_Tabella.isEmpty()) {
			aOutput.value.setRETCODE("11");
			aOutput.value.setMESSAGGIO("in input è stato impostato un codice Tabella non valido");
			return;
		}

		aOutput.value = pBS_PocWLP4Docker.loadCache(aCodiceABI, aCod_Tabella);
		_y1chrono.Stop();
		aOutput.value.setY1Chrono(_y1chrono);
	}

	@Override
	public void loadCacheAsynch(String aCodiceABI, String aCod_Tabella, Holder<Output> aOutput) {
		Y1Chrono _y1chrono = new Y1Chrono();
		_y1chrono.Start();
		if (aCodiceABI == null || aCodiceABI.isEmpty()) {
			aOutput.value.setRETCODE("08");
			aOutput.value.setMESSAGGIO("in input è stato impostato un codice Azienda non valido");
			return;
		}

		if (aCod_Tabella == null || aCod_Tabella.isEmpty()) {
			aOutput.value.setRETCODE("11");
			aOutput.value.setMESSAGGIO("in input è stato impostato un codice Tabella non valido");
			return;
		}

		pBS_PocWLP4Docker.loadCacheAsynch(aCodiceABI, aCod_Tabella);

		_y1chrono.Stop();
		aOutput.value.setRETCODE("04");
		aOutput.value.setMESSAGGIO("richiesta schedulata");
		aOutput.value.setY1Chrono(_y1chrono);
	}

	public void clearCache(String aCodiceABI, Holder<Output> aOutput) {
		Y1Chrono _y1chrono = new Y1Chrono();
		_y1chrono.Start();
		if (aCodiceABI == null || aCodiceABI.isEmpty()) {
			aOutput.value.setRETCODE("08");
			aOutput.value.setMESSAGGIO("in input è stato impostato un codice Azienda non valido");
			return;
		}

		aOutput.value = pBS_PocWLP4Docker.clearCache(aCodiceABI);

	}


}
