package com.wedding.app.service.impl;

import com.wedding.app.dto.Customer;
import com.wedding.app.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sangyuqi on 2018/3/21.
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Override
    public Customer getCustomer() {
        return null;
    }
}
