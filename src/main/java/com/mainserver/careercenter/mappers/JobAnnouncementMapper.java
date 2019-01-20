package com.mainserver.careercenter.mappers;

import com.mainserver.careercenter.domain.JobAnnouncement;
import com.mainserver.careercenter.domain.Term;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobAnnouncementMapper implements RowMapper<JobAnnouncement> {

    @Override
    public JobAnnouncement mapRow(ResultSet resultSet, int i) throws SQLException {
        JobAnnouncement jobAnnouncement = new JobAnnouncement();
        jobAnnouncement.setId(resultSet.getInt("id"));
        jobAnnouncement.setTitle(resultSet.getString("title"));
        jobAnnouncement.setTerm(Term.valueOf(resultSet.getString("term")));
        jobAnnouncement.setStartDate(resultSet.getString("startDate"));
        jobAnnouncement.setLocation(resultSet.getString("location"));
        jobAnnouncement.setJobDescription(resultSet.getString("jobDescription"));
        jobAnnouncement.setJobResponsibilities(resultSet.getString("jobResponsibilities"));
        jobAnnouncement.setRequiredQualifications(resultSet.getString("requiredQualifications"));
        return jobAnnouncement;
    }
}
