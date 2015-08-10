package org.sam.syllabus.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Angel Ortega
 * 
 */
public class SyllabusDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String plan;
	private Date initDate;
	private Date endDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
