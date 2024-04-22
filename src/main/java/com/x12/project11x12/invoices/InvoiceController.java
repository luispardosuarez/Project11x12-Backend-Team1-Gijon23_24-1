package com.x12.project11x12.invoices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api-endpoint}/invoices")
public class InvoiceController {

  @Autowired
  private InvoiceService invoiceService;
  @GetMapping
  public ResponseEntity<List<Invoice>> getAllInvoice(){
    List<Invoice> invoice = invoiceService.getAllInvoices();
    return ResponseEntity.ok(invoice);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id){
    Invoice invoice = invoiceService.getInvoiceById(id);
    if(invoice == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(invoice);
  }
  @PostMapping
  public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice){
    Invoice savedInvoice = invoiceService.saveInvoice(invoice);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedInvoice);
  } 
  @PutMapping("/{id}")
  public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody Invoice invoiceDetails){
    Invoice invoice = invoiceService.getInvoiceById(id);
    if (invoice == null) {
      return ResponseEntity.notFound().build();
    }
    invoice.setTotal(invoiceDetails.getTotal());
    invoice.setDiscount(invoiceDetails.getDiscount());
    invoice.setFinal_total(invoiceDetails.getFinal_total());
    invoice.setPay(invoiceDetails.getPay());
    Invoice updateInvoice = invoiceService.saveInvoice(invoice);
    return ResponseEntity.ok(updateInvoice);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteInvoice(@PathVariable Long id){
    Invoice invoice = invoiceService.getInvoiceById(id);
    if (invoice == null) {
      return ResponseEntity.notFound().build();
    }
    invoiceService.deleteInvoice(id);
    return ResponseEntity.noContent().build();
  }
}
