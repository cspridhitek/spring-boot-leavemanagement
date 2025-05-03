package com.ridhitek.leavemanagement.controller;


import com.ridhitek.leavemanagement.entity.LeaveRequest;
import com.ridhitek.leavemanagement.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leave")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping("/request")
    public LeaveRequest createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return leaveRequestService.createLeaveRequest(leaveRequest);
    }

    @PatchMapping("/approve/{id}")
    public LeaveRequest approveLeaveRequest(@PathVariable Long id) {
        return leaveRequestService.approveLeaveRequest(id);
    }

    @PatchMapping("/reject/{id}")
    public LeaveRequest rejectLeaveRequest(@PathVariable Long id) {
        return leaveRequestService.rejectLeaveRequest(id);
    }

    @PatchMapping("/cancel/{id}")
    public LeaveRequest cancelLeaveRequest(@PathVariable Long id) {
        return leaveRequestService.cancelLeaveRequest(id);
    }
}

