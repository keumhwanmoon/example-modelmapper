package entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Moon, KeumHwan
 * @since 2016-02-23.
 */

@Data
public class Order {
    Customer customer;
    Address billingAddress;
    Date orderDate;
    Code code;
}

