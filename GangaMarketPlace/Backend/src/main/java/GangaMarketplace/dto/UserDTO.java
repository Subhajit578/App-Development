package GangaMarketplace.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private long id;
    private String name;
    private String address;  // Ensure field names are in lowercase and consistent
    private String telephoneNumber; // Updated field name for consistency
    private String email;
    private String userName;
    private String password;
}