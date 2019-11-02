package com.example.demo.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transaction")
//@NamedQuery(name="Transaction.getCount",query="Select count(time) from transaction where time>:lastTime")
public class Transaction {

	@Id
	@Column(name="transaction_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="timestamp")
	//@Temporal(TemporalType.TIMESTAMP)
	private long timestamp;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}	
	
}
