/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 5/22/2021
Time: 8:37 PM
 To change this template use File | Settings | File Templates.
*/
package ai.ecma.lastlesson.repository;

import ai.ecma.lastlesson.entity.Address;
import ai.ecma.lastlesson.entity.Role;
import ai.ecma.lastlesson.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(path = "role",collectionResourceRel = "list"
//        ,excerptProjection = FacultyStatisticProjection.class
)
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByName(RoleName roleUser);
}
