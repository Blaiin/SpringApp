package its.nds.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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

    @Builder(toBuilder = true)
    public Registration(Long user_id, String user_email, String encrypt_pass, String salt) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.encrypt_pass = encrypt_pass;
        this.salt = salt;
    }
}
