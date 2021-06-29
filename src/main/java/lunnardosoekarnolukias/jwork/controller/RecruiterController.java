package lunnardosoekarnolukias.jwork.controller;

import lunnardosoekarnolukias.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class ini berfungsi untuk mengatur segala request atau end point
 * yang berkaitan dengan isi dari database recruiter
 *
 * @author Lunnardo Soekarno Lukias
 * @version 2021.01.alpha
 */
@RequestMapping("/recruiter")
@RestController
public class RecruiterController {

    /**
     * Method ini berfungsi untuk menampilkan seluruh isi database recruiter
     *
     * @return Semua isi dari database recruiter
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Recruiter> getAllRecruiter() {
        return DatabaseRecruiterPostgre.getRecruiterDatabase();
    }

    /**
     * Method ini berfungsi untuk menampilkan informasi mengenai seorang recruiter berdasarkan idnya
     *
     * @return informasi mengenai seorang recruiter berdasarkan idnya
     */
    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id) {
        Recruiter recruiter = null;
        recruiter = DatabaseRecruiterPostgre.getRecruiterById(id);
        return recruiter;
    }

    /**
     * Method ini berfungsi untuk memasukkan informasi seorang recruiter baru ke dalam database dengan memasukkan parameter berikut:
     * @param name bernilai String merupakan nama dari recruiter tersebut
     * @param email bernilai String merupakan email dari recruiter tersebut
     * @param phoneNumber bernilai String merupakan nomor telfon dari recruiter tersebut
     * @param province bernilai String merupakan provinsi lokasi temmpat kerja dari recruiter tersebut
     * @param description bernilai String merupakan deskripsi dari recruiter tersebut
     * @param city bernilai String merupakan kota lokasi temmpat kerja dari recruiter tersebut
     * @throws Exception ketika recruiter tersebut gagal ditambahkan
     * @return objek recruiter baru dengan name, email phonenumber, province, description, dan city yang ditambahkan
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "email") String email,
                                  @RequestParam(value = "phoneNumber") String phoneNumber,
                                  @RequestParam(value = "province") String province,
                                  @RequestParam(value = "description") String description,
                                  @RequestParam(value = "city") String city) {
        Recruiter recruiter = new Recruiter(DatabaseRecruiterPostgre.getLastRecruiterId() + 1,
                name, email, phoneNumber, new Location(DatabaseLocation.getLastLocationId(), province, city, description));

        try {
            DatabaseRecruiterPostgre.insertRecruiter(recruiter);
        } catch (Exception error) {
            error.printStackTrace();
            return null;
        }
        return recruiter;
    }

}
