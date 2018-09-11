package com.prince.bookstoreapi.domain.security;

import com.prince.bookstoreapi.domain.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USER_ROLE")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ROLE_ID")
    private Role role;

    public UserRole() {
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }


    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
