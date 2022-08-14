package com.example.Leave.Management.System.Leave;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    public List<Leave> getLeaves(){
        return leaveRepository.findAll();
    }

    public void addNewLeave(Leave leave) {
        leaveRepository.save(leave);
    }

    public void deleteLeaves(Long id){
        Boolean exists = leaveRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Leave id = " +id + " does not exists");
        }
        leaveRepository.deleteById(id);
    }

    @Transactional
    public void aprroveLeave(Long id){
            Leave leave = leaveRepository.findById(id).orElseThrow(()->{
                throw new IllegalStateException("Leave id = " +id + " does not exists");
            });
            leave.setStatus(LeaveStatus.APPROVED);
    }

    @Transactional
    public void rejectLeave(Long id, String reasonOfReject){
            Leave leave = leaveRepository.findById(id).orElseThrow(()->{
                throw new IllegalStateException("Leave id = " +id + " does not exists");
            });
            leave.setStatus(LeaveStatus.REJECTED);
            if (
                reasonOfReject != null&&
                reasonOfReject.length()>0&&
                !Objects.equals(reasonOfReject, leave.getReasonOfReject())
                ) {
                    leave.setReasonOfReject(reasonOfReject);
            }
            else{
                throw new IllegalStateException("status does not currect");
            }

    }
    // @Transactional
    // public void updateLeaves(Long id, String status, String reasonOfReject){
    //         Leave leave = leaveRepository.findById(id).orElseThrow(()->{
    //             throw new IllegalStateException("Leave id = " +id + " does not exists");
    //         });
            // if (
            //     status != null&&
            //     status.length()>0&&
            //     !Objects.equals(status, leave.getStatus())
            //     ) {
            //         leave.setStatus(LeaveStatus.APPROVED);
            // }
            // else{
            //     throw new IllegalStateException("status does not currect");
            // }

    // }
}
