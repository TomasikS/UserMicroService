package com.example.springbootswagger2.model;

import io.swagger.annotations.ApiModelProperty;

public class User {
@ApiModelProperty(notes = "Name of the Student",name="name",required=true,value="test name")
	private String firstname;
	@ApiModelProperty(notes = "Class of the Student",name="cls",required=true,value="test class")
	private String lastname;
	@ApiModelProperty(notes = "Country of the Student",name="country",required=true,value="test country")
	private String role;
        @ApiModelProperty(notes = "Country of the Student",name="country",required=true,value="test country")
        private String address;
        @ApiModelProperty(notes = "Country of the Student",name="country",required=true,value="test country")
        private String contact;
        @ApiModelProperty(notes = "Country of the Student",name="country",required=true,value="test country")
        private String  login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        @ApiModelProperty(notes = "Country of the Student",name="country",required=true,value="test country")
        private String password;
        
        

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
        
        
    public User(String firstname, String lastname, String role, String address, String contact, String login,String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.address = address;
        this.contact = contact;
        this.login=login;
        this.password=password;
    }
	
	/*@Override
	public String toString() {
		return "Student [name=" + name + ", cls=" + cls + ", country=" + country + "]";
	}*/

}
