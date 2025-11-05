package store.kanggyeonggu.api.pickpro.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pickpros")
public class PickproEntity {

    @Id
    private String index;

    private String parentDepartment;

    private String department;

    private String subDepartment;

}
