package com.example.clinic.repository;

import com.example.clinic.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ClinicRepository {
    private final JdbcTemplate jdbc;
    public ClinicRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    public List<Doctor> doctors() {
        return jdbc.query("SELECT * FROM doctors ORDER BY name", (r,n) ->
            new Doctor(r.getLong("id"), r.getString("name"), r.getString("specialization"), r.getString("phone")));
    }

    public List<Patient> patients() {
        return jdbc.query("SELECT * FROM patients ORDER BY name", (r,n) ->
            new Patient(r.getLong("id"), r.getString("name"), r.getString("email"),
                        r.getString("phone"), r.getInt("age")));
    }

    public void addPatient(Patient p) {
        jdbc.update("INSERT INTO patients(name,email,phone,age) VALUES(?,?,?,?)",
                p.getName(), p.getEmail(), p.getPhone(), p.getAge());
    }

    public void addAppointment(Appointment a) {
        jdbc.update(""" 
            INSERT INTO appointments(doctor_id,patient_id,appointment_date,appointment_time,reason,status)
            VALUES(?,?,?,?,?, 'BOOKED')
            """, a.getDoctorId(), a.getPatientId(), a.getAppointmentDate(),
                a.getAppointmentTime(), a.getReason());
    }

    public List<Appointment> appointments() {
        return jdbc.query("""
            SELECT a.id,a.doctor_id,d.name doctor_name,a.patient_id,p.name patient_name,
                   a.appointment_date,a.appointment_time,a.reason,a.status
            FROM appointments a
            JOIN doctors d ON d.id=a.doctor_id
            JOIN patients p ON p.id=a.patient_id
            ORDER BY a.appointment_date DESC,a.appointment_time DESC
            """, (r,n) -> new Appointment(
                r.getLong("id"), r.getLong("doctor_id"), r.getString("doctor_name"),
                r.getLong("patient_id"), r.getString("patient_name"),
                r.getString("appointment_date"), r.getString("appointment_time"),
                r.getString("reason"), r.getString("status")));
    }

    public boolean updateStatus(Long id, String status) {
        return jdbc.update("UPDATE appointments SET status=? WHERE id=?", status, id) > 0;
    }

    public boolean deleteAppointment(Long id) {
        return jdbc.update("DELETE FROM appointments WHERE id=?", id) > 0;
    }
}
