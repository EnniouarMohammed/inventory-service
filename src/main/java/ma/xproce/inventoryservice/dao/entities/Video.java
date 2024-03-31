package ma.xproce.inventoryservice.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "videos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    private String description;
    private LocalDate datePublication;

    @ManyToOne
    private Creator creator;
}