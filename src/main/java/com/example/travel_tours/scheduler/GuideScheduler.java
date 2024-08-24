package com.example.travel_tours.scheduler;

import com.example.travel_tours.service.abstraction.GuideService;
import com.example.travel_tours.service.abstraction.TourService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GuideScheduler {
    private final GuideService guideService;

    @Scheduled(cron = "* * 1 * * *")
    @SchedulerLock(name = "updateGuide",lockAtLeastFor = "PT1M",lockAtMostFor = "PT3M")
    public void updateGuide(){
        guideService.updateGuideStatus();
    }

}
