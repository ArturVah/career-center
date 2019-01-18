package com.mainserver.careercenter.dao;

import com.mainserver.careercenter.domain.JobAnnouncement;
import com.mainserver.careercenter.domain.Term;
import com.mainserver.careercenter.dto.JobTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FakeDao {

    private static final List<JobAnnouncement> jobAnnouncements = new ArrayList<>();

//    static {
//        for (int i = 1; i <= 10; i++) {
//            JobAnnouncement jobAnnouncement = new JobAnnouncement();
//            jobAnnouncement.setTitle("Job title " + i);
//            jobAnnouncement.setLocation("Location " + i);
//            jobAnnouncement.setJobDescription("Job description " + i);
//            jobAnnouncement.setJobResponsibilities("Job responsibilities " + i);
//            jobAnnouncement.setRequiredQualifications("Required qualifications " + i);
//            jobAnnouncement.setStartDate("ASAP");
//            jobAnnouncement.setTerm(Term.values()[i % 3]);
//
//            jobAnnouncements.add(jobAnnouncement);
//        }
//    }

    public static void postNewJobAnnouncement(JobAnnouncement jobAnnouncement) {
        jobAnnouncements.add(jobAnnouncement);
    }

    /**
     * This method does exactly the same as {@link #getJobTitlesWithoutStream()} method,
     * but in a new fancy way
     */
    public static List<JobTitle> getJobTitlesStream() {
        return jobAnnouncements
                .stream()
                .filter(JobAnnouncement::isEnabled)
                .map(j -> new JobTitle(j.getId(), j.getTitle()))
                .collect(Collectors.toList());
    }

    /**
     * This method is the plain old implementation for getJobTitles method
     */
    @Deprecated
    public static List<JobTitle> getJobTitlesWithoutStream() {
        List<JobTitle> jobTitles = new ArrayList<>();
        for (JobAnnouncement jobAnnouncement : jobAnnouncements) {
            if(jobAnnouncement.isEnabled()) {
                jobTitles.add(new JobTitle(jobAnnouncement.getId(), jobAnnouncement.getTitle()));
            }
        }
        return jobTitles;
    }

    /**
     * This method does exactly the same as {@link #getJobAnnouncementByIdWithoutStream(int)}  method,
     * but in a new fancy way
     */
    public static JobAnnouncement getJobAnnouncementByIdWithStream(int id) {
        return jobAnnouncements
                .stream()
                .filter(JobAnnouncement::isEnabled)
                .filter(j -> j.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Find the JobAnnouncement by given ID
     */
    @Deprecated
    public static JobAnnouncement getJobAnnouncementByIdWithoutStream(int id) {
        for (JobAnnouncement jobAnnouncement : jobAnnouncements) {
            if (jobAnnouncement.getId() == id) {
                if(!jobAnnouncement.isEnabled()) {
                    break;
                }
                return jobAnnouncement;
            }
        }
        throw new IllegalArgumentException();
    }
}
