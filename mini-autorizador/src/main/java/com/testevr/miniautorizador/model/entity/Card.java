package com.testevr.miniautorizador.model.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cartao")
@EntityListeners(AuditingEntityListener.class)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cartao")
    private Long id;

    @Column(name = "numero_cartao", nullable = false, unique = true)
    private String cardNumber;

    @Column(name = "senha", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime createdDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    private Balance balance;
}
