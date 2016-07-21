package org.junglejobs.newsservice.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import org.junglejobs.newsservice.util.CustomNewsSerializer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "NEWS")
public class NewsArticle implements Serializable {
	
	private static final long serialVersionUID = 615486176830759530L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int newsID;

	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "CONTENT")
	private String content;

	@Temporal(TemporalType.DATE)
	@Column(name = "PUBLISH_DATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date publishDate;
	
	public int getNewsId() {
		return newsID;
	}

	public void setNewsId(int newsID) {
		this.newsID = newsID;
	}
	
	public String getTitle() {
	    return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getPublishDate() {
	    return publishDate;
	}
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
}
