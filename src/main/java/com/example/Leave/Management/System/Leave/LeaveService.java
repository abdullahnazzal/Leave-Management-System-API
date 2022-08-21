package com.example.Leave.Management.System.Leave;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    public List<Leave> getLeaves() {
        return leaveRepository.findAll();
    }

    public List<Leave> getLeavesByUserId(Integer userId) {
        return leaveRepository.findLeaveByUserId(userId);
    }

    public List<Leave> getLeavesByStatus(Integer userId, Integer status) {
        List<Leave> leaves= leaveRepository.findAllLeaveByStatus(userId, status);
        return leaves;
    }

    public Leave addNewLeave(Leave leave) {
        leaveRepository.saveAndFlush(leave);
        return leave;

    }

    public void deleteLeaves(Long id) {
        Boolean exists = leaveRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Leave id = " + id + " does not exists");
        }
        leaveRepository.deleteById(id);
    }

    @Transactional
    public void updateLeave(Long id, BodyReq bodyReq) {
        Leave leave = leaveRepository.findById(id).orElseThrow(() -> {
            throw new IllegalStateException("Leave id = " + id + " does not exists");
        });
        // Can Not Sent Status Without Manger
        if (bodyReq.status != null &&
                bodyReq.mangerId == null) {
            throw new IllegalStateException("mangerId Is Null");
            // Can Not Sent The Same Status
        } else if (bodyReq.status.toString() == leave.getStatus().toString()) {
            throw new IllegalStateException("Can Not Sent The Same status");
            // Can Not Sent Status APPROVED Without Manger Or With Reason
        } else if (bodyReq.status.toString() == LeaveStatus.APPROVED.toString() &&
                bodyReq.reasonOfReject != null) {
            throw new IllegalStateException("Can Not sent Reason with APPROVED");
            // Set Status To APPROVED And Set Manger To Manger
        } else if (bodyReq.status.toString() == LeaveStatus.APPROVED.toString()) {
            leave.setStatus(bodyReq.status);
            leave.setmangerId(bodyReq.mangerId);

            // Can Not Sent Status REJECTED Without Manger Or Reason
        } else if (bodyReq.status.toString() == LeaveStatus.REJECTED.toString() &&
                bodyReq.reasonOfReject == null) {
            throw new IllegalStateException("Can Not Sent Status REJECTED Without Reason");
            // Set Status To REJECTED, Set Reason Of Reject To reasonOfReject And Set Manger To Manger
        }else if (bodyReq.status.toString() == LeaveStatus.REJECTED.toString()) {
            leave.setStatus(bodyReq.status);
            leave.setReasonOfReject(bodyReq.reasonOfReject);
            leave.setmangerId(bodyReq.mangerId);
        } 
    }

    // @Transactional
    // public void aprroveLeave(Long id){
    // Leave leave = leaveRepository.findById(id).orElseThrow(()->{
    // throw new IllegalStateException("Leave id = " +id + " does not exists");
    // });
    // leave.setStatus(LeaveStatus.APPROVED);
    // }

    // @Transactional
    // public void rejectLeave(Long id, String reasonOfReject){
    // Leave leave = leaveRepository.findById(id).orElseThrow(()->{
    // throw new IllegalStateException("Leave id = " +id + " does not exists");
    // });
    // leave.setStatus(LeaveStatus.REJECTED);
    // if (
    // reasonOfReject != null&&
    // reasonOfReject.length()>0&&
    // !Objects.equals(reasonOfReject, leave.getReasonOfReject())
    // ) {
    // leave.setReasonOfReject(reasonOfReject);
    // }
    // else{
    // throw new IllegalStateException("status does not currect");
    // }
    // }

    // @Transactional
    // public void updateLeaves(Long id, String status, String reasonOfReject){
    // Leave leave = leaveRepository.findById(id).orElseThrow(()->{
    // throw new IllegalStateException("Leave id = " +id + " does not exists");
    // });
    // if (
    // status != null&&
    // status.length()>0&&
    // !Objects.equals(status, leave.getStatus())
    // ) {
    // leave.setStatus(LeaveStatus.APPROVED);
    // }
    // else{
    // throw new IllegalStateException("status does not currect");
    // }

    // }
}
