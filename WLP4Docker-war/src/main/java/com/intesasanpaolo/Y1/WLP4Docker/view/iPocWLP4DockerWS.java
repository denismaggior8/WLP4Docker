package com.intesasanpaolo.Y1.WLP4Docker.view;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.xml.ws.Holder;

import com.intesasanpaolo.Y1.WLP4Docker.model.Output;


@WebService
public interface iPocWLP4DockerWS {

	@WebMethod
	public String getProperties();

	@WebMethod
	public String HW();

	@WebMethod(operationName = "queryTmlResourceExit")
	public void queryTmlResourceExit (@WebParam(name = "ID", targetNamespace = "", mode = Mode.IN) int aID,
			@WebParam(name = "Output", targetNamespace = "", mode = Mode.INOUT) Holder<Output> aOutput);

	@WebMethod(operationName = "loadCache")
	public void loadCache(@WebParam(name = "CodiceABI", targetNamespace = "", mode = Mode.IN) String aCodiceABI,
			@WebParam(name = "Cod_Tabella", targetNamespace = "") String aCod_Tabella,
			@WebParam(name = "Output", targetNamespace = "", mode = Mode.INOUT) Holder<Output> aOutput);

	@WebMethod(operationName = "loadCacheAsynch")
	public void loadCacheAsynch(@WebParam(name = "CodiceABI", targetNamespace = "", mode = Mode.IN) String aCodiceABI,
			@WebParam(name = "Cod_Tabella", targetNamespace = "") String aCod_Tabella,
			@WebParam(name = "Output", targetNamespace = "", mode = Mode.INOUT) Holder<Output> aOutput);

	@WebMethod(operationName = "clearCache")
	public void clearCache(@WebParam(name = "CodiceABI", targetNamespace = "", mode = Mode.IN) String aCodiceABI,
			@WebParam(name = "Output", targetNamespace = "", mode = Mode.INOUT) Holder<Output> aOutput);

}
