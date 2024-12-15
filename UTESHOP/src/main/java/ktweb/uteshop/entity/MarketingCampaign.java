package ktweb.uteshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "marketingCampaign")
public class MarketingCampaign implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaign_id")
    private Long campaignId;

    @Column(name = "content", nullable = false)
    private String content;

    @OneToOne
    @JoinColumn(name = "voucher_id", referencedColumnName = "voucherId", unique = true)
    private Voucher voucher;

    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete = false;

    private String campaignImage;

}