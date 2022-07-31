package tr.com.nihatalim.jpalockingmechanizm.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product extends BaseEntity {
    @Column(name = "PRODUCT_NAME")
    private String productName;
}
