package com.maiyon.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maiyon.model.enums.ActiveStatus;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.*;
import org.hibernate.annotations.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@DynamicInsert
@DynamicUpdate
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "description")
    private String description;
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
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Product> products;
}