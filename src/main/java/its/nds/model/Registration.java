package its.nds.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pass_id;
    private Long user_id;
    private String user_email;
    private String encrypt_pass;
    private String salt;
    @Column(name = "registeredon")
    private LocalDate registeredOn;

}
