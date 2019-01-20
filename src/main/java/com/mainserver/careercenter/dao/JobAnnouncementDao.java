package com.mainserver.careercenter.dao;

import com.mainserver.careercenter.domain.JobAnnouncement;
import com.mainserver.careercenter.dto.JobTitle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JobAnnouncementDao {

    private SessionFactory sessionFactory = getSessionFactory();

    @PostConstruct
    private SessionFactory getSessionFactory() {
        return new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public void postNewJobAnnouncement(JobAnnouncement jobAnnouncement) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(jobAnnouncement);
        session.getTransaction().commit();
    }

    /**
     * This method does exactly the same as {@link #getJobTitlesWithoutStream()} method,
     * but in a new fancy way
     */
    public List<JobTitle> getJobTitlesStream() {
        Session session = sessionFactory.openSession();
        Query<JobAnnouncement> query = session.createQuery("from JobAnnouncement j where j.enabled = true", JobAnnouncement.class);
        List<JobAnnouncement> jobAnnouncements = query.getResultList();

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
        Session session = sessionFactory.openSession();
        Query<JobAnnouncement> query = session.createQuery("from JobAnnouncement j where j.enabled = true", JobAnnouncement.class);
        List<JobAnnouncement> jobAnnouncements = query.getResultList();

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
        Session session = sessionFactory.openSession();
        Query<JobAnnouncement> query = session.createQuery("from JobAnnouncement j where j.id=:id and j.enabled = true", JobAnnouncement.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

}
