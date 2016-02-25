import dto.OrderDTO;
import entity.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.Date;

/**
 * @author Moon, KeumHwan
 * @since 2016-02-25.
 */
public class Main3 {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        Order order = new Order();
        Customer customer = new Customer();
        Name name = new Name();
        Address address = new Address();
        final Code code = new Code();

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

        modelMapper.addMappings(new PropertyMap<Order, OrderDTO>() {
                                    @Override
                                    protected void configure() {
                                        // City를 Street로 매핑한다.
                                        map().setBillingAddressStreet(source.getBillingAddress().getCity());
                                        // OrderDate는 매핑하지 않는다.
                                        // skip().setOrderDate(null);
                                        skip(source.getOrderDate(), destination.getOrderDate());
                                        // 코드는 매핑하지 않는다.

                                        skip(source.getCode(), destination.getCode());

                                    }
                                }
        );

        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

        // 설정한 City("서울시") 가 Street로 설정 되었다.
        System.out.println("orderDTO.getBillingAddressStreet() = " + orderDTO.getBillingAddressStreet());
        // OrderDate는 Null 이다.
        System.out.println("orderDTO.getOrderDate() = " + orderDTO.getOrderDate());
        // Code는 Null 이다.
        System.out.println("orderDTO.getCode() = " + orderDTO.getCode());



    }
}
