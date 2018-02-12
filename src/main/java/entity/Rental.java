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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Rental generated by hbm2java
 */
@Entity
@Table(name = "rental", catalog = "sakila", uniqueConstraints = @UniqueConstraint(columnNames = { "rental_date",
		"inventory_id", "customer_id" }))
public class Rental implements java.io.Serializable {

	private Integer rentalId;
	private Customer customer;
	private Staff staff;
	private Inventory inventory;
	private Date rentalDate;
	private Date returnDate;
	private Date lastUpdate;
	private Set payments = new HashSet(0);

	public Rental() {
	}

	public Rental(Customer customer, Staff staff, Inventory inventory, Date rentalDate, Date lastUpdate) {
		this.customer = customer;
		this.staff = staff;
		this.inventory = inventory;
		this.rentalDate = rentalDate;
		this.lastUpdate = lastUpdate;
	}

	public Rental(Customer customer, Staff staff, Inventory inventory, Date rentalDate, Date returnDate,
			Date lastUpdate, Set payments) {
		this.customer = customer;
		this.staff = staff;
		this.inventory = inventory;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.lastUpdate = lastUpdate;
		this.payments = payments;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "rental_id", unique = true, nullable = false)
	public Integer getRentalId() {
		return this.rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id", nullable = false)
	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inventory_id", nullable = false)
	public Inventory getInventory() {
		return this.inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "rental_date", nullable = false, length = 19)
	public Date getRentalDate() {
		return this.rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "return_date", length = 19)
	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false, length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rental")
	public Set getPayments() {
		return this.payments;
	}

	public void setPayments(Set payments) {
		this.payments = payments;
	}

}
