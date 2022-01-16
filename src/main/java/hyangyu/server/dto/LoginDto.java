package hyangyu.server.dto;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

   @NotNull
   @Size(min = 3, max = 10)
   private String username;

   @NotNull
   @Size(min = 8, max = 200)
   private String password;
}
