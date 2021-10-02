package com.aus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User  implements Serializable {
    @Id
    private int id;
    private String username;
    private String password;
    private String email;
}
