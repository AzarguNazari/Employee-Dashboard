//package com.example.dashboard.employeedashboard.model;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name="user_details")
//@Setter
//@Getter
//public class UserAccount  implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue
//    private Integer id;
//
//    @Column
//    private String firstName;
//
//    @Column
//    private String lastname;
//
//    @Column
//    private String username;
//
//    @Column
//    private String password;
//
//    @OneToOne(mappedBy = "employee", fetch = FetchType.EAGER)
//    private Employee employee;
//
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="role_id", insertable=false, updatable=false)
//    private Role role;
//
//    public UserAccount id(Integer id) {
//        this.id = id;
//        return this;
//    }
//
//    public UserAccount firstName(String firstName) {
//        this.firstName = firstName;
//        return this;
//    }
//
//    public UserAccount lastName(String lastName) {
//        this.lastname = lastName;
//        return this;
//    }
//
//    public UserAccount username(String username) {
//        this.username = username;
//        return this;
//    }
//
//    public UserAccount role(Role role) {
//        this.role = role;
//        return this;
//    }
//}
//
