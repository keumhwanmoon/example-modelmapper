import dto.OrderDTO;
import entity.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Date;

/**
 * @author Moon, Keum Hwan
 * @since 2016-02-25
 */
public class Main4 {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

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

        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

        System.out.println("orderDTO.getCustomerLastName() = " + orderDTO.getCustomerLastName());
        System.out.println("orderDTO.getCustomerFirstName() = " + orderDTO.getCustomerFirstName());
        System.out.println("orderDTO.getCustomerNameFirstName() = " + orderDTO.getCustomerNameFirstName());
        System.out.println("orderDTO.getBillingCity() = " + orderDTO.getBillingCity());
        System.out.println("orderDTO.getBillingStreet() = " + orderDTO.getBillingStreet());
        System.out.println("orderDTO.getBillingAddressStreet() = " + orderDTO.getBillingAddressStreet());
        System.out.println("orderDTO.getAddressStreet() = " + orderDTO.getAddressStreet());
        System.out.println("orderDTO.getOrderDate().toString() = " + orderDTO.getOrderDate().toString());
        System.out.println("orderDTO.getCode() = " + orderDTO.getCode());
    }
}
