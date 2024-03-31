package ma.xproce.inventoryservice.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePublication;

    @ManyToOne
    private Creator creator;
}