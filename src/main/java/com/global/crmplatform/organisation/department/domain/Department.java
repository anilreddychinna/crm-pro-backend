package com.global.crmplatform.organisation.department.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "b_department")
public class Department {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name="department_name", nullable = false)
	private String deptName;

	@Column(name="department_description")
	private String deptDescription;

	@Column(name="office_id")
	private Long officeId;

	@Column(name="is_deleted" ,nullable = false)
	@ColumnDefault(value="'N'")
	private String deleted;

	@Column(name="is_allocated")
	private String allocated = "No";

	public void delete() {
		this.deleted = "Y";
	}

	public void allocated() {
		this.allocated = "Yes";
	}

}
