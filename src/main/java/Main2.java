import dto.OrderDTO2;
import entity.*;
import org.modelmapper.ModelMapper;

import java.util.Date;

/**
 * @author Moon, KeumHwan
 * @since 2016-02-25.
 */
public class Main2 {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        Order order = new Order();
        Customer customer = new Customer();
        Name name = new Name();
        Address address = new Address();
        Code code = new Code();

        address.setCity("서울시");
        address.setStreet("세종로");

        name.setFirstName("길동");
        name.setLastName("홍");

        customer.setName(name);

        code.setCode("코드");

        order.setCustomer(customer);
        order.setBillingAddress(address);
        order.setOrderDate(new Date());
        order.setCode(code);

        OrderDTO2 orderDTO2 = modelMapper.map(order, OrderDTO2.class);

        System.out.println("orderDTO2.getCustomer().getName().getFirstName() = " + orderDTO2.getCustomer().getName().getFirstName());
        System.out.println("orderDTO2.getCustomer().getName().getLastName() = " + orderDTO2.getCustomer().getName().getLastName());
        System.out.println("orderDTO2.getCode().getCode() = " + orderDTO2.getCode().getCode());
        System.out.println("orderDTO2.getBillingAddress().getCity() = " + orderDTO2.getBillingAddress().getCity());
        System.out.println("orderDTO2.getBillingAddress().getStreet() = " + orderDTO2.getBillingAddress().getStreet());
    }
}
