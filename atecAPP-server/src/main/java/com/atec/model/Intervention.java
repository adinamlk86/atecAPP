package com.atec.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Intervention {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "intervention_seq_gen")
    @SequenceGenerator(name = "intervention_seq_gen",
                       sequenceName = "intervention_sequence", allocationSize = 1)
    private Long id;

    @Column(name="register_date")
    @Temporal(TemporalType.DATE)
    private Date registerDate;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="notice_id")
    private Notice notice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }
}
