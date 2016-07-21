package org.junglejobs.newsservice.service;

import java.util.Date;
import java.util.List;

import org.junglejobs.newsservice.beans.NewsArticle;
import org.junglejobs.newsservice.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsService {

	@Autowired
	NewsDao newsDao;
	
	public List<NewsArticle> getEntityList(Date fromDate, Date toDate) throws Exception {
		return newsDao.getEntityList(fromDate, toDate);
	}

}
