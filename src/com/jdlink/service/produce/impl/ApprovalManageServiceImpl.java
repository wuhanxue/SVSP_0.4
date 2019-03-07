package com.jdlink.service.produce.impl;

import com.jdlink.domain.Approval.ApprovalProcess;
import com.jdlink.mapper.produce.ApprovalManageMapper;
import com.jdlink.service.produce.ApprovalManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalManageServiceImpl implements ApprovalManageService {

    @Autowired
    ApprovalManageMapper approvalManageMapper;

    @Override
    public List<ApprovalProcess> search(ApprovalProcess approvalProcess){ return approvalManageMapper.search(approvalProcess); }

    @Override
    public int searchTotal(ApprovalProcess approvalProcess) { return approvalManageMapper.searchTotal(approvalProcess); }
}
