package com.mainserver.careercenter.controllers;

import com.mainserver.careercenter.dao.FakeDao;
import com.mainserver.careercenter.domain.JobAnnouncement;
import com.mainserver.careercenter.dto.JobTitle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class CareerCenterController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("jobTitles", FakeDao.getJobTitlesStream());
        return modelAndView;
    }

    @RequestMapping(value = "/jobs/{jobId}", method = RequestMethod.GET)
    public ModelAndView getJobById(@PathVariable("jobId") int id) {
        ModelAndView modelAndView = new ModelAndView("job");
        modelAndView.addObject("jobTitles", FakeDao.getJobTitlesStream());
        modelAndView.addObject("jobAnnouncement", FakeDao.getJobAnnouncementByIdWithStream(id));
        return modelAndView;
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String postPage() {
        return "post";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String postNewJobAnnouncement(JobAnnouncement jobAnnouncement) {
        FakeDao.postNewJobAnnouncement(jobAnnouncement);
        return "post";
    }

}
