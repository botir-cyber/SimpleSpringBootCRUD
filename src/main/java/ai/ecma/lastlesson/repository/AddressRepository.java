/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 5/22/2021
Time: 8:37 PM
 To change this template use File | Settings | File Templates.
*/
package ai.ecma.lastlesson.repository;

import ai.ecma.lastlesson.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;
@RepositoryRestResource(path = "address",collectionResourceRel = "list"
//        ,excerptProjection = FacultyStatisticProjection.class
)
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
