package tr.com.nihatalim.jpalockingmechanizm.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PRODUCT_ITEM")
@Getter
@Setter
public class ProductItem extends BaseEntity {
    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(name = "PROCESS_STATUS")
    private int processStatus;

    @Column(name = "PROCESS_DATE")
    private Date processDate;
}
