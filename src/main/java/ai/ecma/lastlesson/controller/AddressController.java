/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 5/22/2021
Time: 9:11 PM
 To change this template use File | Settings | File Templates.
*/
package ai.ecma.lastlesson.controller;

import ai.ecma.lastlesson.entity.User;
import ai.ecma.lastlesson.payload.ApiResponse;
import ai.ecma.lastlesson.security.CurrentUser;
import ai.ecma.lastlesson.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/address_operation")
public class AddressController {
    @Autowired
    AddressService addressService;
    @GetMapping("set_address/{addresId}")
    public HttpEntity<ApiResponse> setAddressToUser(@CurrentUser User user, @PathVariable UUID addresId){
        return ResponseEntity.ok(addressService.setAddressToUser(addresId,user));
    }
    @GetMapping("check")
    public String check(){
        return "hello";
    }
}
