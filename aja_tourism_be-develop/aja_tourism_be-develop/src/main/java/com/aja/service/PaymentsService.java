package com.aja.service;
 
import java.util.List;
 
import com.aja.Dto.PaymentDeleteResponseDto;
import com.aja.Dto.PaymentsRequestDto;
import com.aja.Dto.PaymentsResponseDto;
 
public interface PaymentsService {
 
	PaymentsResponseDto createPayment(PaymentsRequestDto dto);
 
	public List<PaymentsResponseDto> getAllPayments();
 
	public PaymentsResponseDto getPaymentById(Long paymentId);
 
	public PaymentsResponseDto updatePayment(Long paymentId, PaymentsResponseDto payres);
 
	public PaymentDeleteResponseDto deletePayment(Long paymentId);
 
}