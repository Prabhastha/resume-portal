package io.portfolio.resumeportal;

import io.portfolio.resumeportal.models.Job;
import io.portfolio.resumeportal.models.SecurityUser;
import io.portfolio.resumeportal.models.UserProfile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class ResumePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumePortalApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository users, UserProfileRepository userProfileRepository) {
        return args -> {
            users.save(new SecurityUser(1, "foo", "foo", true, "USER"));
            Job job1 = new Job(1,"Company1","Designation", LocalDate.of(2020,01,01),LocalDate.of(2020,03,01));
            Job job2 = new Job(2,"Company2","Designation", LocalDate.of(2021,01,01),LocalDate.of(2021,03,01));
            List<Job> jobs = new ArrayList<>();
            jobs.clear();
            jobs.add(job1);
            jobs.add(job2);
            userProfileRepository.save(new UserProfile(1,"malinga",1,"This is my one and only profile","malinga","lanka","mlanka@gmail.com","072345645","designation", jobs));

            //users.save(new SecurityUser("admin",encoder.encode("password"),"ROLE_USER,ROLE_ADMIN"));
        };
}}
