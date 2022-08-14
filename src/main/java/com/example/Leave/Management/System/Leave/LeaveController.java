package com.example.Leave.Management.System.Leave;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/leave")
public class LeaveController {

    private final LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    // EndPoint For Get All Leave
    // http://localhost:8080/api/v1/leave
    @GetMapping
    public List<Leave> getLeaves() {
        return leaveService.getLeaves();
    }

    // EndPoint For Create New Leave
    // http://localhost:8080/api/v1/leave + Body{Leave}
    @PostMapping
    public void addNewLeave(@RequestBody Leave leave) {
        leaveService.addNewLeave(leave);
    }

    // EndPoint For Delete Leave
    // http://localhost:8080/api/v1/leave/1
    @DeleteMapping(path = "{leaveId}")
    public void deleteLeaves(@PathVariable("leaveId") Long id) {
        leaveService.deleteLeaves(id);
    }

    // EndPoint For approve Leave
    // http://localhost:8080/api/v1/leave/1/approve
    @PutMapping(path = "{leaveId}/approve")
    public void aprroveLeave(
            @PathVariable("leaveId") Long id) {
        leaveService.aprroveLeave(id);
    }

    // EndPoint For reject Leave
    // http://localhost:8080/api/v1/leave/3/reject +Body{reasonOfReject}
    @PutMapping(path = "{leaveId}/reject")
    public void rejectLeave(
            @PathVariable("leaveId") Long id,
            @RequestBody String reasonOfReject) {
        leaveService.rejectLeave(id, reasonOfReject);
    }

    // @PutMapping(path = "{leaveId}")
    // public void updateLeaves(
    // @PathVariable("leaveId") Long id,
    // @RequestParam(name = "status",required = false) String status,
    // @RequestParam(name = "reasonOfReject",required = false) String reasonOfReject
    // ){
    // leaveService.updateLeaves(id, status, reasonOfReject);
    // }
}
