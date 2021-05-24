package ai.ecma.lastlesson.entity;


import ai.ecma.lastlesson.entity.templates.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * PDP.UZ PLATFORMASINING FOYDALNUVCHISI
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "users")
@NoArgsConstructor
public class User extends AbstractEntity implements UserDetails {

    @Column(name = "phoneNumber", unique = true)
    private String phoneNumber;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @ManyToMany
    private List<Role> roles;

    @ManyToOne
    private Address address;


    private String fullName;

    public User(String phoneNumber, String password, List<Role> roles, String fullName) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.roles = roles;
        this.fullName = fullName;
    }

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.phoneNumber;
    }

    @PreUpdate
    public void update() {
        setUpdatedBy(null);
    }

}
