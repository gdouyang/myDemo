package json;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TestBean
{
	
	private String name;
	
	private Integer id;
	
	@JsonSerialize(using = MyDateSerializer.class)
	private Date date;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
