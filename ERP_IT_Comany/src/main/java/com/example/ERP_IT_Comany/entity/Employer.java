package com.example.ERP_IT_Comany.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String rang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
    @OneToMany(mappedBy = "assignee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> tickets_assignee;
    @OneToMany(mappedBy = "reporter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> tickets_reporters;
    private String gender;
    private String isStudent;
    private String lineManager;
    private String departmentName;
    private String employmentStatus;
    private Date startDate;
    private Date startDateInCompany;
    private Date serviceDate;
    private String homeCountry;
    private String currentLocation;
    private String homeOffice;
    private String workAt;
    private Date plannedBusinessTripEndDate;
    private Date plannedLeaveEndDate;
    private String workPhone;
    private String publicCellPhone;
    private String login;
    private String skype;
    private String currentAssignment;
    private String currentProjectRole;
    private String onSiteProjectManager;
    private String hashPassword;

    public String getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(String isStudent) {
        this.isStudent = isStudent;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public List<Ticket> getTickets_assignee() {
        return tickets_assignee;
    }

    public void setTickets_assignee(List<Ticket> tickets_assignee) {
        this.tickets_assignee = tickets_assignee;
    }

    public List<Ticket> getTickets_reporters() {
        return tickets_reporters;
    }

    public void setTickets_reporters(List<Ticket> tickets_reporters) {
        this.tickets_reporters = tickets_reporters;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String isStudent() {
        return isStudent;
    }

    public void setStudent(String student) {
        isStudent = student;
    }

    public String getLineManager() {
        return lineManager;
    }

    public void setLineManager(String lineManager) {
        this.lineManager = lineManager;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDateInCompany() {
        return startDateInCompany;
    }

    public void setStartDateInCompany(Date startDateInCompany) {
        this.startDateInCompany = startDateInCompany;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getHomeOffice() {
        return homeOffice;
    }

    public void setHomeOffice(String homeOffice) {
        this.homeOffice = homeOffice;
    }

    public String getWorkAt() {
        return workAt;
    }

    public void setWorkAt(String workAt) {
        this.workAt = workAt;
    }

    public Date getPlannedBusinessTripEndDate() {
        return plannedBusinessTripEndDate;
    }

    public void setPlannedBusinessTripEndDate(Date plannedBusinessTripEndDate) {
        this.plannedBusinessTripEndDate = plannedBusinessTripEndDate;
    }

    public Date getPlannedLeaveEndDate() {
        return plannedLeaveEndDate;
    }

    public void setPlannedLeaveEndDate(Date plannedLeaveEndDate) {
        this.plannedLeaveEndDate = plannedLeaveEndDate;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getPublicCellPhone() {
        return publicCellPhone;
    }

    public void setPublicCellPhone(String publicCellPhone) {
        this.publicCellPhone = publicCellPhone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getCurrentAssignment() {
        return currentAssignment;
    }

    public void setCurrentAssignment(String currentAssignment) {
        this.currentAssignment = currentAssignment;
    }

    public String getCurrentProjectRole() {
        return currentProjectRole;
    }

    public void setCurrentProjectRole(String currentProjectRole) {
        this.currentProjectRole = currentProjectRole;
    }

    public String getOnSiteProjectManager() {
        return onSiteProjectManager;
    }

    public void setOnSiteProjectManager(String onSiteProjectManager) {
        this.onSiteProjectManager = onSiteProjectManager;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
