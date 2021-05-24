/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 5/22/2021
Time: 8:35 PM
 To change this template use File | Settings | File Templates.
*/
package ai.ecma.lastlesson.entity;

import ai.ecma.lastlesson.entity.templates.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Statistic extends AbstractEntity {
    private String description;
    private Integer point;
}
