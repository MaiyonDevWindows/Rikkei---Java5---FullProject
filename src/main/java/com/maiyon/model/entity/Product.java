package com.maiyon.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maiyon.model.enums.ActiveStatus;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "products")
@DynamicInsert
@DynamicUpdate
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(unique = true, nullable = false)
    private String sku;
    @Column(unique = true, nullable = false)
    private String productName;
    private String description;
    @Column(name = "unit_price", columnDefinition = "DECIMAL(10,2) DEFAULT(1)")
    private Double unitPrice;
    @Column(name = "stock_quantity", columnDefinition = "INT DEFAULT(0)")
    private Integer stockQuantity;
    @CreationTimestamp
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createdDate;
    @UpdateTimestamp
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date updatedDate;
    @Enumerated(EnumType.ORDINAL)
    @ColumnDefault(value = "false")
    @Column(name = "status", columnDefinition = "BIT(1)")
    private ActiveStatus status;
    // * Product - Category: N - 1.
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
    // * Product - ShoppingCart: 1 - N.
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ShoppingCart> shoppingCarts;
    @PrePersist
    private void prePersist(){
        if(this.sku == null){
            this.sku = UUID.randomUUID().toString();
        }
    }
    @PreUpdate
    private void preUpdate(){
        if(this.sku == null){
            this.sku = UUID.randomUUID().toString();
        }
    }
}
