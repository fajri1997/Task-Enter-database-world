package com.example.pgAdmin.entity;




import jakarta.persistence.*;


@Entity
public class UserEntity {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String firstName;
    String lastName;


//    @Enumerated(EnumType.STRING)
private  String status;
    public UserEntity(Long id, String name, String firstName, String lastName, String status) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    public UserEntity() {

    }

    public Long getId() {
        return id;
    }
     public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                '}';
    }
}
