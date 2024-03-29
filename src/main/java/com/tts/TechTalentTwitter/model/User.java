package com.tts.TechTalentTwitter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // below we are defining the name of the column in our database for this field
    @Column(name = "user_id")
    private Long id;

    // @Email, @NotEmpty, @Pattern, @Length are field constraints on our model
    //this is error handling implemented via annotation
    @Email(message = "Please provide a valid email")
    @NotEmpty(message = "Please provide an email")
    private String email;

    @Length(min = 3, message = "Your username must have at least 3 characters")
    @Length(max = 15, message = "Your username cannot have more than 15 characters")
    @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces")
    @NotEmpty(message = "Please provide a username")
    private String username;

    @NotEmpty(message = "Please provide a password with at least 5 characters.")
    @Length(min = 5, message = "Your password must have at least 5 characters")
    private String password;
    @NotEmpty(message = "Please provide your first name")
    private String firstName;
    @NotEmpty(message = "Please provide your last name")
    private String lastName;

    private int active;

    // hibernate annotation that will autogenerate a creation timestamp
    @CreationTimestamp
    private Date createdAt;

    // @ManyToMany is a javax annotation that will define a relationship
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    // TODO(): Create Role class
    private Set<Role> roles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_followers", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id"))
    private List<User> followers;

    @ManyToMany(mappedBy = "followers")
    private List<User> following;
}