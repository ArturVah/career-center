package com.mainserver.careercenter.controllers;

import com.mainserver.careercenter.dao.JobAnnouncementDao;
import com.mainserver.careercenter.domain.JobAnnouncement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CareerCenterController {

    private final JobAnnouncementDao jobAnnouncementDao;

    public CareerCenterController(JobAnnouncementDao jobAnnouncementDao) {
        this.jobAnnouncementDao = jobAnnouncementDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("jobTitles", jobAnnouncementDao.getJobTitlesStream());
        return modelAndView;
    }

    @RequestMapping(value = "/jobs/{jobId}", method = RequestMethod.GET)
    public ModelAndView getJobById(@PathVariable("jobId") int id) {
        ModelAndView modelAndView = new ModelAndView("job");
        modelAndView.addObject("jobTitles", jobAnnouncementDao.getJobTitlesStream());
        modelAndView.addObject("jobAnnouncement", jobAnnouncementDao.getJobAnnouncementByIdWithStream(id));
        return modelAndView;
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String postPage() {
        return "post";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String postNewJobAnnouncement(JobAnnouncement jobAnnouncement) {
        jobAnnouncementDao.postNewJobAnnouncement(jobAnnouncement);
        return "post";
    }

}