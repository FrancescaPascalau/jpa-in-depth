package com.francesca.pascalau.adapters;

import com.francesca.pascalau.entities.LogRegistry;
import com.francesca.pascalau.repository.LogRegistryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class LogRegistryAdapter {

    private final LogRegistryRepository logRegistryRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLogRegistry(final String methodName) {
        final LogRegistry logRegistry = new LogRegistry();
        logRegistry.setMethod(methodName);

        logRegistryRepository.save(logRegistry);
    }
}
