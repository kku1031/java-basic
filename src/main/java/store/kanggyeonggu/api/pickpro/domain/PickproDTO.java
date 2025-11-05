package store.kanggyeonggu.api.pickpro.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PickproDTO {

    private String index;
    private String parentDepartment;
    private String department;
    private String subDepartment;

}
