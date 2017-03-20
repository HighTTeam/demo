package hight.sa.model;

import lombok.Data;

/**
 * Created by dunn on 19/03/2017.
 */
@Data
public class RolePermission {
    private Long id;
    private Long roleId;
    private Long permissionId;

}
