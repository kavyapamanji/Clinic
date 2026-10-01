package com.example.clinic.model;

public class Appointment {
    private Long id;
    private Long doctorId;
    private String doctorName;
    private Long patientId;
    private String patientName;
    private String appointmentDate;
    private String appointmentTime;
    private String reason;
    private String status;

    public Appointment() {}

    public Appointment(Long id, Long doctorId, String doctorName, Long patientId,
                        String patientName, String appointmentDate, String appointmentTime,
                        String reason, String status) {
        this.id=id; this.doctorId=doctorId; this.doctorName=doctorName;
        this.patientId=patientId; this.patientName=patientName;
        this.appointmentDate=appointmentDate; this.appointmentTime=appointmentTime;
        this.reason=reason; this.status=status;
    }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Long getDoctorId(){return doctorId;} public void setDoctorId(Long v){doctorId=v;}
    public String getDoctorName(){return doctorName;} public void setDoctorName(String v){doctorName=v;}
    public Long getPatientId(){return patientId;} public void setPatientId(Long v){patientId=v;}
    public String getPatientName(){return patientName;} public void setPatientName(String v){patientName=v;}
    public String getAppointmentDate(){return appointmentDate;} public void setAppointmentDate(String v){appointmentDate=v;}
    public String getAppointmentTime(){return appointmentTime;} public void setAppointmentTime(String v){appointmentTime=v;}
    public String getReason(){return reason;} public void setReason(String v){reason=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
