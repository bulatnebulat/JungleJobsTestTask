package org.junglejobs.newsservice.dao;

import java.util.Date;
import java.util.List;

import org.junglejobs.newsservice.beans.NewsArticle;

public interface NewsDao {

	public List<NewsArticle> getEntityList(Date fromDate, Date toDate) throws Exception;
	
}
