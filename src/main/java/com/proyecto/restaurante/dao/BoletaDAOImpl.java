package com.proyecto.restaurante.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proyecto.restaurante.entity.Boleta;
import com.proyecto.restaurante.entity.PlatilloHasBoleta;
import com.proyecto.restaurante.entity.PlatilloHasBoletaPK;

@Repository
public class BoletaDAOImpl implements BoletaDAO{

	@PersistenceContext
    private EntityManager entityManager;
	
	
	@Transactional
	@Override
	public void saveBoleta(Boleta bol) {
		Session session = entityManager.unwrap( Session.class );
		try {
			
			session.save(bol);
			for(PlatilloHasBoleta phb : bol.getListaPlatilloHasBoleta()) {
				PlatilloHasBoletaPK pk = new PlatilloHasBoletaPK();
				pk.setNumeroBoleta(bol.getNumeroBoleta());
				pk.setCodigoPlatillo(phb.getPlatillo().getIdPlatillo());
				phb.setPk(pk);
				session.save(phb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	

}
