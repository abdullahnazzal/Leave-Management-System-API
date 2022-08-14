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
                                        "employee");
                        User abd = new User(
                                        "abd",
                                        "Abdullah",
                                        "Nazzal",
                                        "abd@gmail.com",
                                        "123",
                                        "employee");
                        User fadi = new User(
                                        "fadi",
                                        "fadi",
                                        "Nazzal",
                                        "fadi@gmail.com",
                                        "123",
                                        "manger");

                        Leave leave1 = new Leave(
                                        "sick leave",
                                        "2022-07-21T11:30",
                                        "2022-07-21T13:30",
                                        "I'm Sick",
                                        LeaveStatus.PENDING,
                                        "none",
                                        ali,
                                        fadi);

                        Leave leave2 = new Leave(
                                        "sick leave",
                                        "2022-07-21T11:30",
                                        "2022-07-21T13:30",
                                        "I'm Sick",
                                        LeaveStatus.APPROVED,
                                        "none",
                                        abd,
                                        fadi);

                        Leave leave3 = new Leave(
                                        "sick leave",
                                        "2022-07-21T11:30",
                                        "2022-07-21T13:30",
                                        "I'm Sick",
                                        LeaveStatus.REJECTED,
                                        "because this is the third in one weeks",
                                        ali,
                                        fadi);

                        studentRepository.saveAll(
                                        List.of(ali, abd, fadi));
                        leaveRepository.saveAll(List.of(leave1, leave2, leave3));
                };
        };
}