package com.example.clinic.model;

public class Patient {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Integer age;

    public Patient() {}
    public Patient(Long id, String name, String email, String phone, Integer age) {
        this.id = id; this.name = name; this.email = email; this.phone = phone; this.age = age;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}
