package com.intesasanpaolo.Y1.WLP4Docker.view;

import com.intesasanpaolo.Y1.WLP4Docker.model.Output;

public interface iBS_PocWLP4Docker {

	public Output 	queryTmlResourceExit(int aID);

	public Output loadCache(String aCodiceABI, String aCod_Tabella);

	public void loadCacheAsynch(String aCodiceABI, String aCod_Tabella);

	public Output clearCache(String aCodiceABI);

}
