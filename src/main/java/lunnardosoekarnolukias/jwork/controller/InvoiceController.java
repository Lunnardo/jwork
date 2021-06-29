package lunnardosoekarnolukias.jwork.controller;

import lunnardosoekarnolukias.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class ini berfungsi untuk mengatur segala request atau end point
 * yang berkaitan dengan isi dari database invoice
 *
 * @author Lunnardo Soekarno Lukias
 * @version 2021.01.alpha
 */
@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    /**
     * Method ini berfungsi untuk menampilkan seluruh isi database invoice
     *
     * @return Semua isi dari database invoice
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        ArrayList<Invoice>  invoice = null;

        invoice = DatabaseInvoice.getInvoiceDatabase();
        return invoice;
    }

    /**
     * Method ini berfungsi untuk menampilkan isi dari suatu invoice berdasarkan idnya
     * @throws InvoiceNotFoundException ketika invoice dengan id tersebut tidak ditemukan
     *
     * @return isi dari invoice sesuai idnya
     */
    @RequestMapping(value = "/{invoiceId}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int invoiceId) {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(invoiceId);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }
    /**
     * Method ini berfungsi untuk menampilkan isi dari suatu invoice berdasarkan id jobseeker yang mendaftar
     * @throws Exception ketika invoice yang didaftarkan dengan jobsekeer id tersebut tidak ada
     *
     * @return isi dari invoice sesuai jobseeker id
     */
    @RequestMapping(value = "/jobseeker/{jobseekerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByJobseekerId(@PathVariable int jobseekerId) {
        ArrayList<Invoice> invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceByJobseeker(jobseekerId);
        } catch (Exception error) {
            error.printStackTrace();
        }
        return invoice;
    }

    /**
     * Method ini berfungsi untuk menampilkan status invoice tersebut berdasarkan idnya
     * @throws InvoiceNotFoundException ketika invoice dengan id tersebut tidak ditemukan
     *
     * @return status dari invoice tersebut
     */
    @RequestMapping(value = "/invoiceStatus/{invoiceId}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable(value = "invoiceId") int invoiceId,
                                       @RequestParam(value = "status") InvoiceStatus status){
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(invoiceId);
            invoice.setInvoiceStatus(status);
            return invoice;
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }

    }
    /**
     * Method ini berfungsi untuk menghapus suatu invoice berdasarkan id invoice tersebut
     * @throws InvoiceNotFoundException ketika invoice dengan id tersebut tidak ditemukan
     *
     * @return memberitahu bahwa invoice tersebut telah berhasil dihapus
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(@PathVariable int id) {
        try {
            DatabaseInvoice.removeInvoice(id);
            return true;
        } catch (InvoiceNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method ini berfungsi untuk membuat sebuah invoice baru dengan metode pembayaran bank payment
     * @param jobIdList bernilai ArrayList<Integer> menampilkan informasi mengenai job tersebut
     * @param jobseekerId bernilai int merupakan id dari jobseeker atau pencari kerja yang mendaftar pekerjaan atau job tersebut
     * @param adminFee bernilai int merupakan biaya admin yang harus dibayarkan si pencari kerja atau jobseeker
     * @throws JobSeekerNotFoundException ketika jobsekeer yang dimaksud tidak ada pada saat pembuatan invoice
     * @throws JobNotFoundException ketika job yang dimaksud tidak ada pada saat pembuatan invoice
     * @throws OngoingInvoiceAlreadyExistsException ketika ada invoice yang sama dan keduanya dalam keadaan OnGoing
     * @return invoice dengan metode pembayaran bank payment bila berhasil dibuat, jika gagal maka invoice akan null atau mengenai salah
     * satu exception
     */
    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(
            @RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
            @RequestParam(value = "jobseekerId") int jobseekerId,
            @RequestParam(value = "adminFee") int adminFee

    ) throws JobSeekerNotFoundException, JobNotFoundException {
        Invoice invoice = null;
        ArrayList<Job> jobs = new ArrayList<>();
        for (Integer integer : jobIdList) {
            jobs.add(DatabaseJobPostgre.getJobById(integer));
        }
        invoice = new BankPayment(DatabaseInvoice.getLastId() + 1, jobs, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId), adminFee);
        invoice.setTotalFee();
        boolean status = false;
        try {
            status = DatabaseInvoice.addInvoice(invoice);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }
        return status ? invoice : null;
    }

    /**
     * Method ini berfungsi untuk membuat sebuah invoice baru dengan metode pembayaran e-wallet payment
     * @throws OngoingInvoiceAlreadyExistsException ketika ada invoice yang sama dan keduanya dalam keadaan OnGoing
     * @param jobIdList bernilai ArrayList<Integer> menampilkan informasi mengenai job tersebut
     * @param jobseekerId bernilai int merupakan id dari jobseeker atau pencari kerja yang mendaftar pekerjaan atau job tersebut
     * @param referralCode bernilai String merupakan referralCode yang dimasukkan oleh pencari kerja atau jobseeker
     * @return invoice dengan metode pembayaran e-wallet payment bila berhasil dibuat,
     * jika gagal maka invoice akan null atau mengenai OngoingInvoice exception
     */
    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value="jobIdList")ArrayList<Integer> jobIdList,
                                     @RequestParam(value="jobseekerId") int jobseekerId,
                                     @RequestParam(value="referralCode", defaultValue="None") String referralCode) throws JobNotFoundException, JobSeekerNotFoundException, BonusNotFoundException {
        System.out.println(jobIdList);
        EwalletPayment wallet = null;
        ArrayList<Job> jobs = new ArrayList<Job>();
        for(int id : jobIdList)
        {
            jobs.add(DatabaseJobPostgre.getJobById(id));
        }

        wallet = new EwalletPayment(DatabaseInvoice.getLastId() + 1, jobs,
                DatabaseJobseekerPostgre.getJobseekerById(jobseekerId),
                DatabaseBonusPostgre.getBonusByReferralCode(referralCode));
        wallet.setTotalFee();

        try {
            DatabaseInvoice.addInvoice(wallet);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
            return null;
        }

        return wallet;
    }
}

