package com.atec.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "notice_seq_gen")
    @SequenceGenerator(name = "notice_seq_gen",
            sequenceName = "notice_sequence", allocationSize = 1)
    private Long id;

    @Column(name="register_date")
    @Temporal(TemporalType.DATE)
    private Date registerDate;

    @Column(name="status")
    private String status;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="equipment_id")
    private Equipment equipment;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
