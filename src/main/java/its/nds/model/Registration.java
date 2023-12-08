package its.nds.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "registration")
public class Registration {
    @NonNull
    @Id
    private Long pass_id;
    private Long user_id;
    private String user_email;
    private String encrypt_pass;
    private String salt;
}
