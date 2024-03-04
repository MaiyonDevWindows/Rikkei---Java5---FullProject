package com.maiyon.service;

import com.maiyon.model.entity.Invoice;
import com.maiyon.model.entity.InvoiceDetail;

import java.util.List;

public interface InvoiceDetailService {
    List<InvoiceDetail> findByInvoice(Invoice invoice);
}
