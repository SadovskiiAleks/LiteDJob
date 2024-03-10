package com.example.userrequests.model.request;

import com.example.userrequests.model.status.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "request")
@Data
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "fullText")
    private String fullText;


    @ManyToOne(fetch = FetchType.EAGER)
    private UserRole userRole;
}
