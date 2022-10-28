package com.ulas.gplacesproject.service.other;


import com.ulas.gplacesproject.interfaces.repository.other.PerformanceNotifyService;
import com.ulas.gplacesproject.model.entity.PerformanceNotifyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsNotifyServiceImpl implements PerformanceNotifyService {

    @Override
    public void notifyLatedMethod(PerformanceNotifyEntity performanceNotifyEntity) {
        //smsService.sendSmsToGsm(List.of("905555555555"), "message about delayed method");
    }
}
