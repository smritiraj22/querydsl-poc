package entity;// default package
// Generated Aug 14, 2016 11:05:40 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Actor generated by hbm2java
 */
@Entity
@Table(name = "actor", catalog = "sakila")
public class Actor implements java.io.Serializable {

	private Short actorId;
	private String firstName;
	private String lastName;
	private Date lastUpdate;
	private Set filmActors = new HashSet(0);

	public Actor() {
	}

	public Actor(String firstName, String lastName, Date lastUpdate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
	}

	public Actor(String firstName, String lastName, Date lastUpdate, Set filmActors) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
		this.filmActors = filmActors;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "actor_id", unique = true, nullable = false)
	public Short getActorId() {
		return this.actorId;
	}

	public void setActorId(Short actorId) {
		this.actorId = actorId;
	}

	@Column(name = "first_name", nullable = false, length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false, length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false, length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actor")
	public Set getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(Set filmActors) {
		this.filmActors = filmActors;
	}

}
