/**
 * 
 */
package com.taxi24.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author niyomwungeri
 *
 */
@Entity
@Table(name = "invoices")
public class Invoice {
	@Id
	@Column(name = "invoice_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID invoiceId;
	
	@Column(name="invoice_date")
	private Date invoiveDate = new Date();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trip_id")
	private Trip trip;

	public UUID getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(UUID invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getInvoiveDate() {
		return invoiveDate;
	}

	public void setInvoiveDate(Date invoiveDate) {
		this.invoiveDate = invoiveDate;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
}
