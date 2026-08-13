package com.nurlan.fintech.repository;

import com.nurlan.fintech.entity.LedgerEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.UUID;

public interface LedgerEntryRepository extends JpaRepository<LedgerEntry, UUID> {

    @Query("""
        SELECT COALESCE(SUM(
            CASE WHEN le.entryType = 'CREDIT' THEN le.amount ELSE -le.amount END
        ), 0)
        FROM LedgerEntry le
        WHERE le.account.id = :accountId
        """)
    BigDecimal calculateBalance(@Param("accountId") UUID accountId);
}