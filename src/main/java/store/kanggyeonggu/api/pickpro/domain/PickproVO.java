package store.kanggyeonggu.api.pickpro.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PickproVO {

    private String index;
    private String parentDepartment;
    private String department;
    private String subDepartment;

}
