package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.PaymentDeleteResponseDto;
import com.aja.Dto.PaymentsRequestDto;
import com.aja.Dto.PaymentsResponseDto;
import com.aja.service.PaymentsService;

@RestController

@RequestMapping("/api/payment")
@CrossOrigin("*")
public class PaymentsController {
	@Autowired
	private PaymentsService paymentsService;

	@PostMapping("/add")
	public ResponseEntity<PaymentsResponseDto> createPayment(@RequestBody PaymentsRequestDto dto) {
		return ResponseEntity.ok(paymentsService.createPayment(dto));

	}

	@GetMapping("/{id}")
	public ResponseEntity<PaymentsResponseDto> getPaymentById(@PathVariable("id") Long id) {
		PaymentsResponseDto payment = paymentsService.getPaymentById(id);
		return ResponseEntity.ok(payment);
	}

	@GetMapping("/all")
	public ResponseEntity<List<PaymentsResponseDto>> getAllPayments() {
		List<PaymentsResponseDto> pay = paymentsService.getAllPayments();
		return ResponseEntity.ok(pay);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PaymentsResponseDto> updatePayment(@PathVariable Long id,
			@RequestBody PaymentsResponseDto paymentDto) {

		PaymentsResponseDto updated = paymentsService.updatePayment(id, paymentDto);

		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<PaymentDeleteResponseDto> softDelete(@PathVariable Long id) {

		PaymentDeleteResponseDto deletepayment = paymentsService.deletePayment(id);
		return ResponseEntity.ok(deletepayment);
	}

}
