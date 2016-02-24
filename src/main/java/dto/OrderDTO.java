package dto;

import entity.Code;
import lombok.Data;

import java.util.Date;

/**
 * @author Moon, KeumHwan
 * @since 2016-02-23.
 */

@Data
public class OrderDTO {
    String customerFirstName;
    String customerNameFirstName;
    String customerLastName;
    String billingStreet;
    String billingAddressStreet;
    String addressStreet;
    String billingCity;
    Date orderDate;
    String code;

    public void setCode(Code code) {
        this.code = code.getCode();
    }
}
