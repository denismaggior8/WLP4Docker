package com.intesasanpaolo.Y1.WLP4Docker.view;

import com.intesasanpaolo.Y1.WLP4Docker.model.Output;

public interface iBS_PocWLP4Docker {
	public Output queryQODB262(String aCodiceABI, String aCOD_TABELLA, String aCHIAVE_TABELLA);

	public Output loadCache(String aCodiceABI, String aCod_Tabella);

	public void loadCacheAsynch(String aCodiceABI, String aCod_Tabella);

	public Output clearCache(String aCodiceABI);
}
