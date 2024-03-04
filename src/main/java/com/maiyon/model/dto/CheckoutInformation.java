package com.maiyon.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CheckoutInformation {
    @NotBlank(message = "Enter Receive Name")
    private String receiveName;
    @NotBlank(message = "Enter Phone")
    private String receivePhone;
    @NotBlank(message = "Enter Address")
    private String receiveAddress;
    @NotBlank(message = "Enter Note")
    private String note;
}
