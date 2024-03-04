package com.maiyon.service;

import com.maiyon.model.entity.Invoice;
import com.maiyon.model.entity.User;

import java.util.List;

public interface InvoiceService {
    Invoice findByInvoiceId(Long invoiceId);
    List<Invoice> findAll();
    List<Invoice> findByUser(User user);
}
