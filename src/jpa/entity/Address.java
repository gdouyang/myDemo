package jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address
{
	
	@Id
	@Column(name = "OWNER_ID")
	private long ownerId;
	
	private String name;
	
	public long getOwnerId()
	{
		return ownerId;
	}
	
	public void setOwnerId(long ownerId)
	{
		this.ownerId = ownerId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public Address(long ownerId, String name)
	{
		super();
		this.ownerId = ownerId;
		this.name = name;
	}

	public Address()
	{
	}
	
	
	/*
	 * @OneToOne
	 * 
	 * @PrimaryKeyJoinColumn(name="OWNER_ID", referencedColumnName="EMP_ID")
	 * private Employee owner;
	 * 
	 * public void setOwner(Employee owner) { this.owner = owner; this.ownerId =
	 * owner.getId(); }
	 */
}
