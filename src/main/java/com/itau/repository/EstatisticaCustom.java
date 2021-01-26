package com.itau.repository;

import java.util.Date;
import java.util.List;

import com.itau.repository.model.EstatisticaModel;

public interface EstatisticaCustom {

	List<EstatisticaModel> getReportEstatistica(Date dateReport);

}
