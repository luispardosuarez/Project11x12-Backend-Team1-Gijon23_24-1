package com.x12.project11x12.invoices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

  @Autowired
  private InvoiceRepository invoiceRepository;

  public List <Invoice> getAllInvoices(){
    return invoiceRepository.findAll();
  }

  public Invoice getInvoiceById(Long id){
    return invoiceRepository.findById(id).orElse(null);
  }

  public Invoice saveInvoice(Invoice invoice){
    return invoiceRepository.save(invoice);
  }

  public void deleteInvoice(Long id){
    invoiceRepository.deleteById(id);
  }
  
}
