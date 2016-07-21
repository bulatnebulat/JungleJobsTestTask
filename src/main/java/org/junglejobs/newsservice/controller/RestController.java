package org.junglejobs.newsservice.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junglejobs.newsservice.beans.ErrorMessage;
import org.junglejobs.newsservice.beans.NewsArticle;
import org.junglejobs.newsservice.service.NewsService;
import org.junglejobs.newsservice.util.WrongDatesRangeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/news")
public class RestController {

	@Autowired
	NewsService newsService;

	static final Logger logger = Logger.getLogger(RestController.class);
	
	@ExceptionHandler(WrongDatesRangeException.class)
	public ErrorMessage myError(HttpServletRequest request, Exception exception) {
	    ErrorMessage error = new ErrorMessage();
	    error.setStatus(HttpStatus.BAD_REQUEST.value());
	    error.setMessage(exception.getLocalizedMessage());
	    error.setUrl(request.getRequestURL().toString());
	    return error;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<NewsArticle> getNewsArticle(@RequestParam(value = "fromDate", required = false) @DateTimeFormat(pattern="ddMMyyyy") Date fromDate,
			@RequestParam(value = "toDate", required = false) @DateTimeFormat(pattern="ddMMyyyy") Date toDate) {
		if (!fromDate.after(toDate)) {
			throw new WrongDatesRangeException(fromDate, toDate);
		}
		List<NewsArticle> articleList = null;
		try {
			articleList = newsService.getEntityList(fromDate, toDate);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return articleList;
	}

	
}
