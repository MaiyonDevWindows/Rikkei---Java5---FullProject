package com.maiyon.service.Impl;

import com.maiyon.model.entity.Invoice;
import com.maiyon.model.entity.InvoiceDetail;
import com.maiyon.repository.InvoiceDetailRepository;
import com.maiyon.service.InvoiceDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
    private final InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public List<InvoiceDetail> findByInvoice(Invoice invoice) {
        return invoiceDetailRepository.findAllByInvoice(invoice);
    }
}
