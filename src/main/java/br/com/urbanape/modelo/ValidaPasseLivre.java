package br.com.urbanape.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.urbanape.util.JPAUtil;

public class ValidaPasseLivre {
	public boolean validaPL(String cpf){
			
			EntityManager em = new JPAUtil().getEntityManager();
			
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT DISTINCT ri"); 
			sb.append(" FROM Rechargeinfo ri ");
			sb.append(" JOIN FETCH ri.rechargeinfostaffs rs ");
			sb.append(" WHERE ri.prvId = 12715 "); //--PARA PCR USAR 27788 - RMR 12715
			sb.append(" AND ri.utId <> 5 ");
			sb.append(" AND rs.ristfDocnbr = :pCpf");
			
			TypedQuery<Rechargeinfo> query = em.createQuery(sb.toString(), Rechargeinfo.class);
			query.setParameter("pCpf", cpf);
	
			List<Rechargeinfo> lista = query.getResultList();
			
			em.close();
			
			if(lista.isEmpty()){
				return true;
			}else{
				return false;
			}
			
		}
}
