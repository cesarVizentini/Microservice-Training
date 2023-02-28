package com.cesarvizentini.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerID) {
        boolean isFraudentCustomer = fraudCheckService.
                isFraudulentCustomer(customerID);
        return new FraudCheckResponse(isFraudentCustomer);
    }
}
