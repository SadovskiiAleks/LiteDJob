//package com.example.userrequests.service.userService.phone;
//
//import com.example.userrequests.model.phone.Phone;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@FeignClient(value = "", url = "https://cleaner.dadata.ru/api/v1/clean")
//public interface PhoneService {
//
//    @RequestMapping(method = RequestMethod.POST,
//            value = "/phone",
//            produces = "application/json",
//            consumes = "application/json"
//    )
//    Phone checkPhone(@RequestBody String phone,
//                     @RequestHeader String api_key,
//                     @RequestHeader String secret_key);
//}
