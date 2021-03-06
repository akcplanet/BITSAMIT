package org.outreach.cts.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * EventDetails generated by hbm2java
 */
@Entity
@Table(name = "event_details", catalog = "outreach")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class EventDetails extends BaseModel<String> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Activity activity;
	private Council council;
	private EventsType eventType;
	private PocDetails pocDetailsByPoc2Id;
	private PocDetails pocDetailsByPoc1Id;
	private PocDetails pocDetailsByPoc3Id;
	private SchoolDetails schoolDetails;
	private Date eventDate;
	private String eventDesc;
	private String totalHrs;
	private String noOfLivesImpct;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@JsonProperty("id")
	public String getPrimaryKey() {
		return this.primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "activity_id")
	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "council_id")
	public Council getCouncil() {
		return this.council;
	}

	public void setCouncil(Council council) {
		this.council = council;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "type_of_event")
	public EventsType getEventType() {
		return this.eventType;
	}

	public void setEventType(EventsType eventType) {
		this.eventType = eventType;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "poc_2_id")
	public PocDetails getPocDetailsByPoc2Id() {
		return this.pocDetailsByPoc2Id;
	}

	public void setPocDetailsByPoc2Id(PocDetails pocDetailsByPoc2Id) {
		this.pocDetailsByPoc2Id = pocDetailsByPoc2Id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "poc_1_id")
	public PocDetails getPocDetailsByPoc1Id() {
		return this.pocDetailsByPoc1Id;
	}

	public void setPocDetailsByPoc1Id(PocDetails pocDetailsByPoc1Id) {
		this.pocDetailsByPoc1Id = pocDetailsByPoc1Id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "poc_3_id")
	public PocDetails getPocDetailsByPoc3Id() {
		return this.pocDetailsByPoc3Id;
	}

	public void setPocDetailsByPoc3Id(PocDetails pocDetailsByPoc3Id) {
		this.pocDetailsByPoc3Id = pocDetailsByPoc3Id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "school_id")
	public SchoolDetails getSchoolDetails() {
		return this.schoolDetails;
	}

	public void setSchoolDetails(SchoolDetails schoolDetails) {
		this.schoolDetails = schoolDetails;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "event_date")
	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	@Column(name = "event_desc", length = 500)
	public String getEventDesc() {
		return this.eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	@Column(name = "total_hrs", nullable = false, length = 50)
	public String getTotalHrs() {
		return this.totalHrs;
	}

	public void setTotalHrs(String totalHrs) {
		this.totalHrs = totalHrs;
	}

	@Column(name = "no_of_lives_impct")
	public String getNoOfLivesImpct() {
		return this.noOfLivesImpct;
	}

	public void setNoOfLivesImpct(String noOfLivesImpct) {
		this.noOfLivesImpct = noOfLivesImpct;
	}

	
	@Override
	public String toString() {
		return "EventDetails [activity=" + activity + ", council=" + council + ", eventType=" + eventType
				+ ", pocDetailsByPoc2Id=" + pocDetailsByPoc2Id + ", pocDetailsByPoc1Id=" + pocDetailsByPoc1Id
				+ ", pocDetailsByPoc3Id=" + pocDetailsByPoc3Id + ", schoolDetails=" + schoolDetails + ", eventDate="
				+ eventDate + ", eventDesc=" + eventDesc + ", totalHrs=" + totalHrs + ", noOfLivesImpct="
				+ noOfLivesImpct + "]";
	}



}
