package com.example.Leave.Management.System.user;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Leave.Management.System.Leave.Leave;
import com.example.Leave.Management.System.Leave.LeaveRepository;
import com.example.Leave.Management.System.Leave.LeaveStatus;

@Configuration
public class UserConfig {

        @Bean
        CommandLineRunner commandLineRunner(
                        UserRepository studentRepository,
                        LeaveRepository leaveRepository) {
                return args -> {
                        User ali = new User(
                                        "ali",
                                        "aliullah",
                                        "Nazzal",
                                        "ali@gmail.com",
                                        "123",
                                        "employee",
                                        "https://serving.photos.photobox.com/10741083072b82559ccfa3c1949fdd3da5af72aac5448160370738088ed7ec2423677975.jpg");
                        User abd = new User(
                                        "abd",
                                        "Abdullah",
                                        "Nazzal",
                                        "abd@gmail.com",
                                        "123",
                                        "employee",
                                        "https://serving.photos.photobox.com/8210625642e78afbc5a1ba910610e0b1d58e7c911122ed22dee0d05d190d3fe486f56a4b.jpg");
                        User fadi = new User(
                                        "fadi",
                                        "fadi",
                                        "Nazzal",
                                        "fadi@gmail.com",
                                        "123",
                                        "manger",
                                        "https://serving.photos.photobox.com/479975955d737689de23f6e10f72e16144619551e5a1c74d23d9a83cd8ad36f442a0e8b2.jpg");

                        Leave leave1 = new Leave(
                                        "sick leave",
                                        "2022-01-21T11:30",
                                        "2022-01-21T13:30",
                                        "I'm Sick",
                                        LeaveStatus.PENDING,
                                        "none",
                                        ali,
                                        null);

                        Leave leave2 = new Leave(
                                        "sick leave",
                                        "2022-02-21T11:30",
                                        "2022-02-21T13:30",
                                        "I'm Sick",
                                        LeaveStatus.APPROVED,
                                        "none",
                                        abd,
                                        fadi);

                        Leave leave3 = new Leave(
                                        "sick leave",
                                        "2022-03-21T11:30",
                                        "2022-03-21T13:30",
                                        "I'm Sick",
                                        LeaveStatus.REJECTED,
                                        "because this is the third in one weeks",
                                        ali,
                                        fadi);
                        Leave leave4 = new Leave(
                                        "sick leave",
                                        "2022-04-21T11:30",
                                        "2022-04-21T13:30",
                                        "I'm Sick",
                                        LeaveStatus.PENDING,
                                        "because this is the third in one weeks",
                                        ali,
                                        null);
                        Leave leave5 = new Leave(
                                        "sick leave",
                                        "2022-05-21T11:30",
                                        "2022-05-21T13:30",
                                        "I'm Sick",
                                        LeaveStatus.PENDING,
                                        "because this is the third in one weeks",
                                        ali,
                                        null);

                        studentRepository.saveAll(
                                        List.of(ali, abd, fadi));
                        leaveRepository.saveAll(List.of(leave1, leave2, leave3, leave4, leave5));
                };
        };
}