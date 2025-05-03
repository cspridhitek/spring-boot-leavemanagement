package com.ridhitek.leavemanagement.service;


import com.ridhitek.leavemanagement.entity.LeaveRequest;
import com.ridhitek.leavemanagement.constants.LeaveRequestStatus;
import com.ridhitek.leavemanagement.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        leaveRequest.setStatus(LeaveRequestStatus.PENDING);
        return leaveRequestRepository.save(leaveRequest);
    }

    public LeaveRequest approveLeaveRequest(Long leaveRequestId) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(leaveRequestId)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));
        leaveRequest.setStatus(LeaveRequestStatus.APPROVED);
        return leaveRequestRepository.save(leaveRequest);
    }

    public LeaveRequest rejectLeaveRequest(Long leaveRequestId) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(leaveRequestId)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));
        leaveRequest.setStatus(LeaveRequestStatus.REJECTED);
        return leaveRequestRepository.save(leaveRequest);
    }

    public LeaveRequest cancelLeaveRequest(Long leaveRequestId) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(leaveRequestId)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));
        leaveRequest.setStatus(LeaveRequestStatus.CANCELLED);
        return leaveRequestRepository.save(leaveRequest);
    }
}

