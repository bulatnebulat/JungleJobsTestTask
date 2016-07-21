package org.junglejobs.newsservice.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junglejobs.newsservice.beans.NewsArticle;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsDaoImpl implements NewsDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@SuppressWarnings("unchecked")
	@Override
	public List<NewsArticle> getEntityList(Date fromDate, Date toDate) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Query query = null;
		if (toDate != null && fromDate != null) {
			query = session.createQuery("FROM NewsArticle n WHERE n.publishDate between :fromDate AND :toDate");
			query.setParameter("fromDate", fromDate);
			query.setParameter("toDate", toDate);	
		} 
		if (toDate == null && fromDate != null) {
			query = session.createQuery("FROM NewsArticle n WHERE n.publishDate >= :fromDate");
			query.setDate("fromDate", fromDate);	
		} 
		if (toDate != null && fromDate == null) {
			query = session.createQuery("FROM NewsArticle n WHERE n.publishDate <= :toDate");
			query.setDate("toDate", toDate);
		}
		if (toDate == null && fromDate == null) {
			query = session.createQuery("FROM NewsArticle");
		}
		List<NewsArticle> newsList = query.list();
		tx.commit();
		session.close();
		return newsList;
	}
	
}
