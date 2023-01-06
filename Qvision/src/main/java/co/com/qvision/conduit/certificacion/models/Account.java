package co.com.qvision.conduit.certificacion.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private String userName;
    private String email;
    private String password;
}
