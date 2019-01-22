package com.mainserver.careercenter.dao;

import com.mainserver.careercenter.domain.JobAnnouncement;
import com.mainserver.careercenter.dto.JobTitle;
import com.mainserver.careercenter.mappers.JobAnnouncementMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JobAnnouncementDao {

    private final JdbcTemplate jdbcTemplate;
    private final JobAnnouncementMapper jobAnnouncementMapper;

    public JobAnnouncementDao(JdbcTemplate jdbcTemplate, JobAnnouncementMapper jobAnnouncementMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.jobAnnouncementMapper = jobAnnouncementMapper;
    }

    public void postNewJobAnnouncement(JobAnnouncement jobAnnouncement) {
        String sql = "INSERT INTO " +
                "job_announcement(" +
                "title, " +
                "jobDescription, " +
                "jobResponsibilities, " +
                "location, " +
                "requiredQualifications, " +
                "startDate, " +
                "term, " +
                "enabled" +
                ") " +
                "VALUES(?,?,?,?,?,?,?,?)";

        Object[] params = {
                jobAnnouncement.getTitle(),
                jobAnnouncement.getJobDescription(),
                jobAnnouncement.getJobResponsibilities(),
                jobAnnouncement.getLocation(),
                jobAnnouncement.getRequiredQualifications(),
                jobAnnouncement.getStartDate(),
                jobAnnouncement.getTerm().name(),
                jobAnnouncement.isEnabled(),
        };
        jdbcTemplate.update(sql, params);
    }

    /**
     * This method does exactly the same as {@link #getJobTitlesWithoutStream()} method,
     * but in a new fancy way
     */
    public List<JobTitle> getJobTitlesStream() {
        List<JobAnnouncement> jobAnnouncements = jdbcTemplate
                .query("SELECT * FROM job_announcement j WHERE j.enabled = TRUE",
                        jobAnnouncementMapper
                );

        return jobAnnouncements
                .stream()
                .map(j -> new JobTitle(j.getId(), j.getTitle()))
                .collect(Collectors.toList());
    }

    /**
     * This method is the plain old implementation for getJobTitles method
     */
    @Deprecated
    public List<JobTitle> getJobTitlesWithoutStream() {
        List<JobAnnouncement> jobAnnouncements = jdbcTemplate
                .query("SELECT * FROM job_announcement j WHERE j.enabled = TRUE",
                        jobAnnouncementMapper
                );
        List<JobTitle> jobTitles = new ArrayList<>();
        for (JobAnnouncement jobAnnouncement : jobAnnouncements) {
            if (jobAnnouncement.isEnabled()) {
                jobTitles.add(new JobTitle(jobAnnouncement.getId(), jobAnnouncement.getTitle()));
            }
        }
        return jobTitles;
    }

    /**
     * Find the JobAnnouncement by given ID
     */
    public JobAnnouncement getJobAnnouncementByIdWithStream(int id) {
        return jdbcTemplate
                .queryForObject(
                        "SELECT * FROM job_announcement j WHERE j.enabled = TRUE AND j.id=?",
                        jobAnnouncementMapper,
                        id
                );
    }

}