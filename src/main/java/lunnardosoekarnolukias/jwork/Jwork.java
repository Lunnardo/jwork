package lunnardosoekarnolukias.jwork;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Jwork{
    public static void main(String[] args) throws EmailAlreadyExistsException, ReferralCodeAlreadyExistsException, JobNotFoundException, JobSeekerNotFoundException, RecruiterNotFoundException, BonusNotFoundException {
        Location location1 = new Location(1, "DKI Jakarta", "Depok", "Kota Lahir");
        Location location2 = new Location(2, "Jawa Barat", "Depok", "Kota Kerja");
        Location location3 = new Location(3,"Jawa Tengah", "Semarang", "Kota oleh oleh");

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Lonnardi", "lonnardi@ui.ac.id", "081212344321", location1));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Hansaka", "hansaka@ui.ac.id", "081212345678", location2));
       DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Bambang", "bambang@ui.ac.id", "081222334455", location3));

        DatabaseJob.addJob(new Job(14, "Backend Engineer",10000, DatabaseRecruiter.getRecruiterById(1), JobCategory.BackEnd));
        DatabaseJob.addJob(new Job(15, "Frontend Engineer",10000, DatabaseRecruiter.getRecruiterById(2),  JobCategory.FrontEnd));
        DatabaseJob.addJob(new Job(16, "UI Engineer", 10000, DatabaseRecruiter.getRecruiterById(2),  JobCategory.UI));
        DatabaseJob.addJob(new Job(17, "UI Engineer",10000,  DatabaseRecruiter.getRecruiterById(3), JobCategory.UI));


        SpringApplication.run(Jwork.class, args);
        System.out.println("Tugas Tambahan Modul 9");

        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Lunnardo Soekarno Lukias", "lunnardos@ui.ac.id", "lunnardo123"));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Lunnardo Soekarno", "lunnardo123@gmail.com", "123456"));
        ArrayList<Job> job1 = new ArrayList<Job>();
        ArrayList<Job> job2 = new ArrayList<Job>();


        try {
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId() + 1, "PROMO1", 10000, 5000,true));
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId() + 1, "PROMO1", 20000, 5000,true));
        } catch (ReferralCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseJob.getJobById(1);
        } catch (JobNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseJobseeker.getJobseekerById(5);
        }catch (JobSeekerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            DatabaseRecruiter.getRecruiterById(3);
        } catch (RecruiterNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseBonus.getBonusById(3);
        } catch (BonusNotFoundException bonusNotFound) {
            System.out.println(bonusNotFound.getMessage());
        }
        System.out.println("\n=========Database JobSeeker============");
        System.out.println(DatabaseJobseeker.getDatabaseJobseeker());

        System.out.println("\n=========Database Bonus===============");
        System.out.println(DatabaseBonus.getBonusDatabase());

        System.out.println(DatabaseInvoice.getInvoiceDatabase());
        System.out.println("\n");
        try {
            job1.add(new Job(1, "Backend Engineer",1000, DatabaseRecruiter.getRecruiterById(1),  JobCategory.BackEnd));
        }
        catch (RecruiterNotFoundException e) {
            e.printStackTrace();
        }
        try {
            job2.add(new Job(2, "Frontend Engineer",1000, DatabaseRecruiter.getRecruiterById(2),  JobCategory.FrontEnd));
        }
        catch (RecruiterNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(1, job1, DatabaseJobseeker.getJobseekerById(1)));
        }
        catch (JobSeekerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(2, job2, DatabaseJobseeker.getJobseekerById(2)));
        }
        catch (JobSeekerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(3, job1, DatabaseJobseeker.getJobseekerById(2)));
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(4, job1, DatabaseJobseeker.getJobseekerById(2)));
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseInvoice.addInvoice(new EwalletPayment(5, job2, DatabaseJobseeker.getJobseekerById(2)));
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        for (Invoice invoice: DatabaseInvoice.getInvoiceDatabase()){
            new Thread(new FeeCalculator(invoice)).start();
        }
    }
}