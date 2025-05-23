package com.rafaeldsal.ws.minhaprata.model.jpa;

import com.rafaeldsal.ws.minhaprata.exception.BusinessException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product")
public class Product implements Serializable {

  @Id
  @Column(name = "product_id", nullable = false, unique = true, updatable = false)
  private String id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private BigDecimal price;

  @Column(name = "img_url")
  private String imgUrl;

  @Column(name = "stock_quantity", nullable = false)
  private Long stockQuantity;

  @Column(name = "dt_created", updatable = false, nullable = false)
  private LocalDateTime dtCreated;

  @Column(name = "dt_updated", nullable = false)
  private LocalDateTime dtUpdated;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  public void decreaseStockOrFail(long quantity) {
    if (quantity <= 0) {
      throw new BusinessException("Quantidade inválida para reduzir estoque");
    }

    if (this.stockQuantity < quantity) {
      throw new BusinessException("Estoque insuficiente para o produto " + this.getName());
    }

    this.stockQuantity -= quantity;
  }

}
