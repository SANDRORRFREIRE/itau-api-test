package com.itau.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.itau.repository.model.EstatisticaModel;

@Repository
public class EstatisticaCustomRepository implements EstatisticaCustom {

	@PersistenceContext
	private EntityManager entityManager;

	 
	@SuppressWarnings("unchecked")
	@Override
	public List<EstatisticaModel> getReportEstatistica(Date dateReport) {
 
		Query qry =entityManager.createNativeQuery(getQuery());
		qry.setParameter("dateReport", dateReport);
		
        List<Object[]> rows = qry.getResultList();
        List<EstatisticaModel> estatisticasModel = new ArrayList<>();
        for (Object [] row : rows) {
        	EstatisticaModel estatisticaModel = new EstatisticaModel();
        	estatisticaModel.setQuantidade( Long.valueOf((String) row[0]));
        	estatisticaModel.setTipo((String) row[1]);
        	estatisticaModel.setTermo((String) row[2]);
     
        	estatisticasModel.add(estatisticaModel);
        }
		return estatisticasModel;
 
	}

	private String getQuery() {
		StringBuilder str = new StringBuilder();
		str.append("select ");
		str.append( "    TO_CHAR( quantidade) AS quantidade, tp_consulta, st_termo ");
		str.append("  from ( ");
		str.append("select  ");
		str.append("    count(1) as quantidade, tp_consulta, st_termo ");
		str.append(" from estatistica ");
		str.append("     where dt_consulta >= :dateReport");
		str.append(" group by ");
		str.append("     tp_consulta, st_termo  ");
		str.append(" order by ");
		str.append("     tp_consulta, st_termo ) a ");
		return str.toString();
	}
}
