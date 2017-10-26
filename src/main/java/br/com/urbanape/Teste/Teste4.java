package br.com.urbanape.Teste;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.urbanape.modelo.Rechargeinfo;
import br.com.urbanape.util.JPAUtil;

public class Teste4 {
	public static void main(String[] args) throws IOException {		
		
		EntityManager em = new JPAUtil().getEntityManager();
				
		   //--PARA PCR USAR 27788

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT DISTINCT ri"); 
		sb.append(" FROM Rechargeinfo ri ");
		sb.append(" JOIN ri.rechargeinfostaffs rs ");
		sb.append(" WHERE ri.prvId = 12715 ");
		sb.append(" AND ri.utId <> 5 ");
		sb.append(" AND rs.ristfDocnbr = :pCpf");
		
		
		TypedQuery<Rechargeinfo> query = em.createQuery(sb.toString(), Rechargeinfo.class);
		query.setParameter("pCpf", "071149914444");
		
		List<Rechargeinfo> r = query.getResultList();
		
		if(r.isEmpty()){
			System.out.println("N�o encontrado");
		}else{
			System.out.println("Encontrado");
		}
		

		em.close();
	}	
}
