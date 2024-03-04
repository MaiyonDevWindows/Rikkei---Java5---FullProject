package com.maiyon.service.Impl;

import com.maiyon.model.entity.Invoice;
import com.maiyon.model.entity.User;
import com.maiyon.repository.InvoiceRepository;
import com.maiyon.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    @Override
    public Invoice findByInvoiceId(Long invoiceId) {
        return invoiceRepository.findById(invoiceId).orElse(null);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public List<Invoice> findByUser(User user) {
        return invoiceRepository.findAllByUser(user);
    }
}
