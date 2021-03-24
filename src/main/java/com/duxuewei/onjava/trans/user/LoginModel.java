package com.duxuewei.onjava.trans.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class LoginModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String UserId;
    private String Username;
    private String DisplayName;
    private String Email;
    private String AuthToken;
    private String DepartmentId;
    private Date Expired;
    private String CompanyId;
    private String CompanyName;
    private boolean CanLoginProduct;
    private boolean IsSuperAdmin;
    private List<AuthRole> Roles;
    private List<MenuItem> MenuItems;

    public String getUsername() {
        return Username;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public List<MenuItem> getMenuItems() {
        return MenuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.MenuItems = menuItems;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        this.DisplayName = displayName;
    }

    public List<AuthRole> getRoles() {
        return Roles;
    }

    public void setRoles(List<AuthRole> roles) {
        this.Roles = roles;
    }

    public Date getExpired() {
        return Expired;
    }

    public void setExpired(Date expired) {
        this.Expired = expired;
    }

    public String getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.DepartmentId = departmentId;
    }

    public String getAuthToken() {
        return AuthToken;
    }

    public void setAuthToken(String authToken) {
        this.AuthToken = authToken;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        this.CompanyName = companyName;
    }

    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String companyId) {
        this.CompanyId = companyId;
    }
}