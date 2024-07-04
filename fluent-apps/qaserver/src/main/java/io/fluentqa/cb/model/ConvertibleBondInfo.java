package io.fluentqa.cb.model;

import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.jpa.model.MetaModelVo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "convertible_bond_info")
@Data
@Erupt(name = "CB数据", power = @Power(importable = true, export = true))

public class ConvertibleBondInfo extends MetaModelVo {

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "trade_date")
    private String tradeDate;

    @Column(name = "pre_close_price")
    private BigDecimal preClosePrice;

    @Column(name = "open_price")
    private BigDecimal openPrice;

    @Column(name = "high_price")
    private BigDecimal highPrice;

    @Column(name = "low_price")
    private BigDecimal lowPrice;

    @Column(name = "close_price")
    private BigDecimal closePrice;

    @Column(name = "change")
    private BigDecimal change;

    @Column(name = "change_rate")
    private BigDecimal changeRate;

    @Column(name = "accrued_days")
    private Integer accruedDays;

    @Column(name = "accrued_interest")
    private BigDecimal accruedInterest;

    @Column(name = "remaining_term")
    private BigDecimal remainingTerm;

    @Column(name = "current_yield")
    private BigDecimal currentYield;

    @Column(name = "pure_bond_yield")
    private BigDecimal pureBondYield;

    @Column(name = "pure_bond_value")
    private BigDecimal pureBondValue;

    @Column(name = "pure_bond_premium")
    private BigDecimal pureBondPremium;

    @Column(name = "pure_bond_premium_rate")
    private BigDecimal pureBondPremiumRate;

    @Column(name = "conversion_price")
    private BigDecimal conversionPrice;

    @Column(name = "conversion_ratio")
    private BigDecimal conversionRatio;

    @Column(name = "conversion_value")
    private BigDecimal conversionValue;

    @Column(name = "conversion_premium")
    private BigDecimal conversionPremium;

    @Column(name = "conversion_premium_rate")
    private BigDecimal conversionPremiumRate;

    @Column(name = "conversion_pe_ratio")
    private BigDecimal conversionPeRatio;

    @Column(name = "conversion_pb_ratio")
    private BigDecimal conversionPbRatio;

    @Column(name = "arbitrage_space")
    private BigDecimal arbitrageSpace;

    @Column(name = "parity_bottom_price")
    private BigDecimal parityBottomPrice;

    @Column(name = "term")
    private BigDecimal term;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name = "coupon_rate_issue_reference_rate")
    private BigDecimal couponRateIssueReferenceRate;

    @Column(name = "trading_market")
    private String tradingMarket;

    @Column(name = "bond_type")
    private String bondType;

    // Constructors, getters, setters
}
