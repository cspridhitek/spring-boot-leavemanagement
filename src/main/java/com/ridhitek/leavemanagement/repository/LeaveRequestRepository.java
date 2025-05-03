package com.ridhitek.leavemanagement.repository;

import com.ridhitek.leavemanagement.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
}
