package com.hostel.dao;

import java.util.List;

import com.hostel.model.HostelDTO;

public interface HostelDAO {
	
	public List<HostelDTO> getAllHostels() throws Exception;
	
	public HostelDTO getHostelDetailsById(int hostelId) throws Exception;
	
	public int insertHostel(HostelDTO hostelDTO) throws Exception;
	
	public final String getHostelsQuery="select hostel_id, hostel_name from hostel";
	
	public final String getHostelDetailsByIdQuery="select h.hostel_id, h.hostel_name, a.address_line_no1, a.address_line_no2, a.city, a.country from hostel h " +
			"inner join address a on a.address_id=h.hostel_address_id"+
			"where h.hostel_id=:hostelId";
	
	public final String insertHostelQuery="insert into hostel (hostel_name, hostel_street, hostel_city, hostel_state, hostel_postal_code, hostel_country," +
			"hostel_phone,hostel_email, hostel_facebook,   hostel_web,  hostel_checkIn_time,  hostel_checkOut_time,  smoking,  alcohol," +
			"cancellation_hours_limit,  cancellation_fee_percant) values (:hostelName,:adrStreet,:adrCity,:adrState," +
			":adrPostalCode,:adrCountry,:phone,:email,:facebook,:web,:checkInTime,:checkOutTime,:smoking,:alcohol," +
			":orderCancellationHoursLimit,:cancellationFeePercant)";
}
