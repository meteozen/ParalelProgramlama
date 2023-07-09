package com.example.javatutorials.finalhome.webprogramming;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

//Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//DTO ==> validation
public class JqueryDto implements Serializable {

    //serileştirme
    public static final long serialVersionUID = 1L;

    // ID
    private Long id;

    // EMAIL
    @NotNull(message = "E-posta adresinizi girmediniz")
    private String email;

    // PASSWORD
    @NotNull(message = "Şifreyi girmediniz")
    private String passwd;

    //NICKNAME
    @NotNull(message = "Adınızı girmediniz")

    // Sistem tarihi almak
    private Date createdDate;
}