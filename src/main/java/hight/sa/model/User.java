package hight.sa.model;

import lombok.Data;

import java.sql.Date;


/**
 * Created by dunn on 18/03/2017.
 */
@Data
public class User {
    private Long id;
    private String userName;
    private String password;
    private Integer enabled;
    private Date createTime;

}
