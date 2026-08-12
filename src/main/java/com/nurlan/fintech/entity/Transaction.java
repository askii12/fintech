package com.nurlan.fintech.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "idempotency_key", nullable = false, unique = true)
    private String idempotencyKey;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    protected Transaction() {}

    public Transaction(String idempotencyKey, TransactionType type) {
        this.idempotencyKey = idempotencyKey;
        this.type = type;
        this.status = TransactionStatus.PENDING; // всегда стартуем с PENDING
    }

    public UUID getId() { return id; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public TransactionStatus getStatus() { return status; }
    public TransactionType getType() { return type; }
    public Instant getCreatedAt() { return createdAt; }

    // явные бизнес-методы вместо сеттера на status
    public void markCompleted() {
        this.status = TransactionStatus.COMPLETED;
    }

    public void markFailed() {
        this.status = TransactionStatus.FAILED;
    }
}