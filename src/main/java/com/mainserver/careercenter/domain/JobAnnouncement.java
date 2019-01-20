package com.mainserver.careercenter.domain;

public class JobAnnouncement {

    private static int announcementCount = 0;

    private int id;

    private String title;

    private String startDate;

    private Term term;

    private String location;

    private String jobDescription;

    private String jobResponsibilities;

    private String requiredQualifications;

    private boolean enabled;

    public JobAnnouncement() {
        this.id = ++announcementCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobResponsibilities() {
        return jobResponsibilities;
    }

    public void setJobResponsibilities(String jobResponsibilities) {
        this.jobResponsibilities = jobResponsibilities;
    }

    public String getRequiredQualifications() {
        return requiredQualifications;
    }

    public void setRequiredQualifications(String requiredQualifications) {
        this.requiredQualifications = requiredQualifications;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "JobAnnouncement{" +
                "title='" + title + '\'' +
                ", startDate='" + startDate + '\'' +
                ", term=" + term +
                ", location='" + location + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobResponsibilities='" + jobResponsibilities + '\'' +
                ", requiredQualifications='" + requiredQualifications + '\'' +
                '}';
    }
}