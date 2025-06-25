package nic.rti.master.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="appeal")

public class Appeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String status; //new,pending,under_process
     @Column(name="created_at")
    private LocalDateTime createdAt;

    private boolean commentFromPio;
    

}
