/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 5/22/2021
Time: 8:37 PM
 To change this template use File | Settings | File Templates.
*/
package ai.ecma.lastlesson.repository;

import ai.ecma.lastlesson.entity.Address;
import ai.ecma.lastlesson.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "statistic",collectionResourceRel = "list"
//        ,excerptProjection = FacultyStatisticProjection.class
)
public interface StatisticRepository extends JpaRepository<Statistic, UUID> {
}
