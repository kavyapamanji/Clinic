package com.example.clinic.controller;

import com.example.clinic.model.*;
import com.example.clinic.service.ClinicService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicController {
    private final ClinicService service;
    public ClinicController(ClinicService service){this.service=service;}

    @GetMapping("/doctors") public List<Doctor> doctors(){return service.doctors();}
    @GetMapping("/patients") public List<Patient> patients(){return service.patients();}
    @GetMapping("/appointments") public List<Appointment> appointments(){return service.appointments();}

    @PostMapping("/patients")
    public ResponseEntity<Void> addPatient(@RequestBody Patient p){
        service.addPatient(p); return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/appointments")
    public ResponseEntity<Void> book(@RequestBody Appointment a){
        service.book(a); return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/appointments/{id}/status")
    public ResponseEntity<Void> status(@PathVariable Long id,@RequestBody Map<String,String> body){
        return service.status(id, body.get("status"))
                ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id){
        return service.cancel(id)
                ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
