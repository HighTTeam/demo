package hight.sa.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by neron.liu on 10/03/2017.
 */
@Data
public class LoginUser implements Serializable {

    private String email;

    private String password;

}
