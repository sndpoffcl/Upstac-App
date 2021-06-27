package com.upstac.TestLab.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "USER")
public class UserDO extends BaseDO{
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private int id;
    private String name;
    private String gender;
    private String address;
    private String phoneNumber;
    private String emailId;
    private String password;
    private boolean active;
    private String roles;

    @OneToMany(mappedBy = "userDO" , fetch = FetchType.EAGER)
    @JsonManagedReference("user_booking")
    private List<BookingDO> bookings;

    public UserDO(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }
    public UserDO(String name, String gender, String address, String phoneNumber, String emailId, String password, boolean active, String roles) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public UserDO() {
    }

}
