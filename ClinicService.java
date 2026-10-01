package com.example.clinic.service;

import com.example.clinic.model.*;
import com.example.clinic.repository.ClinicRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClinicService {
    private final ClinicRepository repo;
    public ClinicService(ClinicRepository repo) { this.repo = repo; }

    public List<Doctor> doctors(){ return repo.doctors(); }
    public List<Patient> patients(){ return repo.patients(); }
    public List<Appointment> appointments(){ return repo.appointments(); }
    public void addPatient(Patient p){ repo.addPatient(p); }
    public void book(Appointment a){ repo.addAppointment(a); }
    public boolean status(Long id,String status){ return repo.updateStatus(id,status); }
    public boolean cancel(Long id){ return repo.deleteAppointment(id); }
}
