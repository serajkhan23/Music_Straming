package com.example.geekster.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "myUser")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=User.class,property="userId")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userMobNo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "song_user_join_table",joinColumns = @JoinColumn(name = "fk_user_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_song_id"))
    private List<Song> songs;
}
