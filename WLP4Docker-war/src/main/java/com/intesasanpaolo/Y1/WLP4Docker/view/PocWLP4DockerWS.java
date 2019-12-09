package com.intesasanpaolo.Y1.WLP4Docker.view;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.jws.WebService;
import javax.xml.ws.Holder;

import com.intesasanpaolo.Y1.WLP4Docker.model.Output;
import com.intesasanpaolo.Y1.chrono.Y1Chrono;

//@WebService(endpointInterface = "com.intesasanpaolo.Y1.WLP4Docker.view.iPocWLP4DockerWS",serviceName = "poc")
@WebService(serviceName = "poc", portName = "PocWLP4DockerWSPort")
public class PocWLP4DockerWS implements iPocWLP4DockerWS {

	@EJB
	private iBS_PocWLP4Docker pBS_PocWLP4Docker;

	@Override
	public String HW() {
		// TODO Auto-generated method stub
		return "Hello from EG";
	}

	public void queryTmlResourceExit(int aID, Holder<Output> aOutput) {
		Y1Chrono _y1chrono = new Y1Chrono();
		_y1chrono.Start();
		aOutput.value = pBS_PocWLP4Docker.queryTmlResourceExit(aID);
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

	@Override
	public String getProperties() {

		JsonObjectBuilder builder = Json.createObjectBuilder();

		System.getProperties().entrySet().stream()
				.forEach(entry -> builder.add((String) entry.getKey(), (String) entry.getValue()));

		return builder.build().toString();
	}

}
