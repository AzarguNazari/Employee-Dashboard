package com.dashboard.models.JPA;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private Boolean present = false;

    public Attendance(Boolean present){
        this.present = present;
    }
}
