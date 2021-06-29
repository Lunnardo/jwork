package lunnardosoekarnolukias.jwork.controller;

import lunnardosoekarnolukias.jwork.DatabaseJobseekerPostgre;
import lunnardosoekarnolukias.jwork.Jobseeker;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class ini berfungsi untuk mengatur segala request atau end point
 * yang berkaitan dengan isi dari database jobseeker
 *
 * @author Lunnardo Soekarno Lukias
 * @version 2021.01.alpha
 */
@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {
    /**
     * Method ini berfungsi untuk menampilkan seluruh isi database jobseeker
     *
     * @return Semua isi dari database jobseeker
     */
    @RequestMapping("")
    public String indexPage(@RequestParam(value = "name", defaultValue = "world") String name) {
        return "Hello " + name;
    }

    /**
     * Method ini berfungsi untuk menampilkan informasi mengenai seorang jobseeker berdasarkan idnya
     *
     * @return informasi mengenai seorang jobseeker berdasarkan idnya
     */
    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        Jobseeker jobseeker = null;
        jobseeker = DatabaseJobseekerPostgre.getJobseekerById(id);
        return jobseeker;
    }

    /**
     * Method ini berfungsi untuk mendaftarkan seorang jobseeker baru dengan memasukkan parameter berikut:
     * @param name bernilai String merupakan nama dari jobseeker tersebut
     * @param email bernilai String merupakan email dari jobseeker tersebut digunakan oleh jobseeker tersebut untuk mendaftar
     * @param password bernilai String merupakan password yang digunakan oleh jobseeker tersebut untuk mendaftar
     *
     * @return objek jobseeker baru dengan name, email, dan password sesuai yang didaftarkan serta tanggal ketika mendaftar
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value = "name") String name,
                                       @RequestParam(value = "email") String email,
                                       @RequestParam(value = "password") String password) {
        String regexEmail = "^[a-zA-Z0-9&*_~]+([\\.{1}]?[a-z]+)+@[a-z0-9]+([\\.]{1}[a-z]+)";
        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail = patternEmail.matcher(email);

        String regexPassword = "^.*(?=.*[a-z])|(?=.*[A-Z])|(?=.*\\d)[a-zA-Z\\d]{6,}.*$";
        Pattern patternPassword = Pattern.compile(regexPassword);
        Matcher matcherPassword = patternPassword.matcher(password);

        if(matcherEmail.matches() && matcherPassword.matches()) {
            Jobseeker jobseeker = new Jobseeker(DatabaseJobseekerPostgre.getLastJobseekerId() + 1,
                    name, email, password,
                    Calendar.getInstance().get(Calendar.YEAR) + 1,
                    Calendar.getInstance().get(Calendar.MONTH) + 2,
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1);
            DatabaseJobseekerPostgre.insertJobseeker(jobseeker);
            return jobseeker;
        }
        return null;
    }

    /**
     * Method ini berfungsi untuk menjalankan proses login dan memverifikasi identitas seorang jobseeker ketika ingin login ke dalam aplikasi
     * @param email bernilai String merupakan email dari jobseeker tersebut yang sudah didaftarkan
     * @param password bernilai String merupakan password yang digunakan oleh jobseeker tersebut yang sudah didaftarkan
     *
     * @return informasi mengeni email dan password jobseeker berdasarkan database
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value = "email") String email,
                                    @RequestParam(value = "password") String password) {
        return DatabaseJobseekerPostgre.getJobseekerLogin(email, password);
    }
}
