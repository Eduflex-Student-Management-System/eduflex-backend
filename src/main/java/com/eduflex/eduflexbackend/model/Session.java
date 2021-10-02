package com.eduflex.eduflexbackend.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Session {
    @Id
    @GeneratedValue
    private int sessionId;
    @Column
    @Type(type = "timestamp")
    private Date sessionDateTime;
}
