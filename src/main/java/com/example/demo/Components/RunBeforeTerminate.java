package com.example.demo.Components;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@DependsOn("redisConnectionFactory")
public class RunBeforeTerminate {
    private final CacheManager cacheManager;

    @Autowired
    public RunBeforeTerminate(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }   

    @EventListener(ContextClosedEvent.class)
    public void clearAllCaches() {
        if (cacheManager != null) {
            cacheManager.getCacheNames().forEach(cacheName -> {
                Cache cache = cacheManager.getCache(cacheName);
                if (cache != null) {
                    cache.clear();
                    log.info("Cleared cache: {}", cacheName);
                }
            });
            log.info("All caches cleared on application shutdown.");
        }
    }
}
