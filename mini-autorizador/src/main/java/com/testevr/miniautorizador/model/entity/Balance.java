package com.testevr.miniautorizador.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_saldo")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_saldo")
    private Long id;

    @Version
    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime updatedDate;

    @Column(name = "saldo", nullable = false)
    private BigDecimal balance;

    @OneToOne(mappedBy = "balance")
    private Card card;
}

