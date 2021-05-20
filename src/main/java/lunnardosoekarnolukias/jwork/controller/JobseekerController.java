package lunnardosoekarnolukias.jwork.controller;

import lunnardosoekarnolukias.jwork.DatabaseJobseeker;
import lunnardosoekarnolukias.jwork.EmailAlreadyExistsException;
import lunnardosoekarnolukias.jwork.JobSeekerNotFoundException;
import lunnardosoekarnolukias.jwork.Jobseeker;
import org.springframework.web.bind.annotation.*;

import static lunnardosoekarnolukias.jwork.DatabaseJobseeker.getJobseekerLogin;

@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    @RequestMapping("")
    public String indexPage(@RequestParam(value = "name", defaultValue = "world") String name) {
        return "Hello " + name;
    }

    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        Jobseeker jobseeker = null;
        try {
            jobseeker = DatabaseJobseeker.getJobseekerById(id);
        } catch (JobSeekerNotFoundException e) {
            e.getMessage();
            return null;
        }
        return jobseeker;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value = "email") String email,
                                    @RequestParam(value = "password") String password) {
        return (getJobseekerLogin(email, password));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value = "name") String name,
                                       @RequestParam(value = "email") String email,
                                       @RequestParam(value = "password") String password) {
        Jobseeker jobseeker = new Jobseeker(DatabaseJobseeker.getLastId() + 1, name, email, password);
        try {
            DatabaseJobseeker.addJobseeker(jobseeker);
        } catch (EmailAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        return jobseeker;
    }
}
