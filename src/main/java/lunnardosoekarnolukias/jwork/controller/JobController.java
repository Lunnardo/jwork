package lunnardosoekarnolukias.jwork.controller;

import lunnardosoekarnolukias.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class ini berfungsi untuk mengatur segala request atau end point
 * yang berkaitan dengan isi dari database job
 *
 * @author Lunnardo Soekarno Lukias
 * @version 2021.01.alpha
 */
@RequestMapping("/job")
@RestController
public class JobController {
    /**
     * Method ini berfungsi untuk menampilkan seluruh isi database job
     *
     * @return Semua isi dari database job
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Job> getAllJob() {
        return DatabaseJobPostgre.getJobDatabase();
    }

    /**
     * Method ini berfungsi untuk menampilkan isi dari suatu job berdasarkan idnya
     *
     * @return isi dari job sesuai idnya
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Job getJobById(@PathVariable int id) {
        Job job = null;
        job = DatabaseJobPostgre.getJobById(id);
        return job;
    }

    /**
     * Method ini berfungsi untuk menampilkan isi dari suatu job berdasarkan recruiter id
     * yang membuat job tersebut
     *
     * @return isi dari job sesuai recruiter id
     */
    @RequestMapping(value = "/recruiter/{recruiterId}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJobPostgre.getJobByRecruiter(recruiterId);
    }

    /**
     * Method ini berfungsi untuk menampilkan isi dari suatu job berdasarkan category pekerjaannya
     *
     * @return isi dari job sesuai category pekerjaannya
     */
    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJobPostgre.getJobByCategory(String.valueOf(category));
    }

    /**
     * Method ini berfungsi untuk membuat sebuah invoice baru dengan metode pembayaran bank payment
     * @param name bernilai String merupakan nama dari job atau pekerjaan
     * @param fee bernilai int merupakan biaya atau fee dari pekerjaan atau job tersebut
     * @param category merupakan objek Jobcategory yang berisi tentang kategori job atau pekerjaan
     * @param recruiterId bernilai int  merupakan id si penerima kerja atau recruiter
     * @throws JobSeekerNotFoundException ketika jobsekeer yang dimaksud tidak ada pada saat pembuatan invoice
     * @throws JobNotFoundException ketika job yang dimaksud tidak ada pada saat pembuatan invoice
     * @throws OngoingInvoiceAlreadyExistsException ketika ada invoice yang sama dan keduanya dalam keadaan OnGoing
     * @return invoice dengan metode pembayaran bank payment bila berhasil dibuat, jika gagal maka invoice akan null atau mengenai salah
     * satu exception
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value = "name") String name,
                      @RequestParam(value = "fee") int fee,
                      @RequestParam(value = "category") JobCategory category,
                      @RequestParam(value = "recruiterId") int recruiterId
    ) {
        Job job = null;
        job = new Job(DatabaseJobPostgre.getLastJobId() + 1, name, fee,
                DatabaseRecruiterPostgre.getRecruiterById(recruiterId), category);
        DatabaseJobPostgre.insertJob(job);
        return job;
    }

}
