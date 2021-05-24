package ai.ecma.lastlesson.entity;

import ai.ecma.lastlesson.entity.enums.RoleName;
import ai.ecma.lastlesson.entity.templates.AbstractEntityLong;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AbstractEntityLong implements GrantedAuthority {

    @Enumerated(EnumType.STRING)
    private RoleName name;

    private String description;

    @Override
    public String getAuthority() {
        return name.name();
    }
}
