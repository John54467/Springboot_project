package io.reflectoring.jvcart.Dto;

public class OrderCreater {
	private String referenceId;

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	
	public OrderCreater() {
		// no-arg constructor for frameworks
	}
	
	public OrderCreater(String referenceId) {
		super();
		this.referenceId = referenceId;
		
	}


}