package com.example.Leave.Management.System.Leave;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.Leave.Management.System.user.User;

@Entity
@Table(
    name = "leaves"
    )
public class Leave {

    @Id
    @SequenceGenerator(
        name = "leaves_sequence",
        sequenceName = "leaves_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "leaves_sequence"
    )

    @Column(
        name = "id",
        updatable = false
    )
    private Long id;
    
    @Column(
        nullable = false
    )
    private String type;
    
    @Column(
        nullable = false
    )
    private String startDate;
    
    @Column(
        nullable = false
    )
    private String endDate;
    
    @Column(
        nullable = false
    )
    private String description;
    
    @Column(
        nullable = false
    )
    private LeaveStatus status;
    
    @Column(
        nullable = false
    )
    private String reasonOfReject;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    
    private User userId;

    @ManyToOne
    @JoinColumn(name = "user_result_id", referencedColumnName = "id")
    
    private User mangerId;

    public Leave() {
    }

    public Leave(Long id, String type, String startDate, String endDate, String description, LeaveStatus status, String reasonOfReject, User userId, User mangerId) {
        this.id = id;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.status = status;
        this.reasonOfReject = reasonOfReject;
        this.userId = userId;
        this.mangerId = mangerId;
    }

    public Leave(String type, String startDate, String endDate, String description, LeaveStatus status, String reasonOfReject, User userId, User mangerId) {
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.status = status;
        this.reasonOfReject = reasonOfReject;
        this.userId = userId;
        this.mangerId = mangerId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LeaveStatus getStatus() {
        return this.status;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }

    public String getReasonOfReject() {
        return this.reasonOfReject;
    }

    public void setReasonOfReject(String reasonOfReject) {
        this.reasonOfReject = reasonOfReject;
    }

    public User getUserId() {
        return this.userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public User getmangerId() {
        return this.mangerId;
    }

    public void setmangerId(User mangerId) {
        this.mangerId = mangerId;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", type='" + getType() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", description='" + getDescription() + "'" +
            ", status='" + getStatus() + "'" +
            ", reasonOfReject='" + getReasonOfReject() + "'" +
            ", userId='" + getUserId() + "'" +
            ", mangerId='" + getmangerId() + "'" +
            "}";
    }

}
