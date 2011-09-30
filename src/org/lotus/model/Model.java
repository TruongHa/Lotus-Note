package org.lotus.model;

public class Model {

	protected Integer id;
	protected boolean retired;

	public boolean isRetired() {
		return retired;
	}

	public void setRetired(boolean retired) {
		this.retired = retired;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		
		return getClass().getSimpleName() + "[id=" + id + "]";
	}
}
