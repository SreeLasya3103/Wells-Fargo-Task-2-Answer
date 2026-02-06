package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @Column(nullable = false)
    private LocalDate createdDate;

    @Column(precision = 19, scale = 4)
    private BigDecimal totalValue;

    // One portfolio belongs to one client
    @OneToOne
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;

    // One portfolio can have many securities
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities;

    // Default constructor (required by JPA)
    public Portfolio() {
    }

    // Constructor to initialize all fields
    public Portfolio(LocalDate createdDate, BigDecimal totalValue, Client client) {
        this.createdDate = createdDate;
        this.totalValue = totalValue;
        this.client = client;
    }

    // Getters and Setters
    public Long getPortfolioId() {
        return portfolioId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}