package com.example.Leave.Management.System.Leave;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Leave.Management.System.user.User;

@RestController
@RequestMapping(path = "api/v1/leave")
public class LeaveController {

    private final LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    // EndPoint For Get All Leave
    // http://localhost:8080/api/v1/leave
    @GetMapping(path = "/all")
    public List<Leave> getLeaves() {
        return leaveService.getLeaves();
    }

    // EndPoint For Get All Leave
    // http://localhost:8080/api/v1/leave?userId=1
    @GetMapping
    public List<Leave> getLeavesByUserId(@RequestParam(required = true) Integer userId) {
        return leaveService.getLeavesByUserId(userId);
    }

    // EndPoint For Get All Leave By Filter
    // http://localhost:8080/api/v1/leave/?status=APPROVED
    @GetMapping(path = "/")
    public List<Leave> getLeavesByStatus(
        @RequestParam(name = "status",required = false) Integer status,
        @RequestParam(name = "userId",required = false) Integer userId
        )
        {
        return leaveService.getLeavesByStatus(userId,status);
    }

    // EndPoint For Create New Leave
    // http://localhost:8080/api/v1/leave + Body{Leave}
    @PostMapping
    public Leave addNewLeave(@RequestBody Leave leave) {
        return leaveService.addNewLeave(leave);
    }

    // EndPoint For Delete Leave
    // http://localhost:8080/api/v1/leave/1
    @DeleteMapping(path = "{leaveId}")
    public void deleteLeaves(@PathVariable("leaveId") Long id) {
        leaveService.deleteLeaves(id);
    }
    // EndPoint For approve Leave
    // http://localhost:8080/api/v1/leave/1/ +Body{status, reasonOfReject}
    @PutMapping(path = "{leaveId}")
    public void updateLeave(
            @PathVariable("leaveId") Long id,
            @RequestBody BodyReq body
            
            // @RequestBody LeaveStatus status ,
            // @RequestBody String reasonOfReject
            ) {
        leaveService.updateLeave(id, body);
    }
    
    // EndPoint For approve Leave
    // http://localhost:8080/api/v1/leave/1/approve
    // @PutMapping(path = "{leaveId}/approve")
    // public void aprroveLeave(
    //         @PathVariable("leaveId") Long id) {
    //     leaveService.aprroveLeave(id);
    // }

    // EndPoint For reject Leave
    // http://localhost:8080/api/v1/leave/3/reject +Body{reasonOfReject}
    // @PutMapping(path = "{leaveId}/reject")
    // public void rejectLeave(
    //         @PathVariable("leaveId") Long id,
    //         @RequestBody String reasonOfReject) {
    //     leaveService.rejectLeave(id, reasonOfReject);
    // }

    // @PutMapping(path = "{leaveId}")
    // public void updateLeaves(
    // @PathVariable("leaveId") Long id,
    // @RequestParam(name = "status",required = false) String status,
    // @RequestParam(name = "reasonOfReject",required = false) String reasonOfReject
    // ){
    // leaveService.updateLeaves(id, status, reasonOfReject);
    // }
}
class BodyReq {
    LeaveStatus status ;
    String reasonOfReject;
    User mangerId;

    public BodyReq() {
    }

    public BodyReq(LeaveStatus status, String reasonOfReject, User mangerId) {
        this.status = status;
        this.reasonOfReject = reasonOfReject;
        this.mangerId = mangerId;
    }

    public BodyReq(LeaveStatus status, String reasonOfReject) {
        this.status = status;
        this.reasonOfReject = reasonOfReject;
    }

    public LeaveStatus getStatus() {
        return this.status;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }

    public String getReasonOfReject() {
        return this.reasonOfReject;
    }

    public void setReasonOfReject(String reasonOfReject) {
        this.reasonOfReject = reasonOfReject;
    }

    public User getMangerId() {
        return this.mangerId;
    }

    public void setMangerId(User mangerId) {
        this.mangerId = mangerId;
    }

}