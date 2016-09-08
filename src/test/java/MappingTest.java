import dto.OrderDTO;
import dto.OrderDTO2;
import entity.*;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Date;

/**
 * @author jason, Moon
 * @since 2016. 9. 8.
 */
public class MappingTest {

    @Test
    public void mappingTest() throws Exception {

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

    @Test
    public void mappingTest2() throws Exception {

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

    @Test
    public void mappingTest3() throws Exception {

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

        modelMapper.addMappings(createPropertyMap());

        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

        // 설정한 City("서울시") 가 Street로 설정 되었다.
        System.out.println("orderDTO.getBillingAddressStreet() = " + orderDTO.getBillingAddressStreet());
        // OrderDate는 Null 이다.
        System.out.println("orderDTO.getOrderDate() = " + orderDTO.getOrderDate());
        // Code는 Null 이다.
        System.out.println("orderDTO.getCode() = " + orderDTO.getCode());
    }

    private static PropertyMap<Order, OrderDTO> createPropertyMap() {

        return new PropertyMap<Order, OrderDTO>() {
            @Override
            protected void configure() {
                // City를 Street로 매핑한다.
                //map().setBillingAddressStreet(source.getBillingAddress().getCity());
                map(source.getBillingAddress().getCity(), destination.getBillingAddressStreet());
                // OrderDate는 매핑하지 않는다.
                // skip().setOrderDate(null);
                skip(source.getOrderDate(), destination.getOrderDate());
                // 코드는 매핑하지 않는다.
                skip(source.getCode(), destination.getCode());
            }
        };
    }

    @Test
    public void mappingTest4() throws Exception {

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
