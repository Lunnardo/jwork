package lunnardosoekarnolukias.jwork.controller;

import lunnardosoekarnolukias.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static lunnardosoekarnolukias.jwork.DatabaseJobseeker.getJobseekerLogin;

@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {


    @RequestMapping("")
    public String indexPage(@RequestParam(value = "name", defaultValue = "world") String name) {
        return "Hello " + name;
    }

    @RequestMapping("/all")
    public ArrayList<Jobseeker> getAllJobseeker() {
        ArrayList<Jobseeker> jobseeker = null;

        jobseeker = DatabaseJobseeker.getDatabaseJobseeker();
        return jobseeker;
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

    ///test123
}
