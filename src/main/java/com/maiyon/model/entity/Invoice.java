package com.maiyon.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maiyon.model.enums.InvoiceStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Long invoiceId;
    private String serialNumber;
    private Double totalPrice;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private InvoiceStatus status;
    private String note;
    private String receiveName;
    private String receiveAddress;
    private String receivePhone;
    private Date createdDate;
    private Date receiveDate;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;
    @OneToMany(mappedBy = "invoice")
    @JsonIgnore
    private List<InvoiceDetail> invoiceDetails;
}
