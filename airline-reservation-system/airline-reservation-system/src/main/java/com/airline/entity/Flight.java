package com.airline.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	
	@Column(name="available_seat", nullable=false)
	private int availableSeat;
	
	@Column(name="total_seat", nullable=false)
	private int totalSeats;
	
	@Column(nullable=false)
	private float fare;
	
	@Column(name="time_departure", nullable=false)
	private String time;
	
	@Column(nullable=false)
	private LocalDate date;
	
	@Column(length=30 , nullable=false)
	private String source;
	
	@Column(length=30 , nullable=false)
	private String destination;
	
	@ManyToOne
	private Airline airline;
}
