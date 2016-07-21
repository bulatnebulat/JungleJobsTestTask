package org.junglejobs.newsservice.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.junglejobs.newsservice.beans.NewsArticle;
import org.springframework.stereotype.Component;

@Component
public class CustomNewsSerializer extends JsonSerializer<NewsArticle> {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm");

	@Override
	public void serialize(NewsArticle value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		String formattedDate = dateFormat.format(value.getPublishDate());
		jgen.writeNumber(value.getNewsId());
		jgen.writeString(value.getTitle());
		jgen.writeString(value.getContent());
		jgen.writeString(formattedDate);
		
	}

}
