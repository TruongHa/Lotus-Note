package org.lotus.model;

import java.util.Date;

public class Task extends Model {

	private Task parent;
	private String name;
	private String description;
	private Long estimateTime;
	private Long actualTime;
	private Integer status;
	private Date date;

	public Task getParent() {
		return parent;
	}

	public void setParent(Task parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getEstimateTime() {
		return estimateTime;
	}

	public void setEstimateTime(Long estimateTime) {
		this.estimateTime = estimateTime;
	}

	public Long getActualTime() {
		return actualTime;
	}

	public void setActualTime(Long actualTime) {
		this.actualTime = actualTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
