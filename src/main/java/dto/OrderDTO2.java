package dto;

import lombok.Data;

/**
 * @author Moon, KeumHwan
 * @since 2016-02-25.
 */

@Data
public class OrderDTO2 {
    CustomerDTO customer;
    AddressDTO billingAddress;
    CodeDTO code;
}
