package kodlama.io.rentACar.entities.concretes;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name ="brands")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "brand")
    List<Model> models;

}
