package com.dashboard.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attendance")
@Setter
@Getter
@NoArgsConstructor
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
