/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 5/22/2021
Time: 9:03 PM
 To change this template use File | Settings | File Templates.
*/
package ai.ecma.lastlesson.service;

import ai.ecma.lastlesson.entity.Address;
import ai.ecma.lastlesson.entity.User;
import ai.ecma.lastlesson.exception.BadRequestException;
import ai.ecma.lastlesson.payload.ApiResponse;
import ai.ecma.lastlesson.repository.AddressRepository;
import ai.ecma.lastlesson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;
    public ApiResponse setAddressToUser(UUID addressId, User user){
        Optional<Address> byId = addressRepository.findById(addressId);
            if (byId.isPresent()){
                user.setAddress(byId.get());
                userRepository.save(user);
                return new ApiResponse("Userga manzil biriktirildi",true);
            }else {
                throw new BadRequestException("bunday manzil yo'q");
            }
    }
}
